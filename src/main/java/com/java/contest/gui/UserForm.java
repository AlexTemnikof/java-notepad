package com.java.contest.gui;

import com.java.contest.core.entities.NoteImg;
import com.java.contest.service.iservices.Service;
import com.java.contest.service.tools.ClipboardManager;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.plaf.metal.*;
public class UserForm extends JFrame implements ActionListener {

    // Text component
    private static JTextArea ta;
    private static JTextPane t;

    private static ArrayList<NoteImg> noteImgList;

    // Frame
    JFrame f;

    JMenuBar mb;

    JMenu mi2;

    Service service;

    static String id;

    // Constructor
    public UserForm(Service service)
    {
        this.service = service;

        noteImgList = new ArrayList<>();

        // Create a frame
        f = new JFrame("Nodes");

        try {
            // Set metal look and feel
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

            // Set theme to ocean
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        }

        catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Text component
        ta = new JTextArea();
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        Font font = new Font("Times New Roman",Font.BOLD, 17);
        ta.setFont(font);
        ta.setText("New Node");
        JPanel pta = new JPanel(new BorderLayout());
        pta.setPreferredSize(new Dimension(300, 50));
        pta.setBorder(BorderFactory.createLineBorder(Color.black));
        pta.add(ta);

        t = new JTextPane();
        t.setText("Type here...");
        JPanel pt = new JPanel(new BorderLayout());
        pt.setPreferredSize(new Dimension(300, 400));
        pt.setBorder(BorderFactory.createLineBorder(Color.black));
        pt.add(t);

        // Create a menubar
        mb = new JMenuBar();

        // Create amenu for menu
        JMenu m1 = new JMenu("File");

        // Create menu items
        JMenuItem mi1 = new JMenuItem("New");

        mi2 = new JMenu("Open");

        for (JMenuItem menuItem: service.transferNotes()){
            mi2.add(menuItem);
        }

        JMenuItem mi3 = new JMenuItem("Save");
        JMenuItem mi4 = new JMenuItem("Delete");

        mi1.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);

        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi4);


        JMenu m2 = new JMenu("Edit");

        // Create menu items
        JMenuItem mi5 = new JMenuItem("cut");
        JMenuItem mi6 = new JMenuItem("copy");
        JMenuItem mi7 = new JMenuItem("paste");
        JMenuItem mi8 = new JMenuItem("insert image");


        mi5.addActionListener(this);
        mi6.addActionListener(this);
        mi7.addActionListener(this);
        mi8.addActionListener(this);

        m2.add(mi5);
        m2.add(mi6);
        m2.add(mi7);
        m2.add(mi8);

        JMenuItem mc = new JMenuItem("close");

        mc.addActionListener(this);

        mb.add(m1);
        mb.add(m2);
        mb.add(mc);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));

        innerPanel.add(pta, BorderLayout.CENTER);
        innerPanel.add(pt, BorderLayout.CENTER);

        JScrollPane p = new JScrollPane(innerPanel);

        panel.add(p, BorderLayout.CENTER);

        f.setJMenuBar(mb);
        f.add(panel);
        f.pack();
        f.setLocationByPlatform(true);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        switch (s) {
            case "cut" -> t.cut();
            case "copy" -> t.copy();
            case "paste" -> t.paste();
            case "insert image" -> {
                Image image = ClipboardManager.getImageFromClipboard();
                if (image != null) {
                    ImageIcon imageIcon = new ImageIcon(image);
                    noteImgList.add(new NoteImg(t.getCaretPosition(), imageIcon));
                    t.insertIcon(imageIcon);
                }
            }
            case "Delete" ->{
                service.deleteNote(id);
                ta.setText("New node");
                t.setText("Type here...");
                mi2.removeAll();
                for (JMenuItem menuItem : service.transferNotes()) {
                    mi2.add(menuItem);
                }
                mb.revalidate();
            }
            case "Save" -> {
                save();
                service.save();
            }
            case "New" -> {
                save();
                id = service.createNote();
                ta.setText("New Node");
                t.setText("Type here...");
                mi2.removeAll();
                for (JMenuItem menuItem : service.transferNotes()) {
                    mi2.add(menuItem);
                }
                mb.revalidate();
            }
            case "close" -> {
                f.setVisible(false);
                service.save();
                System.exit(0);
            }
        }
    }

    private void save(){
        id = service.saveNote(id, ta.getText(), t.getText(), noteImgList);
        mi2.removeAll();
        for (JMenuItem menuItem : service.transferNotes()) {
            mi2.add(menuItem);
        }
        mb.revalidate();
    }

    private static void init(){
        ta.setText("New node");
        t.setText("Welcome! You can type here...");
    }

    private static void init(String ident, String header, String text, ArrayList<NoteImg> images){
        noteImgList = images;
        id = ident;
        ta.setText(header);
        t.setText(text);
        if (images != null) {
            for (NoteImg img : images) {
                t.setCaretPosition(img.getIndex());
                t.insertIcon(img.getImg());
            }
        }
    }


    public static void open(String id, String header, String text, ArrayList<NoteImg> imgList){
        init(id, header, text, imgList);
    }


    public static void main(Service service)
    {
        UserForm e = new UserForm(service);
        init();
    }

    public static void main(Service service, String id, String header, String text, ArrayList<NoteImg> images){
        UserForm e = new UserForm(service);
        e.init(id, header, text, images);
    }
}

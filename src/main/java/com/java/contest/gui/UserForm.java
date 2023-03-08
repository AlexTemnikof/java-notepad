package com.java.contest.gui;

import com.java.contest.core.entities.NodeImg;
import com.java.contest.service.iservices.IService;
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

    private static ArrayList<NodeImg> nodeImgList;

    // Frame
    JFrame f;

    JMenuBar mb;

    JMenu mi2;

    IService service;

    static String id;

    // Constructor
    public UserForm(IService service)
    {
        this.service = service;

        nodeImgList = new ArrayList<>();

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
        JPanel pta = new JPanel(new BorderLayout());
        pta.setPreferredSize(new Dimension(300, 50));
        pta.setBorder(BorderFactory.createLineBorder(Color.black));
        pta.add(ta);

        t = new JTextPane();
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

        for (JMenuItem menuItem: service.transferNodes()){
            mi2.add(menuItem);
        }

        JMenuItem mi3 = new JMenuItem("Save");

        mi1.addActionListener(this);
        mi3.addActionListener(this);

        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        //todo: implement

        JMenu m2 = new JMenu("Edit");

        // Create menu items
        JMenuItem mi4 = new JMenuItem("cut");
        JMenuItem mi5 = new JMenuItem("copy");
        JMenuItem mi6 = new JMenuItem("paste");
        JMenuItem mi7 = new JMenuItem("insert image");


        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);
        mi7.addActionListener(this);

        m2.add(mi4);
        m2.add(mi5);
        m2.add(mi6);
        m2.add(mi7);

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

        if (s.equals("cut")) {
            t.cut();
        }
        else if (s.equals("copy")) {
            t.copy();
        }

        else if (s.equals("paste")) {
            t.paste();
        }
        else if (s.equals("insert image")){
            Image image = ClipboardManager.getImageFromClipboard();
            if(image != null){
                ImageIcon imageIcon = new ImageIcon(image);
                nodeImgList.add(new NodeImg(t.getCaretPosition(), imageIcon));
                t.insertIcon(imageIcon);
            }
        }
        else if (s.equals("Save")) {
            save();
            service.save();
        }

        else if (s.equals("New")) {
            save();
            id = service.createNode();
            ta.setText("New Node");
            t.setText("Type here...");
            mi2.removeAll();
            for (JMenuItem menuItem: service.transferNodes()){
                mi2.add(menuItem);
            }
            mb.revalidate();

        }
        else if (s.equals("close")) {
            f.setVisible(false);
            service.save();
        }
    }

    private void save(){
        service.saveNode(id, ta.getText(), t.getText(), nodeImgList);
    }

    private static void init(){
        ta.setText("New node");
        t.setText("Welcome! You can type here...");
    }

    private static void init(String ident, String header, String text, ArrayList<NodeImg> images){
        nodeImgList = images;
        id = ident;
        ta.setText(header);
        t.setText(text);
        if (images != null) {
            for (NodeImg img : images) {
                t.setCaretPosition(img.getIndex());
                t.insertIcon(img.getImg());
            }
        }
    }


    public static void open(String id, String header, String text, ArrayList<NodeImg> imgList){
        init(id, header, text, imgList);
    }


    public static void main(IService service)
    {
        UserForm e = new UserForm(service);
        init();
    }

    public static void main(IService service, String id, String header, String text, ArrayList<NodeImg> images){
        UserForm e = new UserForm(service);
        e.init(id, header, text, images);
    }
}

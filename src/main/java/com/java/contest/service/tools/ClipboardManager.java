package com.java.contest.service.tools;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public abstract class ClipboardManager {
    public static Image getImageFromClipboard()
    {
        Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        if (transferable != null && transferable.isDataFlavorSupported(DataFlavor.imageFlavor))
        {
            try
            {
                return (Image) transferable.getTransferData(DataFlavor.imageFlavor);
            }
            catch (UnsupportedFlavorException | IOException e)
            {
                // handle this as desired
                e.printStackTrace();
            }
        }
        else
        {
            //todo: implement
            System.err.println("getImageFromClipboard: That wasn't an image!");
        }
        return null;
    }
}

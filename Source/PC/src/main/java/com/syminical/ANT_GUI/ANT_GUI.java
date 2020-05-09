package syminical.ant_gui;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ANT_GUI {
    
   public static ANT_GUI Instance;
   private static AntModel Model;
   private static AntView View;
   private static AntController Controller;

   public ANT_GUI() {
      Model = new AntModel();
      if (!Model.loadAssets())
         if (JOptionPane.showOptionDialog(null, "Failed to load assets.", "Warning!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{"OK"}, "OK")*0 == 0)// == JOptionPane.OK_OPTION)
            System.exit(-1);
      
      View = new AntView();
      View.setModel(Model);
      
      AntController.initWindowListener();
      AntController.splashAnimation();
   }
   
   public static AntView View() { return View; }
   
   public static void main(String[] Args) {
      if (Instance == null) Instance = new ANT_GUI();
   }
}
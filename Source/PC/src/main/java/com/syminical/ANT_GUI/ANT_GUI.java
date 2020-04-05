package syminical.ant_gui;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class ANT_GUI {
    
   public static ANT_GUI Instance;
   //public GameController GC;
   //private WindowBox MainBox, SettingsBox, InfoBox, DevBox;
   private ANTFrame MainFrame;
   private DragListener DL;
   private final Dimension MAIN_BOX_SIZE = new Dimension( 410, 438 ), SETTINGS_BOX_SIZE = new Dimension( 200, 300 ), INFO_BOX_SIZE = new Dimension( 350, 300 ), DEV_BOX_SIZE = new Dimension( 251, 75 );
   private Image[] MainAssets;


   public ANT_GUI() {
      MainAssets = new Image[2];
      DL = new DragListener(this);
      
      //GC = new GameController(this);
      //GC.begin();
      if (!loadAssets()) {
         if (JOptionPane.showOptionDialog(null, "Failed to load assets.", "Warning!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{"OK"}, "OK") == JOptionPane.OK_OPTION)
            System.exit(-1);
      }
      createWindows();
   }

   private boolean loadAssets() {
      try {
         //this.getClass().getResource("../../../../Images/UIExport/FRAME.png")
         MainAssets[0] = ImageIO.read( new File("Images/UIexport/FRAME.png") );
         MainAssets[1] = ImageIO.read( new File("Images/UIexport/icons/closeXButton/closeX.png") );
      } catch (Exception e) { return false; }
      return true;
   }

   private void createWindows() {
      MainFrame = new ANTFrame() {
         public void setContentPane() {
            this.setContentPane(new BackgroundPanel(MainAssets[0], BackgroundPanel.ACTUAL));
            this.getContentPane().setBackground(new Color(0,0,255));
         }
         
         public void addComponents() {
            JPanel TitlePanel = new JPanel();
               this.fixComponentSizes(TitlePanel, new Dimension(410, 33));
               TitlePanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
               TitlePanel.add(new AlphaContainer(new BackgroundPanel(MainAssets[1], BackgroundPanel.ACTUAL)));
            ((BackgroundPanel)(this.getContentPane())).add(TitlePanel);
         }
         
         public void style() {
            this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            this.setUndecorated(true);
            this.fixComponentSizes(this, MAIN_BOX_SIZE);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
         }
      };
      MainFrame.addMouseListener(DL);
      MainFrame.addMouseMotionListener(DL);
   }
   
   public static void main(String[] Args) {
      if (Instance == null) Instance = new ANT_GUI();
   }
}
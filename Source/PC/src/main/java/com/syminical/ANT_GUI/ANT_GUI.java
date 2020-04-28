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
   private static ANTFrame MainFrame;
   private static DragListener DL;
   private final Dimension MAIN_BOX_SIZE = new Dimension( 410, 439 ), SETTINGS_BOX_SIZE = new Dimension( 200, 300 ), INFO_BOX_SIZE = new Dimension( 350, 300 ), DEV_BOX_SIZE = new Dimension( 251, 75 );
   private Image[] FrameAssets, BodyAssets;


   public ANT_GUI() {
      
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
         
         
         /*
         FrameAssets[0] = ImageIO.read( new File("Images/UIexport/FRAME.png") );
         FrameAssets[1] = ImageIO.read( new File("Images/UIexport/icons/closeXButton/closeX.png") );
         FrameAssets[2] = ImageIO.read( new File("Images/UIexport/icons/closeXButton/closeXActive.png") );
         BodyAssets[0] = ImageIO.read(new File("Images/UIexport/SPLASH.png"));
         */
      } catch (Exception e) { return false; }
      return true;
   }

   private void createWindows() {
      MainFrame = new ANTFrame() {
         public void setContentPane() {
            this.setContentPane(new BackgroundPanel(FrameAssets[0], BackgroundPanel.ACTUAL));
            this.fixComponentSizes(this, MAIN_BOX_SIZE);
            ((BackgroundPanel)(this.getContentPane())).setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
         }
         
         public void addComponents() {
            JPanel TitlePanel = new JPanel();
               this.fixComponentSizes(TitlePanel, new Dimension(410, 34));
               TitlePanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
               TitlePanel.add(new MouseOverComponent(Arrays.copyOfRange(FrameAssets, 1, 3)) {
                  @Override
                  public void mouseClicked(MouseEvent ME) {
                     ANT_GUI.terminateProgram();
                  }
               });
               TitlePanel.setBackground(new Color(0,0,255));
               //TitlePanel.add(new AlphaContainer(new BackgroundPanel(FrameAssets[1], BackgroundPanel.ACTUAL)));
            ((BackgroundPanel)(this.getContentPane())).add(TitlePanel);
            
            JPanel BodyPanel = new JPanel();
               this.fixComponentSizes(BodyPanel, new Dimension(405, 400));
               BodyPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
               BodyPanel.add(Box.createRigidArea(new Dimension(2, 400)));
               JPanel ContentPanel = new BackgroundPanel(BodyAssets[0], BackgroundPanel.ACTUAL);
                  /*this.fixComponentSizes(ContentPanel, new Dimension(400, 400));
                  ContentPanel.setOpaque(true);
                  ContentPanel.setBackground(new Color(0,255,0));*/
               BodyPanel.add(ContentPanel);
            ((BackgroundPanel)(this.getContentPane())).add(BodyPanel);
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
      DL.setTarget(MainFrame);
      MainFrame.addMouseListener(DL);
      MainFrame.addMouseMotionListener(DL);
   }
   
   public static void terminateProgram() {
      if (Instance != null) {
         MainFrame.setVisible(false);
         MainFrame.dispose();
         System.exit(0);
      }
   }
   
   public static DragListener getDL() { return DL; }
   
   public static void main(String[] Args) {
      if (Instance == null) Instance = new ANT_GUI();
   }
}
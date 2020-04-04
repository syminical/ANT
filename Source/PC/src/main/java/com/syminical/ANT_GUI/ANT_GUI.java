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
   public GameController GC;
   private WindowBox MainBox, SettingsBox, InfoBox, DevBox;
   private final Dimension MAIN_BOX_SIZE = new Dimension( 410, 438 ), SETTINGS_BOX_SIZE = new Dimension( 200, 300 ), INFO_BOX_SIZE = new Dimension( 350, 300 ), DEV_BOX_SIZE = new Dimension( 251, 75 );
   private Image[] MainAssets;


   public ANT_GUI() {
      MainAssets = new Image[1];
      
      //GC = new GameController(this);
      //GC.begin();
      createWindows();
      if (!loadAssets()) {
         if (JOptionPane.showOptionDialog(null, "Failed to load assets.", "Warning!", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{"OK"}, "OK") == JOptionPane.OK_OPTION)
            System.exit(-1);
      }
   }

   private boolean loadAssets() {
      try {
         MainAssets[0] = ImageIO.read( this.getClass().getResource("/Images/UIExport/FRAME.png") );
      } catch (Exception e) { return false; }

      return true;
   }

   private void createWindows() {
      MainBox = new WindowBox(this, "ANT GUI TEST", MAIN_BOX_SIZE, null, null) {  
         public void buildBox() {
            /*
            //window mouse event zones  
            //main button
            Zones().add(new Zone(this, new Rectangle(49, 248, 155, 56)) {
               @Override
               public void clicked(MouseEvent ME) { Parent().tell(0); }
            });

            //info button
            Zones().add(new Zone(this, new Rectangle(47, 496, 165, 11)) {
               @Override
               public void clicked(MouseEvent ME) { 
                  if (ME.getModifiers() == (MouseEvent.CTRL_MASK + MouseEvent.BUTTON1_MASK))
                     Parent().tell(2);
                  else
                     Parent().tell(1);
               }
            });
            */

            //window customization
            this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            this.setResizable(false);
            this.setUndecorated(true);
            //this.setBackground( new Color( 0, 0, 0, 0 ) );

            this.addMouseListener(new MouseHandler(this));
            this.addKeyListener(new KeyHandler(this));
            
            this.addComponent(new BackgroundPanel(MainAssets[0]));
         }

         @Override
         public void mouseClicked(MouseEvent ME) {
            super.mouseClicked(ME);
            Parent().tell(20, ME.toString());
         }
      };
      MainBox.addComponent( GC.View() );
   }

   public void tell(int m) {
      switch (m) {
         case 0: break;
         default:
      }
   }

   public void tell(String S) {}

   public void tell(int n, String S ) {
      //0:main,1:info,2:dev
      switch ((int)(n/10)) {
         case 2: DevBox.tell(n, S); break;
         default:
      }
   }

   public static void main(String[] Args) {
      if (Instance == null)
         Instance = new ANT_GUI();            
   }

   private class MouseHandler extends MouseAdapter {
      private final WindowBox PARENT;

      public MouseHandler(WindowBox Prnt) { PARENT = Prnt; }

      @Override
      public void mouseClicked(MouseEvent ME) {
         PARENT.mouseClicked(ME);   
      }
   }

   private class KeyHandler extends KeyAdapter {
      private final WindowBox PARENT;
      private char lastKey, currentKey;
      private boolean idle = true;

      public KeyHandler(WindowBox Prnt) { PARENT = Prnt; }

      @Override
      public void keyPressed(KeyEvent KE) {
         lastKey = KE.getKeyChar();
         currentKey = lastKey;
         PARENT.tell(21, ""+lastKey);
         PARENT.tell(22, ""+currentKey);
         PARENT.Parent().GC.keyPressed(KE);
      }

      @Override
      public void keyReleased(KeyEvent KE) {
         if (KE.getKeyChar() == currentKey)
            PARENT.tell(22, "NONE");
         PARENT.Parent().GC.keyReleased(KE);
      }
   }
}
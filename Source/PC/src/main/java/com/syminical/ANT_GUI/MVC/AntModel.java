package syminical.ant_gui;

import java.awt.Image;
import java.io.*;
import javax.imageio.*;


public class AntModel {
   private static AntModel Instance;
   private ImageList FrameAssets, ConnectionAssets, NavBarAssets, NotifAssets;
   private Image[] MiscAssets;
   
   private void init() {
      loadAssets();
   }

   public boolean loadAssets() {
      FrameAssets = new ImageList();
      ConnectionAssets = new ImageList();
      
      try {
         FrameAssets.add(ImageIO.read( this.getClass().getResource("/assets/frame/SPLASH.png") ));
         FrameAssets.add(ImageIO.read( this.getClass().getResource("/assets/frame/FRAME.png") ));
         FrameAssets.add(ImageIO.read( this.getClass().getResource("/assets/frame/closeXButton/closeXInactive.png") ));
         FrameAssets.add(ImageIO.read( this.getClass().getResource("/assets/frame/closeXButton/closeXActive.png") ));
         
         
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/options/ConOpTitle.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/options/prefs/ConOpPrefTitle.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/options/prefs/notificationsList/NLactive.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/options/prefs/notificationsList/NLinactive.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/options/prefs/newNotifications/NNactive.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/options/prefs/newNotifications/NNinactive.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/options/prefs/readTexts/RTactive.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/options/prefs/readTexts/RTinactive.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/options/prefs/sendTexts/STactive.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/options/prefs/sendTexts/STinactive.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/options/connect/ConActive.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/options/connect/ConInactive.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/options/remove/RemActive.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/options/remove/RemInactive.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/scan/ScanTitle.png") ));
         ConnectionAssets.add(ImageIO.read( this.getClass().getResource("/assets/connection/scan/QRCODE.png") ));
      } catch (Exception e) { e.printStackTrace(); return false; }
      
      return true;
   }
   
   public ImageList getImageList(ModelData __) {
      switch (__) {
         case FrameAssets: return FrameAssets;
         case ConnectionAssets: return ConnectionAssets;
         default: return null;
      }
   }
   
   public Image getImage(ModelData __) {
      return null;
   }
   
   public static AntModel getInstance() {
      if (Instance != null) return Instance;
      else return new AntModel();
   }
}
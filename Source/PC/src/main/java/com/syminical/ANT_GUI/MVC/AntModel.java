//  Copyright (C) 2020 Alexandru Manaila.

/*  This file is part of A.N.T.

    A.N.T. is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    A.N.T. is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with A.N.T.  If not, see <https://www.gnu.org/licenses/>.
*/

package syminical.ant_gui;

import java.awt.Image;
import java.io.*;
import javax.imageio.*;


public class AntModel {
   private static AntModel Instance;
   private ImageList FrameAssets, NavBarAssets, ConnectionAssets, NotifAssets;
   private Image[] MiscAssets;
   
   private void init() {
      loadAssets();
   }

   public boolean loadAssets() {
      FrameAssets = new ImageList();
      NavBarAssets = new ImageList();
      ConnectionAssets = new ImageList();
      
      try {
         FrameAssets.add(ImageIO.read( this.getClass().getResource("/assets/frame/SPLASH.png") ));
         FrameAssets.add(ImageIO.read( this.getClass().getResource("/assets/frame/FRAME.png") ));
         FrameAssets.add(ImageIO.read( this.getClass().getResource("/assets/frame/closeXButton/closeXActive.png") ));
         FrameAssets.add(ImageIO.read( this.getClass().getResource("/assets/frame/closeXButton/closeXInactive.png") ));
         
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/backArrow/BAactive.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/backArrow/BAicon.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/clearAll/CAactive.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/clearAll/CAinactive.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/notifs/NotifsHover.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/notifs/NotifsIcon.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/notifs/NotifsActive.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/texts/TextsHover.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/texts/TextsIcon.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/texts/TextsActive.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/gear/GearHover.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/gear/GearIcon.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/gear/GearActive.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/info/InfoHover.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/info/InfoIcon.png") ));
         NavBarAssets.add(ImageIO.read( this.getClass().getResource("/assets/navBar/info/InfoActive.png") ));
         
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
         case NavBarAssets: return NavBarAssets;
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
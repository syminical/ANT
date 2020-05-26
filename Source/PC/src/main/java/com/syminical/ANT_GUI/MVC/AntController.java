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

public class AntController {
   private static DragListener DL;

   public static void frameCloseX() {
      if (ANT_GUI.View() != null) ANT_GUI.View().kill();
      System.exit(0);
   }
   
   public static void navBarBack() { }
   public static void navBarClearAll() { ANT_GUI.View().removeAllNotifications(); }
   public static void navBarGear() { }
   public static void navBarInfo() { }
   public static void navBarNotifs() { }
   public static void navBarTexts() { }
   
   public static void connOpSetNotifList() { }
   public static void connOpSetNewNotif() { }
   public static void connOpSetReadTxts() { }
   public static void connOpSetSendTxts() { }
   public static void connOpGenerate() { }
   public static void connOpDelete() { }
   
   public static void notificationCardClose(int __) { ANT_GUI.View().removeNotification(__); }
   
   public static void initWindowListener() {
      DL = new DragListener();
         DL.setTarget(AntView.Window());
         AntView.Window().addMouseListener(DL);
         AntView.Window().addMouseMotionListener(DL);
   }
   
   public static void splashAnimation() {
      try {
         AntView.splash();
         Thread.sleep(4000);
         AntView.notifs();
      } catch(Exception e) { System.out.println("splash animation failed"); }
   }
   
   public static DragListener DL() { return DL; }
}
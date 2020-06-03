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

import java.awt.*;
import javax.swing.*;

public class AntController {
   private static DragListener DL;
   private static AntModel Model;
   private static AntView View;

   public static void frameCloseX() {
      if (View != null) View.kill();
      System.exit(0);
   }
   
   public static void navBarClearAll() { if (Model.getCurrentViewState() == ViewState.Notifications) ANT_GUI.View().removeAllNotifications(); else connEstablished(); }
   public static void navBarGear() { View.setScene(ViewState.ConnectionOptions); }
   public static void navBarInfo() { View.setScene(ViewState.About); }
   public static void navBarNotifs() { View.setScene(ViewState.Notifications); }
   public static void navBarTexts() { View.setScene(ViewState.TextThreadList); }
   public static void navBarBack() {
      if (Model.getCurrentViewState() == ViewState.ConnectionScan)
         View.setScene(ViewState.ConnectionOptions);
      else View.setScene(ViewState.TextThreadList);
   }
   
   public static void connOpSetNotifList() { }
   public static void connOpSetNewNotif() { }
   public static void connOpSetReadTxts() { }
   public static void connOpSetSendTxts() { }
   public static void connOpGenerate() { View.setScene(ViewState.ConnectionScan); }
   public static void connOpDelete() { Model.setConnected(false); View.setScene(ViewState.ConnectionOptions); }
   public static void connEstablished() { Model.setConnected(true); View.setScene(ViewState.Notifications); }
   
   public static void notificationCardClose(Component __) { ANT_GUI.View().removeNotification(__); }
   
   public static void initWindowListener() {
      DL = new DragListener();
         DL.setTarget(View.Window());
         View.Window().addMouseListener(DL);
         View.Window().addMouseMotionListener(DL);
   }
   
   public static void splashAnimation() {
      try {
         Thread.sleep(4000);
         View.setScene(ViewState.ConnectionOptions);
      } catch(Exception e) { System.out.println("splash animation failed"); }
   }
   
   public static void link(AntModel M, AntView V) { Model = M; View = V; }
   public static DragListener DL() { return DL; }
}
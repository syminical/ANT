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
      //AntController.splashAnimation();
   }
   
   public static AntView View() { return View; }
   
   public static void main(String[] Args) {
      if (Instance == null) Instance = new ANT_GUI();
   }
}
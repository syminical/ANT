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
import java.awt.*;

public abstract class AntFrame extends JFrame {
   public AntFrame(String __) {
      super(__);
      setContentPane();
      addComponents();
      style();
      this.setVisible(true);
   }
   
   public abstract void setContentPane();
   public abstract void addComponents();
   public abstract void style();
   
   public static void fixComponentSizes(Component Part, Dimension Size) {
      Part.setMinimumSize(Size);
      Part.setMaximumSize(Size);
      Part.setPreferredSize(Size);
   }
}
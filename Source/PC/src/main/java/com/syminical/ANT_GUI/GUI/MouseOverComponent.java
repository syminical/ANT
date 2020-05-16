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
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class MouseOverComponent extends BackgroundPanel implements MouseListener {
   protected static final int INACTIVE = 1, HOVER = 0;
   protected boolean clicked = false;
   protected Image[] States;

   public MouseOverComponent(Image[] __) {
      super(__[INACTIVE]);
      States = __;
      addMouseListener(this);
      //addMouseListener(AntController.DL());
      //addMouseMotionListener(AntController.DL());
   }
   
   public void mouseEntered(MouseEvent ME) { setImage(States[HOVER]); }
   public void mouseExited(MouseEvent ME) { setImage(States[INACTIVE]); }
   public void mouseClicked(MouseEvent ME) { }
   public void mousePressed(MouseEvent ME) { }
   public void mouseReleased(MouseEvent ME) { }
}
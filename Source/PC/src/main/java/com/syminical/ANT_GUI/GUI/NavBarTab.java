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
import java.awt.event.*;

public class NavBarTab extends MouseOverComponent implements MouseListener {
   private final int ACTIVE = 2;
   
   public NavBarTab(Image[] __) {
      super(__);
   }
   
   @Override
   public void mouseClicked(MouseEvent ME) { ((ButtonGroup)(this.getParent())).reset(); clicked = true; setImage(States[ACTIVE]); }
   
   @Override
   public void mouseExited(MouseEvent ME) { setImage(States[(clicked)? ACTIVE : INACTIVE]); }
   
   public void reset() { clicked = false; setImage(States[INACTIVE]); }
}
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
import javax.swing.JPanel;
import java.util.LinkedList;

public abstract class ButtonGroup<E> extends JPanel {
   private LinkedList<E> Buttons;
   private E Selected;
   
   public ButtonGroup() {
      super();
      Buttons = new LinkedList<E>();
      this.setOpaque(false);
      this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
      createButtons();
   }
   
   public abstract void createButtons();
   
   public void add(E __) {
      super.add(__);
      Buttons.add(__);
   }
   
   public void selectFirst() { Buttons.getFirst().mouseClicked(null); }
   
   public void reset() {
      for (E Bttn : Buttons) Bttn.reset();
   }
   
   public void Select(int __) { Selected = __; }
   public E Selected() { return Selected; }
}
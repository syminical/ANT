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
import java.awt.Image;
import java.awt.event.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class AntScrollBar extends JScrollBar implements MouseListener {
   private static Image[] States;
   public static final int ACTIVE = 0, INACTIVE = 1;
   private static int CURRENT = INACTIVE;
   
   public AntScrollBar(Image[] __) {
      super();
      States = __;
      this.setUI(new AntScrollBarUI());
      this.addMouseListener(this);
      this.setOpaque(false);
      AntFrame.fixComponentSizes(this, new Dimension(4, 357));
      this.setUnitIncrement(40);
      //this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 6, 0, 6));
   }
   
   public void mouseEntered(MouseEvent ME) { CURRENT = ACTIVE; ME.getComponent().repaint(); }
   public void mouseExited(MouseEvent ME) { CURRENT = INACTIVE; ME.getComponent().repaint(); }
   public void mouseClicked(MouseEvent ME) { }
   public void mousePressed(MouseEvent ME) { }
   public void mouseReleased(MouseEvent ME) { }
   
   public static Image State() { if (States != null) return States[CURRENT]; return null; }
   
   class AntScrollBarUI extends BasicScrollBarUI {
      protected JButton createZeroButton() { //Posted to S.O. by Honzik. https://stackoverflow.com/questions/1786886/remove-arrows-from-swing-scrollbar-in-jscrollpane#4162361
         JButton button = new JButton("");
         Dimension zeroDim = new Dimension(0,0);
         button.setPreferredSize(zeroDim);
         button.setMinimumSize(zeroDim);
         button.setMaximumSize(zeroDim);
         return button;
      }
   
      @Override
      protected JButton createDecreaseButton(int orientation) {
         return createZeroButton();
      }

      @Override
      protected JButton createIncreaseButton(int orientation) {
         return createZeroButton();
      }
      
      @Override
      protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
         g.drawImage(null, r.x, r.y, r.width, r.height, null);
      }

      @Override
      protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
         g.drawImage(AntScrollBar.State(), r.x, r.y, r.width, r.height, null);
      }
   }
}
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
import javax.swing.*;

public class NotificationCard extends BackgroundPanel implements MouseListener {
   private Image[] States;
   private final int SMALL_ACTIVE = 0, SMALL_INACTIVE = 1, BIG_ACTIVE = 2, BIG_INACTIVE = 3;
   private boolean clicked = false;
   private String Text;
   private int id;
   private JPanel Top, Bottom;
   private JLabel TopText, SmallBottomText;
   private JTextArea BigBottomText;
   
   public NotificationCard(Image[] s, int i, String t) { super(s[1]); States = s; id = i; Text = t; build(); addMouseListener(this); }

   private void build() {
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      //AntFrame.fixComponentSizes(this, new Dimension(286, 51));//286
      //this.setOpaque(false);
      //this.setOpaque(true);
      //this.setBackground(Color.GREEN);
      
      Top = new JPanel();
         Top.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
         AntFrame.fixComponentSizes(Top, new Dimension(286, 18));
         Top.setOpaque(false);
         TopText = new JLabel(" Tinder - 2h   > "+Text);
            AntFrame.fixComponentSizes(TopText, new Dimension(263, 18));
            //TopText.setOpaque(true);
            //TopText.setBackground(new Color(255, 0, 0));
            TopText.setForeground(Color.WHITE);
            TopText.setFont(new Font("Courier New Bold", Font.PLAIN, 10));
         Top.add(TopText);
         Top.add(new MouseOverComponent(new Image[]{States[4], States[5]}) {
            @Override
            public void mouseClicked(MouseEvent ME) { 
               Object Temp = ME.getComponent().getParent().getParent();
               if (Temp instanceof NotificationCard) ((NotificationCard)Temp).close();
            }
         });
      this.add(Top);
      
      Bottom = new JPanel();
         //Bottom.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
         AntFrame.fixComponentSizes(Bottom, new Dimension(286, 33));
         Bottom.setOpaque(false);
         SmallBottomText = new JLabel(" Your daily Top Picks are ready...");
            //AntFrame.fixComponentSizes(SmallBottomText, new Dimension(286, 18));
            SmallBottomText.setOpaque(false);
            SmallBottomText.setForeground(Color.WHITE);
            SmallBottomText.setFont(new Font("Courier New Bold", Font.PLAIN, 13));
         Bottom.add(SmallBottomText, BorderLayout.CENTER);
      this.add(Bottom);
   }

   public void mouseEntered(MouseEvent ME) {
      if (clicked)
         setImage(States[BIG_ACTIVE]);
      else
         setImage(States[SMALL_ACTIVE]);
   }
   
   public void mouseExited(MouseEvent ME) {
      if (clicked)
         setImage(States[BIG_INACTIVE]);
      else
         setImage(States[SMALL_INACTIVE]);
   }
   
   public void mouseClicked(MouseEvent ME) {
      clicked = !clicked;
      if (clicked) {
         AntFrame.fixComponentSizes(this, new Dimension(286, 102));
         setImage(States[BIG_ACTIVE]);
      } else {
         AntFrame.fixComponentSizes(this, new Dimension(286, 51));
         setImage(States[SMALL_ACTIVE]);
      }
      this.repaint();
   }
   
   public void mousePressed(MouseEvent ME) { }
   public void mouseReleased(MouseEvent ME) { }
   
   public void close() { AntController.notificationCardClose(this.getParent()); }
}
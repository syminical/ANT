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
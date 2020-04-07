package syminical.ant_gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

public class MouseOverComponent extends BackgroundPanel implements MouseListener {
   private final int INACTIVE = 0, ACTIVE = 1;
   private Image[] States;

   public MouseOverComponent(Image[] __) {
      super(__[0]);
      States = __;
      addMouseListener(this);
      addMouseListener(ANT_GUI.getDL());
      addMouseMotionListener(ANT_GUI.getDL());
   }
   
   public void mouseEntered(MouseEvent ME) { setImage(States[ACTIVE]); }
   public void mouseExited(MouseEvent ME) { setImage(States[INACTIVE]); }
   public void mouseClicked(MouseEvent ME) { }
   public void mousePressed(MouseEvent ME) { }
   public void mouseReleased(MouseEvent ME) { }
}
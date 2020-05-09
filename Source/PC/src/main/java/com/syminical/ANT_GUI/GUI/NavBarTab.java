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
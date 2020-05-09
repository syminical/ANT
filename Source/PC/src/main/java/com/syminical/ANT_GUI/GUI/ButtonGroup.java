package syminical.ant_gui;

import java.awt.*;
import javax.swing.JPanel;
import java.util.LinkedList;

public abstract class ButtonGroup extends JPanel {
   private LinkedList<NavBarTab> Buttons;
   
   public ButtonGroup() {
      super();
      Buttons = new LinkedList<NavBarTab>();
      this.setOpaque(false);
      this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
      createButtons();
   }
   
   public abstract void createButtons();
   
   @Override
   public Component add(Component __) {
      super.add(__);
      Buttons.add((NavBarTab)__);
      return __;
   }
   
   public void selectFirst() { Buttons.getFirst().mouseClicked(null); }
   
   public void reset() {
      for (NavBarTab Bttn : Buttons) Bttn.reset();
   }
}
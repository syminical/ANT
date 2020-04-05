package syminical.ant_gui;

import javax.swing.*;
import java.awt.*;

public abstract class ANTFrame extends JFrame {
   public ANTFrame() {
      super("ANT GUI TEST");
      setContentPane();
      addComponents();
      style();
      this.setVisible(true);
   }
   
   public abstract void setContentPane();
   public abstract void addComponents();
   public abstract void style();
   
   protected void fixComponentSizes(Component Part, Dimension Size) {
      Part.setMinimumSize(Size);
      Part.setMaximumSize(Size);
   }
}
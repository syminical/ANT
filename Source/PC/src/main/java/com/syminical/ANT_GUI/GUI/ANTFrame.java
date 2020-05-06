package syminical.ant_gui;

import javax.swing.*;
import java.awt.*;

public abstract class AntFrame extends JFrame {
   public AntFrame(String __) {
      super(__);
      setContentPane();
      addComponents();
      style();
      this.setVisible(true);
   }
   
   public abstract void setContentPane();
   public abstract void addComponents();
   public abstract void style();
   
   public static void fixComponentSizes(Component Part, Dimension Size) {
      Part.setMinimumSize(Size);
      Part.setMaximumSize(Size);
      Part.setPreferredSize(Size);
   }
}
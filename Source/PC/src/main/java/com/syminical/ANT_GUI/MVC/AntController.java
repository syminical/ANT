package syminical.ant_gui;

public class AntController {
   private static DragListener DL;

   public static void frameCloseXButton() {
      if (ANT_GUI.View() != null) ANT_GUI.View().kill();
      System.exit(0);
   }
   
   public static void initWindowListener() {
      DL = new DragListener();
         DL.setTarget(AntView.Window());
         ANT_GUI.View().Window().addMouseListener(DL);
         ANT_GUI.View().Window().addMouseMotionListener(DL);
   }
   
   public static DragListener DL() { return DL; }
}
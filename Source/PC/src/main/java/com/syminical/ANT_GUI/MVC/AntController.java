package syminical.ant_gui;

public class AntController {
   private static DragListener DL;

   public static void frameCloseX() {
      if (ANT_GUI.View() != null) ANT_GUI.View().kill();
      System.exit(0);
   }
   
   public static void navBarBack() { }
   public static void navBarClearAll() { }
   public static void navBarGear() { }
   public static void navBarInfo() { }
   public static void navBarNotifs() { }
   public static void navBarTexts() { }
   
   public static void initWindowListener() {
      DL = new DragListener();
         DL.setTarget(AntView.Window());
         AntView.Window().addMouseListener(DL);
         AntView.Window().addMouseMotionListener(DL);
   }
   
   public static void splashAnimation() {
      try {
         AntView.splash();
         Thread.sleep(4000);
         AntView.notifs();
      } catch(Exception e) { System.out.println("splash animation failed"); }
   }
   
   public static DragListener DL() { return DL; }
}
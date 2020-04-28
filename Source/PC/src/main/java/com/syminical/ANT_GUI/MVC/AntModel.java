package syminical.ant_gui;

public class AntModel {
   private static AntModel Instance;
   Image[] FrameAssets, NavBarAssets, NotifAssets, ConnectionAssets;
   
   private void init() {
      loadAssets();
   }

   public boolean loadAssets() {
      FrameAssets = new Image[3];
      BodyAssets = new Image[1];
      try {
         FrameAssets[0] = ImageIO.read( this.getClass().getResource("/img/UIexport/FRAME.png") );
         FrameAssets[1] = ImageIO.read( this.getClass().getResource("/img/UIexport/icons/closeXButton/closeX.png") );
         FrameAssets[2] = ImageIO.read( this.getClass().getResource("/img/UIexport/icons/closeXButton/closeXActive.png") );
         BodyAssets[0]  = ImageIO.read( this.getClass().getResource("/img/UIexport/SPLASH.png") );
      } catch (Exception e) { 
   }
   
   public static AntModel getInstance() {
      if (Instance != null) return Instance;
      else return new AntModel();
   }
}
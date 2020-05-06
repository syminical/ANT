package syminical.ant_gui;

import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;

public class AntView {
   private static AntModel Model;
   private static AntFrame Window;
   private final Dimension WINDOW_SIZE = new Dimension( 410, 439 );
   private JPanel BodyPanel, Splash, RegisterOptions, RegisterScan, NotificationList, TextThreadList, TextThread, SettingsOptions, SettingsScan, About;
   //private BackgroundPanel Splash;
   
   private void init() {
      createScenes();
      createWindow();
   }
   
   private void createWindow() {
      ImageList WindowAssets = Model.getImageList(ModelData.FrameAssets);
      
      Window = new AntFrame("ANT GUI TEST") {
         public void setContentPane() {
            this.setContentPane(new BackgroundPanel(WindowAssets.next(), BackgroundPanel.ACTUAL));
            this.fixComponentSizes(this, WINDOW_SIZE);
            ((BackgroundPanel)(this.getContentPane())).setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
            //((BackgroundPanel)(this.getContentPane())).setOpaque(true);
         }
         
         public void addComponents() {
            JPanel TitlePanel = new JPanel();
               this.fixComponentSizes(TitlePanel, new Dimension(410, 34));
               TitlePanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
               TitlePanel.add(new MouseOverComponent(WindowAssets.next(2)) {
                  @Override
                  public void mouseClicked(MouseEvent ME) { AntController.frameCloseXButton(); }
               });
               //TitlePanel.setBackground(new Color(0,0,255));
            ((BackgroundPanel)(this.getContentPane())).add(TitlePanel);
            
            BodyPanel = new JPanel();
               AntFrame.fixComponentSizes(BodyPanel, new Dimension(410, 400));
               BodyPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
               //BodyPanel.setOpaque(true);
               //BodyPanel.setBackground(new Color(0,255,0));
               BodyPanel.add(Box.createRigidArea(new Dimension(5, 400)));
               BodyPanel.add(Splash);
               /*JPanel ContentPanel 
                  this.fixComponentSizes(ContentPanel, new Dimension(400, 400));
                  ContentPanel.setOpaque(true);
                  ContentPanel.setBackground(new Color(0,255,0));
               BodyPanel.add(ContentPanel);*/
            ((BackgroundPanel)(this.getContentPane())).add(BodyPanel);
         }
         
         public void style() {
            this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            this.setUndecorated(true);
            this.fixComponentSizes(this, WINDOW_SIZE);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setVisible(true);
         }
      };
   }
   
   private void createScenes() {
      RegisterOptions = new JPanel();
      RegisterScan = new JPanel();
      NotificationList = new JPanel();
      TextThreadList = new JPanel();
      TextThread = new JPanel();
      SettingsOptions = new JPanel();
      SettingsScan = new JPanel();
      About = new JPanel();
      
      Splash = new JPanel();
         AntFrame.fixComponentSizes(Splash, new Dimension(400, 400));
         Splash.setOpaque(false);
         //Splash.setLayout(new BoxLayout(Splash, BoxLayout.Y_AXIS));
         Splash.add(new BackgroundPanel(Model.getImageList(ModelData.FrameAssets).next(), BackgroundPanel.ACTUAL));
         //Splash.setBackground(new Color(255,127,0));
   }
   
   public void setModel(AntModel __) {
      Model = __;
      init();
   }
   
   public void kill() {
      if (Window == null) return;  
         Window.setVisible(false);
         Window.dispose();
   }
   
   public static AntFrame Window() { return Window; }
}
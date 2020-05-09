package syminical.ant_gui;

import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;

public class AntView {
   private static AntModel Model;
   private static AntFrame Window;
   private final Dimension WINDOW_SIZE = new Dimension( 410, 439 );
   private static JPanel Body, Scene, NavBar, Back, NoBack, ClearAll, NoClearAll, NavTabs, Splash, RegisterOptions, RegisterScan, NotificationList, TextThreadList, TextThread, SettingsOptions, SettingsScan, About;
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
                  public void mouseClicked(MouseEvent ME) { AntController.frameCloseX(); }
               });
               //TitlePanel.setBackground(new Color(0,0,255));
            ((BackgroundPanel)(this.getContentPane())).add(TitlePanel);
            
            Scene = new JPanel();
               AntFrame.fixComponentSizes(Scene, new Dimension(400, 400));
               Scene.setLayout(new BoxLayout(Scene, BoxLayout.Y_AXIS));
               Scene.setOpaque(false);
               Scene.add(NavBar);
               Scene.add(Splash);
            
            Body = new JPanel();
               AntFrame.fixComponentSizes(Body, new Dimension(410, 400));
               Body.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
               //Body.setOpaque(true);
               //Body.setBackground(new Color(0,255,0));
               Body.add(Box.createRigidArea(new Dimension(5, 400)));
               Body.add(Scene);
            ((BackgroundPanel)(this.getContentPane())).add(Body);
               /*JPanel ContentPanel 
                  this.fixComponentSizes(ContentPanel, new Dimension(400, 400));
                  ContentPanel.setOpaque(true);
                  ContentPanel.setBackground(new Color(0,255,0));
               Body.add(ContentPanel);*/
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
      
      NavBar = new JPanel();
         ImageList NavBarAssets = Model.getImageList(ModelData.NavBarAssets);
         AntFrame.fixComponentSizes(NavBar, new Dimension(400, 33));
         NavBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
         NavBar.setOpaque(false);
         Back = new JPanel();
            AntFrame.fixComponentSizes(Back, new Dimension(58, 33));
            Back.setOpaque(false);
            Back.add(new MouseOverComponent(NavBarAssets.next(2)) {
               @Override
               public void mouseClicked(MouseEvent ME) { AntController.navBarBack(); }
            });
            NavBar.add(Back);
         NoBack = new JPanel();
            AntFrame.fixComponentSizes(NoBack, new Dimension(58, 33));
            NoBack.setOpaque(false);
            NoBack.add(Box.createRigidArea(new Dimension(58, 29)));
            NoBack.setVisible(false);
            NavBar.add(NoBack);
         NavBar.add(Box.createRigidArea(new Dimension(108, 1)));
         ClearAll = new JPanel();
            AntFrame.fixComponentSizes(ClearAll, new Dimension(63, 33));
            ClearAll.setOpaque(false);
            ClearAll.add(new MouseOverComponent(NavBarAssets.next(2)) {
               @Override
               public void mouseClicked(MouseEvent ME) { AntController.navBarClearAll(); }
            });
            NavBar.add(ClearAll);
         NoClearAll = new JPanel();
            AntFrame.fixComponentSizes(NoClearAll, new Dimension(63, 33));
            NoClearAll.setOpaque(false);
            NoClearAll.add(Box.createRigidArea(new Dimension(63, 22)));
            NoClearAll.setVisible(false);
            NavBar.add(NoClearAll);
         NavBar.add(Box.createRigidArea(new Dimension(39, 1)));
         NavTabs = new JPanel();
            AntFrame.fixComponentSizes(NavTabs, new Dimension(132, 33));
            NavTabs.setLayout(new BoxLayout(NavTabs, BoxLayout.Y_AXIS));
            NavTabs.setOpaque(false);
            NavTabs.add(new ButtonGroup() {
               @Override
               public void createButtons() {
                  this.add(new NavBarTab(NavBarAssets.next(3)) {
                     @Override
                     public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.navBarGear(); }
                  });
                  this.add(new NavBarTab(NavBarAssets.next(3)) {
                     @Override
                     public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.navBarInfo(); }
                  });
                  this.add(new NavBarTab(NavBarAssets.next(3)) {
                     @Override
                     public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.navBarNotifs(); }
                  });
                  this.add(new NavBarTab(NavBarAssets.next(3)) {
                     @Override
                     public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.navBarTexts(); }
                  });
                  this.selectFirst();
               }
            });
            NavBar.add(NavTabs);
            
      Splash = new JPanel();
         AntFrame.fixComponentSizes(Splash, new Dimension(400, 400));
         Splash.setOpaque(false);
         //Splash.setLayout(new BoxLayout(Splash, BoxLayout.Y_AXIS));
         Splash.add(new BackgroundPanel(Model.getImageList(ModelData.FrameAssets).next(), BackgroundPanel.ACTUAL));
         //Splash.setBackground(new Color(255,127,0));
         Splash.setVisible(false);
   }
   
   public static void splash() {
      if (Window != null) {
         NavBar.setVisible(false);
         Splash.setVisible(true);
      }
   }
   
   public static void notifs() {
      if (Window != null) {
         Splash.setVisible(false);
         NavBar.setVisible(true);
      }
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
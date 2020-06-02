//  Copyright (C) 2020 Alexandru Manaila.

/*  This file is part of A.N.T.

    A.N.T. is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    A.N.T. is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with A.N.T.  If not, see <https://www.gnu.org/licenses/>.
*/

package syminical.ant_gui;

import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;

public class AntView {
   private static AntModel Model;
   private static AntFrame Window;
   private final Dimension WINDOW_SIZE = new Dimension( 410, 439 );
   private static JPanel Body, Scene, NavBar, NoNavBar, Back, NoBack, ClearAll, NoClearAll, NavTabs, NotificationList;
   //below are the scenes available for Scene.
   private static JPanel Splash, ConnectionOptions, ConnectionScan, Notifications, TextThreadList, TextThread, About;
   private JPanel CurrentScene;
   private static JTextArea License;
   private JScrollPane NotificationListHolder;
   //private BackgroundPanel Splash;
   
   private void init() {
      createScenes();
         Model.setConnected(false);
         Model.setCurrentViewState(ViewState.Splash);
         Model.setCurrentScene(Splash);
      createWindow();
      addNotification(0, "one");
      addNotification(1, "two");
      addNotification(2, "three");
      addNotification(3, "four");
      addNotification(4, "five");
      addNotification(5, "six");
      addNotification(6, "seven");
      addNotification(7, "eight");
      addNotification(8, "nine");
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
               Scene.add(Splash);
               Scene.add(NavBar);
               Scene.add(NoNavBar);
               Scene.add(ConnectionOptions);
               Scene.add(ConnectionScan);
               Scene.add(Notifications);
               Scene.add(About);
            
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
      TextThreadList = new JPanel();
      TextThread = new JPanel();
      
      NoNavBar = new JPanel();
         AntFrame.fixComponentSizes(NoNavBar, new Dimension(1, 33));
         NoNavBar.setOpaque(false);
         NoNavBar.setVisible(false);
         
      NavBar = new JPanel();
         ImageList NavBarAssets = Model.getImageList(ModelData.NavBarAssets);
         AntFrame.fixComponentSizes(NavBar, new Dimension(400, 33));
         NavBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
         NavBar.setOpaque(false);
         NavBar.setVisible(false);
         Back = new JPanel();
            AntFrame.fixComponentSizes(Back, new Dimension(58, 33));
            Back.setOpaque(false);
            Back.add(new MouseOverComponent(NavBarAssets.next(2)) {
               @Override
               public void mouseClicked(MouseEvent ME) { if (ME.getComponent().isVisible()) { AntController.navBarBack(); } }
            });
            Back.setVisible(false);
            NavBar.add(Back);
         NoBack = new JPanel();
            AntFrame.fixComponentSizes(NoBack, new Dimension(58, 33));
            NoBack.setOpaque(false);
            NoBack.add(Box.createRigidArea(new Dimension(58, 29)));
            //NoBack.setVisible(false);
            NavBar.add(NoBack);
         NavBar.add(Box.createRigidArea(new Dimension(108, 1)));
         ClearAll = new JPanel();
            AntFrame.fixComponentSizes(ClearAll, new Dimension(63, 33));
            ClearAll.setOpaque(false);
            ClearAll.setVisible(false);
            ClearAll.add(new MouseOverComponent(NavBarAssets.next(2)) {
               @Override
               public void mouseClicked(MouseEvent ME) { if (ME.getComponent().isVisible()) { AntController.navBarClearAll(); } }
            });
            NavBar.add(ClearAll);
         NoClearAll = new JPanel();
            AntFrame.fixComponentSizes(NoClearAll, new Dimension(63, 33));
            NoClearAll.setOpaque(false);
            NoClearAll.add(Box.createRigidArea(new Dimension(63, 22)));
            //NoClearAll.setVisible(false);
            NavBar.add(NoClearAll);
         NavBar.add(Box.createRigidArea(new Dimension(39, 1)));
         NavTabs = new JPanel();
            AntFrame.fixComponentSizes(NavTabs, new Dimension(132, 33));
            NavTabs.setLayout(new BoxLayout(NavTabs, BoxLayout.Y_AXIS));
            NavTabs.setOpaque(false);
            NavTabs.add(new ButtonGroup<ClickableMouseOverComponent>() {
               @Override
               public void createButtons() {
                  this.add(new ClickableMouseOverComponent(NavBarAssets.next(3)) {
                     @Override
                     public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); if (ME != null)  AntController.navBarNotifs(); }
                  });
                  this.add(new ClickableMouseOverComponent(NavBarAssets.next(3)) {
                     @Override
                     public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.navBarTexts(); }
                  });
                  this.add(new ClickableMouseOverComponent(NavBarAssets.next(3)) {
                     @Override
                     public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.navBarGear(); }
                  });
                  this.add(new ClickableMouseOverComponent(NavBarAssets.next(3)) {
                     @Override
                     public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.navBarInfo(); }
                  });
                  this.selectFirst();
               }
            });
         NavBar.add(NavTabs);
         
      ImageList ConnectionAssets = Model.getImageList(ModelData.ConnectionAssets);
      ConnectionOptions = new JPanel();
         ConnectionOptions.setLayout(new BoxLayout(ConnectionOptions, BoxLayout.Y_AXIS));
         AntFrame.fixComponentSizes(ConnectionOptions, new Dimension(400, 367));
         ConnectionOptions.setOpaque(false);
         ConnectionOptions.setVisible(false);
         
         BackgroundPanel ConnOpTitle = new BackgroundPanel(ConnectionAssets.next(), BackgroundPanel.ACTUAL);
            AntFrame.fixComponentSizes(ConnOpTitle, new Dimension(400, 47));
         ConnectionOptions.add(ConnOpTitle);
         
         BackgroundPanel ConnOpSubTitle = new BackgroundPanel(ConnectionAssets.next(), BackgroundPanel.ACTUAL);
            AntFrame.fixComponentSizes(ConnOpSubTitle, new Dimension(400, 75));
         ConnectionOptions.add(ConnOpSubTitle);
         
         JPanel OptionsSpacer = new JPanel();
            OptionsSpacer.setOpaque(false);
            OptionsSpacer.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            AntFrame.fixComponentSizes(OptionsSpacer, new Dimension(400, 104));
            OptionsSpacer.add(Box.createRigidArea(new Dimension(94, 1)));
            JPanel OptionsList = new JPanel();
               //OptionsList.setLayout(new BoxLayout(OptionsList, BoxLayout.Y_AXIS));
               OptionsList.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
               AntFrame.fixComponentSizes(OptionsList, new Dimension(212, 104));
               OptionsList.setOpaque(false);
               OptionsList.add(new ClickableMouseOverComponent(ConnectionAssets.next(3)) {
                  @Override
                  public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.connOpSetNotifList(); }
               });
               OptionsList.add(Box.createRigidArea(new Dimension(212, 20)));
               OptionsList.add(new ClickableMouseOverComponent(ConnectionAssets.next(3)) {
                  @Override
                  public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.connOpSetNewNotif(); }
               });
               OptionsList.add(Box.createRigidArea(new Dimension(212, 20)));
               OptionsList.add(new ClickableMouseOverComponent(ConnectionAssets.next(3)) {
                  @Override
                  public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.connOpSetReadTxts(); }
               });
               OptionsList.add(Box.createRigidArea(new Dimension(212, 20)));
               OptionsList.add(new ClickableMouseOverComponent(ConnectionAssets.next(3)) {
                  @Override
                  public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.connOpSetSendTxts(); }
               });
            OptionsSpacer.add(OptionsList);
         ConnectionOptions.add(OptionsSpacer);
         
         ConnectionOptions.add(Box.createRigidArea(new Dimension(1, 58)));
         
         JPanel GenerateSpacer = new JPanel();
            GenerateSpacer.setOpaque(false);
            GenerateSpacer.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            AntFrame.fixComponentSizes(GenerateSpacer, new Dimension(400, 41));
            GenerateSpacer.add(Box.createRigidArea(new Dimension(133, 1)));
            GenerateSpacer.add(new MouseOverComponent(ConnectionAssets.next(2)) {
               @Override
               public void mouseClicked(MouseEvent ME) { if (ME.getComponent().isVisible()) { AntController.connOpGenerate(); } }
            });
         ConnectionOptions.add(GenerateSpacer);
         
         JPanel NoGenerate = new JPanel();
            AntFrame.fixComponentSizes(NoGenerate, new Dimension(400, 41));
            NoGenerate.setOpaque(false);
            NoGenerate.setVisible(false);
         ConnectionOptions.add(NoGenerate);
         
         ConnectionOptions.add(Box.createRigidArea(new Dimension(1, 17)));
         
         JPanel DeleteSpacer = new JPanel();
            DeleteSpacer.setOpaque(false);
            DeleteSpacer.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            AntFrame.fixComponentSizes(DeleteSpacer, new Dimension(400, 8));
            DeleteSpacer.add(Box.createRigidArea(new Dimension(177, 1)));
            DeleteSpacer.add(new MouseOverComponent(ConnectionAssets.next(2)) {
               @Override
               public void mouseClicked(MouseEvent ME) { if (ME.getComponent().isVisible()) { AntController.connOpDelete(); } }
            });
         ConnectionOptions.add(DeleteSpacer);
            
      ConnectionScan = new JPanel();
         ConnectionScan.setLayout(new BoxLayout(ConnectionScan, BoxLayout.Y_AXIS));
         AntFrame.fixComponentSizes(ConnectionScan, new Dimension(400, 316));
         ConnectionScan.setOpaque(false);
         ConnectionScan.setVisible(false);
         ConnectionScan.add(new BackgroundPanel(ConnectionAssets.next(), BackgroundPanel.ACTUAL));
         ConnectionScan.add(new BackgroundPanel(ConnectionAssets.next(), BackgroundPanel.ACTUAL));
         
      Notifications = new JPanel();
         Notifications.setLayout(new BoxLayout(Notifications, BoxLayout.Y_AXIS));
         AntFrame.fixComponentSizes(Notifications, new Dimension(400, 367));
         Notifications.setOpaque(false);
         Notifications.setVisible(false);
         NotificationList = new JPanel();
            NotificationList.setLayout(new BoxLayout(NotificationList, BoxLayout.Y_AXIS));
            //NotificationList.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
            //AntFrame.fixComponentSizes(NotificationList, new Dimension(390, 356));
            NotificationList.setOpaque(false);
            //NotificationList.setBackground(new Color(255, 255, 0));
            //NotificationList.add(Box.createRigidArea(new Dimension(10, 10)));
         NotificationListHolder = new JScrollPane(NotificationList);
            AntFrame.fixComponentSizes(NotificationListHolder, new Dimension(400, 367));
            NotificationListHolder.setVerticalScrollBar(new AntScrollBar(Model.getImageList(ModelData.MiscAssets).tailList(0).next(2)));
            NotificationListHolder.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            NotificationListHolder.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            NotificationListHolder.setOpaque(false);
            NotificationListHolder.getViewport().setOpaque(false);
            NotificationListHolder.setBorder(javax.swing.BorderFactory.createEmptyBorder(6,0,6,6));
            //NotificationListHolder.setBackground(new Color(255, 0, 255));
            //NotificationListHolder.getViewport().setBackground(new Color(0,255,0));
            //NotificationListHolder.setBorder(javax.swing.BorderFactory.createEmptyBorder(6,6,6,6));
         Notifications.add(NotificationListHolder, BorderLayout.CENTER);
      
      About = new JPanel();
         About.setLayout(new BoxLayout(About, BoxLayout.Y_AXIS));
         AntFrame.fixComponentSizes(About, new Dimension(400, 367));
         About.setOpaque(false);
         About.setVisible(false);
         //JTextArea License = new JTextArea(Model.getString(ModelData.License), 1, 1);
         License = new JTextArea(Model.getString(ModelData.License), 1, 1);
            //AntFrame.fixComponentSizes(License, new Dimension(33, 70));
            License.setFont(new Font("Courier New Bold", Font.PLAIN, 11));
            License.setEditable(false);
            License.setOpaque(false);
            License.setHighlighter(null);
            License.setForeground(Color.WHITE);
            License.setLineWrap(true);
            License.setWrapStyleWord(true);
         JScrollPane LicenseHolder = new JScrollPane(License);
            AntFrame.fixComponentSizes(LicenseHolder, new Dimension(400, 367));
            LicenseHolder.setVerticalScrollBar(new AntScrollBar(Model.getImageList(ModelData.MiscAssets).tailList(0).next(2)));
            LicenseHolder.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            LicenseHolder.setOpaque(false);
            LicenseHolder.getViewport().setOpaque(false);
            LicenseHolder.setBorder(javax.swing.BorderFactory.createEmptyBorder(6,6,6,6));
         About.add(LicenseHolder);
         
      Splash = new JPanel();
         AntFrame.fixComponentSizes(Splash, new Dimension(400, 400));
         Splash.setOpaque(false);
         Splash.setVisible(true);
         //Splash.setLayout(new BoxLayout(Splash, BoxLayout.Y_AXIS));
         Splash.add(new BackgroundPanel(Model.getImageList(ModelData.FrameAssets).next(), BackgroundPanel.ACTUAL));
   }
   
   public void addNotification(int id, String Text) {
      JPanel __ = new JPanel();
         __.setOpaque(false);
         __.setLayout(new BoxLayout(__, BoxLayout.Y_AXIS));
         AntFrame.fixComponentSizes(__, new Dimension(314, 60));
         __.add(Box.createRigidArea(new Dimension(314, 9)));//286
         __.add(new NotificationCard(Model.getImageList(ModelData.NotificationAssets).tailList(1).next(6), id, Text));
      NotificationList.add(__);
   }
   
   //navbar visible is the default
   public static void setScene(ViewState __) {
      // current state description
      ViewState __CurrentViewState = Model.getCurrentViewState();
         if (__CurrentViewState == __) return;
      JPanel __CurrentScene = Model.getCurrentScene();
      boolean __connected = Model.getConnected();
      
      // future state description
      Model.setCurrentViewState(__);
      switch(__) {
         case ConnectionOptions: Model.setCurrentScene(ConnectionOptions); break;
         case ConnectionScan: Model.setCurrentScene(ConnectionScan); break;
         case Notifications: Model.setCurrentScene(Notifications); break;
         case TextThreadList: Model.setCurrentScene(TextThreadList); break;
         case TextThread: Model.setCurrentScene(TextThread); break;
         case About: Model.setCurrentScene(About); break;
         default:
      }
      
      // transition from current to future state
      switch(__CurrentViewState) { // cleanup
         case Splash:
            NavBar.setVisible(true);
            if (!__connected) NavTabs.setVisible(false);
            break;
         case ConnectionOptions:
            if (!__connected && __ == ViewState.ConnectionOptions) { // remove clicked
               NavTabs.setVisible(false);
            } else { // generate clicked
               Back.setVisible(true);
               NoBack.setVisible(false);
               ClearAll.setVisible(true);
               NoClearAll.setVisible(false);
            }
            break;
         case ConnectionScan:
            Back.setVisible(false);
            NoBack.setVisible(true);
            if (__ == ViewState.Notifications) {
               NavTabs.setVisible(true);
               ((ButtonGroup)(NavTabs.getComponents()[0])).selectFirst();
            }
            break;
         case Notifications:
            ClearAll.setVisible(false);
            NoClearAll.setVisible(true);
         default:
      }
      switch(__) { // prep
         case Notifications:
            ClearAll.setVisible(true);
            NoClearAll.setVisible(false);
         default:
      }
      __CurrentScene.setVisible(false);
      Model.getCurrentScene().setVisible(true);
   }
   
   public void removeNotification(Component __) {
      NotificationList.remove(__);
      NotificationList.revalidate();
      NotificationList.repaint();
   }
   
   public void removeAllNotifications() {
      NotificationList.removeAll();
      NotificationList.revalidate();
      NotificationList.repaint();
   }
   
   public static void saveLicense() {
      Model.saveLicense(License.getText());
   }
   
   public static void splash() {
      /*if (Window != null) {
         NavBar.setVisible(false);
         Splash.setVisible(true);
      }*/
   }
   
   public static void notifs() {
      /*if (Window != null) {
         Splash.setVisible(false);
         NavBar.setVisible(true);
      }*/
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
   
   public static boolean isNavVisible() { return NavBar.isVisible(); }
   public static AntFrame Window() { return Window; }
}
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
   private static JPanel Body, Scene, NavBar, NoNavBar, Back, NoBack, ClearAll, NoClearAll, NavTabs, Splash, ConnectionOptions,
                  ConnectionScan, NotificationList, TextThreadList, TextThread, SettingsOptions, SettingsScan, About;
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
               Scene.add(NoNavBar);
               NoNavBar.setVisible(false);
               Scene.add(Splash);
               Scene.add(ConnectionOptions);
               ConnectionOptions.setVisible(false);
               Scene.add(ConnectionScan);
               ConnectionScan.setVisible(false);
               //Scene.add(ConnectionScan);
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
      NotificationList = new JPanel();
      TextThreadList = new JPanel();
      TextThread = new JPanel();
      About = new JPanel();
      
      NoNavBar = new JPanel();
         AntFrame.fixComponentSizes(NoNavBar, new Dimension(1, 33));
         NoNavBar.setOpaque(false);
         
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
                     public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.navBarGear(); }
                  });
                  this.add(new ClickableMouseOverComponent(NavBarAssets.next(3)) {
                     @Override
                     public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.navBarInfo(); }
                  });
                  this.add(new ClickableMouseOverComponent(NavBarAssets.next(3)) {
                     @Override
                     public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.navBarNotifs(); }
                  });
                  this.add(new ClickableMouseOverComponent(NavBarAssets.next(3)) {
                     @Override
                     public void mouseClicked(MouseEvent ME) { super.mouseClicked(ME); AntController.navBarTexts(); }
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
         ConnectionScan.add(new BackgroundPanel(ConnectionAssets.next(), BackgroundPanel.ACTUAL));
         ConnectionScan.add(new BackgroundPanel(ConnectionAssets.next(), BackgroundPanel.ACTUAL));
      
      About = new JPanel();
         About.setLayout(new BoxLayout(About, BoxLayout.Y_AXIS));
         AntFrame.fixComponentSizes(About, new Dimension(400, 367));
         About.setOpaque(false);
         JTextArea License = new JTextArea(Model.getString(ModelData.License), 1, 1);
            //AntFrame.fixComponentSizes(License, new Dimension(33, 70));
            License.setFont(new Font("Courier New Bold", Font.PLAIN, 9));
            License.setEditable(false);
            License.setOpaque(false);
            License.setHighlighter(null);
            License.setForeground(Color.WHITE);
         JScrollPane LicenseHolder = new JScrollPane(License);
            AntFrame.fixComponentSizes(LicenseHolder, new Dimension(400, 367));
            LicenseHolder.setVerticalScrollBar(new AntScrollBar(Model.getImageList(ModelData.MiscAssets).next(2)));
            LicenseHolder.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            LicenseHolder.setOpaque(false);
            LicenseHolder.getViewport().setOpaque(false);
            LicenseHolder.setBorder(javax.swing.BorderFactory.createEmptyBorder(6,6,6,6));
         About.add(LicenseHolder);
         
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
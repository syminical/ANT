package syminical.ant_gui;

import javax.swing.*;

public class AntView extends JPanel {
   private static AntModel Model;
   private JPanel Splash, RegisterOptions, RegisterScan, NotificationList, TextThreadList, TextThread, SettingsOptions, SettingsScan, About;
   
   public AntView() {
      init();
   }
   
   public void setModel(AntModel __) {
      Model = __;
      init();
   }
   
   private void init() {
      if (Model != null) return;
      
      Splash = new JPanel();
      RegisterOptions = new JPanel();
      RegisterScan = new JPanel();
      NotificationList = new JPanel();
      TextThreadList = new JPanel();
      TextThread = new JPanel();
      SettingsOptions = new JPanel();
      SettingsScan = new JPanel();
      About = new JPanel();
   }
}
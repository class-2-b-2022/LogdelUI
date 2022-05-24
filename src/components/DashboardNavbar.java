package components;

import handlers.LogoutHandler;

import javax.swing.*;
import java.awt.*;

public class DashboardNavbar {
    private Panel navbar=new Panel();
    public Panel returnNavbar(String title) {
        Label appTitle = new Label();
        appTitle.setText(title);
        appTitle.setForeground(Color.white);
        appTitle.setBounds(0, 0, 300, 40);
        appTitle.setFont(new Font("Arial", Font.BOLD, 18));
        JButton logout = new JButton("Logout");
        logout.setActionCommand("logout");
        logout.addActionListener(new LogoutHandler());
        navbar.setBackground(new Color(000033));
        navbar.setLayout(new GridLayout(1, 2));
        navbar.add(appTitle);
        navbar.add(logout);

//        JLabel la6=new JLabel();
//        Panel profile = new Panel();
//        profile.setLayout(new FlowLayout(FlowLayout.RIGHT));
//        la6.setIcon(new ImageIcon("assets\\profile.png"));// your image here
//        profile.add(la6);
//        navbar.add(profile);
        return navbar;
    }
}

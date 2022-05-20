package components;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Yves Isite
 */
public class DashboardNavbar {
    private Panel navbar=new Panel();
    public Panel returnNavbar(String title,String adminName) {
        Label appTitle = new Label(title, Label.CENTER);
        appTitle.setForeground(Color.white);
        appTitle.setBounds(0, 0, 600, 40);
        appTitle.setFont(new Font("Arial", Font.BOLD, 18));

        navbar.setBackground(new Color(0x0B0B2D));
        navbar.setLayout(new GridLayout(1, 2));
        navbar.add(appTitle);

        Panel prof=new Panel();
        prof.setLayout(new GridLayout(1, 2));

        Label name = new Label(adminName);
        name.setForeground(Color.white);
        name.setBounds(0, 0, 600, 40);
        name.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel la6=new JLabel();
        Panel profile = new Panel();
        la6.setIcon(new ImageIcon("assets\\profile.png"));// your image here
        
        prof.add(la6);
        prof.add(name);

        navbar.add(prof);
        return navbar;
    }
}

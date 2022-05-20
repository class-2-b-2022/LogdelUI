package components;

import pages.Inventory;
import utils.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: Yves Isite
 */
public class DashboardSidebar extends Panel {
    private Panel sidebar = new Panel();
    JButton showInventory;
    Theme theme = new Theme();

    public JButton createButton(String text, Color color){
        JButton button = new JButton(text);
        button.setForeground(color!=null ? color: Color.white);
        button.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
        button.setBackground(theme.getPrimary());
        button.setFocusable(false);
        return button;
    }

    public Panel returnSidebar () {
        sidebar.setLayout(new GridLayout(8, 1));
        sidebar.setBackground(new Color(31, 31, 115));

        showInventory = this.createButton("Inventory", null);
        showInventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inventory inventory = new Inventory();

            }
        });

        addSidebarItem1("Inventory", "truck.png");

        addSidebarItem("Company Management", "industry.png");
        addSidebarItem("Delivery", "truck.png");
        addSidebarItem("Notifications", "notifications.png");
        addSidebarItem("Billing", "billing.png");
        addSidebarItem("Account", "account.png");
        return sidebar;
    }

    private void addSidebarItem1(String title,String image) {
        JPanel sidebarOpt=new JPanel();
        sidebarOpt.setBackground(new Color(31, 31, 115));
        sidebarOpt.setLayout(new GridLayout(2, 1));
        sidebarOpt.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        showInventory.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
        showInventory.setFont(new Font("Arial", Font.BOLD, 15));
        showInventory.setBackground(new Color(31, 31, 115));
        showInventory.setForeground(Color.white);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("assets\\"+image));// your image here
        sidebarOpt.add(label);
        sidebarOpt.add(showInventory);
        sidebar.add(sidebarOpt);
    }

    private void addSidebarItem(String title,String image) {
        JPanel sidebarOpt=new JPanel();
        sidebarOpt.setLayout(new GridLayout(2, 1));
        JButton l1=new JButton(title);
        sidebarOpt.setBackground(new Color(31, 31, 115));
        sidebarOpt.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        l1.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
        l1.setFont(new Font("Arial", Font.BOLD, 15));
        l1.setBackground(new Color(31, 31, 115));
        l1.setForeground(Color.white);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("assets\\"+image));// your image here
        sidebarOpt.add(label);
        sidebarOpt.add(l1);
        sidebar.add(sidebarOpt);
    }
}

package components;

import javax.swing.*;
import java.awt.*;

public class DashboardSidebar extends Panel {
    private Panel sidebar = new Panel();
    public Panel returnSidebar () {
        sidebar.setLayout(new GridLayout(5, 1));
        sidebar.setBackground(new Color(31, 31, 115));

        addSidebarItem("Company Management", "industry.png");
        addSidebarItem("Delivery", "truck.png");
        addSidebarItem("Notifications", "notifications.png");
        addSidebarItem("Billing", "billing.png");
        addSidebarItem("Account", "account.png");
        return sidebar;
    }

    private void addSidebarItem(String title,String image) {
        Panel sidebarOpt=new Panel();
        sidebarOpt.setLayout(new GridLayout(2, 1));
        JButton l1=new JButton(title);
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

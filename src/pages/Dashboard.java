package pages;

import utils.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard {
    JFrame frame;
    JPanel container;
    JButton showInventory, showCompany;
    Theme theme = new Theme();
    public Dashboard() {
        frame = new JFrame("Dashboard");
        frame.setBounds(300, 130, 1000, 1000);
        container = new JPanel();
       showInventory = this.createButton("Inventory", null);
       showCompany = this.createButton("Company", null);
       showCompany.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               MainCompanyPage inventory = new MainCompanyPage();

           }
       });
        container.add(showCompany);
        frame.add(container);
        frame.setVisible(true);
    }

    public JButton createButton(String text, Color color){
        JButton button = new JButton(text);
        button.setForeground(color!=null ? color: Color.white);
        button.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
        button.setBackground(theme.getPrimary());
        button.setFocusable(false);
        return button;
    }
}

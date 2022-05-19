package pages;

import utils.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reports extends JFrame implements ActionListener {
    Frame frame = new JFrame();
    JPanel container = new JPanel();
    Theme theme = new Theme();
    JLabel title = new JLabel("INVENTORY REPORTS MODULE");
    JPanel content = new JPanel();

    public Reports(){
        frame.setBounds(300, 130, 700, 500);
        container.setBounds(0, 50, 700, 500);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(theme.getPrimary());
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        content.setLayout(new GridLayout(2,1));
        content.setBackground(Color.lightGray);
        container.add(title);
        container.add(content);

        container.setBackground(theme.getSecondary());
        frame.add(container);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args){
        Reports reports = new Reports();
    }
}

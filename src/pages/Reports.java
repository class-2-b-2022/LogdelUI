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
    JLabel title = new JLabel("REPORTS MODULE");
    JButton option = createButton("Choose reports to view", new Color(0,51,102));
    JButton choice1 = createButton("Company Management Reports",new Color(0, 51, 102));
    JButton choice2 = createButton("Inventory Management Reports",new Color(0, 51, 102));

    public Reports(){
        frame.setBounds(300, 130, 700, 500);
        container.setBounds(0, 50, 700, 500);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(theme.getPrimary());
        title.setFont(new Font("Arial", Font.BOLD, 20));
        container.add(title);

        container.setBackground(theme.getSecondary());
        frame.add(container);
        frame.setResizable(false);
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
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args){
        Reports reports = new Reports();
    }
}

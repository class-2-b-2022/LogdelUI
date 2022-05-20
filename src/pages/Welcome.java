package pages;

import utils.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome implements ActionListener {
    JFrame frame = new JFrame();
    Theme theme = new Theme();
    JLabel inWord = new JLabel("WELCOME TO LOGDEL");
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\student\\Documents\\GitHub\\LogdelUI\\src\\assets\\logdel.png").getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT));
    ImageIcon headerIcon = new ImageIcon("C:\\Users\\student\\Documents\\GitHub\\LogdelUI\\src\\assets\\logdelWhite.png");


    JLabel logo = new JLabel();
    JPanel container = new JPanel();
    JPanel welcome = new JPanel();
    JPanel account = new JPanel();
//    Border border = comp.getInsideBorder();
    JButton login = createButton("Login",null);
    JButton registerCompanyBtn = createButton("Register your company",new Color(0, 51, 102));
    public Welcome(){
        frame.setBounds(300, 130, 700, 500);
        frame.setIconImage(headerIcon.getImage());
        container.setBounds(0, 50, 700, 500);
        inWord.setHorizontalAlignment(SwingConstants.CENTER);
        inWord.setForeground(theme.getPrimary());
        inWord.setFont(new Font("Arial", Font.BOLD, 20));
//        panel.setLocation(100, 300);
        welcome.setLayout(new GridLayout(2,1));
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.add(inWord);
        logo.setIcon(imageIcon);
        welcome.add(logo);
        welcome.setBackground(theme.getSecondary());
        account.add(login);
        account.setBackground(theme.getSecondary());
        account.setLayout(new FlowLayout(FlowLayout.CENTER));
        container.add(welcome);
        container.add(account);
        container.setLayout(new GridLayout(2,1));
        frame.add(container);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    public JLabel createLabel(String text, Color color){
        JLabel label = new JLabel(text);
        label.setForeground(color);
        return label;
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
}

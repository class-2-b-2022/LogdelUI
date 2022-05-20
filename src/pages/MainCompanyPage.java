package pages;

import utils.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCompanyPage extends JFrame {


    Theme theme = new Theme();
    JPanel welcome = new JPanel();
    JPanel navigation = new JPanel();
    JLabel logo = new JLabel();
    JLabel companyMain = createLabel("COMPANY MANAGEMENT",null);
    JButton create = createMenu("Register", null);
    JButton view = createMenu("View Info", null);
    JButton update = createMenu("Update Info", null);
    JButton delete = createMenu("Delete Company", null);
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\allie\\OneDrive\\Documents\\Java_P\\LogdelUI\\src\\assets\\logdel.png").getImage().getScaledInstance(200, 220, Image.SCALE_DEFAULT));
    ImageIcon headerIcon = new ImageIcon("C:\\Users\\allie\\OneDrive\\Documents\\Java_P\\LogdelUI\\src\\assets\\logdelwhite.png");
    JMenuBar companyMenu = new JMenuBar();
    JFrame frame2;

    public MainCompanyPage(){
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setBounds(100,200, 500,400);
        this.setLayout(new GridLayout(2,1));
        navigation.setLayout(new GridLayout(2,1));
        companyMain.setHorizontalAlignment(SwingConstants.CENTER);
        companyMain.setForeground(theme.getPrimary());
        navigation.add(companyMain);
        companyMain.setFont(new Font("Arial", Font.BOLD, 20));
        logo.setIcon(imageIcon);
        welcome.add(logo);
        welcome.setBounds(1,1, 100,60);
        companyMenu.add(create);
        companyMenu.add(view);
        companyMenu.add(update);
        companyMenu.add(delete);
        navigation.add(companyMenu);
        this.setIconImage(headerIcon.getImage());
        this.add(welcome);
        this.add(navigation);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                create = new JFrame("Second menu");
//                f2.setBackground(Color.CYAN);
//                f2.setBounds(20,20, 500, 600
                CreateCompany createCompany = new CreateCompany();
            }
        });
    }
    public JLabel createLabel(String text, Color color){
        JLabel label = new JLabel(text);
        label.setForeground(color);
        return label;
    }
    public JButton createMenu(String text, Color color){
        JButton button = new JButton(text);
        button.setForeground(color!=null ? color: Color.black);
        button.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
        button.setBackground(theme.getPrimary());
        button.setFocusable(false);
        button.setFont(new Font("Arial", Font.TYPE1_FONT, 12));
        return button;
    }
//
//    public static void main(String args[]){
//        new MainCompanyPage();
//    }
}

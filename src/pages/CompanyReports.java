package pages;

import utils.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompanyReports extends JFrame implements ActionListener {
    Frame frame = new JFrame();

    FlowLayout layout = new FlowLayout();
    JPanel container = new JPanel();
    Theme theme = new Theme();
    JLabel title = new JLabel("Company Reports");
    JPanel content = new JPanel();

    JPanel tin_panel = new JPanel();
    JPanel name_panel = new JPanel();
    JPanel email_panel = new JPanel();
    JPanel type_panel = new JPanel();
    JPanel phone_panel = new JPanel();
    JPanel desc_panel = new JPanel();
    JPanel create_panel = new JPanel();

    JLabel tin = new JLabel("Tin: ");
    JLabel name = new JLabel("Company Name: ");
    JLabel email = new JLabel("Email: ");
    JLabel type = new JLabel("Type: ");
    JLabel phone = new JLabel("Phone: ");
    JLabel desc = new JLabel("Description: ");
    JLabel created = new JLabel("CreatedAt: ");

    JLabel tin_content = new JLabel("12345");
    JLabel name_content = new JLabel("Bralirwa");
    JLabel email_content = new JLabel("info@gmail.com");
    JLabel type_content = new JLabel("Manufacturer");
    JLabel phone_content = new JLabel("0788834874");
    JLabel desc_content = new JLabel("Manufacturers");
    JLabel created_content = new JLabel("2022-05-04");

    Object[][] data = {{1,"12345", "Bralirwa","info@gmail.com", "Manufacturer", "0788834874", "Manufacturers","2022-05-04"}, {2,"12345", "Bralirwa","info@gmail.com", "Manufacturer", "0788834874", "Manufacturers","2022-05-04"}};

    public CompanyReports(){
        frame.setBounds(300, 130, 700, 500);
        container.setBounds(0, 50, 700, 500);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(theme.getPrimary());
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10,10));
        tin.setHorizontalAlignment(SwingConstants.CENTER);

        tin_panel.add(tin);
        tin_panel.add(tin_content);
        name_panel.add(name);
        name_panel.add(name_content);
        email_panel.add(email);
        email_panel.add(email_content);
        type_panel.add(type);
        type_panel.add(type_content);
        phone_panel.add(phone);
        phone_panel.add(phone_content);
        desc_panel.add(desc);
        desc_panel.add(desc_content);
        create_panel.add(created);
        create_panel.add(created_content);

        container.setLayout(new GridLayout(9,1));
        container.add(title);
        container.add(tin_panel);
        container.add(name_panel);
        container.add(email_panel);
        container.add(type_panel);
        container.add(phone_panel);
        container.add(desc_panel);
        container.add(create_panel);

        container.setBackground(theme.getSecondary());
        frame.add(container);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args){CompanyReports companyReports = new CompanyReports();}
}

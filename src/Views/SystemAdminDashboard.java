package Views;

import javax.swing.*;

import pages.Inventory;
import utils.Theme;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemAdminDashboard extends JPanel {
    GridBagConstraints constraints = new GridBagConstraints();
    Panel navbar = new Panel();
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
    public SystemAdminDashboard() {
        setLayout(new GridBagLayout());
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        int x, y;  // for clarity
        constraints.gridheight = 7; // span two rows

        Panel sidebar = new Panel();
        showInventory = this.createButton("Inventory", null);
        showInventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inventory inventory = new Inventory(1);

            }
        });
        sidebar.add(showInventory);
        sidebar.setBackground(new Color(31, 31, 115));
        addGB(sidebar,   x = 0, y = 0, 0.2);
        constraints.gridheight = 1; // set it back

        Label appTitle = new Label();
        appTitle.setText(" LODGEL APP");
        appTitle.setForeground(Color.white);
        appTitle.setBounds(0, 0, 300, 40);
        appTitle.setFont(new Font("Arial", Font.BOLD, 18));

        navbar.setBackground(new Color(000033));
        navbar.setLayout(new GridLayout(1, 2));
        navbar.add(appTitle);
        addGB(navbar,   x = 1, y = 0, 0.8);

        Panel contentHolder = new Panel();
        contentHolder.setBackground(new Color(0x303057));
        addGB(contentHolder, x=1, y=1, 0.8);

        Panel contentHolder1 = new Panel();
        contentHolder1.setBackground(new Color(0x303057));
        addGB(contentHolder1, x=1, y=2, 0.8);

        Panel contentHolder2 = new Panel();
        contentHolder2.setBackground(new Color(0x303057));
        addGB(contentHolder2, x=1, y=3, 0.8);

        Panel contentHolder3 = new Panel();
        contentHolder3.setBackground(new Color(0x303057));
        addGB(contentHolder3, x=1, y=4, 0.8);

        Panel contentHolder4 = new Panel();
        contentHolder4.setBackground(new Color(0x303057));
        addGB(contentHolder4, x=1, y=5, 0.8);

        Panel contentHolder5 = new Panel();
        contentHolder5.setBackground(new Color(0x303057));
        addGB(contentHolder5, x=1, y=6, 0.8);

//        constraints.gridwidth = 2; // span two columns
//        addGB(new JButton("four"),  x = 1, y = 1, 1.0);
        constraints.gridwidth = 1; // set it back
        constraints.gridheight = 1;
    }

    public void addGB(Component component, int x, int y,double weightx) {
        constraints.weightx = weightx;
        constraints.gridx = x;
        constraints.gridy = y;
        add(component, constraints);
    }

    public static void DashboardMain() {
        JFrame frame = new JFrame("System Admin | Dashboard");
        frame.setIconImage((new ImageIcon("assets\\logo1.png")).getImage());
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setBounds(0, 0, 1366, 768);
        frame.setContentPane(new SystemAdminDashboard());
        frame.setVisible(true);
    }
}
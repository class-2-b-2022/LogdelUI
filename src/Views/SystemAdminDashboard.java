package Views;

import components.DashboardNavbar;
import components.DashboardSidebar;
import utils.CheckLoggedInStatus;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Yves Isite
 */
public class SystemAdminDashboard extends JPanel {
    GridBagConstraints constraints = new GridBagConstraints();
    private Panel sidebar = new DashboardSidebar().returnSidebar();

    public SystemAdminDashboard() throws Exception {
        CheckLoggedInStatus loginStatus=new CheckLoggedInStatus();
//        User loggedInUser = loginStatus.getLoggedInUser();
//        if(!loggedInUser)
//            System.out.println("Please login first");
        setLayout(new GridBagLayout());
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        int x, y;  // for clarity
        constraints.gridheight = 7; // span two rows

        int profitPercentage=7;
        int newCompanyRequests=3;
        addGB(sidebar,   x = 0, y = 0, .1);
        constraints.gridheight = 1; // set it back

        addGB(new DashboardNavbar().returnNavbar("LOGDEL System Admin", "Yves Isite"),   x = 1, y = 0, 0.8);

        Label contentHolder = new Label("2 Companies registered", Label.CENTER);
        contentHolder.setBackground(new Color(16, 33, 90));
        contentHolder.setForeground(Color.white);
        contentHolder.setFont(new Font("Arial", Font.BOLD, 16));
        addGB(contentHolder, x=1, y=1, 0.8);

        Label contentHolder1 = new Label(profitPercentage+"% Profit obtained so far", Label.CENTER);
        contentHolder1.setBackground(new Color(0xFFFFFF));
        contentHolder1.setForeground(Color.black);
        contentHolder1.setFont(new Font("Arial", Font.BOLD, 16));
        addGB(contentHolder1, x=1, y=2, 0.8);

        Label contentHolder2 = new Label(newCompanyRequests+" New company requests", Label.CENTER);
        contentHolder2.setForeground(Color.white);
        contentHolder2.setFont(new Font("Arial", Font.BOLD, 16));
        contentHolder2.setBackground(new Color(0x1E7B1B));
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

        Panel contentHolder6 = new Panel();
        contentHolder6.setBackground(new Color(0x303057));
        addGB(contentHolder6, x=1, y=7, 0.8);

        Panel contentHolder7 = new Panel();
        contentHolder7.setBackground(new Color(0x303057));
        addGB(contentHolder7, x=1, y=8, 0.8);

//        constraints.gridwidth = 2; // span two columns
//        addGB(new JButton("four"),  x = 1, y = 1, 1.0);
        constraints.gridwidth = 1; // set it back
        constraints.gridheight = 1;
    }

    void addGB(Component component, int x, int y,double weightx) {
        constraints.weightx = weightx;
        constraints.gridx = x;
        constraints.gridy = y;
        add(component, constraints);
    }

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("System Admin | Dashboard");
        frame.setIconImage((new ImageIcon("assets\\logo1.png")).getImage());
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setBounds(0, 0, 1366, 768);
        frame.setContentPane(new SystemAdminDashboard());
        frame.setVisible(true);
    }

    public static void mainMethod() throws Exception {
        JFrame frame = new JFrame("System Admin | Dashboard");
        frame.setIconImage((new ImageIcon("assets\\logo1.png")).getImage());
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setBounds(0, 0, 1366, 768);
        frame.setContentPane(new SystemAdminDashboard());
        frame.setVisible(true);
    }
}
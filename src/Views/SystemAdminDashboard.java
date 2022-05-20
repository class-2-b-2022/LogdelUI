package Views;

import components.DashboardNavbar;
import components.DashboardSidebar;

import javax.swing.*;
import java.awt.*;

public class SystemAdminDashboard extends JPanel {
    GridBagConstraints constraints = new GridBagConstraints();
    public SystemAdminDashboard() {
        setLayout(new GridBagLayout());
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        int x, y;  // for clarity
        constraints.gridheight = 7; // span two rows

        addGB(new DashboardSidebar().returnSidebar(),   x = 0, y = 0, 0.1);
        constraints.gridheight = 1; // set it back

        addGB(new DashboardNavbar().returnNavbar("LOGDEL Admin"),   x = 1, y = 0, 0.8);

        Panel contentHolder = new Panel();
        contentHolder.setBackground(Color.WHITE);
        addGB(contentHolder, x=1, y=1, 0.8);

        Panel contentHolder1 = new Panel();
        contentHolder1.setBackground(Color.WHITE);
        addGB(contentHolder1, x=1, y=2, 0.8);

        Panel contentHolder2 = new Panel();
        contentHolder2.setBackground(Color.WHITE);
        addGB(contentHolder2, x=1, y=3, 0.8);

        Panel contentHolder3 = new Panel();
        contentHolder3.setBackground(Color.WHITE);
        addGB(contentHolder3, x=1, y=4, 0.8);

        Panel contentHolder4 = new Panel();
        contentHolder4.setBackground(Color.WHITE);
        addGB(contentHolder4, x=1, y=5, 0.8);

        Panel contentHolder5 = new Panel();
        contentHolder5.setBackground(Color.WHITE);
        addGB(contentHolder5, x=1, y=6, 0.8);

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

    public static void main(String[] args) {
        JFrame frame = new JFrame("System Admin | Dashboard");
        frame.setIconImage((new ImageIcon("C:\\Users\\user\\OneDrive\\Documents\\projects\\Logistics-java-project\\logdel-ui\\LogdelUI\\assets\\logo1.png")).getImage());
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setBounds(0, 0, 1366, 768);
        frame.setContentPane(new SystemAdminDashboard());
        frame.setVisible(true);
    }

    public static void mainMethod() {
        JFrame frame = new JFrame("System Admin | Dashboard");
        frame.setIconImage((new ImageIcon("C:\\Users\\user\\OneDrive\\Documents\\projects\\Logistics-java-project\\logdel-ui\\LogdelUI\\assets\\logo1.png")).getImage());
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setBounds(0, 0, 1366, 768);
        frame.setContentPane(new SystemAdminDashboard());
        frame.setVisible(true);
    }
}
package Views;

import components.DashboardNavbar;
import components.DashboardSidebar;
import handlers.InventoryHandler;
import handlers.RoutingHandler;
import handlers.VehicleManagementHandler;

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

        Panel sidebar = new Panel();

//        showInventory = this.createButton("Inventory", null);
//        showInventory.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Inventory inventory = new Inventory();
//
//            }
//        });
//        sidebar.add(showInventory);
        sidebar.setLayout(new GridLayout(5, 1));
        sidebar.setBackground(new Color(31, 31, 115));

        Panel sidebarOpt1=new Panel();
        sidebarOpt1.setLayout(new GridLayout(2, 1));
        Button l1=new Button("Company Management");
        l1.setFont(new Font("Arial", Font.BOLD, 15));
        l1.setBackground(new Color(31, 31, 115));
        l1.setForeground(Color.white);
        JLabel label = new JLabel();
//        label.setLayout(new FlowLayout(FlowLayout.CENTER));
        label.setIcon(new ImageIcon("assets\\industry.png"));// your image here
        label.setForeground(Color.red);
        sidebarOpt1.add(label);
        sidebarOpt1.add(l1);
        sidebar.add(sidebarOpt1);

        Panel sidebarOpt2=new Panel();
        sidebarOpt2.setLayout(new GridLayout(2, 1));
        Button l2=new Button("Delivery");
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        l2.setBackground(new Color(31, 31, 115));
        l2.setForeground(Color.white);
        l2.setActionCommand("delivery");
        l2.addActionListener(new RoutingHandler());

        JLabel la2=new JLabel();
//        la2.setLayout(new FlowLayout(FlowLayout.CENTER));
        la2.setIcon(new ImageIcon("assets\\truck.png"));// your image here
        sidebarOpt2.add(la2);
        sidebarOpt2.add(l2);
        sidebar.add(sidebarOpt2);

        Panel sidebarOpt3=new Panel();
        sidebarOpt3.setLayout(new GridLayout(2, 1));
        Button l3=new Button("Inventory");
        l3.setActionCommand("inventory");
        l3.addActionListener(new InventoryHandler());
        l3.setFont(new Font("Arial", Font.BOLD, 15));
        l3.setBackground(new Color(31, 31, 115));
        l3.setForeground(Color.white);
        JLabel la3=new JLabel();
        la3.setLayout(new FlowLayout(FlowLayout.CENTER));
        la3.setIcon(new ImageIcon("assets\\notifications.png"));// your image here
        sidebarOpt3.add(la3);
        sidebarOpt3.add(l3);
        sidebar.add(sidebarOpt3);

        Panel sidebarOpt4=new Panel();
        sidebarOpt4.setLayout(new GridLayout(2, 1));
        Button l4=new Button("Billing");
        l4.setFont(new Font("Arial", Font.BOLD, 15));
        l4.setBackground(new Color(31, 31, 115));
        l4.setForeground(Color.white);
        JLabel la4=new JLabel();
        la4.setLayout(new FlowLayout(FlowLayout.CENTER));
        la4.setIcon(new ImageIcon("assets\\billing.png"));// your image here
        sidebarOpt4.add(la4);
        sidebarOpt4.add(l4);
        sidebar.add(sidebarOpt4);

        Panel sidebarOpt5=new Panel();
        sidebarOpt5.setLayout(new GridLayout(2, 1));
        Button l5=new Button("Account");
        l5.setFont(new Font("Arial", Font.BOLD, 15));
        l5.setBackground(new Color(31, 31, 115));
        l5.setForeground(Color.white);
        JLabel la5=new JLabel();
//        la5.setLayout(new FlowLayout(FlowLayout.CENTER));
        la5.setIcon(new ImageIcon("assets\\account.png"));// your image here
        sidebarOpt5.add(la5);
        sidebarOpt5.add(l5);
        sidebar.add(sidebarOpt5);

        addGB(sidebar,   x = 0, y = 0, 0.1);
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
        frame.setIconImage((new ImageIcon("assets\\logo1.png")).getImage());
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setBounds(0, 0, 1366, 768);
        frame.setContentPane(new SystemAdminDashboard());
        frame.setVisible(true);
    }

    public static void mainMethod() {
        JFrame frame = new JFrame("System Admin | Dashboard");
        frame.setIconImage((new ImageIcon("assets\\logo1.png")).getImage());
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setBounds(0, 0, 1366, 768);
        frame.setContentPane(new SystemAdminDashboard());
        frame.setVisible(true);
    }
}
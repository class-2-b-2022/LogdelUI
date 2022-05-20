package Views;

import javax.swing.*;

import utils.Theme;

import java.awt.*;

public class SystemAdminDashboard extends JPanel {
    GridBagConstraints constraints = new GridBagConstraints();
    Panel navbar = new Panel();

    public SystemAdminDashboard() {
        setLayout(new GridBagLayout());
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        int x, y;  // for clarity
        constraints.gridheight = 7; // span two rows

        Panel sidebar = new Panel();
        sidebar.setLayout(new GridLayout(5, 1));
        sidebar.setBackground(new Color(31, 31, 115));

        Panel sidebarOpt1=new Panel();
        sidebarOpt1.setLayout(new GridLayout(2, 1));
        Button l1=new Button("Company Management");
        l1.setFont(new Font("Arial", Font.BOLD, 15));
        l1.setBackground(new Color(31, 31, 115));
        l1.setForeground(Color.white);
        JLabel label = new JLabel();
        label.setLayout(new FlowLayout(FlowLayout.CENTER));
        label.setIcon(new ImageIcon("assets\\industry.png"));// your image here
        sidebarOpt1.add(label);
        sidebarOpt1.add(l1);
        sidebar.add(sidebarOpt1);

        Panel sidebarOpt2=new Panel();
        sidebarOpt2.setLayout(new GridLayout(2, 1));
        Button l2=new Button("Delivery");
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        l2.setBackground(new Color(31, 31, 115));
        l2.setForeground(Color.white);
        JLabel la2=new JLabel();
//        la2.setLayout(new FlowLayout(FlowLayout.CENTER));
        la2.setIcon(new ImageIcon("assets\\truck.png"));// your image here
        sidebarOpt2.add(la2);
        sidebarOpt2.add(l2);
        sidebar.add(sidebarOpt2);

        Panel sidebarOpt3=new Panel();
        sidebarOpt3.setLayout(new GridLayout(2, 1));
        Button l3=new Button("Notifications");
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
        la5.setLayout(new FlowLayout(FlowLayout.CENTER));
        la5.setIcon(new ImageIcon("assets\\account.png"));// your image here
        sidebarOpt5.add(la5);
        sidebarOpt5.add(l5);
        sidebar.add(sidebarOpt5);

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
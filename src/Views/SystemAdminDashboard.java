package Views;

import javax.swing.*;
import utils.Theme;
import java.awt.*;

public class SystemAdminDashboard {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints c1 = new GridBagConstraints();

        Panel rightHandSide = new Panel();
        Panel sidebar = new Panel();

        Panel navbar = new Panel();
        rightHandSide.setLayout(new GridBagLayout());
        navbar.setBackground(new Color(51, 51, 204));
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.weightx = 1;
        c1.gridx = 0;
        c1.ipady = 50;
        c1.gridy = 0;
        rightHandSide.add(navbar, c1);


        rightHandSide.setBackground(new Theme().getPrimary());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.weightx = 0.8;
        c.gridx = 1;
        c.ipady = 768;
        c.gridy = 0;
        pane.add(rightHandSide, c);

        sidebar.setBackground(new Color(0, 51, 204));
        c.weightx = 0.2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 768;
        pane.add(sidebar, c);
    }


    private static void createAndShowGUI() {
//Create and set up the window.
        JFrame frame = new JFrame("System Admin | Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Set up the content pane.
        addComponentsToPane(frame.getContentPane());

//Display the window.
        frame.setBounds(0, 0, 1366, 768);
        frame.setVisible(true);
    }

    public static void mainMethod() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
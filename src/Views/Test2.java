package Views;

import utils.Theme;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Test2 {
    GridBagConstraints constraints = new GridBagConstraints();
    public static void addComponentsToPane(JFrame frame, Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints c1 = new GridBagConstraints();

        Container rightHandSide = new Panel();
        Panel sidebar = new Panel();

        Panel navbar = new Panel();
        Label appTitle = new Label();
        appTitle.setText(" LODGEL APP");
        appTitle.setForeground(Color.white);
        appTitle.setBounds(0, 0, 300, 40);
        appTitle.setFont(new Font("Arial", Font.BOLD, 18));
        rightHandSide.setLayout(new GridBagLayout());
        navbar.setBackground(new Color(000033));
        navbar.setLayout(new GridLayout(1, 2));
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.weightx = 1;
        c1.weighty = 0;
        c1.gridx = 0;
        c1.ipady = 60;
        c1.gridy = 0;
        navbar.add(appTitle);
        rightHandSide.add(navbar, c1);

        rightHandSide.setBackground(new Theme().getPrimary());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.weightx = 0.8;
        c.gridx = 1;
        c.ipady = 50;
        c.gridheight = 3;
        c.gridy = 0;
        pane.add(rightHandSide, c);

        sidebar.setBackground(new Color(4, 4, 29));
        c.weightx = 0.1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 768;
        pane.add(sidebar, c);
    }


    private static void createAndShowGUI() {
        JFrame frame = new JFrame("System Admin | Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame, frame.getContentPane());
        frame.setIconImage((new ImageIcon("assets\\logdel.png")).getImage());
        frame.setBounds(0, 0, 1366, 768);
        frame.setVisible(true);
    }

    void addGB(Component component, int x, int y, JFrame frame) {
        constraints.gridx = x;
        constraints.gridy = y;
        frame.add(component, constraints);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

/**
 * @author : Yves Isite
 */
public class SystemAdminDashboard extends Frame {
    private Panel sidebar=new Panel();
    private Panel rightHandSide=new Panel();
    private Panel navbar=new Panel();
    private Label appTitle=new Label();
    private Panel userContent = new Panel();

    SystemAdminDashboard() {
        ImageIcon img = new ImageIcon("/src/images/icon.png");
        setIconImage(img.getImage());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        sidebar.setBackground(new Color(94, 3, 3, 1));
        add(sidebar);
        appTitle.setText("LODGEL APP");
        appTitle.setForeground(Color.white);
        appTitle.setBounds(50, 50, 300, 40);
        appTitle.setFont(new Font("Arial", Font.BOLD, 16));
        navbar.setLayout(new GridLayout(1,2));
        navbar.setBackground(new Color(112, 0, 0, 1));
        navbar.add(appTitle);
        rightHandSide.setLayout(new GridLayout(7, 1));
        rightHandSide.setBackground(Color.WHITE);
        rightHandSide.add(navbar);
        userContent.setBackground(Color.BLUE);
        rightHandSide.add(userContent);
        add(rightHandSide);
        setVisible(true);
        setSize(1366, 768);
        setTitle("System Admin | Dashboard");
        setLayout(new GridLayout(1, 2));
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        SystemAdminDashboard adminDashboard = new SystemAdminDashboard();
    }
}

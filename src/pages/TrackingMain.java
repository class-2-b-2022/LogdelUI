package pages;


import handlers.TrackingHandler;

import utils.Theme;

import javax.swing.*;
import java.awt.*;

public class TrackingMain extends JFrame {
    private final Theme theme = new Theme();
    public TrackingMain(){
        this.setVisible(true);
        this.setTitle("Tracking Management Module");
        this.setBounds(12,12,400,500);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));

        JLabel label = new JLabel("WELCOME TO TRACKING MANAGEMENT SYSTEM");
        label.setForeground(theme.getRedForeground());
        label.setFont(new Font("ARIAL",Font.BOLD,20));
        label.setAlignmentX(CENTER_ALIGNMENT);

        Dimension d = label.getMaximumSize();
        Dimension maximumSize = new Dimension(d);

        container.add(label);

        createButton("View En-route Vehicles",theme,"view_outgoing",container,maximumSize);
        createButton("Add Leaving Vehicles",theme,"add_outgoing",container,maximumSize);



        this.add(container);
    }

    private void createButton(String label,Theme theme,String value,JPanel container,Dimension maximumSize){
        JButton btn = new JButton(label);
        btn.setBackground(theme.getRedForeground());
        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createEtchedBorder(0));
        btn.setFont(new Font("Arial",Font.BOLD,17));
        btn.setActionCommand(value);
        btn.addActionListener(new TrackingHandler());

        btn.setMaximumSize(maximumSize);
        container.add(btn);


    }
}
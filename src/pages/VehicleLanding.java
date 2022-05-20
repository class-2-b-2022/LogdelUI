package pages;

import handlers.VehicleManagementHandler;
import utils.Theme;

import javax.swing.*;
import java.awt.*;

public class VehicleLanding extends JFrame {
    private Theme theme = new Theme();
    public VehicleLanding(){
        this.setVisible(true);
        this.setTitle("Vehicle Management Module");
        this.setBounds(10,10,1000,500);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));

        JLabel label = new JLabel("WELCOME TO VEHICLE MANAGEMENT SYSTEM");
        label.setForeground(theme.getSideBarColor());
        label.setFont(new Font("ARIAL",Font.BOLD,20));
        label.setAlignmentX(CENTER_ALIGNMENT);

        Dimension d = label.getMaximumSize();
        Dimension maximumSize = new Dimension(d);

        container.add(label);

        createButton("View Vehicles",theme,"view_vehicles",container,maximumSize);
        createButton("Add Vehicle",theme,"add_vehicle",container,maximumSize);
        createButton("Tracking",theme,"tracking",container,maximumSize);



        this.add(container);
    }

    private void createButton(String label,Theme theme,String value,JPanel container,Dimension maximumSize){
        JButton btn = new JButton(label);
        btn.setBackground(theme.getSideBarColor());
        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createEtchedBorder(0));
        btn.setFont(new Font("Arial",Font.BOLD,17));
        btn.setActionCommand(value);
        btn.addActionListener(new VehicleManagementHandler());

        btn.setMaximumSize(maximumSize);

        container.add(btn);


    }
}

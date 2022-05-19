package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventory implements ActionListener {
    JFrame frame = new JFrame();
    JLabel l_inventoryId,l_quantity, l_status, l_productId, l_companyTIN,l_mainHeader;
    JTextField t_inventoryId, t_quantity, t_status, t_productId, t_companyTIN;
    JButton createInventory;

    public void createInventory() {
        frame.setVisible(true);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setTitle("Create Inventory");

        l_mainHeader = new JLabel("Create Inventory");
        l_mainHeader.setBounds(100,25,120,25);
        l_mainHeader.setBackground(Color.blue);

        l_inventoryId = new JLabel("Inventory Id: ");
        l_inventoryId.setBounds(50,50,175,25);
        t_inventoryId = new JTextField();
        t_inventoryId.setBounds(135,50,75,25);

        l_quantity = new JLabel("Quantity: ");
        l_quantity.setBounds(50,75,75,25);
        t_quantity = new JTextField();
        l_status = new JLabel("Status: ");
        l_status.setBounds(50,100,75,25);

        l_productId = new JLabel("Product Id: ");
        l_productId.setBounds(50,125,75,25);

        l_companyTIN = new JLabel("Company TIN: ");
        l_companyTIN.setBounds(50,150,85,25);

        frame.add(l_mainHeader);

        frame.add(l_inventoryId);
        frame.add(t_inventoryId);

        frame.add(l_quantity);
        frame.add(l_status);
        frame.add(l_productId);
        frame.add(l_companyTIN);
    }

    public static void main(String args[]) {
        Inventory inventory = new Inventory();
        inventory.createInventory();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

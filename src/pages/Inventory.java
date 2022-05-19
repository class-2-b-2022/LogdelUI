package pages;

import formats.InventoryModel;
import formats.RequestBody;
import formats.ResponseBody;
import utils.ConnectToServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventory implements ActionListener {
    JFrame frame = new JFrame();
    JLabel l_inventoryId,l_quantity, l_status, l_productId, l_companyTIN,l_mainHeader;
    JTextField t_inventoryId, t_quantity, t_productId, t_companyTIN;
    Choice c_status;
    JButton createInventory;
    JLabel messageLabel = new JLabel();
    InventoryModel model = new InventoryModel();
    RequestBody request = new RequestBody();
    ConnectToServer connectToServer = new ConnectToServer();
    ResponseBody response = new ResponseBody();

    public void createInventory() {
        frame.setVisible(true);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setTitle("Create Inventory");

        l_mainHeader = new JLabel("Create Inventory");
        l_mainHeader.setBounds(100,25,120,25);

        l_inventoryId = new JLabel("Inventory Id: ");
        l_inventoryId.setBounds(50,50,175,25);
        t_inventoryId = new JTextField();
        t_inventoryId.setBounds(135,50,150,25);

        l_quantity = new JLabel("Quantity: ");
        l_quantity.setBounds(50,75,75,25);
        t_quantity = new JTextField();
        t_quantity.setBounds(135,75,150,25);

        l_status = new JLabel("Status: ");
        l_status.setBounds(50,100,75,25);
        c_status = new Choice();
        c_status.setBounds(135,100,150,25);
        c_status.add("");
        c_status.add("IN");
        c_status.add("OUT");

        l_productId = new JLabel("Product Id: ");
        l_productId.setBounds(50,125,75,25);
        t_productId = new JTextField();
        t_productId.setBounds(135,125,150,25);

        l_companyTIN = new JLabel("Company TIN: ");
        l_companyTIN.setBounds(50,150,85,25);
        t_companyTIN = new JTextField();
        t_companyTIN.setBounds(135,150,150,25);

        createInventory = new JButton("Create Inventory");
        createInventory.setBounds(50,185,100,25);
        createInventory.setActionCommand("Create");
        createInventory.addActionListener(this);
        frame.add(l_mainHeader);
        frame.add(createInventory);

        frame.add(l_inventoryId);
        frame.add(t_inventoryId);

        frame.add(l_quantity);
        frame.add(t_quantity);

        frame.add(l_status);
        frame.add(c_status);

        frame.add(l_productId);
        frame.add(t_productId);

        frame.add(l_companyTIN);
        frame.add(t_companyTIN);
    }

    public static void main(String args[]) {
        Inventory inventory = new Inventory();
        inventory.createInventory();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == createInventory) {
                model.setBranchId(Integer.parseInt(t_companyTIN.getText()));
                model.setProductId(Integer.parseInt(t_productId.getText()));
                model.setQuantity(Integer.parseInt(t_quantity.getText()));
                model.setStatus(c_status.getItem(c_status.getSelectedIndex()));
                request.setAction("POST");
                request.setRoute("/inventory");
                request.setData(model);

                try {
                    response = connectToServer.connectToServer(request);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                frame.dispose();
                Welcome welcomePage = new Welcome();
                welcomePage.InventoryHomePage();
            }
    }
}

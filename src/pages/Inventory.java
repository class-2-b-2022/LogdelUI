package pages;

import models.InventoryModel;
import services.InventoryService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    JFrame frame;
    JTable inventoriesTable;
    InventoryService inventoryService = new InventoryService(1);
    DefaultTableModel defaultTableModel;

    List<InventoryModel> inventories;
    InventoryModel inventoryModel;
    public Inventory() {
        inventories = inventoryService.getInventory();
        frame = new JFrame("Inventory");
        frame.setBounds(300, 130, 700, 500);
        frame.setVisible(true);

        String column[]={"Quantity","Product Id","Branch Id", "status"};
        defaultTableModel = new DefaultTableModel();
        inventoriesTable = new JTable(defaultTableModel);
        inventoriesTable.setPreferredScrollableViewportSize(new Dimension(300, 100));
        inventoriesTable.setFillsViewportHeight(true);
        frame.add(new JScrollPane(inventoriesTable));
        defaultTableModel.addColumn("Quantity");
        defaultTableModel.addColumn("Product Name");
        defaultTableModel.addColumn("Price");
        defaultTableModel.addColumn("status");

        for (int i=0; i<inventories.size(); i++){
            this.inventoryModel = (InventoryModel) inventories.get(i);
            defaultTableModel.addRow(new Object[]{inventoryModel.getQuantity(), inventoryModel.getProductName(), inventoryModel.getPricePerBulk(), inventoryModel.getStatus()});
        }
        frame.setVisible(true);
    }
}

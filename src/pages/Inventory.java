package pages;

import components.Table;
import formats.ProductModel;
import formats.RequestBody;
import formats.ResponseBody;
import models.InventoryModel;
import services.InventoryService;
import utils.ConnectToServer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    RequestBody request;
    ResponseBody response;
    ProductModel productModel;
    int branchId;

    JFrame globalFrame;
    public Inventory(int branchId) {
        this.branchId = branchId;
        globalFrame = new JFrame("Inventory Dashboard");
        globalFrame.setBounds(100, 100, 1000, 1000);
        globalFrame.setLayout(new FlowLayout());

        JButton createInventory = new JButton("Create Inventory");
        createInventory.setBounds(500, 500, 200, 30);
        JButton showInventories = new JButton("Show Inventories");
        showInventories.setBounds(500, 600, 200, 30);
        globalFrame.add(createInventory);
        globalFrame.add(showInventories);
        createInventory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Inventory.createInventory(branchId);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        showInventories.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inventory.showInventories();
            }
        });
        globalFrame.setVisible(true);
        }
        public static void showInventories() {
            JFrame frame;
            JTable inventoriesTable;
            InventoryService inventoryService = new InventoryService(1);
            DefaultTableModel defaultTableModel;

            List<InventoryModel> inventories;
            InventoryModel inventoryModel;
            inventories = inventoryService.getInventory();
            frame = new JFrame("Inventory");
            frame.setBounds(300, 130, 700, 500);
            frame.setVisible(true);

            Object columns[] = {"Quantity", "Product Id", "Branch Id", "status"};
            defaultTableModel = new DefaultTableModel();
            inventoriesTable = new JTable(defaultTableModel);
            inventoriesTable.setPreferredScrollableViewportSize(new Dimension(300, 100));
            inventoriesTable.setFillsViewportHeight(true);
            inventoriesTable.getTableHeader().setBackground(Color.BLUE);
            inventoriesTable.getTableHeader().setForeground(Color.white);
            inventoriesTable.setDefaultRenderer(Object.class, new TableCellRenderer(){
                private final DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    if (row%2 == 0){
                        c.setBackground(new Color(1, 150,200));
                    }
                    else {
                        c.setBackground(new Color(215,215,215));
                    }
                    return c;
                }

            });
            ((DefaultTableCellRenderer)inventoriesTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

            JScrollPane inventoryTableDisplay = new JScrollPane(inventoriesTable);
            inventoriesTable.getTableHeader().setPreferredSize(new Dimension(inventoriesTable.getWidth(),40));
            inventoryTableDisplay.getViewport().setBackground(Color.WHITE);
            inventoriesTable.setBorder(BorderFactory.createLineBorder(Color.white));

            frame.add(inventoryTableDisplay);
            defaultTableModel.addColumn("Quantity");
            defaultTableModel.addColumn("Product Name");
            defaultTableModel.addColumn("Price");
            defaultTableModel.addColumn("status");

            for (int i = 0; i < inventories.size(); i++) {
                inventoryModel = (InventoryModel) inventories.get(i);
                defaultTableModel.addRow(new Object[]{inventoryModel.getQuantity(), inventoryModel.getProductName(), inventoryModel.getPricePerBulk(), inventoryModel.getStatus()});
            }
        }
        public static void createInventory (int branchId) throws Exception {
            List<ProductModel> products = new InventoryService(branchId).getProducts();
            JButton createInventory;
            JLabel  l_quantity, l_status, l_productId, l_mainHeader;
            JTextField  t_quantity;
            Choice c_status, c_product;
            JLabel message  = new JLabel();
            JFrame frame = new JFrame();
            frame.setVisible(true);
            frame.setSize(600, 600);
            frame.setLayout(null);
            frame.setTitle("Create Inventory");

            l_mainHeader = new JLabel("Create Inventory");
            l_mainHeader.setBounds(100, 25, 120, 25);

            l_quantity = new JLabel("Quantity: ");
            l_quantity.setBounds(50, 75, 75, 25);
            t_quantity = new JTextField();
            t_quantity.setBounds(135, 75, 150, 25);

            l_status = new JLabel("Status: ");
            l_status.setBounds(50, 100, 75, 25);
            c_status = new Choice();
            c_status.setBounds(135, 100, 150, 25);
            c_status.add("IN");
            c_status.add("OUT");

            l_productId = new JLabel("Product Name: ");
            l_productId.setBounds(50, 125, 75, 25);
            c_product = new Choice();
            c_product.setBounds(135, 125, 150, 25);
            ProductModel productModel1;
            for (int i = 0; i < products.size(); i++) {
                productModel1 = (ProductModel) products.get(i);
                c_product.add(productModel1.getProductName());
            }


            createInventory = new JButton("Create Inventory");
            createInventory.setBounds(50, 185, 100, 25);
            createInventory.setActionCommand("Create");
            createInventory.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    InventoryService inventoryService = new InventoryService(branchId);
                    ProductModel product;
                    InventoryModel inventoryModel = new InventoryModel();
                    for (int i = 0; i < products.size(); i++) {
                        product = (ProductModel) products.get(i);
                        if (product.getProductName().equals(c_product.getItem(c_product.getSelectedIndex()))){
                            inventoryModel.setProductId(product.getProductId());
                            break;
                        }
                    }
                    inventoryModel.setStatus(c_status.getItem(c_status.getSelectedIndex()));
                    inventoryModel.setQuantity(Integer.parseInt(t_quantity.getText()));
                    inventoryModel.setBranchId(branchId);
                    try {
                        message.setText(inventoryService.createInventory(inventoryModel));
                        frame.add(message);
                        Thread.sleep(1000);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }finally {
                        frame.dispose();
                    }

                }
            });
            frame.add(l_mainHeader);
            frame.add(createInventory);

            frame.add(l_quantity);
            frame.add(t_quantity);

            frame.add(l_status);
            frame.add(c_status);

            frame.add(l_productId);
            frame.add(c_product);

        }
    }
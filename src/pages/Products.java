package pages;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import formats.ProductModel;
import formats.RequestBody;
import formats.ResponseBody;
import services.ProductService;
import java.awt.event.*;
import java.awt.FlowLayout;

public class Products {
	 RequestBody request;
	    ResponseBody response;
	    ProductModel productModel;
	    int branchId;

	    JFrame globalFrame;
	    
	    public Products(int branchId) {
	        
	        globalFrame = new JFrame("Product Dashboard");
	        globalFrame.setBounds(100, 100, 1000, 1000);
	        globalFrame.setLayout(new FlowLayout());

	        JButton createProduct = new JButton("Create Product");
	        createProduct.setBounds(500, 500, 200, 30);
	        JButton showProducts = new JButton("Show Products");
	        showProducts.setBounds(500, 600, 200, 30);
	     
	        globalFrame.add(createProduct);
	        globalFrame.add(showProducts);
	        
	        createProduct.addActionListener(new ActionListener() {
	        	  @Override
	              public void actionPerformed(ActionEvent e) {
	                  try {
	                      Products.createProducts(branchId);
	                  } catch (Exception ex) {
	                      throw new RuntimeException(ex);
	                  }
	              }
	        });

//	        showInventories.addActionListener(new ActionListener() {
//	            @Override
//	            public void actionPerformed(ActionEvent e) {
//	                Inventory.showInventories();
//	            }
//	        });
	        globalFrame.setVisible(true);
	}
	        
	        
//	        public static void showInventories() {
//	            JFrame frame;
//	            JTable inventoriesTable;
//	            InventoryService inventoryService = new InventoryService(1);
//	            DefaultTableModel defaultTableModel;
//
//	            List<InventoryModel> inventories;
//	            InventoryModel inventoryModel;
//	            inventories = inventoryService.getInventory();
//	            frame = new JFrame("Inventory");
//	            frame.setBounds(300, 130, 700, 500);
//	            frame.setVisible(true);
//
//	            Object columns[] = {"Quantity", "Product Id", "Branch Id", "status"};
//	            defaultTableModel = new DefaultTableModel();
//	            inventoriesTable = new JTable(defaultTableModel);
//	            inventoriesTable.setPreferredScrollableViewportSize(new Dimension(300, 100));
//	            inventoriesTable.setFillsViewportHeight(true);
//	            inventoriesTable.getTableHeader().setBackground(Color.BLUE);
//	            inventoriesTable.getTableHeader().setForeground(Color.white);
//	            inventoriesTable.setDefaultRenderer(Object.class, new TableCellRenderer(){
//	                private final DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();
//	                @Override
//	                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//	                    Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//	                    if (row%2 == 0){
//	                        c.setBackground(new Color(1, 150,200));
//	                    }
//	                    else {
//	                        c.setBackground(new Color(215,215,215));
//	                    }
//	                    return c;
//	                }
//
//	            });
//	            ((DefaultTableCellRenderer)inventoriesTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
//
//	            JScrollPane inventoryTableDisplay = new JScrollPane(inventoriesTable);
//	            inventoriesTable.getTableHeader().setPreferredSize(new Dimension(inventoriesTable.getWidth(),40));
//	            inventoryTableDisplay.getViewport().setBackground(Color.WHITE);
//	            inventoriesTable.setBorder(BorderFactory.createLineBorder(Color.white));
//
//	            frame.add(inventoryTableDisplay);
//	            defaultTableModel.addColumn("Quantity");
//	            defaultTableModel.addColumn("Product Name");
//	            defaultTableModel.addColumn("Price");
//	            defaultTableModel.addColumn("status");
//
//	            for (int i = 0; i < inventories.size(); i++) {
//	                inventoryModel = (InventoryModel) inventories.get(i);
//	                defaultTableModel.addRow(new Object[]{inventoryModel.getQuantity(), inventoryModel.getProductName(), inventoryModel.getPricePerBulk(), inventoryModel.getStatus()});
//	            }
//	        }
	        public static void createProducts (int branchId) throws Exception {
	            
//				List<ProductModel> products =  (List<ProductModel>) new ProductService(branchId);
	            JButton createProduct;
	            JLabel  l_name, l_type, l_price;
	            JTextField  t_name,t_type,t_price;
	            
	            JLabel message  = new JLabel();
	            JFrame frame = new JFrame();
	            frame.setVisible(true);
	            frame.setSize(600, 600);
	            frame.setLayout(null);
	            frame.setTitle("Register Product");

	            JLabel l_mainHeader = new JLabel("Register Product");
	            l_mainHeader.setBounds(100, 25, 120, 25);

//	            l_name = new JLabel("Product Name: ");
//	            l_name.setBounds(50, 75, 75, 25);
//	            t_name = new JTextField();
//	            t_name.setBounds(135, 75, 150, 25);
//
//				l_type = new JLabel("Product Type: ");
//				l_type.setBounds(50, 75, 75, 25);
//				t_type = new JTextField();
//				t_type.setBounds(135, 150, 150, 25);
//				l_price = new JLabel("Product Price: ");
//				l_price.setBounds(50, 75, 75, 25);
//				t_price = new JTextField();
//				t_price.setBounds(135, 125, 150, 25);
	            l_name = new JLabel("Product Name: ");
	            l_name.setBounds(50, 75, 75, 25);
	            t_name = new JTextField();
	            t_name.setBounds(135, 75, 150, 25);

	            l_type = new JLabel("Product Type: ");
	            l_type.setBounds(50, 100, 75, 25);
	            t_type = new JTextField();
	            t_type.setBounds(135, 100, 150, 25);
	           

	            l_price = new JLabel("Product Price: ");
	            l_price.setBounds(50, 125, 75, 25);
	            t_price = new JTextField();
	            t_price.setBounds(135, 125, 150, 25);
//	            t_price.addKeyListener(new KeyAdapter() 
//	            {
//	                public void keyTyped(KeyEvent e) {
//	                    char c = e.getKeyChar();
//	                    if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
//	                         e.consume();  // if it's not a number, ignore the event
//	                    }
//	                }
	          
	          


	            createProduct = new JButton("Register Product");
	            createProduct.setBounds(50, 185, 100, 25);
	            createProduct.setActionCommand("Create");
	            createProduct.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    ProductService productService = new ProductService(branchId);
	                    ProductModel product;
	                    ProductModel productModel = new ProductModel();
	                  productModel.setProductName(t_name.getText());
	                  productModel.setProductType(t_type.getText());
	                  productModel.setCompanyId(branchId);
	                  productModel.setPricePerBulk(Integer.parseInt(t_price.getText()));

	                    try {
	                        message.setText(productService.createProduct(productModel));
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
	            frame.add(createProduct);

	            frame.add(l_name);
	            frame.add(t_name);

	            frame.add(t_type);
	            frame.add(l_type);

	            frame.add(t_price);
	            frame.add(l_price);

	        }
}

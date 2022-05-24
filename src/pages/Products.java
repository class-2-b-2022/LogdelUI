package pages;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import formats.ProductModel;
import formats.RequestBody;
import formats.ResponseBody;
import services.ProductService;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Color;
public class Products {
	 RequestBody request;
	    ResponseBody response;
//	    ProductModel productModel;
	    int branchId;

	    JFrame globalFrame;
	    
        JTable productsTable;
        ProductService productService = new ProductService(1);
        DefaultTableModel defaultTableModel;

        List<ProductModel> products;
       ProductModel productModel;
	    
	    public Products(int branchId) throws Exception {
	        
	        globalFrame = new JFrame("Product Dashboard");
	        globalFrame.setBounds(300, 130, 700, 500);
	        globalFrame.setLayout(new FlowLayout());

	        JButton createProduct = new JButton("Create Product");
	        createProduct.setBounds(500, 500, 200, 30);
//	        JButton showProducts = new JButton("Show Products");
//	        showProducts.setBounds(500, 600, 200, 30);
	     
//	        globalFrame.add(createProduct);
//	        globalFrame.add(showProducts);
	        
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
//
//	        showProducts.addActionListener(new ActionListener() {
//	            @Override
//	            public void actionPerformed(ActionEvent e) {
//	               try {
//					Products.showproducts();
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//	            }
//	        });
	        globalFrame.setVisible(true);
//	}
	        
	        
//	        public static void showproducts() throws Exception {
//	          
//	        }
	 
        products =productService.getProducts();
//        frame = new JFrame("Products");
//        frame.setBounds(300, 130, 700, 500);
//        frame.setVisible(true);

//        Object columns[] = {"Product", "Type", "Price(Bulk)"};
        defaultTableModel = new DefaultTableModel();
        productsTable = new JTable(defaultTableModel);
        productsTable.setPreferredScrollableViewportSize(new Dimension(300, 100));
        productsTable.setFillsViewportHeight(true);
        productsTable.getTableHeader().setBackground(Color.BLUE);
        productsTable.getTableHeader().setForeground(Color.white);
        productsTable.setDefaultRenderer(Object.class, new TableCellRenderer(){
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
        ((DefaultTableCellRenderer)productsTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        JScrollPane productsTableDisplay = new JScrollPane(productsTable);
        productsTable.getTableHeader().setPreferredSize(new Dimension(productsTable.getWidth(),40));
        productsTableDisplay.getViewport().setBackground(Color.WHITE);
        productsTable.setBorder(BorderFactory.createLineBorder(Color.white));

       globalFrame.add(productsTableDisplay);
        defaultTableModel.addColumn("Product");
        defaultTableModel.addColumn("Type");
        defaultTableModel.addColumn("Price/(Bulk)");
       

        for (int i = 0; i < products.size(); i++) {
            productModel = (ProductModel) products.get(i);
            defaultTableModel.addRow(new Object[]{productModel.getProductName(), productModel.getProductType(),productModel.getPricePerBulk()});
        }
	    }
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

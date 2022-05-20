package pages.Reports;

import components.InventoryReport;
import formats.RequestBody;
import formats.ResponseBody;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InventoryReportsTable {
    RequestBody request;
    ResponseBody response;
    ReportManager reportManager = new ReportManager();
    InventoryReport reportModel;
    int branchId;

    JFrame globalFrame;
    public InventoryReportsTable() {
        globalFrame = new JFrame("Reports Dashboard");
        globalFrame.setBounds(100, 100, 1000, 1000);
        globalFrame.setLayout(new FlowLayout());

        JButton companyReports = new JButton("Company Reports");
        companyReports.setBounds(500, 500, 200, 30);
        JButton inventoryReports = new JButton("Inventory Reports");
        inventoryReports.setBounds(500, 600, 200, 30);

        globalFrame.add(companyReports);
        globalFrame.add(inventoryReports);
        companyReports.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        inventoryReports.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InventoryReportsTable.InventoryReportsTable();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        globalFrame.setVisible(true);
    }
    public static void InventoryReportsTable() throws Exception {
        JFrame frame;
        JTable inventoriesTable;
        ReportManager reportManager = new ReportManager();
        DefaultTableModel defaultTableModel;

        List<InventoryReport> reports;
        InventoryReport inventoryReport;
        reports = reportManager.viewReports();
        frame = new JFrame("Reports");
        frame.setBounds(300, 130, 700, 500);
        frame.setVisible(true);

        Object columns[] = {"Date", "Product", "Status", "Quantity","Company"};
        defaultTableModel = new DefaultTableModel();
        inventoriesTable = new JTable(defaultTableModel);
        inventoriesTable.setPreferredScrollableViewportSize(new Dimension(300, 100));
        inventoriesTable.setFillsViewportHeight(true);
        inventoriesTable.getTableHeader().setBackground(new Color(255, 3, 98));
        inventoriesTable.getTableHeader().setForeground(Color.white);
        inventoriesTable.setDefaultRenderer(Object.class, new TableCellRenderer(){
            private final DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row%2 == 0){
                    c.setBackground(new Color(255, 134, 180));
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
//            defaultTableModel.addColumn("Inventory Id");
        defaultTableModel.addColumn("Date");
        defaultTableModel.addColumn("Product");
        defaultTableModel.addColumn("Status");
        defaultTableModel.addColumn("Quantity");
        defaultTableModel.addColumn("Company");


        for (int i = 0; i < reports.size(); i++) {
            inventoryReport = (InventoryReport) reports.get(i);
            defaultTableModel.addRow(new Object[]{inventoryReport.getDate(),inventoryReport.getProduct(),inventoryReport.getStatus(),inventoryReport.getQuantity(),inventoryReport.getCompanyName()});
        }
    }
}



package pages;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class Billing extends JFrame {

//    JTable table;
   public static CardLayout card = new CardLayout(40, 30);
    public Billing() throws HeadlessException {
        this.setVisible(true);

//        this.setLayout(new BorderLayout());

        Panel container = new Panel();
        container.setLayout(card);
        DefaultTableModel model = new DefaultTableModel(data, columns);
        model.setColumnIdentifiers(columns);

        JTable table = new JTable(model) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        table.setRowHeight(40);

        table.getTableHeader().setOpaque(false);
        table.setShowGrid(false);

        table.getTableHeader().setReorderingAllowed(false);
        Color color = new Color(112,0,0);
        table.getTableHeader().setBackground(color);
        table.getTableHeader().setForeground(Color.white);
        table.setDefaultRenderer(Object.class, new TableCellRenderer(){
            private final DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row%2 == 0){
                    c.setBackground(new Color(212, 185,185));
                }
                else {
                    c.setBackground(new Color(215,215,215));
                }
                return c;
            }

        });
        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(table);
        table.getTableHeader().setPreferredSize(new Dimension(jScrollPane.getWidth(),40));
        jScrollPane.getViewport().setBackground(Color.WHITE);
        jScrollPane.setBorder(BorderFactory.createLineBorder(Color.white));
        container.add(jScrollPane);
        container.setBackground(Color.white);
//        container.setSize(800,300);

        this.add(container);

    }

    Object [][] data = {{1, "Gasaro","Leila"}, {2, "Gasaro","Leila"}, {3, "Gasaro","Leila"}};
    Object [] columns = {"Id", "Fname", "Lname"};





}

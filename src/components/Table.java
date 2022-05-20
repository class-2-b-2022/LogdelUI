package components;

import utils.Theme;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class Table extends JFrame {
    private String title;
    private Object[][] data;
    private Object[] columns;

    public Table(String title, Object[][] data, Object[] columns) throws HeadlessException {
        this.title = title;
        this.data = data;
        this.columns = columns;
        this.setVisible(true);

        JLabel label = new JLabel(this.title, JLabel.LEFT);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBackground(Color.red);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel container = new JPanel();
        container.setOpaque(false);
        container.add(label);
        container.setLayout(new FlowLayout());
        DefaultTableModel model = new DefaultTableModel(this.data, this.columns);
        model.setColumnIdentifiers(columns);

        this.setBounds(10,10,900,500);

        JTable table = new JTable(model) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        table.setRowHeight(40);

        table.getTableHeader().setOpaque(false);
        table.setShowGrid(false);

        table.setAutoCreateRowSorter(true);
        table.getTableHeader().setReorderingAllowed(false);
        Color color = new Theme().getSideBarColor();
        table.getTableHeader().setBackground(color);
        table.getTableHeader().setForeground(Color.white);
        table.setDefaultRenderer(Object.class, new TableCellRenderer(){
            private final DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row%2 == 0){
                    c.setBackground(new Theme().getOddRowColor());
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

        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        this.add(container);

    }
}

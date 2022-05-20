package pages;

import components.Table;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class Billing extends JFrame {
    Object [][] data = {{1, "Gasaro","Leila"}, {2, "Gasaro","Leila"}, {3, "Gasaro","Leila"}};
    Object [] columns = {"Id", "Fname", "Lname"};

    public Billing() throws HeadlessException {
        new Table("Billing",data,columns);
    }


}

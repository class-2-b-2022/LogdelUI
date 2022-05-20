package pages;

import components.Table;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

public class Tracking extends JFrame {
    Object [][] data = {{1, "Prince","kyabihu","Kigali","Rubavu",12,"Musanze"}, {1, "Prince","Nyabihu","Kigali","Rubavu",12,"Musanze"}, {1, "Prince","Nyabihu","Kigali","Rubavu",12,"Musanze"}};
    Object [] columns = {"Vehicle Id","Driver Name", "Current Location", "Destination","Source Location","Fuel Level","Nearest Station","Departure Time","Arriving time"};
    public Tracking() throws HeadlessException {
        new Table("Tracking",data,columns);
    }
}
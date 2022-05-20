package pages;

import components.Table;
import formats.RequestBody;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.IOError;
import java.io.IOException;

public class Billing extends JFrame {
    Object [][] data = {{1, "Gasaro","Leila"}, {2, "Gasaro","Leila"}, {3, "Gasaro","Leila"}};
    Object [] columns = {"walletId", "Type", "Amount", "Date","Received From","Payed To"};

    public Billing() throws HeadlessException {
        new Table("Billing",data,columns);
    }

    public static void main(String args[]) throws IOException {
        RequestBody req = new RequestBody();
        req.setRoute("/billing");
        req.setAction("GetWallet");

    }


}

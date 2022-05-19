package components;

import javax.swing.*;
import java.awt.*;

public class InventoryReport extends JFrame {
    private Object[][] data;
    Frame frame = new JFrame();
    Integer tid;

    public InventoryReport(Integer tid) throws HeadlessException{
        this.tid = tid;
        tid = 1;
        this.setVisible(true);
        this.setBackground(Color.lightGray);

        JLabel label = new JLabel("Transaction #"+tid+" ",JLabel.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBounds(0,20,500,100);
        label.setFont(new Font("Arial",Font.BOLD,18));
        label.setForeground(Color.CYAN);

    }
    public static void main(String[] args){
        InventoryReport report = new InventoryReport(2);
    }
}

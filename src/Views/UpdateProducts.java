package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProducts implements ActionListener{
    public static void main(String[] args) {
        Products frame=new Products();
        frame.setText("LODGEL APP");
        frame.setTitle("Update Product info");
        frame.setVisible(true);
        frame.setBounds(10,10,370,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

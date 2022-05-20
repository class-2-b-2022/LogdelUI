package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Products extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel namelabel = new JLabel("Product Name");
    JLabel typelabel = new JLabel("Product Type");
    JLabel quantitylabel = new JLabel("Quantity");
    JLabel pricelabel = new JLabel("Price per bulk");
    JTextField nametextfield = new JTextField();
    JTextField typeField = new JTextField();
    JTextField quantityfield = new JTextField();
    JTextField priceField = new JTextField();
    JButton updatebutton = new JButton("Update");
    JButton productbutton = new JButton("Reset");

    Products() {
        setLayoutManager();
        setLocationAndSize();
        addComponentTocontainer();
//        addActionEvent();
    }

    ;

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        namelabel.setBounds(50, 150, 100, 30);
        typelabel.setBounds(50, 200, 100, 30);
        nametextfield.setBounds(150, 150, 150, 30);
        typeField.setBounds(150, 200, 150, 30);
        pricelabel.setBounds(50, 250, 100, 30);
        quantitylabel.setBounds(50, 300, 100, 30);
        priceField.setBounds(150, 250, 150, 30);
        quantityfield.setBounds(150, 300, 150, 30);
        updatebutton.setBounds(50, 350, 80, 30);
        productbutton.setBounds(200, 350, 100, 30);
    }

    public void addComponentTocontainer() {
        container.add(namelabel);
        container.add(typelabel);
        container.add(nametextfield);
        container.add(typeField);
        container.add(pricelabel);
        container.add(quantitylabel);
        container.add(priceField);
        container.add(quantityfield);
        container.add(updatebutton);
        container.add(productbutton);
    }

    public void addActionEvent() {
        updatebutton.addActionListener(this);
        productbutton.addActionListener(this);

    }

    JPanel panel = new JPanel();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updatebutton) {
//            String userText;
//            String pwdText;
//            userText = usertextfield.getText();
//            pwdText = passwordField.getText();
//            if (userText.equalsIgnoreCase("Neza") && pwdText.equalsIgnoreCase("bruce")) {
//                JOptionPane.showMessageDialog(this, "Login Successfully");
//            } else {
//                JOptionPane.showMessageDialog(this, "Invalid Email or Password");
//            }
//        }
//        if (e.getSource() == resetbutton) {
//            usertextfield.setText("");
//            passwordField.setText("");
//        }
//        if (e.getSource() == showpass) {
//            if (showpass.isSelected()) {
//                passwordField.setEchoChar((char) 0);
//            } else {
//                passwordField.setEchoChar('*');
//            }
//        }
//    }
        }
    }


}
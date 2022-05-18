package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Gui extends JFrame implements ActionListener {
    Container container=getContentPane();
    JLabel userlabel=new JLabel("Email");
    JLabel passlabel=new JLabel("Password");
    JTextField usertextfield=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginbutton=new JButton("Login");
    JButton resetbutton=new JButton("Reset");
    JCheckBox showpass=new JCheckBox("Show Password");
    Gui() {
        setLayoutManager();
        setLocationAndSize();
        addComponentTocontainer();
        addActionEvent();
    };
    public void setLayoutManager(){
      container.setLayout(null);
    }
    public void setLocationAndSize(){
      userlabel.setBounds(50,150,100,30);
      passlabel.setBounds(50,220,100,30);
      usertextfield.setBounds(150,150,150,30);
      passwordField.setBounds(150,220,150,30);
      showpass.setBounds(150,250,150,30);
      loginbutton.setBounds(100,300,100,30);
      loginbutton.setSize(150,50);
      loginbutton.setFont(new Font("Tahoma", Font.PLAIN, 26));
      loginbutton.setForeground(Color.ORANGE);
//        loginbutton.setBounds(545, 392, 162, 73);
      resetbutton.setBounds(200,300,100,30);
    }
    public void addComponentTocontainer(){
     container.add(userlabel);
     container.add(passlabel);
     container.add(usertextfield);
     container.add(passwordField);
     container.add(showpass);
     container.add(loginbutton);
//     container.add(resetbutton);
    }
    public void addActionEvent(){
        loginbutton.addActionListener(this);
        resetbutton.addActionListener(this);
        showpass.addActionListener(this);
    }

    JPanel panel = new JPanel();

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource() == loginbutton) {
        String userText;
        String pwdText;
        userText = usertextfield.getText();
        pwdText = passwordField.getText();
        if(userText.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Email is required");
            return;
        }
        if(pwdText.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Password is required");
            return;
        }
        if (userText.equalsIgnoreCase("Neza") && pwdText.equalsIgnoreCase("bruce")) {
            JOptionPane.showMessageDialog(this, "Login Successfully");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Email or Password");
        }
    }
    if(e.getSource() == resetbutton){
        usertextfield.setText("");
        passwordField.setText("");
    }
    if(e.getSource() == showpass){
        if(showpass.isSelected()){
            passwordField.setEchoChar((char)0);
        }else{
            passwordField.setEchoChar('*');
        }
    }
    }
    }
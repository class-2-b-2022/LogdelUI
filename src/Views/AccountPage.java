package Views;

import pages.Welcome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AccountPage extends JFrame  {
    JButton registerButton;
    Container container;

    JLabel message;

    public AccountPage(){
        message = new JLabel("Manage Users");
        message.setFont(new Font("Courier", Font.BOLD, 20));

        registerButton = new JButton("Register User");
        container = getContentPane();
        container.setLayout(null);
        setBounds();
        addComponents();
    }

    public void setBounds() {
        message.setBounds(100, 10, 600, 40);
        registerButton.setBounds(100, 100, 250, 40);
        registerButton.setBackground(new Color(30, 143, 255));
        registerButton.setForeground(Color.white);

        registerButton.setActionCommand("SEND");
        registerButton.addActionListener(new AccountPage.ButtonClickEventHandler());
    }

    public void addComponents() {
//        container.add(branchLabel);
        container.add(message);
        container.add(registerButton);
    }

    public static void main(String[] args) throws IOException{
        AccountPage frame = new AccountPage();

        frame.setTitle("Manage Users");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBounds(500, 100, 450, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public class ButtonClickEventHandler extends Component implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("SEND")){
//               RegisterUsers register = new RegisterUsers();
                RegisterUsers.mainMethod();
            }
        }
    }
}

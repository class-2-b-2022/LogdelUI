package Views;

import javax.swing.*;

public class Login {
    public static void main(String[] args) {
        Gui frame=new Gui();
        frame.setTitle("Login form");
        frame.setVisible(true);
        frame.setBounds(10,10,370,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
package Views;

import Views.SystemAdminDashboard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class invoices extends JFrame implements ActionListener{
    JLabel title, l,l2,l3,l4;
    JButton b;
    Color color;
    public invoices(){
        title= new JLabel("LOGDEL PAYMENT RECEIPT");
        title.setBounds(50,50,300,20);
        l= new JLabel("Date: Thu May 19 20:58:46 CAT 2022");
        l.setBounds(50,100,300,20);
        l2= new JLabel("Received From: Gasaro Leila");
        l2.setBounds(50,140,300,20);
        l3= new JLabel("Amount: 500.0");
        l3.setBounds(50,180,300,20);
        l4= new JLabel("New Balance: 51935.0");
        l4.setBounds(50,220,300,20);
        b=new JButton("Okay");
        b.setBounds(100,260,80,30);
        b.setBackground(new Color(30,144,255));
        b.setFocusable(false);
        b.setForeground(color!=null ? color: Color.white);
        b.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
        b.addActionListener(this);

        add(title);add(l);add(l2);add(l3);add(l4);add(b);
        setSize(400,400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b){
            this.dispose();
             SystemAdminDashboard.mainMethod();
        }
    }
}
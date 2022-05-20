package pages;

import utils.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wallet{
    JFrame frame = new JFrame();
    JLabel logoWord= new JLabel("LOGDEL");
    JLabel word = new JLabel("Happy");
    JPanel balance = new JPanel();
    JLabel mybalance = new JLabel("My Balance");
    JLabel amount = new JLabel("$ 2180");
    JPanel container  = new JPanel();
    JPanel trans = new JPanel();
    JLabel transtxt = new JLabel("Transactions");
    JPanel transactions = new JPanel();
    Theme theme = new Theme();
    JPanel div = new JPanel();
    JPanel div1 = new JPanel();
    JPanel div2 = new JPanel();
    JPanel div3 = new JPanel();
    JPanel nav = new JPanel();
    JPanel buttons = new JPanel();
    JButton btn = createButton("SAVE TO MY WALLET", Color.white);
    JFrame frame2;
    public Wallet(){

        mybalance.setFont(new Font("Arial", Font.BOLD, 20));
        mybalance.setHorizontalAlignment(SwingConstants.CENTER);
        mybalance.setForeground(theme.getPrimary());

        amount.setFont(new Font("Arial", Font.BOLD, 40));
        amount.setHorizontalAlignment(SwingConstants.CENTER);
        amount.setForeground(theme.getSecondary());

        container.setBounds(0, 150, 700, 500);
//        container.setLayout(new GridLayout(2,1));
//        container.setBackground(Color.cyan);

        logoWord.setFont(new Font("Arial",Font.BOLD,20));
//        logoWord.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoWord.setForeground(theme.getPrimary());

        nav.setLayout(new BoxLayout(nav,BoxLayout.Y_AXIS));
//        nav.setBackground(Color.cyan);
        nav.add(new JLabel(" "));
        nav.add(logoWord);
//        nav.add(new JPanel().add(word));
        nav.setPreferredSize(new Dimension(300,30));

        balance.setLayout(new GridLayout(2,1));
        balance.add(mybalance);
        balance.add(amount);

        buttons.setBounds(200,300,700,500);
//        buttons.setBackground(Color.red);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame2 = new JFrame("Save");
                Container c = new Container();
                JLabel title = new JLabel("Add Some amount");
                JLabel name = new JLabel("Amount");
                JTextField tname = new JTextField();
                JLabel id = new JLabel("ID");
                JTextField tid = new JTextField();
                JPanel pan = new JPanel();
                pan.add(id);
                pan.add(tid);

                name.setFont(new Font("Arial", Font.PLAIN, 20));
                name.setSize(100, 20);
                name.setLocation(100, 100);

                tname.setFont(new Font("Arial", Font.PLAIN, 15));
                tname.setSize(190, 20);
                tname.setLocation(200, 100);

                id.setFont(new Font("Arial", Font.PLAIN, 20));
                id.setSize(100, 20);
                id.setLocation(100, 100);

                tid.setFont(new Font("Arial", Font.PLAIN, 15));
                tid.setSize(190, 20);
                tid.setLocation(200, 100);

                frame2.add(title);
//                frame2.add(id);
                frame2.add(tid);
                frame2.add(name);
                frame2.add(tname);

                frame2.add(createButton("Save",theme.getPrimary()));
                frame2.setVisible(true);
                frame2.setBackground(Color.red);
                frame2.setBounds(300, 130, 500, 500);
                frame2.setLayout(null);
            }
        });
        buttons.add(btn);

        container.add(balance);



//        word.setHorizontalAlignment(SwingConstants.LEFT);
        
        trans.setLayout(new GridLayout());
//        trans.setBackground(Color.blue);
        trans.setBounds(200,300,700,500);

        transtxt.setHorizontalAlignment(SwingConstants.CENTER);
        transtxt.setFont(new Font("Arial",Font.BOLD,20));
        transtxt.setForeground(theme.getPrimary());
        trans.add(transtxt);

        ImageIcon image = new ImageIcon("C:\\Users\\student\\Downloads\\pics\\sour.jpg");
        ImageIcon image1 = new ImageIcon("C:\\Users\\student\\Downloads\\pics\\oma.jpg");
        ImageIcon image2 = new ImageIcon("C:\\Users\\student\\Downloads\\pics\\wiz.jpg");
        ImageIcon image3 = new ImageIcon("C:\\Users\\student\\Downloads\\pics\\yu.jpg");
        JLabel label = new JLabel();
        Image resized = image.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        label.setBounds(10,200,100,80);
        image = new ImageIcon(resized);
        label.setIcon(image);

        JLabel label1 = new JLabel();
        Image resized1 = image1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        label1.setBounds(10,200,100,80);
        image1 = new ImageIcon(resized1);
        label1.setIcon(image1);

        JLabel label2 = new JLabel();
        Image resized2 = image2.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        label2.setBounds(10,200,100,80);
        image2 = new ImageIcon(resized2);
        label2.setIcon(image2);

        JLabel label3 = new JLabel();
        Image resized3 = image3.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        label3.setBounds(10,200,100,80);
        image3 = new ImageIcon(resized3);
        label3.setIcon(image3);

        div.setLayout(new GridLayout());
        div.add(label);
        div.setBounds(200,300,700,700);
        div.setBackground(Color.white);
        div.setPreferredSize(new Dimension(300,50));
        div.add(new JLabel("John Doe"));
        JLabel n1 = new JLabel("+$1000");
        n1.setForeground(Color.green);
        div.add(n1);

        div1.setLayout(new GridLayout());
        div1.add(label1);
        div1.setBounds(200,300,700,700);
        div1.setBackground(Color.white);
        div1.setPreferredSize(new Dimension(300,50));
        div1.add(new JLabel("Cimerwa"));
        JLabel n2 = new JLabel("-$500");
        n2.setForeground(Color.red);
        div1.add(n2);

        div2.setLayout(new GridLayout());
        div2.add(label2);
        div2.setBounds(200,300,700,700);
        div2.setBackground(Color.white);
        div2.setPreferredSize(new Dimension(300,50));
        div2.add(new JLabel("Acele Happy"));
        JLabel n3 = new JLabel("+$4320");
        n3.setForeground(Color.green);
        div2.add(n3);

        div3.setLayout(new GridLayout());
        div3.add(label3);
        div3.setBounds(200,300,700,700);
        div3.setBackground(Color.white);
        div3.setPreferredSize(new Dimension(300,50));
        div3.add(new JLabel("Bralirwa"));
        JLabel n4 = new JLabel("-$4320");
        n4.setForeground(Color.red);
        div3.add(n4);

//        transactions.setBackground(Color.red);
//        GridLayout gridlayout = new GridLayout(4,1);
//        gridlayout.setVgap(5);
//        transactions.setLayout(gridlayout);

        transactions.add(div);
        transactions.add(div1);
        transactions.add(div2);
        transactions.add(div3);

        frame.add(nav);
        frame.add(container);
        frame.add(trans);
        frame.add(buttons);
        frame.add(transactions);

        JScrollPane jScrollPane = new JScrollPane(transactions);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.getContentPane().add(jScrollPane);

        frame.setBackground(Color.red);
        frame.setBounds(300, 130, 700, 500);
        frame.setLayout(new GridLayout(5,1));
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public JButton createButton(String text, Color color){
        JButton button = new JButton(text);
        button.setForeground(color!=null ? color: Color.white);
        button.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));
        button.setBackground(theme.getPrimary());
        button.setFocusable(false);
        return button;
    }


    public static void main(String args[]){
        new Wallet();
    }
}

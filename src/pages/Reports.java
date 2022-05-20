package pages;

import utils.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reports extends JFrame implements ActionListener {
    Frame frame = new JFrame();

    FlowLayout layout = new FlowLayout();
    JPanel container = new JPanel();
    Theme theme = new Theme();
    JLabel title = new JLabel("REPORTS MODULE");
    JPanel content = new JPanel();

    JPanel date_panel = new JPanel();
    JPanel product_panel = new JPanel();
    JPanel status_panel = new JPanel();
    JPanel quantity_panel = new JPanel();
    JPanel company_panel = new JPanel();

    JLabel date = new JLabel("Date: ");
    JLabel product = new JLabel("Product: ");
    JLabel status = new JLabel("Status: ");
    JLabel quantity = new JLabel("Quantity: ");
    JLabel company = new JLabel("Company: ");

    JLabel date_content = new JLabel("2022-04-15");
    JLabel product_content = new JLabel("Akarabo");
    JLabel status_content = new JLabel("OUT");
    JLabel quantity_content = new JLabel("25");
    JLabel company_content = new JLabel("NYIRANGARAMA");

    Object [][] data = {{1, "2022-06-05","Fanta","IN","10","BRALIRWA"} ,{2, "2022-06-05","AKARABO","IN","10","NYIRANGARAMA"} ,{3, "2022-06-05","TIPI SUPA","IN","10","SULFO"} };

    public Reports(){
        frame.setBounds(300, 130, 700, 500);
        container.setBounds(0, 50, 700, 500);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(theme.getPrimary());
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        date.setHorizontalAlignment(SwingConstants.CENTER);

        date_panel.add(date);
        date_panel.add(date_content);
        product_panel.add(product);
        product_panel.add(product_content);
        status_panel.add(status);
        status_panel.add(status_content);
        quantity_panel.add(quantity);
        quantity_panel.add(quantity_content);
        company_panel.add(company);
        company_panel.add(company_content);

        content.setLayout(new GridLayout(7,1));
        content.setBorder(BorderFactory.createEmptyBorder(10,10,0,10));
        container.add(title);
        content.add(date_panel);
        content.add(product_panel);
        content.add(status_panel);
        content.add(quantity_panel);
        content.add(company_panel);

        container.add(content);
        container.setBackground(Color.white);
        frame.add(container);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args){
        Reports reports = new Reports();
    }
}

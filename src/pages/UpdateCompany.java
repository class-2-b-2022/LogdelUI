package pages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import formats.Company;
import formats.RequestBody;
import formats.ResponseBody;
import utils.ConnectToServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCompany extends JFrame {
    static ConnectToServer connect = new ConnectToServer();
    Container c;
    JLabel title;
    JLabel companyTIN;
    JLabel companyName  ;
    JLabel companyPhone;
    JLabel companyDescr;
    JLabel companyEmail;
    JLabel companyType;
    JLabel main;
    JTextField TIN;
    JTextField name;
    JTextField phone;
    JTextField description;
    JTextField email;
    JTextField type;
    JButton submit;
    JPanel companyInformation = new JPanel();
    JLabel success;
    public UpdateCompany(){
        setTitle("Updating Form");
        setBounds(300,90,900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        c = getContentPane();
        c.setLayout(null);
//        c.setBackground(Color.black);
        title = new JLabel("Updating Company");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        companyTIN = new JLabel("Company TIN" );
        companyTIN.setFont(new Font("Arial", Font.PLAIN, 15));
        companyTIN.setSize(300, 20);
        companyTIN.setBackground(Color.black);
        companyTIN.setLocation(100, 100);
        c.add(companyTIN);
        TIN = new JTextField();
        TIN.setFont(new Font("Arial", Font.PLAIN, 15));
        TIN.setSize(250, 30);
        TIN.setLocation(300, 100);
        c.add(TIN);
        companyName = new JLabel("Company Name");
        companyName.setFont(new Font("Arial", Font.PLAIN, 15));
        companyName.setSize(300, 20);
        companyName.setLocation(100, 150);
        c.add(companyName);
        name = new JTextField();
        name.setSize(250,30);
        name.setLocation(300,150);
        name.setFont(new Font("Arial", Font.PLAIN, 15));
        c.add(name);
        companyPhone = new JLabel("Company Phone");
        companyPhone.setFont(new Font("Arial", Font.PLAIN, 15));
        companyPhone.setSize(300,30);
        companyPhone.setLocation(100,200);
        c.add(companyPhone);
        phone = new JTextField();
        phone.setFont(new Font("Arial", Font.PLAIN, 15));
        phone.setSize(250,30);
        phone.setLocation(300,200);
        c.add(phone);
        companyDescr = new JLabel("Company Description");
        companyDescr.setFont(new Font("Arial", Font.PLAIN, 15));
        companyDescr.setSize(300,30);
        companyDescr.setLocation(100,250);
        c.add(companyDescr);
        description = new JTextField();
        description.setFont(new Font("Arial", Font.PLAIN, 15));
        description.setSize(250,30);
        description.setLocation(300,250);
        c.add(description);
        companyEmail = new JLabel("Company Email");
        companyEmail.setFont(new Font("Arial", Font.PLAIN, 15));
        companyEmail.setSize(300,30);
        companyEmail.setLocation(100,300);
        c.add(companyEmail);
        email = new JTextField();
        email.setFont(new Font("Arial", Font.PLAIN, 15));
        email.setSize(250,30);
        email.setLocation(300,300);
        c.add(email);
        companyType = new JLabel("Company Type");
        companyType.setFont(new Font("Arial", Font.PLAIN, 15));
        companyType.setSize(250,30);
        companyType.setLocation(100,350);
        c.add(companyType);
        type = new JTextField();
        type.setFont(new Font("Arial", Font.PLAIN, 15));
        type.setSize(250,30);
        type.setLocation(300,350);
        c.add(type);
        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.PLAIN, 15));
        submit.setSize(100, 20);
        submit.setLocation(150, 450);
        submit.setBackground(Color.cyan);
//        submit.addActionListener(actionPerformed(this;
        c.add(submit);
        success = new JLabel("Creating ");
        success.setFont(new Font("Arial", Font.PLAIN, 15));
        success.setSize(250,30);
        success.setLocation(100,500);

        c.add(success);
        main = new JLabel("REGISTER YOUR COMPANY");


        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String json = "";
                System.out.println(name.getText());
                RequestBody clientRequest = new RequestBody();
                clientRequest.setRoute("/company");
                clientRequest.setAction("UPDATE");
                Company company = new Company();
                company.setTIN(Integer.valueOf(TIN.getText()));
                company.setName(name.getText());
                company.setEmail(email.getText());
                company.setType(type.getText());
                company.setPhone(Integer.valueOf(phone.getText()));


                company.setDescription(description.getText());
                clientRequest.setData(company);
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    json = objectMapper.writeValueAsString(clientRequest);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
                System.out.println(json);
                ResponseBody responseBody = null;
                try {
                    responseBody = connect.connectToServer(clientRequest);

                    if(responseBody.getStatus() == "201"){
                        System.out.println("Created Company");
                        success.setText("Create Successfully");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println(responseBody.getMessage());
            }
        });

        setVisible(false);

        companyInformation = new JPanel();
        companyInformation.add(main);
//        companyInformation.add(company
    }
    public void actionPerformed(ActionEvent e) throws Exception {
        if(e.getSource() == submit) {
            String json = "";
            System.out.println(name.getText());
            RequestBody clientRequest = new RequestBody();
            clientRequest.setRoute("/company");
//            clientRequest.setAction("REGISTER");
            Company company = new Company();
            company.setTIN(Integer.valueOf(TIN.getText()));
            company.setPhone(Integer.valueOf(phone.getText()));
            company.setType(type.getText());
            company.setEmail(email.getText());
            company.setDescription(description.getText());
            clientRequest.setData(company);
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(clientRequest);
            System.out.println(json);
            ResponseBody responseBody = connect.connectToServer(clientRequest);
            System.out.println(responseBody.getMessage());
        }
    }
//    public static void main(String args[]){
//        new CreateCompany();
//    }
}

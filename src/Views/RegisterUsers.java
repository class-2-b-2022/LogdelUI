package Views;

import formats.RequestBody;
import formats.ResponseBody;
import formats.User;
import utils.ConnectToServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUsers extends JFrame {
    JLabel message;
    JOptionPane pane;
    JLabel nameLabel;
    JTextField nameField;

    JLabel validationError;

    JLabel mobileNoLabel;
    JTextField mobileNoField;

    JLabel emailLabel;
    JTextField emailField;

    JLabel passwordLabel;
    JPasswordField passwordField;

    JLabel branchLabel;
    JComboBox<String> branchList;

    JButton registerButton;
    Container container;
    public RegisterUsers() {
        message = new JLabel("Register User");
        message.setFont(new Font("Courier", Font.BOLD, 20));
        nameLabel = new JLabel("FullName");
        nameField = new JTextField();
        validationError = new JLabel("");

        emailLabel = new JLabel("Email");
        emailField = new JTextField();

        mobileNoLabel = new JLabel("Telephone");
        mobileNoField = new JTextField();

        passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();

        branchLabel = new JLabel("Role");
        branchList = new JComboBox<String>();

        branchList.addItem("BRANCH ADMIN");
        branchList.addItem("DISTRIBUTOR");
        branchList.addItem("RESELLER");

        registerButton = new JButton("Register");
        container = getContentPane();
        container.setLayout(null);
        setBounds();
        addComponents();
    }

    public void setBounds() {
        message.setBounds(50, 10, 600, 40);
        nameLabel.setBounds(50, 120, 100, 40);
        nameField.setBounds(130, 120, 250, 40);

        mobileNoLabel.setBounds(50, 180, 100, 40);
        mobileNoField.setBounds(130, 180, 250, 40);

        emailLabel.setBounds(50, 240, 100, 40);
        emailField.setBounds(130, 240, 250, 40);

        passwordLabel.setBounds(50, 300, 100, 40);
        passwordField.setBounds(130, 300, 250, 40);

        branchLabel.setBounds(50, 60, 100, 40);
        branchList.setBounds(130, 60, 250, 40);

        registerButton.setBounds(130, 385, 250, 40);
        registerButton.setBackground(new Color(30, 143, 255));
        registerButton.setForeground(Color.white);

        validationError.setBounds(130, 340, 250, 40);
        validationError.setForeground(Color.red);

        registerButton.setActionCommand("SEND");
        registerButton.addActionListener(new ButtonClickEventHandler());
    }

    public void addComponents() {
        container.add(branchLabel);
        container.add(branchList);
        container.add(emailLabel);
        container.add(emailField);
        container.add(message);
        container.add(nameLabel);
        container.add(nameField);
        container.add(mobileNoLabel);
        container.add(mobileNoField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(registerButton);
        container.add(validationError);
    }

    public static void mainMethod() {
        RegisterUsers frame = new RegisterUsers();

        frame.setTitle("Register Users");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setBounds(500, 100, 450, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public class ButtonClickEventHandler extends Component implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("SEND")){
                String email = emailField.getText();
                String fullnames = nameField.getText();
                String password = passwordField.getText();
                String phone  = mobileNoField.getText();
                String role = branchList.getSelectedItem().toString();

                validationError.setText(null);
                validationError.setVisible(true);

                if(fullnames.trim().length() == 0){
                    validationError.setText("Username is required");
                    return ;
                }

                if(fullnames.length() < 3){
                    validationError.setText("Username must be at least 3 characters");
                    return ;
                }

                if(fullnames.length() > 40 ){
                    validationError.setText("Username is too long");
                    return ;
                }

                if(phone.length() == 0){
                    validationError.setText("Phone number is required");
                    return ;
                }

                if(phone.length() != 10){
                    validationError.setText("Phone number must be 10 numbers");
                    return ;
                }

                if(password.length() ==  0){
                    validationError.setText("Password is required");
                    return ;
                }

                if(password.length() < 6){
                    validationError.setText("Password must be at least 6 characters");
                    return ;
                }

                if(password.length() > 25){
                    validationError.setText("Password is too long");
                    return ;
                }

                if(email.length() == 0){
                    validationError.setText("Email is required");
                    return ;
                }

                if(email.length() > 100){
                    validationError.setText("Email is too long");
                    return ;
                }

                boolean isEmailValid = validateEmail(email);

                if(!isEmailValid){
                    validationError.setText("Invalid email address format");
                    return ;
                }

                User user = new User();
                user.setNames(fullnames);
                user.setPhone(Integer.parseInt(phone));
                user.setEmail(email);
                user.setPassword(password);

                int integerRole = 0;

                if(role.equals("BRANCH ADMIN")){
                    integerRole = 1;
                }
                if(role.equals("DISTRIBUTOR")){
                    integerRole = 2;
                }
                if(role.equals("RESELLER")){
                    integerRole = 3;
                }

                user.setRole(integerRole);
                user.setRoleAsString(role);

                RequestBody clientRequest = new RequestBody();
                clientRequest.setRoute("/users");
                clientRequest.setAction("register");

                clientRequest.setData(user);
                ConnectToServer clientServerConnector = new ConnectToServer();

                try {
                    validationError.setVisible(false);
                    validationError.setText("");
                    ResponseBody responseBody = clientServerConnector.connectToServer(clientRequest);
                    ;System.out.println(responseBody.getStatus());
                    if(responseBody.getStatus().equals("200")){
                        if(responseBody.getMessage().length()>0){
                            pane.showMessageDialog(new RegisterUsers(), responseBody.getMessage());
                            container.add(pane);
                            validationError.setText(null);
                            return ;
                        }
                    }

                    validationError.setVisible(true);
                        validationError.setText("Email already exists");
                        return ;

                } catch (Exception ex) {
//                    System.out.print(ex.getMessage());
//                    validationError.setText("Email already exists");
//                    throw new RuntimeException(ex);
                }

            }
        }

        public static boolean validateEmail(String email) {
            String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
            java.util.regex.Matcher m = p.matcher(email);
            return m.matches();
        }
    }
}
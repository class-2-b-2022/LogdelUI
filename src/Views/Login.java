package Views;

import com.fasterxml.jackson.databind.ObjectMapper;
import data_format.Data_format;
import formats.RequestBody;
import formats.ResponseBody;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Properties;
public class Login extends JFrame implements ActionListener {
    Container container=getContentPane();
    JLabel userlabel=new JLabel("Email");
    JLabel passlabel=new JLabel("Password");
    JTextField usertextfield=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginbutton=new JButton("Login");
    JButton resetbutton=new JButton("Reset");
    JCheckBox showpass=new JCheckBox("Show Password");

    public Login() {

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
            String userText="";
            String pwdText="";
//            String userText="";
            //rdev@gmail.com
            //nicemonn
            //
//            String pwdText="";
        userText = usertextfield.getText();
        pwdText = passwordField.getText();
//            Scanner scanner=new Scanner(System.in);
//            scanner.nextLine();
        if(userText.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Email is required");
            return;
        }
        if(pwdText.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this, "Password is required");
            return;
        }
        JSONObject jsonHolder = new JSONObject();
        ObjectMapper objectMapper = new ObjectMapper();
        Data_format dataFormat=new Data_format();
        dataFormat.setEmail(userText);
        dataFormat.setPassword(pwdText);
        RequestBody requestBody=new RequestBody();
        requestBody.setAction("login");
        requestBody.setRoute("/users");
        requestBody.setData(dataFormat);
        LoginHelper loginHelper=new LoginHelper();
        ResponseBody responseBody= null;
        try {
            System.out.println(userText.toString());
            responseBody = loginHelper.login(requestBody);
            if(Integer.parseInt(responseBody.getStatus()) == 200){
                System.out.println("Loggedin Successfully");
                Properties properties=new Properties();
                FileWriter fileWriter=new FileWriter("config.properties");
                jsonHolder=new JSONObject(responseBody.getData().toString());
                System.out.println(jsonHolder);
                String userid= jsonHolder.get("userId").toString();
                System.out.println(userid);
                properties.setProperty("userId", String.valueOf(userid));
                properties.store(fileWriter,"Loggedin User");
                System.lineSeparator().repeat(100);

                this.dispose();
                SystemAdminDashboard.mainMethod();



            }else {
                JOptionPane.showMessageDialog(this, "Invalid Email or Password");
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
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

    public static void mainMethod() {
        Login framed=new Login();
        framed.setTitle("Welcome back to Logdel");
        framed.setVisible(true);
        framed.setBounds(10,10,370,600);
        framed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framed.setResizable(false);
    }
    }

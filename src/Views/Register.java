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

public class Register extends JFrame implements ActionListener {
    Container container = getContentPane();

    JLabel driverName = new JLabel("Driver Name");
    JLabel currentLocation = new JLabel("Current Location");
    JLabel sourceLocation = new JLabel("Source Location");
    JLabel destination = new JLabel("Destination");
    JLabel fuelLevel = new JLabel("Fuel level");
    JLabel nearestStation = new JLabel("Nearest Station");
    JLabel departureTime = new JLabel("Departure Time");
    JLabel arrivalTime = new JLabel("Arrival Time");

    JTextField nameField = new JTextField();
    JTextField currentLocationField = new JTextField();
    JTextField sourceLocationField = new JTextField();
    JTextField destinationField = new JTextField();
    JTextField fuelLevelField = new JTextField();
    JTextField nearestStationField = new JTextField();
    JTextField departureTimeField = new JTextField();
    JTextField arrivalTimeField = new JTextField();

    JButton register = new JButton("Register");
    JButton resetbutton = new JButton("Reset");

    Register() {
        setLayoutManager();
        setLocationAndSize();
        addComponentTocontainer();
        addActionEvent();
    }

    ;

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        driverName.setBounds(50, 50, 100, 30);
        currentLocation.setBounds(50, 100, 100, 30);
        sourceLocation.setBounds(50, 150, 100, 30);
        destination.setBounds(50, 200, 100, 30);
        fuelLevel.setBounds(50, 250, 100, 30);
        nearestStation.setBounds(50, 300, 100, 30);
        departureTime.setBounds(50, 350, 100, 30);
        arrivalTime.setBounds(50, 400, 100, 30);

        nameField.setBounds(150, 50, 150, 30);
        currentLocationField.setBounds(150, 100, 150, 30);
        sourceLocationField.setBounds(150, 150, 150, 30);
        destinationField.setBounds(150, 200, 150, 30);
        fuelLevelField.setBounds(150, 250, 150, 30);
        nearestStationField.setBounds(150, 300, 150, 30);
        departureTimeField.setBounds(150, 350, 150, 30);
        arrivalTimeField.setBounds(150, 400, 150, 30);

        register.setBounds(100, 450, 100, 30);

        register.setSize(150, 50);
        register.setFont(new Font("Tahoma", Font.PLAIN, 26));
        register.setForeground(Color.ORANGE);
        resetbutton.setBounds(275, 459, 70, 30);
    }

    public void addComponentTocontainer() {
        container.add(driverName);
        container.add(currentLocation);
        container.add(sourceLocation);
        container.add(destination);
        container.add(fuelLevel);
        container.add(nearestStation);
        container.add(departureTime);
        container.add(arrivalTime);
        container.add(register);
        container.add(resetbutton);

        container.add(nameField);
        container.add(currentLocationField);
        container.add(sourceLocationField);
        container.add(destinationField);
        container.add(fuelLevelField);
        container.add(nearestStationField);
        container.add(departureTimeField);
        container.add(arrivalTimeField);
    }

    public void addActionEvent() {
        register.addActionListener(this);
        resetbutton.addActionListener(this);
    }

    JPanel panel = new JPanel();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            String userText = "";
            String pwdText = "";
//            String userText="";
            //rdev@gmail.com
            //nicemonn
            //
//            String pwdText="";
//            userText = usertextfield.getText();
//            pwdText = passwordField.getText();
//            Scanner scanner=new Scanner(System.in);
//            scanner.nextLine();
//            if (userText.equalsIgnoreCase("")) {
//                JOptionPane.showMessageDialog(this, "name is required");
//                return;
//            }
//            if (pwdText.equalsIgnoreCase("")) {
//                JOptionPane.showMessageDialog(this, "Password is required");
//                return;
//            }
            JSONObject jsonHolder = new JSONObject();
            ObjectMapper objectMapper = new ObjectMapper();
            Data_format dataFormat = new Data_format();
            dataFormat.setEmail(userText);
            dataFormat.setPassword(pwdText);
            RequestBody requestBody = new RequestBody();
            requestBody.setAction("register");
            requestBody.setRoute("/vehicles");
            requestBody.setData(dataFormat);
            LoginHelper loginHelper = new LoginHelper();
            ResponseBody responseBody = null;
            try {
                System.out.println(userText.toString());
                responseBody = loginHelper.login(requestBody);
                if (Integer.parseInt(responseBody.getStatus()) == 200) {
                    System.out.println("Registered Successfully");
                    Properties properties = new Properties();
                    FileWriter fileWriter = new FileWriter("C:\\Users\\user\\IdeaProjects\\logdelui\\New folder\\LogdelUI\\config.properties");
                    jsonHolder = new JSONObject(responseBody.getData().toString());
                    String userid = jsonHolder.getString("vehicleId").toString();
                    properties.setProperty("VehicleId", userid);
                    properties.store(fileWriter, "Registered vehicle");
                    System.lineSeparator().repeat(100);
                    Register frame = new Register();
                    frame.setTitle("Dashboard");
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid credentials");
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == resetbutton) {
            nameField.setText("");
            currentLocationField.setText("");
            sourceLocationField.setText("");
            destinationField.setText("");
            fuelLevelField.setText("");
            nearestStationField.setText("");
            departureTimeField.setText("");
            arrivalTimeField.setText("");
        }
    }

    public static void main(String[] args) {
        Register frame = new Register();
        frame.setTitle("Welcome back to Logdel");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }
}

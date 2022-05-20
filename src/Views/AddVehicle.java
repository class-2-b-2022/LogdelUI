package Views;

import com.fasterxml.jackson.databind.ObjectMapper;
import data_format.Vehicle_format;
import formats.RequestBody;
import formats.ResponseBody;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;


public class AddVehicle extends JFrame implements ActionListener {

    Container container=getContentPane();
    JLabel vehicleModel=new JLabel("Model");
    JLabel plateNbr=new JLabel("Plate");
    JLabel vehicleBrand=new JLabel("brand");
    JLabel vehicleOwner=new JLabel("Owner");
    JLabel Description=new JLabel("Description");
    JTextField model=new JTextField();
    JTextField pltNumber=new JTextField();
    JTextField brand=new JTextField();
    JTextField Owner=new JTextField();
    JTextField description=new JTextField();

    JButton Createbutton=new JButton("Create Vehicle");
    JButton resetbutton=new JButton("Reset");
    AddVehicle() {
        setLayoutManager();
        setLocationAndSize();
        addComponentTocontainer();
        addActionEvent();
    }
    public void setLayoutManager(){
        container.setLayout(null);
    }
    public void setLocationAndSize(){
        vehicleModel.setBounds(50,50,100,30);
        plateNbr.setBounds(50,100,100,30);
        vehicleBrand.setBounds(50,150,100,30);
        vehicleOwner.setBounds(50,200,100,30);
        Description.setBounds(50,250,100,30);

        model.setBounds(150,50,150,30);
        pltNumber.setBounds(150,100,150,30);
        brand.setBounds(150,150,150,30);
        Owner.setBounds(150,200,150,30);
        description.setBounds(150,250,150,30);

        Createbutton.setBounds(100,300,100,30);
        Createbutton.setSize(150,30);
        Createbutton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        Createbutton.setForeground(Color.ORANGE);
        resetbutton.setBounds(100,350,100,30);
        resetbutton.setSize(150,30);
        resetbutton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        resetbutton.setForeground(Color.ORANGE);

    }
    public void addComponentTocontainer(){
        container.add(vehicleModel);
        container.add(plateNbr);
        container.add(vehicleBrand);
        container.add(vehicleOwner);
        container.add( Description);

        container.add(model);
        container.add(pltNumber);
        container.add(brand);
        container.add(Owner);
        container.add(description);

        container.add(Createbutton);
        container.add(resetbutton);
    }
    public void addActionEvent(){
        Createbutton.addActionListener(this);
        resetbutton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Createbutton) {
            String vehiclemodel="";
            String vehicleplatenumber="";
            String vehiclebrand="";
            String vehicleowner="";
            String vehicledescription="";

            vehiclemodel = model.getText();
            vehicleplatenumber = pltNumber.getText();
            vehiclebrand = brand.getText();
            vehicleowner = Owner.getText();
            vehicledescription = description.getText();

            if(vehiclemodel.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(this, "Vehicle model is required");
                return;
            }
            if(vehicleplatenumber.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(this, "plate number is required");
                return;
            }
            if(vehiclebrand.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(this, "vehicle brand is required");
                return;
            }
            if(vehicleowner.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(this, "vehicle Owner is required");
                return;
            }
            if(vehicledescription.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(this, "vehicle description is required");
                return;
            }
            JSONObject jsonHolder = new JSONObject();
            ObjectMapper objectMapper = new ObjectMapper();
            Vehicle_format vehicleFormat=new Vehicle_format();
            vehicleFormat.setBrand(vehiclebrand);
            vehicleFormat.setModel(vehiclemodel);
            vehicleFormat.setDescription(vehicledescription);
            vehicleFormat.setPlateNbr(vehicleplatenumber);
            vehicleFormat.setOwner(vehicleowner);
            RequestBody requestBody=new RequestBody();
            requestBody.setAction("register");
            requestBody.setRoute("/delivery/vehicles");
            requestBody.setData(vehicleFormat);
//            LoginHelper loginHelper=new LoginHelper();
            VehicleHelper vehicleHelper =new VehicleHelper();
            ResponseBody responseBody= null;
            System.out.println("Vehicle added Successfully");
            try {
//                System.out.println(userText.toString());
                responseBody = vehicleHelper.login(requestBody);
                System.out.println(Integer.parseInt(responseBody.getStatus()));
                if(Integer.parseInt(responseBody.getStatus()) == 201){

//                    Properties properties=new Properties();
//                    FileWriter fileWriter=new FileWriter("C:\\Users\\user\\IdeaProjects\\logdelui\\New folder\\LogdelUI\\config.properties");
//                    jsonHolder=new JSONObject(responseBody.getData().toString());
//                    String userid=jsonHolder.getString("userId").toString();
//                    properties.setProperty("userId",userid);
//                    properties.store(fileWriter,"Loggedin User");
//                    System.lineSeparator().repeat(100);
//                    Login frame=new Login();
//                    frame.setTitle("Dashboard");
//                    frame.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(this, "Invalid Email or Password");
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == resetbutton){
            model.setText("");
            pltNumber.setText("");
            brand.setText("");
            Owner.setText("");
            description.setText("");
        }
    }
    public static void main(String[] args) {
        AddVehicle frame=new AddVehicle();
        frame.setTitle("Add New Vehcle");
        frame.setVisible(true);
        frame.setBounds(10,10,400,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}

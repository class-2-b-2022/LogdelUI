package utils;

import formats.RequestBody;
import formats.ResponseBody;
import formats.User;
import org.json.JSONObject;
import pages.Welcome;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class CheckLoggedInStatus {

    public static FileReader fileReader;
    public static FileWriter fileWriter;

    static {
        try {
            fileReader = new FileReader("config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static User loggedInUser = new User();
    public static RequestBody request = new RequestBody();
    public static ConnectToServer connect = new ConnectToServer();
    public static Properties prop = new Properties();
    public CheckLoggedInStatus() throws IOException {
    }
    public static Boolean isLoggedIn() throws IOException {
        prop.load(fileReader);
        if(prop.getProperty("userId") == "" || prop.getProperty("userId") == null){
            return false;
        }
        return true;
    }
    public static User getLoggedInUser() throws Exception {
        prop.load(fileReader);
        JSONObject jsonHolder = new JSONObject();
        if(isLoggedIn()){
            request.setRoute("/users");
            request.setAction("GET");
            request.setData(Integer.parseInt(prop.getProperty("userId")));
            ResponseBody res = connect.connectToServer(request);
            jsonHolder = new JSONObject(res.getData().toString());
            loggedInUser.setNames(jsonHolder.get("names").toString());
            loggedInUser.setEmail(jsonHolder.get("email").toString());
            loggedInUser.setUserId(Integer.parseInt(jsonHolder.get("userId").toString()));
            loggedInUser.setRole(Integer.parseInt(jsonHolder.get("role").toString()));
            loggedInUser.setRoleAsString(jsonHolder.get("roleAsString").toString());
            loggedInUser.setPhone(Integer.parseInt(jsonHolder.get("phone").toString()));
            return loggedInUser;
        }
        return null;
    }
    public static void logout() throws Exception{
        try {
            fileWriter = new FileWriter("C:\\apps\\projects\\logisticsProject\\logdelUI\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        prop.load(fileReader);
        if(isLoggedIn()){
            prop.remove("userId");
            prop.store(fileWriter, null);
            System.out.println("Successfully logged out!");
            new Welcome();
        }
    }
}

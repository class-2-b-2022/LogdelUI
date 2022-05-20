package main;

import Views.SystemAdminDashboard;
import pages.Welcome;
import utils.CheckLoggedInStatus;


public class Main {
    public static void main(String[] args) throws Exception {
        if(CheckLoggedInStatus.isLoggedIn()){
            SystemAdminDashboard.mainMethod();
        }else{
            new Welcome();
        }


    }
}

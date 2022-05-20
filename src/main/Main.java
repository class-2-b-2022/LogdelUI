package main;

import Views.SystemAdminDashboard;
import pages.Dashboard;
import pages.LoginPage;
import pages.Welcome;
import utils.CheckLoggedInStatus;

import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

//        if(CheckLoggedInStatus.isLoggedIn()){
        SystemAdminDashboard.DashboardMain();
//        }else{
           new Welcome();
//        }


    }
}

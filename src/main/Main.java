package main;

import Views.SystemAdminDashboard;

import pages.Welcome;
import utils.CheckLoggedInStatus;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        if(CheckLoggedInStatus.isLoggedIn()){
            SystemAdminDashboard.mainMethod();
        }else{
            System.out.println("Little changes");
            new Welcome();
        }

    }
}

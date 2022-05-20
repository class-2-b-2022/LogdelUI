package main;

import pages.Billing;
import pages.Dashboard;
import utils.CheckLoggedInStatus;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if(CheckLoggedInStatus.isLoggedIn()){
            new Dashboard();
        }else{
//            new Welcome();
            new Billing();
        }


    }
}

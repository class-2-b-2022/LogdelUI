package handlers;

import pages.Welcome;
import utils.CheckLoggedInStatus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("logout")){
            try {
                CheckLoggedInStatus.logout();

                new Welcome();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

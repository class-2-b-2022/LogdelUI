package handlers;

import pages.VehicleLanding;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoutingHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("delivery")){
            new VehicleLanding();
        }
    }
}

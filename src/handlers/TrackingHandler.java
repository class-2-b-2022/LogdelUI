package handlers;

import Views.Register;
import components.Table;
import pages.TrackingMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackingHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("view_outgoing")){
            Object [][] data = {{1, "Prince","kyabihu","Kigali","Rubavu",12,"Musanze"}, {1, "Prince","Nyabihu","Kigali","Rubavu",12,"Musanze"}, {1, "Prince","Nyabihu","Kigali","Rubavu",12,"Musanze"}};
             Object [] columns = {"Vehicle Id","Driver Name", "Current Location", "Destination","Source Location","Fuel Level","Nearest Station","Departure Time","Arriving time"};
    
        new Table("Tracking",data,columns);
    }
        if(e.getActionCommand().equals("add_outgoing")){
            new Register().mainMethod();
        }
    }
}

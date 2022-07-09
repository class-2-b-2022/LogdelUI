package handlers;

import pages.Inventory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!e.getActionCommand().equals("inventory")) {
            Inventory.mainMethod();
        }


    }
}

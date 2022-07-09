package handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pages.MainCompanyPage;

public class CompanyHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("company")){
            new MainCompanyPage();
        }
    }
}
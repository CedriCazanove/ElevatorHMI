package Controller.ActionListener;

import Model.Password;
import View.ElevatorView;
import View.Ressource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelPassword implements ActionListener {
    private ElevatorView elevatorView;
    private Password password;
    private Ressource rsc = new Ressource();
    private int delay = 200; //milliseconds
    private ActionListener taskPerformer;

    public CancelPassword(ElevatorView elevatorView, Password password) {
        this.elevatorView = elevatorView;
        this.password = password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        password.removeLastDigit();
        elevatorView.getBtnCancel().setIcon(rsc.getIconCrossPressed());
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                elevatorView.getBtnCancel().setIcon(rsc.getIconCross());
            }
        };
        new Timer(delay, taskPerformer).start();
    }
}
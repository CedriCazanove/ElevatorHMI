package Controller.ActionListener;

import Model.Password;
import View.ElevatorView;
import View.Ressource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WriteIntoPassword implements ActionListener {

    private ElevatorView elevatorView;
    private Password password;
    private int digit;
    private Ressource rsc = new Ressource();
    private int delay = 200; //milliseconds
    private ActionListener taskPerformer;

    public WriteIntoPassword(ElevatorView elevatorView, Password password, int digit) {
        this.elevatorView = elevatorView;
        this.password = password;
        this.digit = digit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        password.addDigit(digit);
        switch (digit) {
            case 0:
                elevatorView.getBtnDigit0().setIcon(rsc.getIconDigit0Green());
                taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        elevatorView.getBtnDigit0().setIcon(rsc.getIconDigit0());
                    }
                };
                new Timer(delay, taskPerformer).start();
                break;
            case 1:
                elevatorView.getBtnDigit1().setIcon(rsc.getIconDigit1Green());
                taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        elevatorView.getBtnDigit1().setIcon(rsc.getIconDigit1());
                    }
                };
                new Timer(delay, taskPerformer).start();
                break;
            case 2:
                elevatorView.getBtnDigit2().setIcon(rsc.getIconDigit2Green());
                taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        elevatorView.getBtnDigit2().setIcon(rsc.getIconDigit2());
                    }
                };
                new Timer(delay, taskPerformer).start();
                break;
            case 3:
                elevatorView.getBtnDigit3().setIcon(rsc.getIconDigit3Green());
                taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        elevatorView.getBtnDigit3().setIcon(rsc.getIconDigit3());
                    }
                };
                new Timer(delay, taskPerformer).start();
                break;
            case 4:
                elevatorView.getBtnDigit4().setIcon(rsc.getIconDigit4Green());
                taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        elevatorView.getBtnDigit4().setIcon(rsc.getIconDigit4());
                    }
                };
                new Timer(delay, taskPerformer).start();
                break;
            case 5:
                elevatorView.getBtnDigit5().setIcon(rsc.getIconDigit5Green());
                taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        elevatorView.getBtnDigit5().setIcon(rsc.getIconDigit5());
                    }
                };
                new Timer(delay, taskPerformer).start();
                break;
            case 6:
                elevatorView.getBtnDigit6().setIcon(rsc.getIconDigit6Green());
                taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        elevatorView.getBtnDigit6().setIcon(rsc.getIconDigit6());
                    }
                };
                new Timer(delay, taskPerformer).start();
                break;
            case 7:
                elevatorView.getBtnDigit7().setIcon(rsc.getIconDigit7Green());
                taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        elevatorView.getBtnDigit7().setIcon(rsc.getIconDigit7());
                    }
                };
                new Timer(delay, taskPerformer).start();
                break;
            case 8:
                elevatorView.getBtnDigit8().setIcon(rsc.getIconDigit8Green());
                taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        elevatorView.getBtnDigit8().setIcon(rsc.getIconDigit8());
                    }
                };
                new Timer(delay, taskPerformer).start();
                break;
            case 9:
                elevatorView.getBtnDigit9().setIcon(rsc.getIconDigit9Green());
                taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        elevatorView.getBtnDigit9().setIcon(rsc.getIconDigit9());
                    }
                };
                new Timer(delay, taskPerformer).start();
                break;
        }
    }
}

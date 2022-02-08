package Controller.ActionListener;

import Controller.ActionListener.Elevator.SendSupPanelReq;
import Controller.Mqtt.MqttPublisher;
import View.ElevatorView;
import View.Ressource;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupervisorOnOffAction implements ActionListener {

    private ElevatorView elevatorView;
    private MqttPublisher mqttPublisher;
    private Ressource rsc = new Ressource();

    public SupervisorOnOffAction(ElevatorView elevatorView, MqttPublisher mqttPublisher) {
        this.elevatorView = elevatorView;
        this.mqttPublisher = mqttPublisher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (elevatorView.getSupervisorOnOff().isSelected()) {
            //add something to login
            elevatorView.getSupervisorOnOff().setIcon(rsc.getIconSupervisor());
            //we display the code to enter the code to use the panel as supervisor
            elevatorView.setCodeAccessSupervisor(true);
            elevatorView.getLblPassword().setText("Tap the password");
        } else {
            elevatorView.getSupervisorOnOff().setIcon(rsc.getIconUser());
            elevatorView.getPassword().clear();
            //send a request to say that we are in automatic mode
            new SendSupPanelReq(mqttPublisher, "automatic", "POreset", false).actionPerformed(null);
            elevatorView.setSupervisor(false);
            elevatorView.setCodeAccessSupervisor(false);
        }
        elevatorView.getPanelSupervisor().setVisible(elevatorView.getSupervisor());
        elevatorView.getPanelCodeAccessSupervisor().setVisible(elevatorView.getCodeAccessSupervisor());
    }
}

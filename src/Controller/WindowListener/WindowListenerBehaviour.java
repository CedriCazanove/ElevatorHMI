package Controller.WindowListener;

import Controller.Mqtt.MqttPublisher;
import Controller.Mqtt.MqttSubscriber;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;

public class WindowListenerBehaviour implements WindowListener {

    private FileWriter myWriter;

    private MqttPublisher mqttPublisher;

    public WindowListenerBehaviour(FileWriter myWriter, MqttPublisher mqttPublisher) {
        this.myWriter = myWriter;
        this.mqttPublisher = mqttPublisher;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            myWriter.close();
            mqttPublisher.stopConnection();
            System.out.println("ElevatorHMI well closed");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

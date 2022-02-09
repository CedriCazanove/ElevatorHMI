package Controller;

import Controller.ActionListener.Elevator.SendServPReq;
import Controller.Mqtt.MqttPublisher;
import Controller.Request.TestRequestServPAns;
import Model.Elevator.Elevator;
import View.ElevatorView;
import org.json.JSONException;

import java.util.TimerTask;

public class AskingAllStatePeriodicaly {

    private MqttPublisher mqttPublisher;

    private int delay = 5000; //5sec by default

    private java.util.Timer timer;

    private TimerTask timerTask;

    public AskingAllStatePeriodicaly(MqttPublisher mqttPublisher) {
        this.mqttPublisher = mqttPublisher;
        this.timer = new java.util.Timer();
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                new SendServPReq(mqttPublisher).actionPerformed(null);
                System.out.println("Asking for the state of the elevator..");
                try {
                    mqttPublisher.sendMessage(new TestRequestServPAns().toJSON().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void startAsking() {
        timer.schedule(timerTask, 0, delay);//period is in ms (every 5sec we ask)
    }

    public void stopAsking() {
        this.timer.cancel();
        this.timer = new java.util.Timer();
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                new SendServPReq(mqttPublisher).actionPerformed(null);
                System.out.println("Asking for the state of the elevator..");
                try {
                    mqttPublisher.sendMessage(new TestRequestServPAns().toJSON().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}

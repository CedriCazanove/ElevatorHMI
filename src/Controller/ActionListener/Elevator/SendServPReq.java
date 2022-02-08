package Controller.ActionListener.Elevator;

import Controller.Mqtt.MqttPublisher;
import Controller.Request.UserRequest;
import org.json.JSONException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendServPReq implements ActionListener {

    private MqttPublisher mqttPublisher;

    public SendServPReq(MqttPublisher mqttPublisher) {
        this.mqttPublisher = mqttPublisher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserRequest requestForStates = new UserRequest("ServPReq", "Service Panel", "show all states");
        try {
            System.out.println(requestForStates.toJSON());
            mqttPublisher.sendMessage(requestForStates.toJSON().toString());
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

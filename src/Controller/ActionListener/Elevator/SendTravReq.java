package Controller.ActionListener.Elevator;

import Controller.Mqtt.MqttPublisher;
import Controller.Request.*;
import org.json.JSONException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendTravReq implements ActionListener {

    private UserRequest request;
    private MqttPublisher mqttPublisher;

    public SendTravReq(MqttPublisher mqttPublisher, String request) {
        this.request = new UserRequest("TravReq", "Elevator Panel", request);
        this.mqttPublisher = mqttPublisher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            System.out.println(request.toJSON());
            mqttPublisher.sendMessage(request.toJSON().toString());
            //mqttPublisher.sendMessage(new TestRequestServPAns().toJSON().toString());
            //mqttPublisher.sendMessage(new TestRequestCurrentLevel().toJSON().toString());
            //mqttPublisher.sendMessage(new TestRequestDirection().toJSON().toString());
            //mqttPublisher.sendMessage(new TestRequestDoorState().toJSON().toString());
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        new SendServPReq(mqttPublisher).actionPerformed(null);
    }
}

package Controller.ActionListener;

import Controller.Mqtt.MqttPublisher;
import Controller.Request.SupervisorRequest;
import org.json.JSONException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendSupPanelReq implements ActionListener {

    private SupervisorRequest supervisorRequest;
    private MqttPublisher mqttPublisher;

    public SendSupPanelReq(MqttPublisher mqttPublisher, String mode, String request, Object state) {
        this.supervisorRequest = new SupervisorRequest("SupPanelReq", "Panel", mode, request, state);
        this.mqttPublisher = mqttPublisher;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            System.out.println(supervisorRequest.toJSON());
            mqttPublisher.sendMessage(supervisorRequest.toJSON().toString());
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        new SendServPReq(mqttPublisher).actionPerformed(null);
    }
}

package Controller.Mqtt;

import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.JSONException;
import org.json.JSONObject;

public class MqttPublisher {

    private String topic = "/21WS-SysArch/H1";

    private String broker = "tcp://localhost:1884";//"tcp://ce121caz@ea-pc165.ei.htwg-konstanz.de:1883";//

    private String clientId = "JavaSample";

    private String username = "H1";

    private String password = "DF9";

    private MemoryPersistence persistence = new MemoryPersistence();

    private MqttClient sampleClient;

    private MqttConnectOptions connOpts;

    private int qos = 0;

    private FileWriter myWriter;


    public MqttPublisher(FileWriter myWriter) {
        try {
            this.myWriter = myWriter;
            sampleClient = new MqttClient(this.broker, this.clientId, this.persistence);
            connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setUserName(username);
            connOpts.setPassword(password.toCharArray());
        } catch(MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }

    public void startConnection() {
        try {
            System.out.println("Connecting to broker : " + this.broker);
            this.sampleClient.connect(connOpts);
            System.out.println("Connected to broker");
        } catch(MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        try {
            MqttMessage message = new MqttMessage(msg.getBytes());
            message.setQos(qos);
            this.sampleClient.publish(topic, message);
            System.out.println("Message published");
            JSONObject jsonmsg = new JSONObject(msg);
            String other;
            if(jsonmsg.get("type").equals("SupPanelReq")) {
                other = "\n\tMode: " + jsonmsg.get("mode").toString() +"\n\tControl: " +jsonmsg.get("control").toString() + "\n\tState: "+ jsonmsg.get("state").toString();
            } else if(jsonmsg.get("type").equals("TravReq")) {
                other = jsonmsg.get("request").toString();
            } else {
                other = "null";
            }
            myWriter.write("Sent message type: " + jsonmsg.get("type").toString() + " at " + jsonmsg.get("time").toString() +"\n------------------------------- \nMessage: " + other + " \nDevice: "+ jsonmsg.get("device").toString() + "\n------------------------------------------------------------------------------------------------\n");

        } catch(MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }  catch (JSONException e1) {
            System.out.println(e1 + "Not able to convert into JSON");
        }  catch (IOException e) {
            System.out.println(e + "; An error occurred writing the file.");
            e.printStackTrace();
        }



    }

    public void stopConnection() {
        try {
            this.sampleClient.disconnect();
            this.sampleClient.close();
            System.out.println("Disconnected to broker");
        } catch(MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }



}

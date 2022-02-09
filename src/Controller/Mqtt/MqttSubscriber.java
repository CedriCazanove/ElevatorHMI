package Controller.Mqtt;

import Model.Elevator.Elevator;

import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.JSONException;
import org.json.JSONObject;
import Controller.Request.*;

public class MqttSubscriber implements MqttCallback{

	/** The broker url. */
	private static final String brokerUrl ="tcp://localhost:1884";

	/** The client id. */
	private static final String clientId = "clientId";

	/** The topic. */
	private static final String topic = "/21WS-SysArch/H1";

	private String username = "H1";

	private String password = "DF9";

	private MemoryPersistence persistence = new MemoryPersistence();

	private MqttClient sampleClient;

	private MqttConnectOptions connOpts;

	private Elevator elevator;

	private String other;

	private FileWriter myWriter;

	public MqttSubscriber(Elevator elevator, FileWriter myWriter) {
		this.elevator = elevator;
		this.myWriter = myWriter;
	}

	public void subscribe() {
		try	{
			sampleClient = new MqttClient(brokerUrl, MqttClient.generateClientId(), persistence);
			connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			connOpts.setUserName(username);
			connOpts.setPassword(password.toCharArray());

			System.out.println("checking");
			System.out.println("Mqtt Connecting to broker for listening: " + brokerUrl);

			sampleClient.connect(connOpts);
			System.out.println("Mqtt Connected for listening");

			sampleClient.setCallback(this);
			sampleClient.subscribe(this.topic, 2);

			System.out.println("Subscribed");
			System.out.println("Listening");

		} catch (MqttException me) {
			System.out.println(me);
		}
	}

	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("Subscribe :\n" + new String(message.getPayload()));
		JSONObject jsonmsg = new JSONObject(new String(message.getPayload()));
		System.out.println("Type : " + jsonmsg.get("type").toString());
		Request requestBack = null;
		try {
			switch (jsonmsg.get("type").toString()) {
				case "ServPAns":
					System.out.println("ServPAns");
					requestBack = new RequestBackPanelAnswer(jsonmsg.get("type").toString(), jsonmsg.get("device").toString(), jsonmsg.getJSONArray("states"), jsonmsg.get("time").toString());
					elevator.treatRequestBackAnswer((RequestBackPanelAnswer) requestBack);
					other = jsonmsg.get("states").toString();
					break;
				case "ServState":
				case "DoorState":
					System.out.println("State");
					requestBack = new RequestBackState(jsonmsg.get("type").toString(), jsonmsg.get("device").toString(), jsonmsg.get("state").toString(), jsonmsg.get("time").toString());
					elevator.treatRequestBackState((RequestBackState) requestBack);
					other = jsonmsg.get("state").toString();
					break;
				case "CurrentLevel":
					System.out.println("Level");
					requestBack = new RequestBackLevel(jsonmsg.get("type").toString(), jsonmsg.get("device").toString(), jsonmsg.get("level").toString(), jsonmsg.get("time").toString());
					elevator.treatRequestBackLevel((RequestBackLevel) requestBack);
					other = jsonmsg.get("level").toString();
					break;
				case "DirInd":
					System.out.println("Direction");
					requestBack = new RequestBackDirection(jsonmsg.get("type").toString(), jsonmsg.get("device").toString(), jsonmsg.get("direction").toString(), jsonmsg.get("time").toString());
					elevator.treatRequestBackDirection((RequestBackDirection) requestBack);
					other = jsonmsg.get("direction").toString();
					break;
				case "LogMsg":
					System.out.println("Log Error");
					requestBack = new LogError(jsonmsg.get("type").toString(), jsonmsg.get("message").toString(), jsonmsg.get("device").toString(), jsonmsg.get("time").toString(), jsonmsg.get("severity").toString());
					other = jsonmsg.get("severity").toString() + " " + jsonmsg.get("message").toString();
					break;
				default:
					System.out.println("no request back match");
					break;
			}
		} catch (JSONException e) {
			System.out.println("JSONException: " + e.getMessage());
		}

		printMessageInFile(jsonmsg.get("type").toString(), jsonmsg.get("time").toString(), jsonmsg.get("device").toString(), other);
		System.out.println("END");
	}

	private void printMessageInFile(String type, String dateTime, String device, String other2) {
		try {
			myWriter.write("Received message type: " + type + " at " + dateTime +"\n ------------------------------- \n Message: " + other2 + " \n Device: "+ device + "\n------------------------------------------------------------------------------------------------\n");

		} catch (IOException e) {
			System.out.println("An error occurred writing the file.");
			e.printStackTrace();
		}
	}

}

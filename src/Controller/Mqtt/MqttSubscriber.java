package Controller.Mqtt;

import Model.Elevator;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.JSONObject;
import Controller.Request.*;

public class MqttSubscriber implements MqttCallback{
	
	/** The broker url. */
	private static final String brokerUrl ="tcp://localhost:1884";

	/** The client id. */
	private static final String clientId = "clientId";

	/** The topic. */
	private static final String topic = "/21WS-SysArch/C1";//
    
    private String username = "H1";
   
    private String password = "DF9";
    
    private MemoryPersistence persistence = new MemoryPersistence();
    
    private MqttClient sampleClient;
    
    private MqttConnectOptions connOpts;
    
    private Elevator elevator;
    
    public MqttSubscriber(Elevator elevator) {
    	this.elevator = elevator;
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
		switch(jsonmsg.get("type").toString()) {
		case "ServPAns":
			System.out.println("ServPAns");
			requestBack = new RequestBackPanelAnswer(jsonmsg.get("type").toString(), jsonmsg.get("device").toString(), jsonmsg.getJSONArray("states"), jsonmsg.get("time").toString());
			System.out.println("ServPAns");
			elevator.treatRequestBackAnswer( (RequestBackPanelAnswer) requestBack);
			break;
		case "ServState":
		case "Model.DoorState":
			System.out.println("State");
			requestBack = new RequestBackState(jsonmsg.get("type").toString(), jsonmsg.get("device").toString(), jsonmsg.get("state").toString(), jsonmsg.get("time").toString());
			System.out.println("State");
			elevator.treatRequestBackState( (RequestBackState) requestBack);
			break;
		case "CurrentLevel":
			System.out.println("Level");
			requestBack = new RequestBackLevel(jsonmsg.get("type").toString(), jsonmsg.get("device").toString(), jsonmsg.get("level").toString(), jsonmsg.get("time").toString());
			System.out.println("Level");
			elevator.treatRequestBackLevel( (RequestBackLevel) requestBack);
			break;
		case "DirInd":
			System.out.println("Direction");
			requestBack = new RequestBackDirection(jsonmsg.get("type").toString(), jsonmsg.get("device").toString(), jsonmsg.get("direction").toString(), jsonmsg.get("time").toString());

			elevator.treatRequestBackDirection((RequestBackDirection) requestBack);
			break;
		case "LogMsg":
			System.out.println("Log Error");
			requestBack = new LogError(jsonmsg.get("type").toString(), jsonmsg.get("message").toString(), jsonmsg.get("device").toString(), jsonmsg.get("time").toString(), jsonmsg.get("severity").toString());

			break;
		default:
			 System.out.println("no request back match");
			 break;
		}
		System.out.println("END");
	}

}

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.json.JSONObject;

public class MqttSubscriber implements MqttCallback{
	
	/** The broker url. */
	private static final String brokerUrl ="tcp://localhost:1888";

	/** The client id. */
	private static final String clientId = "clientId";

	/** The topic. */
	private static final String topic = "/21WS-SysArch/#";
    
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
			sampleClient = new MqttClient(brokerUrl, clientId, persistence);
			connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			connOpts.setUserName(username);
	        connOpts.setPassword(password.toCharArray());

			System.out.println("checking");
			System.out.println("Mqtt Connecting to broker for listening: " + brokerUrl);

			sampleClient.connect(connOpts);
			System.out.println("Mqtt Connected for listening");

			sampleClient.setCallback(this);
			sampleClient.subscribe(this.topic);

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
		JSONObject jsonmsg = new JSONObject(new String(message.getPayload()));
		System.out.println("Subscribe :\n" + jsonmsg);
		System.out.println("Type : " + jsonmsg.get("type").toString());
		RequestBack requestBack = null;
		switch(jsonmsg.get("type").toString()) {
		case "TravReqRes":
			requestBack = new RequestBackReset(jsonmsg.get("type").toString(), jsonmsg.get("device").toString(), jsonmsg.get("reset").toString(), jsonmsg.get("time").toString());
			System.out.println("Reset");
			break;
		case "ServPaAns":
			requestBack = new RequestBackAnswer(jsonmsg.get("type").toString(), jsonmsg.get("device").toString(), jsonmsg.get("answer").toString(), jsonmsg.get("time").toString());
			System.out.println("Answer");
			break;
		case "ServState":
		case "DoorState":
			requestBack = new RequestBackState(jsonmsg.get("type").toString(), jsonmsg.get("device").toString(), jsonmsg.get("state").toString(), jsonmsg.get("time").toString());
			System.out.println("State");
			elevator.treatRequestBackState( (RequestBackState) requestBack);
			break;
		case "CurrentLevel":
			requestBack = new RequestBackLevel(jsonmsg.get("type").toString(), jsonmsg.get("device").toString(), jsonmsg.get("level").toString(), jsonmsg.get("time").toString());
			System.out.println("Level");
			elevator.treatRequestBackLevel( (RequestBackLevel) requestBack);
			break;
		case "DirInd":
			requestBack = new RequestBackDirection(jsonmsg.get("type").toString(), jsonmsg.get("device").toString(), jsonmsg.get("direction").toString(), jsonmsg.get("time").toString());
			System.out.println("Direction");
			break;
		case "LogMsg":
			requestBack = new LogError(jsonmsg.get("type").toString(), jsonmsg.get("message").toString(), jsonmsg.get("device").toString(), jsonmsg.get("time").toString(), jsonmsg.get("severity").toString());
			System.out.println("Log Error");
			break;
		default:
			 System.out.println("no request back match");
		}
		
	}

}

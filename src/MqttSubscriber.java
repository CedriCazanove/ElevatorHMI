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
	private static final String brokerUrl ="tcp://localhost:1883";

	/** The client id. */
	private static final String clientId = "clientId";

	/** The topic. */
	private static final String topic = "test";//"/21WS-SysArch/#";
    
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
			System.out.println("Mqtt Connecting to broker: " + brokerUrl);

			sampleClient.connect(connOpts);
			System.out.println("Mqtt Connected");

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
		// TODO Auto-generated method stub
		JSONObject jsonmsg = new JSONObject(new String(message.getPayload()));
		
	}

}

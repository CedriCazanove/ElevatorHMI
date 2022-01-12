import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttPublisher {
	
	private String topic = "/21WS-SysArch/test";
	
	private String broker = "tcp://localhost:1888";//"tcp://ce121caz@ea-pc165.ei.htwg-konstanz.de:1883";// 
	
    private String clientId = "JavaSample";
    
    private String username = "H1";
   
    private String password = "DF9";
    
    private MemoryPersistence persistence = new MemoryPersistence();
    
    private MqttClient sampleClient;
    
    private MqttConnectOptions connOpts;
    
    private int qos = 0;
    
    public MqttPublisher() {
    	try {
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
    	} catch(MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
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

import java.awt.EventQueue;

public class ElevatorHMI {
	
	private static MqttPublisher mqttPublisher;
	
	private static MqttSubscriber mqttSubscriber;
	
	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		System.out.println(elevator.toString());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mqttSubscriber = new MqttSubscriber(elevator);
					mqttSubscriber.subscribe();
					mqttPublisher = new MqttPublisher();
					mqttPublisher.startConnection();
					ElevatorView windowElevator = new ElevatorView(elevator, mqttPublisher);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

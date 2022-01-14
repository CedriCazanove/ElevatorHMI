import java.awt.EventQueue;

public class ElevatorHMI {
	
	private static MqttPublisher mqttPublisher;
	
	private static MqttSubscriber mqttSubscriber;
	
	public static void main(String[] args) {
		Elevator elevator = new Elevator(DoorState.CLOSE, ElevatorState.INSERVICE, 0, Direction.IDLE, ElevatorSpeed.SPEED1);
		System.out.println(elevator.toString());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					mqttPublisher = new MqttPublisher();
					mqttPublisher.startConnection();
					mqttSubscriber = new MqttSubscriber(elevator);
					mqttSubscriber.subscribe();
					ElevatorPanelControlOutside windowOutside = new ElevatorPanelControlOutside(mqttPublisher);
					ElevatorPanelControlInside windowInside = new ElevatorPanelControlInside(mqttPublisher);
					ElevatorView windowElevator = new ElevatorView(elevator);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

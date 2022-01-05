import java.awt.EventQueue;

public class ElevatorHMI {
	
	private static MqttPublisher mqttPublisher;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ElevatorPanelControlOutside window = new ElevatorPanelControlOutside();
					//window.frame.setVisible(true);
					try {
						mqttPublisher = new MqttPublisher();
						mqttPublisher.startConnection();
					} catch (Exception e) {
						e.printStackTrace();
					}
					ElevatorPanelControlOutside windowOuside = new ElevatorPanelControlOutside(mqttPublisher);
					ElevatorPanelControlInside windowInside = new ElevatorPanelControlInside(mqttPublisher);
					ElevatorView windowElevator = new ElevatorView();
					Elevator elevator = new Elevator(DoorState.OPEN, ElevatorState.INSERVICE, CurrentLevel.LEVEL0, Direction.IDLE);
					System.out.println(elevator.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

import Controller.MqttPublisher;
import Controller.MqttSubscriber;
import Model.Elevator;
import View.ElevatorView;

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
					mqttPublisher = new MqttPublisher();
					mqttPublisher.startConnection();
					mqttSubscriber = new MqttSubscriber(elevator);
					mqttSubscriber.subscribe();
					ElevatorView windowElevator = new ElevatorView(elevator, mqttPublisher);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

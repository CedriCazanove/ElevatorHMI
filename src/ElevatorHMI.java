import Controller.Mqtt.MqttPublisher;
import Controller.Mqtt.MqttSubscriber;
import Model.Elevator;
import View.ElevatorView;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ElevatorHMI {

	private static MqttPublisher mqttPublisher;

	private static MqttSubscriber mqttSubscriber;

	private static FileWriter myWriter;

	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		System.out.println(elevator.toString());

		try {
			File file= new File ("files","file.txt");
			if (file.exists())
			{
				myWriter = new FileWriter(file,true);//if file exists append to file. Works fine.
			}
			else
			{
				myWriter = new FileWriter(file);// If file does not exist. Create it. This throws a FileNotFoundException. Why?
			}
		} catch (IOException e1) {
			System.out.println(e1 + "; Not able to find the specified directory");
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mqttPublisher = new MqttPublisher(myWriter);
					mqttPublisher.startConnection();
					mqttSubscriber = new MqttSubscriber(elevator, myWriter);
					mqttSubscriber.subscribe();
					ElevatorView windowElevator = new ElevatorView(elevator, mqttPublisher, myWriter);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

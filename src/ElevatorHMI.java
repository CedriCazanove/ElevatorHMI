import Controller.ActionListener.Elevator.SendServPReq;
import Controller.AskingAllStatePeriodicaly;
import Controller.Mqtt.MqttPublisher;
import Controller.Mqtt.MqttSubscriber;
import Controller.Request.TestRequestServPAns;
import Model.Elevator.Elevator;
import View.ElevatorView;
import org.json.JSONException;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TimerTask;

public class ElevatorHMI {

	private static MqttPublisher mqttPublisher;

	private static MqttSubscriber mqttSubscriber;

	private static FileWriter myWriter;

	private static AskingAllStatePeriodicaly statePeriodicaly;

	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		//System.out.println(elevator.toString());
		try {
			File file= new File ("files","file.txt");
			if (file.exists()) {
				myWriter = new FileWriter(file,true);//if file exists append to file. Works fine.
			} else {
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

					/**
					 * Can only display the window when we have at least received the state once to initialize the elevator and the view
					 */
					statePeriodicaly = new AskingAllStatePeriodicaly(mqttPublisher);
					statePeriodicaly.setDelay(5000); //asking every 5 secondes
					statePeriodicaly.startAsking();
					/*
					java.util.Timer timer = new java.util.Timer();
					TimerTask timerTask = new TimerTask() {
						@Override
						public void run() {
							new SendServPReq(mqttPublisher).actionPerformed(null);
							System.out.println("Waiting for the state of the elevator..");
							try {
								mqttPublisher.sendMessage(new TestRequestServPAns().toJSON().toString());
							} catch (JSONException e) {
								e.printStackTrace();
							}
						}
					};
					timer.schedule(timerTask, 0, 5000);//period is in ms (every 5sec we ask)
*/
					while(!elevator.getPIm_ready()) {
						System.out.println("Elevator is" + (elevator.getPIm_ready() ? " " : " not") + " ready");
					}
					System.out.println("Elevator is" + (elevator.getPIm_ready() ? " " : " not") + " ready");
					//timer.cancel();
					statePeriodicaly.stopAsking();
					windowElevator.setElevatorViewVisible(true);

					/**
					 * Asking for all the state every 1min
					 */
					statePeriodicaly.setDelay(60000);
					statePeriodicaly.startAsking();
					/*
					timer = new java.util.Timer();
					timerTask = new TimerTask() {
						@Override
						public void run() {
							new SendServPReq(mqttPublisher).actionPerformed(null);
						}
					};
					timer.schedule(timerTask, 0, 60000);//period is in ms (every 1min we ask)

					 */
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

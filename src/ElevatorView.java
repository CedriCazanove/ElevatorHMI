import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.json.JSONException;

import javax.swing.JLabel;
import javax.swing.JButton;

public class ElevatorView {

	private JFrame frame;

	private Elevator elevator;

	private static MqttPublisher mqttPublisher;

	private static MqttSubscriber mqttSubscriber;

	Timer timer;

	private static JLabel labelElevator;

	private JLabel lblFloorIndicator;

	private JButton btnUp, btnDown;

	private static URL urlFloorIndicator = ElevatorView.class.getResource("/floorIndicator.png");

	private static URL urlElevatorOpen = ElevatorView.class.getResource("/elevatorOpen.png");
	private static URL urlElevatorClose = ElevatorView.class.getResource("/elevatorClose.png");
	private static URL urlElevatorInTransition = ElevatorView.class.getResource("/elevatorInTransition.png");

	private static Icon iconElevatorOpen = new ImageIcon(urlElevatorOpen);
	private static Icon iconElevatorClose = new ImageIcon(urlElevatorClose);
	private static Icon iconElevatorInTransition = new ImageIcon(urlElevatorInTransition);

	private static URL urlUp = ElevatorPanelControlOutside.class.getResource("/up.png");
	private static URL urlUpGreen = ElevatorPanelControlOutside.class.getResource("/upGreen.png");
	Icon iconUp = new ImageIcon(urlUp);
	Icon iconUpGreen = new ImageIcon(urlUpGreen);

	private static URL urlDown = ElevatorPanelControlOutside.class.getResource("/down.png");
	private static URL urlDownGreen = ElevatorPanelControlOutside.class.getResource("/downGreen.png");
	Icon iconDown = new ImageIcon(urlDown);
	Icon iconDownGreen = new ImageIcon(urlDownGreen);
	private JButton btnUp_1;
	private JButton btnDown_1;
	private JButton btnUp_2;
	private JButton btnDown_2;
	private JButton btnUp_3;
	private JButton btnDown_3;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElevatorView window = new ElevatorView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ElevatorView(Elevator elevator, MqttPublisher mqttPublisher, MqttSubscriber mqttSubscriber) {
		initialize();
		this.mqttPublisher = mqttPublisher;
		this.mqttSubscriber = mqttSubscriber;
		this.elevator = elevator;
		this.elevator.setListener(new Elevator.ElevatorListener() {
			private Elevator elevatorView = elevator;

			@Override
			public void doorStateChanged() {
				System.out.println("ElevatorView : The state of the elevator change");
				System.out.println(elevatorView.toString());
				switch(elevatorView.getDoorState()) {
					case OPEN:
						labelElevator.setIcon(iconElevatorOpen);
						break;
					case CLOSE:
						labelElevator.setIcon(iconElevatorClose);
						break;
					case OPENING:
					case CLOSING:
						labelElevator.setIcon(iconElevatorInTransition);
						break;
					default:
						System.out.println("ElevatorView : no match");

				}
			}
			@Override
			public void currentLevelChanged() {
				System.out.println("ElevatorView : currentLevelChanged");

				int nextLevel = (3 - elevatorView.getCurrentLevel())*135 + 3;
				labelElevator.setBounds(0, nextLevel, 100, 135);
				btnUp.setIcon(iconUpGreen);
			}
			@Override
			public void elevatorStateChanged() {
				// TODO Auto-generated method stub

			}
			@Override
			public void directionChanged() {
				// TODO Auto-generated method stub

			}
			@Override
			public void speedChanged() {
				// TODO Auto-generated method stub

			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Elevator");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(350, 100, 249, 653);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelElevator = new JPanel();
		panelElevator.setBounds(30, 63, 100, 543);
		frame.getContentPane().add(panelElevator);
		panelElevator.setLayout(null);


		labelElevator = new JLabel(iconElevatorOpen);
		labelElevator.setBounds(0, 408, 100, 135);
		panelElevator.add(labelElevator);

		JPanel panelFloor = new JPanel();
		panelFloor.setBounds(10, 63, 10, 543);
		frame.getContentPane().add(panelFloor);
		panelFloor.setLayout(null);

		Icon iconFloorIndicator = new ImageIcon(urlFloorIndicator);
		lblFloorIndicator = new JLabel(iconFloorIndicator);
		lblFloorIndicator.setBounds(0, 0, 10, 543);
		panelFloor.add(lblFloorIndicator);

		btnUp = new JButton(iconUp);
		btnUp.setBounds(150, 482, 50, 50);
		btnUp.setFocusPainted(false);
		btnUp.setFocusable(false);
		btnUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Request request = new Request("TravReq", "Elevator Panel", "move to level 0");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnUp);

		btnDown = new JButton(iconDown);
		btnDown.setBounds(150, 543, 50, 50);
		btnDown.setFocusPainted(false);
		btnDown.setFocusable(false);
		btnDown.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Request request = new Request("TravReq", "Elevator Panel", "move to level 0");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnDown);

		btnUp_1 = new JButton(iconUp);
		btnUp_1.setBounds(150, 347, 50, 50);
		btnUp_1.setFocusPainted(false);
		btnUp_1.setFocusable(false);
		btnUp_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Request request = new Request("TravReq", "Elevator Panel", "move to level 0");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnUp_1);

		btnDown_1 = new JButton(iconDown);
		btnDown_1.setBounds(150, 408, 50, 50);
		btnDown_1.setFocusPainted(false);
		btnDown_1.setFocusable(false);
		btnDown_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Request request = new Request("TravReq", "Elevator Panel", "move to level 1");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnDown_1);

		btnUp_2 = new JButton(iconUp);
		btnUp_2.setBounds(150, 212, 50, 50);
		btnUp_2.setFocusPainted(false);
		btnUp_2.setFocusable(false);
		btnUp_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Request request = new Request("TravReq", "Elevator Panel", "move to level 0");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnUp_2);

		btnDown_2 = new JButton(iconDown);
		btnDown_2.setBounds(150, 273, 50, 50);
		btnDown_2.setFocusPainted(false);
		btnDown_2.setFocusable(false);
		btnDown_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Request request = new Request("TravReq", "Elevator Panel", "move to level 0");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnDown_2);

		btnUp_3 = new JButton(iconUp);
		btnUp_3.setBounds(150, 78, 50, 50);
		btnUp_3.setFocusPainted(false);
		btnUp_3.setFocusable(false);
		btnUp_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Request request = new Request("TravReq", "Elevator Panel", "move to level 0");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnUp_3);

		btnDown_3 = new JButton(iconDown);
		btnDown_3.setBounds(150, 138, 50, 50);
		btnDown_3.setFocusPainted(false);
		btnDown_3.setFocusable(false);
		btnDown_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Request request = new Request("TravReq", "Elevator Panel", "move to level 0");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnDown_3);

		JLabel lblElevatorIndicator = new JLabel("New label");
		lblElevatorIndicator.setBounds(10, 10, 190, 40);
		frame.getContentPane().add(lblElevatorIndicator);
	}
}

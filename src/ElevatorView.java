import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

import org.json.JSONException;

public class ElevatorView {

	private JFrame frame;

	private Elevator elevator;

	private static MqttPublisher mqttPublisher;

	private static JLabel labelElevator;

	private JLabel lblFloorIndicator;

	private JButton btnUp, btnUp_1, btnDown_1, btnUp_2, btnDown_2, btnDown_3;

	private JButton btnLevel0, btnLevel1, btnLevel2, btnLevel3, btnStop, btnOpen, btnClose;

	private JButton btnDigit1, btnDigit2, btnDigit3, btnDigit4, btnDigit5, btnDigit6, btnDigit7, btnDigit8, btnDigit9, btnDigit0, btnValidate, btnCancel;

	private JButton btnPOreset, btnPOdv2, btnPOdv1, btnPOdclose, btnPOdopen, btnPOuv2, btnPOuv1;

	private JToggleButton supervisorOnOff;

	private Password password;

	private Boolean codeAccessSupervisor = false, supervisor = false;

	private JPanel panelCodeAccessSupervisor, panelSupervisor;

	private JLabel lblPassword, lblPOreset, lblPOdv2, lblPOdv1, lblPOuv1, lblPOuv2, lblPOdclose, lblPOdopen;

	//Picture for the displaying the level on the left
	private static URL urlFloorIndicator = ElevatorView.class.getResource("/floorIndicator.png");
	private static Icon iconFloorIndicator = new ImageIcon(urlFloorIndicator);

	//Picture of the elevator
	private static URL urlElevatorOpen = ElevatorView.class.getResource("/elevatorOpen.png");
	private static URL urlElevatorClose = ElevatorView.class.getResource("/elevatorClose.png");
	private static URL urlElevatorInTransition = ElevatorView.class.getResource("/elevatorInTransition.png");
	private static Icon iconElevatorOpen = new ImageIcon(urlElevatorOpen);
	private static Icon iconElevatorClose = new ImageIcon(urlElevatorClose);
	private static Icon iconElevatorInTransition = new ImageIcon(urlElevatorInTransition);

	//Picture for the Up button
	private static URL urlUp = ElevatorPanelControlOutside.class.getResource("/up.png");
	private static URL urlUpGreen = ElevatorPanelControlOutside.class.getResource("/upGreen.png");
	Icon iconUp = new ImageIcon(urlUp);
	Icon iconUpGreen = new ImageIcon(urlUpGreen);

	//Picture for the down button
	private static URL urlDown = ElevatorPanelControlOutside.class.getResource("/down.png");
	private static URL urlDownGreen = ElevatorPanelControlOutside.class.getResource("/downGreen.png");
	Icon iconDown = new ImageIcon(urlDown);
	Icon iconDownGreen = new ImageIcon(urlDownGreen);

	//Picture for the stop button
	private static URL urlStop = ElevatorPanelControlInside.class.getResource("/stop.png");
	private static URL urlStopPressed = ElevatorPanelControlInside.class.getResource("/stopPressed.png");
	Icon iconStop = new ImageIcon(urlStop);
	Icon iconStopPressed = new ImageIcon(urlStopPressed);

	//Picture for the open button
	private static URL urlOpen = ElevatorPanelControlInside.class.getResource("/open.png");
	private static URL urlOpenGreen = ElevatorPanelControlInside.class.getResource("/openGreen.png");
	Icon iconOpen = new ImageIcon(urlOpen);
	Icon iconOpenGreen = new ImageIcon(urlOpenGreen);

	//Picture for the close button
	private static URL urlClose = ElevatorPanelControlInside.class.getResource("/close.png");
	private static URL urlCloseGreen = ElevatorPanelControlInside.class.getResource("/closeGreen.png");
	Icon iconClose = new ImageIcon(urlClose);
	Icon iconCloseGreen = new ImageIcon(urlCloseGreen);

	//Picture for the level 0 button
	private static URL urlLevel0 = ElevatorPanelControlInside.class.getResource("/level0.png");
	private static URL urlLevel0Green = ElevatorPanelControlInside.class.getResource("/level0Green.png");
	Icon iconLevel0 = new ImageIcon(urlLevel0);
	Icon iconLevel0Green = new ImageIcon(urlLevel0Green);

	//Picture for the level 1 button
	private static URL urlLevel1 = ElevatorPanelControlInside.class.getResource("/level1.png");
	private static URL urlLevel1Green = ElevatorPanelControlInside.class.getResource("/level1Green.png");
	Icon iconLevel1 = new ImageIcon(urlLevel1);
	Icon iconLevel1Green = new ImageIcon(urlLevel1Green);

	//Picture for the level 2 button
	private static URL urlLevel2 = ElevatorPanelControlInside.class.getResource("/level2.png");
	private static URL urlLevel2Green = ElevatorPanelControlInside.class.getResource("/level2Green.png");
	Icon iconLevel2 = new ImageIcon(urlLevel2);
	Icon iconLevel2Green = new ImageIcon(urlLevel2Green);

	//Picture for the level 3 button
	private static URL urlLevel3 = ElevatorPanelControlInside.class.getResource("/level3.png");
	private static URL urlLevel3Green = ElevatorPanelControlInside.class.getResource("/level3Green.png");
	Icon iconLevel3 = new ImageIcon(urlLevel3);
	Icon iconLevel3Green = new ImageIcon(urlLevel3Green);

	//Picture for the digit 0
	private static URL urlDigit0 = ElevatorPanelControlOutside.class.getResource("/digit0.png");
	private static URL urlDigit0Green = ElevatorPanelControlOutside.class.getResource("/digit0Green.png");
	Icon iconDigit0 = new ImageIcon(urlDigit0);
	Icon iconDigit0Green = new ImageIcon(urlDigit0Green);

	//Picture for the digit 1
	private static URL urlDigit1 = ElevatorPanelControlOutside.class.getResource("/digit1.png");
	private static URL urlDigit1Green = ElevatorPanelControlOutside.class.getResource("/digit1Green.png");
	Icon iconDigit1 = new ImageIcon(urlDigit1);
	Icon iconDigit1Green = new ImageIcon(urlDigit1Green);

	//Picture for the digit 2
	private static URL urlDigit2 = ElevatorPanelControlOutside.class.getResource("/digit2.png");
	private static URL urlDigit2Green = ElevatorPanelControlOutside.class.getResource("/digit2Green.png");
	Icon iconDigit2 = new ImageIcon(urlDigit2);
	Icon iconDigit2Green = new ImageIcon(urlDigit2Green);

	//Picture for the digit 3
	private static URL urlDigit3 = ElevatorPanelControlOutside.class.getResource("/digit3.png");
	private static URL urlDigit3Green = ElevatorPanelControlOutside.class.getResource("/digit3Green.png");
	Icon iconDigit3 = new ImageIcon(urlDigit3);
	Icon iconDigit3Green = new ImageIcon(urlDigit3Green);

	//Picture for the digit 4
	private static URL urlDigit4 = ElevatorPanelControlOutside.class.getResource("/digit4.png");
	private static URL urlDigit4Green = ElevatorPanelControlOutside.class.getResource("/digit4Green.png");
	Icon iconDigit4 = new ImageIcon(urlDigit4);
	Icon iconDigit4Green = new ImageIcon(urlDigit4Green);

	//Picture for the digit 5
	private static URL urlDigit5 = ElevatorPanelControlOutside.class.getResource("/digit5.png");
	private static URL urlDigit5Green = ElevatorPanelControlOutside.class.getResource("/digit5Green.png");
	Icon iconDigit5 = new ImageIcon(urlDigit5);
	Icon iconDigit5Green = new ImageIcon(urlDigit5Green);

	//Picture for the digit 6
	private static URL urlDigit6 = ElevatorPanelControlOutside.class.getResource("/digit6.png");
	private static URL urlDigit6Green = ElevatorPanelControlOutside.class.getResource("/digit6Green.png");
	Icon iconDigit6 = new ImageIcon(urlDigit6);
	Icon iconDigit6Green = new ImageIcon(urlDigit6Green);

	//Picture for the digit 7
	private static URL urlDigit7 = ElevatorPanelControlOutside.class.getResource("/digit7.png");
	private static URL urlDigit7Green = ElevatorPanelControlOutside.class.getResource("/digit7Green.png");
	Icon iconDigit7 = new ImageIcon(urlDigit7);
	Icon iconDigit7Green = new ImageIcon(urlDigit7Green);

	//Picture for the digit 8
	private static URL urlDigit8 = ElevatorPanelControlOutside.class.getResource("/digit8.png");
	private static URL urlDigit8Green = ElevatorPanelControlOutside.class.getResource("/digit8Green.png");
	Icon iconDigit8 = new ImageIcon(urlDigit8);
	Icon iconDigit8Green = new ImageIcon(urlDigit8Green);

	//Picture for the digit 9
	private static URL urlDigit9 = ElevatorPanelControlOutside.class.getResource("/digit9.png");
	private static URL urlDigit9Green = ElevatorPanelControlOutside.class.getResource("/digit9Green.png");
	Icon iconDigit9 = new ImageIcon(urlDigit9);
	Icon iconDigit9Green = new ImageIcon(urlDigit9Green);

	//Picture for the cancel button
	private static URL urlCross = ElevatorPanelControlOutside.class.getResource("/cross.png");
	private static URL urlCrossPressed = ElevatorPanelControlOutside.class.getResource("/crossPressed.png");
	Icon iconCross = new ImageIcon(urlCross);
	Icon iconCrossPressed = new ImageIcon(urlCrossPressed);

	//Picture for the validate button
	private static URL urlCheck = ElevatorPanelControlOutside.class.getResource("/check.png");
	private static URL urlCheckPressed = ElevatorPanelControlOutside.class.getResource("/checkPressed.png");
	Icon iconCheck = new ImageIcon(urlCheck);
	Icon iconCheckPressed = new ImageIcon(urlCheckPressed);

	//Picture for the User/Supervisor mode
	private static URL urlUser = ElevatorPanelControlOutside.class.getResource("/user.png");
	private static URL urlSupervisor = ElevatorPanelControlOutside.class.getResource("/supervisor.png");
	Icon iconUser = new ImageIcon(urlUser);
	Icon iconSupervisor = new ImageIcon(urlSupervisor);

	//Picture for the led for the supervisor button
	private static URL urlledOff = ElevatorPanelControlOutside.class.getResource("/ledOff.png");
	private static URL urlledGreen = ElevatorPanelControlOutside.class.getResource("/ledGreen.png");
	private static URL urlledRed = ElevatorPanelControlOutside.class.getResource("/ledRed.png");
	Icon iconLedOff = new ImageIcon(urlledOff);
	Icon iconLedGreen = new ImageIcon(urlledGreen);
	Icon iconLedRed = new ImageIcon(urlledRed);

	/**
	 * Create the application.
	 */
	public ElevatorView(Elevator elevator, MqttPublisher mqttPublisher) {
		initialize();
		this.mqttPublisher = mqttPublisher;
		this.password = new Password();
		this.password.setListener(new Password.PasswordListener() {
			@Override
			public void passwordIsCorrect() {
				panelCodeAccessSupervisor.setVisible(false);
				supervisor = true;
				panelSupervisor.setVisible(supervisor);
			}

			@Override
			public void changed() {
				lblPassword.setText(password.getPass());
			}
		});
		this.elevator = elevator;
		/**
		 * Create the listener of the elevator which allow us to update the view
		 */
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
		frame.setBounds(100, 100, 540, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/**
		 * Panel to display the elevator
		 */
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

		lblFloorIndicator = new JLabel(iconFloorIndicator);
		lblFloorIndicator.setBounds(0, 0, 10, 543);
		panelFloor.add(lblFloorIndicator);

		//Button to call the elevator to go up at the level 0
		btnUp = new JButton(iconUp);
		btnUp.setBounds(150, 512, 50, 50);
		btnUp.setFocusPainted(false);
		btnUp.setFocusable(false);
		btnUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserRequest request = new UserRequest("TravReq", "Elevator Panel", "move to level 0");
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

		//Button to call the elevator to go up at the level 1
		btnUp_1 = new JButton(iconUp);
		btnUp_1.setBounds(150, 347, 50, 50);
		btnUp_1.setFocusPainted(false);
		btnUp_1.setFocusable(false);
		btnUp_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserRequest request = new UserRequest("TravReq", "Elevator Panel", "move to level 0");
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

		//Button to call the elevator to go down at the level 1
		btnDown_1 = new JButton(iconDown);
		btnDown_1.setBounds(150, 408, 50, 50);
		btnDown_1.setFocusPainted(false);
		btnDown_1.setFocusable(false);
		btnDown_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserRequest request = new UserRequest("TravReq", "Elevator Panel", "move to level 1");
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

		//Button to call the elevator to go up at the level 2
		btnUp_2 = new JButton(iconUp);
		btnUp_2.setBounds(150, 212, 50, 50);
		btnUp_2.setFocusPainted(false);
		btnUp_2.setFocusable(false);
		btnUp_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserRequest request = new UserRequest("TravReq", "Elevator Panel", "move to level 0");
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

		//Button to call the elevator to go down at the level 2
		btnDown_2 = new JButton(iconDown);
		btnDown_2.setBounds(150, 273, 50, 50);
		btnDown_2.setFocusPainted(false);
		btnDown_2.setFocusable(false);
		btnDown_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserRequest request = new UserRequest("TravReq", "Elevator Panel", "move to level 0");
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

		//Button to call the elevator to go down at the level 3
		btnDown_3 = new JButton(iconDown);
		btnDown_3.setBounds(150, 108, 50, 50);
		btnDown_3.setFocusPainted(false);
		btnDown_3.setFocusable(false);
		btnDown_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserRequest request = new UserRequest("TravReq", "Elevator Panel", "move to level 0");
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

		//Label to indicate the position of the elevator
		JLabel lblElevatorIndicator = new JLabel("New label");
		lblElevatorIndicator.setBounds(10, 10, 190, 40);
		frame.getContentPane().add(lblElevatorIndicator);

		/**
		JPanel for the button inside the elevator available for the user
		 */
		JPanel panel = new JPanel();
		panel.setBounds(230, 250, 110, 230);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		//Button to go at the level 0 from inside the elevator
		btnLevel0 = new JButton(iconLevel0);
		btnLevel0.setBounds(0, 0, 50, 50);
		panel.add(btnLevel0);
		btnLevel0.setFocusPainted(false);
		btnLevel0.setFocusable(false);
		btnLevel0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserRequest request = new UserRequest("TravReq", "Elevator Panel", "1REQ");
				RequestBackLevel requestBackLevel = new RequestBackLevel("CurrentLevel", "Elevator", "0", "yo");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
					mqttPublisher.sendMessage(requestBackLevel.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//Button to go at the level 1 from inside the elevator
		btnLevel1 = new JButton(iconLevel1);
		btnLevel1.setBounds(60, 0, 50, 50);
		panel.add(btnLevel1);
		btnLevel1.setFocusable(false);
		btnLevel1.setFocusPainted(false);
		btnLevel1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserRequest request = new UserRequest("TravReq", "Elevator Panel", "move to level 1");
				RequestBackLevel requestBackLevel = new RequestBackLevel("CurrentLevel", "Elevator", "1", "yo");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
					mqttPublisher.sendMessage(requestBackLevel.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//Button to go at the level 2 from inside the elevator
		btnLevel2 = new JButton(iconLevel2);
		btnLevel2.setBounds(0, 60, 50, 50);
		panel.add(btnLevel2);
		btnLevel2.setFocusPainted(false);
		btnLevel2.setFocusable(false);
		btnLevel2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserRequest request = new UserRequest("TravReq", "Elevator Panel", "move to level 2");
				RequestBackLevel requestBackLevel = new RequestBackLevel("CurrentLevel", "Elevator", "2", "yo");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
					mqttPublisher.sendMessage(requestBackLevel.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//Button to go at the level 3 from inside the elevator
		btnLevel3 = new JButton(iconLevel3);
		btnLevel3.setBounds(60, 60, 50, 50);
		panel.add(btnLevel3);
		btnLevel3.setFocusable(false);
		btnLevel3.setFocusPainted(false);
		btnLevel3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserRequest request = new UserRequest("TravReq", "Elevator Panel", "move to level 3");
				RequestBackLevel requestBackLevel = new RequestBackLevel("CurrentLevel", "Elevator", "3", "yo");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
					mqttPublisher.sendMessage(requestBackLevel.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//Button to stop the elevator from inside
		btnStop = new JButton(iconStop);
		btnStop.setBounds(30, 120, 50, 50);
		panel.add(btnStop);
		btnStop.setFocusable(false);
		btnStop.setFocusPainted(false);
		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserRequest request = new UserRequest("TravReq", "Elevator Panel", "emergency");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//Button to open the door of the elevator
		btnOpen = new JButton(iconOpen);
		btnOpen.setBounds(0, 180, 50, 50);
		panel.add(btnOpen);
		btnOpen.setFocusable(false);
		btnOpen.setFocusPainted(false);
		btnOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserRequest request = new UserRequest("TravReq", "Elevator Panel", "open door");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//Button to close the door of the elevator
		btnClose = new JButton(iconClose);
		btnClose.setBounds(60, 180, 50, 50);
		panel.add(btnClose);
		btnClose.setFocusable(false);
		btnClose.setFocusPainted(false);
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserRequest request = new UserRequest("TravReq", "Elevator Panel", "close door");
				try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		/**
		 * Supervisor component
		 */
		supervisorOnOff = new JToggleButton(iconUser);
		supervisorOnOff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (supervisorOnOff.isSelected()) {
					//add something to login
					supervisorOnOff.setIcon(iconSupervisor);
					//we display the code to enter the code to use the panel as supervisor
					codeAccessSupervisor = true;

				} else {
					supervisorOnOff.setIcon(iconUser);
					supervisor = false;
					codeAccessSupervisor = false;
				}
				panelSupervisor.setVisible(supervisor);
				panelCodeAccessSupervisor.setVisible(codeAccessSupervisor);
			}
		});
		supervisorOnOff.setBounds(390, 10, 120, 21);
		frame.getContentPane().add(supervisorOnOff);

		/**
		 * Supervisor Code to auth
		 */
		panelCodeAccessSupervisor = new JPanel();
		panelCodeAccessSupervisor.setBounds(390, 31, 120, 180);
		frame.getContentPane().add(panelCodeAccessSupervisor);
		panelCodeAccessSupervisor.setVisible(false);
		panelCodeAccessSupervisor.setLayout(null);

		//Button for the digit 1
		btnDigit1 = new JButton(iconDigit1);
		btnDigit1.setBounds(0, 20, 40, 40);
		btnDigit1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				password.addDigit(1);
				btnDigit1.setIcon(iconDigit1Green);
				int delay = 1000; //milliseconds
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDigit1.setIcon(iconDigit1);
					}
				};
				new Timer(delay, taskPerformer).start();
			}
		});
		panelCodeAccessSupervisor.add(btnDigit1);

		//Button for the digit 2
		btnDigit2 = new JButton(iconDigit2);
		btnDigit2.setBounds(40, 20, 40, 40);
		btnDigit2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				password.addDigit(2);
				btnDigit2.setIcon(iconDigit2Green);
				int delay = 1000; //milliseconds
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDigit2.setIcon(iconDigit2);
					}
				};
				new Timer(delay, taskPerformer).start();
			}
		});
		panelCodeAccessSupervisor.add(btnDigit2);

		//Button for the digit 3
		btnDigit3 = new JButton(iconDigit3);
		btnDigit3.setBounds(80, 20, 40, 40);
		btnDigit3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				password.addDigit(3);
				btnDigit3.setIcon(iconDigit3Green);
				int delay = 1000; //milliseconds
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDigit3.setIcon(iconDigit3);
					}
				};
				new Timer(delay, taskPerformer).start();
			}
		});
		panelCodeAccessSupervisor.add(btnDigit3);

		//Button for the digit 4
		btnDigit4 = new JButton(iconDigit4);
		btnDigit4.setBounds(0, 60, 40, 40);
		btnDigit4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				password.addDigit(4);
				btnDigit4.setIcon(iconDigit4Green);
				int delay = 1000; //milliseconds
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDigit4.setIcon(iconDigit4);
					}
				};
				new Timer(delay, taskPerformer).start();
			}
		});
		panelCodeAccessSupervisor.add(btnDigit4);

		//Button for the digit 5
		btnDigit5 = new JButton(iconDigit5);
		btnDigit5.setBounds(40, 60, 40, 40);
		btnDigit5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				password.addDigit(5);
				btnDigit5.setIcon(iconDigit5Green);
				int delay = 1000; //milliseconds
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDigit5.setIcon(iconDigit5);
					}
				};
				new Timer(delay, taskPerformer).start();
			}
		});
		panelCodeAccessSupervisor.add(btnDigit5);

		//Button for the digit 6
		btnDigit6 = new JButton(iconDigit6);
		btnDigit6.setBounds(80, 60, 40, 40);
		btnDigit6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				password.addDigit(6);
				btnDigit6.setIcon(iconDigit6Green);
				int delay = 1000; //milliseconds
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDigit6.setIcon(iconDigit6);
					}
				};
				new Timer(delay, taskPerformer).start();
			}
		});
		panelCodeAccessSupervisor.add(btnDigit6);

		//Button for the digit 7
		btnDigit7 = new JButton(iconDigit7);
		btnDigit7.setBounds(0, 100, 40, 40);
		btnDigit7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				password.addDigit(7);
				btnDigit7.setIcon(iconDigit7Green);
				int delay = 1000; //milliseconds
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDigit7.setIcon(iconDigit7);
					}
				};
				new Timer(delay, taskPerformer).start();
			}
		});
		panelCodeAccessSupervisor.add(btnDigit7);

		//Button for the digit 8
		btnDigit8 = new JButton(iconDigit8);
		btnDigit8.setBounds(40, 100, 40, 40);
		btnDigit8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				password.addDigit(8);
				btnDigit8.setIcon(iconDigit8Green);
				int delay = 1000; //milliseconds
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDigit8.setIcon(iconDigit8);
					}
				};
				new Timer(delay, taskPerformer).start();
			}
		});
		panelCodeAccessSupervisor.add(btnDigit8);

		//Button for the digit 9
		btnDigit9 = new JButton(iconDigit9);
		btnDigit9.setBounds(80, 100, 40, 40);
		btnDigit9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				password.addDigit(9);
				btnDigit9.setIcon(iconDigit9Green);
				int delay = 1000; //milliseconds
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDigit9.setIcon(iconDigit9);
					}
				};
				new Timer(delay, taskPerformer).start();
			}
		});
		panelCodeAccessSupervisor.add(btnDigit9);

		//Button to validate the password
		btnValidate = new JButton(iconCheck);
		btnValidate.setBounds(0, 140, 40, 40);
		btnValidate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				password.isPassCorrect();
				btnValidate.setIcon(iconCheckPressed);
				int delay = 1000; //milliseconds
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnValidate.setIcon(iconCheck);
					}
				};
				new Timer(delay, taskPerformer).start();
			}
		});
		panelCodeAccessSupervisor.add(btnValidate);

		//Button for the digit 0
		btnDigit0 = new JButton(iconDigit0);
		btnDigit0.setBounds(40, 140, 40, 40);
		btnDigit0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				password.addDigit(0);
				btnDigit0.setIcon(iconDigit0Green);
				int delay = 1000; //milliseconds
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnDigit0.setIcon(iconDigit0);
					}
				};
				new Timer(delay, taskPerformer).start();
			}
		});
		panelCodeAccessSupervisor.add(btnDigit0);

		//Button to remove the last digit
		btnCancel = new JButton(iconCross);
		btnCancel.setBounds(80, 140, 40, 40);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				password.removeLastDigit();
				btnCancel.setIcon(iconCrossPressed);
				int delay = 1000; //milliseconds
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnCancel.setIcon(iconCross);
					}
				};
				new Timer(delay, taskPerformer).start();
			}
		});
		panelCodeAccessSupervisor.add(btnCancel);

		lblPassword = new JLabel("Tap the password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setToolTipText("");
		lblPassword.setBounds(0, 0, 120, 20);
		panelCodeAccessSupervisor.add(lblPassword);

		panelSupervisor = new JPanel();
		panelSupervisor.setBounds(360, 40, 182, 379);
		frame.getContentPane().add(panelSupervisor);
		panelSupervisor.setVisible(false);
		panelSupervisor.setLayout(null);

		//Button for POreset
		btnPOreset = new JButton(iconLedOff);
		btnPOreset.setBounds(112, 0, 40, 40);
		btnPOreset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SupervisorRequest supervisorRequest = new SupervisorRequest("SupPanelReq", "Panel", "manual", "POreset", true);
				try {
					System.out.println(supervisorRequest.toJSON());
					mqttPublisher.sendMessage(supervisorRequest.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelSupervisor.add(btnPOreset);

		lblPOreset = new JLabel("POreset");
		lblPOreset.setBounds(10, 10, 92, 13);
		panelSupervisor.add(lblPOreset);

		//Button for POdv2
		btnPOdv2 = new JButton(iconLedOff);
		btnPOdv2.setBounds(112, 44, 40, 40);
		btnPOdv2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SupervisorRequest supervisorRequest = new SupervisorRequest("SupPanelReq", "Panel", "manual", "POdv2", true);
				try {
					System.out.println(supervisorRequest.toJSON());
					mqttPublisher.sendMessage(supervisorRequest.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelSupervisor.add(btnPOdv2);

		lblPOdv2 = new JLabel("POdv2");
		lblPOdv2.setBounds(10, 54, 92, 13);
		panelSupervisor.add(lblPOdv2);

		//Button for POdv1
		btnPOdv1 = new JButton(iconLedOff);
		btnPOdv1.setBounds(112, 90, 40, 40);
		btnPOdv1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SupervisorRequest supervisorRequest = new SupervisorRequest("SupPanelReq", "Panel", "manual", "POdv1", true);
				try {
					System.out.println(supervisorRequest.toJSON());
					mqttPublisher.sendMessage(supervisorRequest.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelSupervisor.add(btnPOdv1);

		lblPOdv1 = new JLabel("POdv1");
		lblPOdv1.setBounds(10, 100, 92, 13);
		panelSupervisor.add(lblPOdv1);

		//Button for POuv1
		btnPOuv1 = new JButton(iconLedOff);
		btnPOuv1.setBounds(112, 137, 40, 40);
		btnPOuv1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SupervisorRequest supervisorRequest = new SupervisorRequest("SupPanelReq", "Panel", "manual", "POuv1", true);
				try {
					System.out.println(supervisorRequest.toJSON());
					mqttPublisher.sendMessage(supervisorRequest.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelSupervisor.add(btnPOuv1);

		lblPOuv1 = new JLabel("POuv1");
		lblPOuv1.setBounds(10, 147, 92, 13);
		panelSupervisor.add(lblPOuv1);

		//Button for POuv2
		btnPOuv2 = new JButton(iconLedOff);
		btnPOuv2.setBounds(112, 180, 40, 40);
		btnPOuv2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SupervisorRequest supervisorRequest = new SupervisorRequest("SupPanelReq", "Panel", "manual", "POuv2", true);
				try {
					System.out.println(supervisorRequest.toJSON());
					mqttPublisher.sendMessage(supervisorRequest.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelSupervisor.add(btnPOuv2);

		lblPOuv2 = new JLabel("POuv2");
		lblPOuv2.setBounds(10, 190, 92, 13);
		panelSupervisor.add(lblPOuv2);

		//Button for POdclose
		btnPOdclose = new JButton(iconLedOff);
		btnPOdclose.setBounds(112, 224, 40, 40);
		btnPOdclose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SupervisorRequest supervisorRequest = new SupervisorRequest("SupPanelReq", "Panel", "manual", "POdclose", true);
				try {
					System.out.println(supervisorRequest.toJSON());
					mqttPublisher.sendMessage(supervisorRequest.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelSupervisor.add(btnPOdclose);

		lblPOdclose = new JLabel("POdclose");
		lblPOdclose.setBounds(10, 234, 92, 13);
		panelSupervisor.add(lblPOdclose);

		//Button for POdopen
		btnPOdopen = new JButton(iconLedOff);
		btnPOdopen.setBounds(112, 274, 40, 40);
		btnPOdopen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SupervisorRequest supervisorRequest = new SupervisorRequest("SupPanelReq", "Panel", "manual", "POdopen", true);
				try {
					System.out.println(supervisorRequest.toJSON());
					mqttPublisher.sendMessage(supervisorRequest.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelSupervisor.add(btnPOdopen);

		lblPOdopen = new JLabel("POdopen");
		lblPOdopen.setBounds(10, 284, 92, 13);
		panelSupervisor.add(lblPOdopen);
	}
}

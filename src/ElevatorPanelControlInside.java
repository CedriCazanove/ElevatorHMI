import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ElevatorPanelControlInside {

	private JFrame frame;

	private Elevator elevatorInside;

	private static MqttPublisher mqttPublisher;

	private Boolean codeAccessSupervisor = false, supervisor = false;

	private JButton btnLevel0, btnLevel1, btnLevel2, btnLevel3, btnStop, btnOpen, btnClose;

	private static URL urlStop = ElevatorPanelControlInside.class.getResource("/stop.png");
	private static URL urlStopPressed = ElevatorPanelControlInside.class.getResource("/stopPressed.png");
	Icon iconStop = new ImageIcon(urlStop);
	Icon iconStopPressed = new ImageIcon(urlStopPressed);

	private static URL urlOpen = ElevatorPanelControlInside.class.getResource("/open.png");
	private static URL urlOpenGreen = ElevatorPanelControlInside.class.getResource("/openGreen.png");
	Icon iconOpen = new ImageIcon(urlOpen);
	Icon iconOpenGreen = new ImageIcon(urlOpenGreen);

	private static URL urlClose = ElevatorPanelControlInside.class.getResource("/close.png");
	private static URL urlCloseGreen = ElevatorPanelControlInside.class.getResource("/closeGreen.png");
	Icon iconClose = new ImageIcon(urlClose);
	Icon iconCloseGreen = new ImageIcon(urlCloseGreen);

	private static URL urlLevel0 = ElevatorPanelControlInside.class.getResource("/level0.png");
	private static URL urlLevel0Green = ElevatorPanelControlInside.class.getResource("/level0Green.png");
	Icon iconLevel0 = new ImageIcon(urlLevel0);
	Icon iconLevel0Green = new ImageIcon(urlLevel0Green);

	private static URL urlLevel1 = ElevatorPanelControlInside.class.getResource("/level1.png");
	private static URL urlLevel1Green = ElevatorPanelControlInside.class.getResource("/level1Green.png");
	Icon iconLevel1 = new ImageIcon(urlLevel1);
	Icon iconLevel1Green = new ImageIcon(urlLevel1Green);

	private static URL urlLevel2 = ElevatorPanelControlInside.class.getResource("/level2.png");
	private static URL urlLevel2Green = ElevatorPanelControlInside.class.getResource("/level2Green.png");
	Icon iconLevel2 = new ImageIcon(urlLevel2);
	Icon iconLevel2Green = new ImageIcon(urlLevel2Green);

	private static URL urlLevel3 = ElevatorPanelControlInside.class.getResource("/level3.png");
	private static URL urlLevel3Green = ElevatorPanelControlInside.class.getResource("/level3Green.png");
	Icon iconLevel3 = new ImageIcon(urlLevel3);
	Icon iconLevel3Green = new ImageIcon(urlLevel3Green);

	private static URL urlDigit0 = ElevatorPanelControlOutside.class.getResource("/digit0.png");
	private static URL urlDigit0Green = ElevatorPanelControlOutside.class.getResource("/digit0Green.png");
	Icon iconDigit0 = new ImageIcon(urlDigit0);
	Icon iconDigit0Green = new ImageIcon(urlDigit0Green);

	private static URL urlDigit1 = ElevatorPanelControlOutside.class.getResource("/digit1.png");
	private static URL urlDigit1Green = ElevatorPanelControlOutside.class.getResource("/digit1Green.png");
	Icon iconDigit1 = new ImageIcon(urlDigit1);
	Icon iconDigit1Green = new ImageIcon(urlDigit1Green);

	private static URL urlDigit2 = ElevatorPanelControlOutside.class.getResource("/digit2.png");
	private static URL urlDigit2Green = ElevatorPanelControlOutside.class.getResource("/digit2Green.png");
	Icon iconDigit2 = new ImageIcon(urlDigit2);
	Icon iconDigit2Green = new ImageIcon(urlDigit2Green);

	private static URL urlDigit3 = ElevatorPanelControlOutside.class.getResource("/digit3.png");
	private static URL urlDigit3Green = ElevatorPanelControlOutside.class.getResource("/digit3Green.png");
	Icon iconDigit3 = new ImageIcon(urlDigit3);
	Icon iconDigit3Green = new ImageIcon(urlDigit3Green);

	private static URL urlDigit4 = ElevatorPanelControlOutside.class.getResource("/digit4.png");
	private static URL urlDigit4Green = ElevatorPanelControlOutside.class.getResource("/digit4Green.png");
	Icon iconDigit4 = new ImageIcon(urlDigit4);
	Icon iconDigit4Green = new ImageIcon(urlDigit4Green);

	private static URL urlDigit5 = ElevatorPanelControlOutside.class.getResource("/digit5.png");
	private static URL urlDigit5Green = ElevatorPanelControlOutside.class.getResource("/digit5Green.png");
	Icon iconDigit5 = new ImageIcon(urlDigit5);
	Icon iconDigit5Green = new ImageIcon(urlDigit5Green);

	private static URL urlDigit6 = ElevatorPanelControlOutside.class.getResource("/digit6.png");
	private static URL urlDigit6Green = ElevatorPanelControlOutside.class.getResource("/digit6Green.png");
	Icon iconDigit6 = new ImageIcon(urlDigit6);
	Icon iconDigit6Green = new ImageIcon(urlDigit6Green);

	private static URL urlDigit7 = ElevatorPanelControlOutside.class.getResource("/digit7.png");
	private static URL urlDigit7Green = ElevatorPanelControlOutside.class.getResource("/digit7Green.png");
	Icon iconDigit7 = new ImageIcon(urlDigit7);
	Icon iconDigit7Green = new ImageIcon(urlDigit7Green);

	private static URL urlDigit8 = ElevatorPanelControlOutside.class.getResource("/digit8.png");
	private static URL urlDigit8Green = ElevatorPanelControlOutside.class.getResource("/digit8Green.png");
	Icon iconDigit8 = new ImageIcon(urlDigit8);
	Icon iconDigit8Green = new ImageIcon(urlDigit8Green);

	private static URL urlDigit9 = ElevatorPanelControlOutside.class.getResource("/digit9.png");
	private static URL urlDigit9Green = ElevatorPanelControlOutside.class.getResource("/digit9Green.png");
	Icon iconDigit9 = new ImageIcon(urlDigit9);
	Icon iconDigit9Green = new ImageIcon(urlDigit9Green);

	private static URL urlCross = ElevatorPanelControlOutside.class.getResource("/cross.png");
	private static URL urlCrossPressed = ElevatorPanelControlOutside.class.getResource("/crossPressed.png");
	Icon iconCross = new ImageIcon(urlCross);
	Icon iconCrossPressed = new ImageIcon(urlCrossPressed);

	private static URL urlCheck = ElevatorPanelControlOutside.class.getResource("/check.png");
	private static URL urlCheckPressed = ElevatorPanelControlOutside.class.getResource("/checkPressed.png");
	Icon iconCheck = new ImageIcon(urlCheck);
	Icon iconCheckPressed = new ImageIcon(urlCheckPressed);

	private static URL urlUser = ElevatorPanelControlOutside.class.getResource("/user.png");
	private static URL urlSupervisor = ElevatorPanelControlOutside.class.getResource("/supervisor.png");
	Icon iconUser = new ImageIcon(urlUser);
	Icon iconSupervisor = new ImageIcon(urlSupervisor);

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElevatorPanelControlInside window = new ElevatorPanelControlInside();
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
	public ElevatorPanelControlInside(MqttPublisher mqttPublisher, Elevator elevator) {
		initialize();
		this.mqttPublisher = mqttPublisher;
		this.elevatorInside = elevator;
		this.elevatorInside.addNewElevatorListener(new Elevator.ElevatorListener() {
			private Elevator elevatorView = elevator;

			@Override
			public void doorStateChanged() {

			}

			@Override
			public void currentLevelChanged() {
				int currentLevel = elevatorView.getCurrentLevel();
				if (currentLevel == 0) {
					btnLevel0.setIcon(iconLevel0Green);
				} else if (currentLevel == 1) {
					btnLevel1.setIcon(iconLevel1Green);
				} else if (currentLevel == 2) {
					btnLevel2.setIcon(iconLevel2Green);
				} else if (currentLevel == 3) {
					btnLevel3.setIcon(iconLevel3Green);
				}
				System.out.println("Message BIEN RECU");
				/*int delay = 1000; //milliseconds
				ActionListener taskPerformer = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						btnLevel1.setIcon(iconLevel1);
					}
				};
				new Timer(delay, taskPerformer).start();*/
			}

			@Override
			public void elevatorStateChanged() {

			}

			@Override
			public void directionChanged() {

			}

			@Override
			public void req1Changed() {

			}

			@Override
			public void up1Changed() {

			}

			@Override
			public void req2Changed() {

			}

			@Override
			public void up2Changed() {

			}

			@Override
			public void down2Changed() {

			}

			@Override
			public void req3Changed() {

			}

			@Override
			public void up3Changed() {

			}

			@Override
			public void down3Changed() {

			}

			@Override
			public void req4Changed() {

			}

			@Override
			public void down4Changed() {

			}

			@Override
			public void openChanged() {

			}

			@Override
			public void closeChanged() {

			}

			@Override
			public void emergencyChanged() {

			}

			@Override
			public void poresetChanged() {

			}

			@Override
			public void podv2Changed() {

			}

			@Override
			public void podv1Changed() {

			}

			@Override
			public void pouv1Changed() {

			}

			@Override
			public void pouv2Changed() {

			}

			@Override
			public void podcloseChanged() {

			}

			@Override
			public void podopenChanged() {

			}

			@Override
			public void povcrawlselectChanged() {

			}

			@Override
			public void pis_l1slChanged() {

			}

			@Override
			public void pis_l1rChanged() {

			}

			@Override
			public void pis_l1suChanged() {

			}

			@Override
			public void pis_l1auChanged() {

			}

			@Override
			public void pis_l2slChanged() {

			}

			@Override
			public void pis_l2rChanged() {

			}

			@Override
			public void pis_l2suChanged() {

			}

			@Override
			public void pis_l2auChanged() {

			}

			@Override
			public void pis_l3slChanged() {

			}

			@Override
			public void pis_l3rChanged() {

			}

			@Override
			public void pis_l3suChanged() {

			}

			@Override
			public void pis_l3auChanged() {

			}

			@Override
			public void pis_l4slChanged() {

			}

			@Override
			public void pis_l4rChanged() {

			}

			@Override
			public void pis_l1alChanged() {

			}

			@Override
			public void pis_l2alChanged() {

			}

			@Override
			public void pis_l3alChanged() {

			}

			@Override
			public void pis_l4alChanged() {

			}

			@Override
			public void pis_l4suChanged() {

			}

			@Override
			public void pis_l4auChanged() {

			}

			@Override
			public void pis_dopenedChanged() {

			}

			@Override
			public void pis_dclosedChanged() {

			}

			@Override
			public void pim_readyChanged() {

			}

			@Override
			public void pim_onChanged() {

			}

			@Override
			public void pim_errorChanged() {

			}

			@Override
			public void pis_vChanged() {

			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Inside");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 250, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				mqttPublisher.stopConnection();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

		});

		JPanel panel = new JPanel();
		panel.setBounds(60, 80, 110, 230);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

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
	}
}

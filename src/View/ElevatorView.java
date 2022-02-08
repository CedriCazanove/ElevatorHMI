package View;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Hashtable;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Controller.ActionListener.*;
import Controller.ListenerBehaviour.ElevatorViewAnswerElevatorListener;
import Controller.ListenerBehaviour.ElevatorViewAnswerPasswordListener;
import Model.Elevator;
import Model.Password;
import Controller.Mqtt.MqttPublisher;

public class ElevatorView {

	private JFrame frame;

	private Elevator elevator;

	private static MqttPublisher mqttPublisher;

	private static JLabel labelElevator;

	private JLabel lblFloorIndicator, lblElevatorIndicator;

	private JButton btnUp, btnUp_1, btnDown_1, btnUp_2, btnDown_2, btnDown_3;

	private JButton btnLevel0, btnLevel1, btnLevel2, btnLevel3, btnStop, btnOpen, btnClose;

	private JButton btnDigit1, btnDigit2, btnDigit3, btnDigit4, btnDigit5, btnDigit6, btnDigit7, btnDigit8, btnDigit9, btnDigit0, btnValidate, btnCancel;

	private JButton btnPOreset, btnPOdv2, btnPOdv1, btnPOdclose, btnPOdopen, btnPOuv2, btnPOuv1;

	private JToggleButton supervisorOnOff;

	private Password password;

	private Boolean codeAccessSupervisor = false, supervisor = false;

	private JPanel panelCodeAccessSupervisor, panelSupervisor;

	private JLabel lblPassword, lblPOreset, lblPOdv2, lblPOdv1, lblPOuv1, lblPOuv2, lblPOdclose, lblPOdopen, lblPOv_crawlSelect, lblPOv_crawlValue;

	private JSlider sliderPOv_crawlSelect;

	Border emptyBorder = BorderFactory.createEmptyBorder();

	private Ressource rsc = new Ressource();

	/**
	 * Create the application.
	 */
	public ElevatorView(Elevator elevator, MqttPublisher mqttPublisher) {
		this.mqttPublisher = mqttPublisher;
		this.password = new Password();
		this.password.addNewPasswordListener(new ElevatorViewAnswerPasswordListener(this, password));
		initialize(mqttPublisher, password);
		this.elevator = elevator;
		/**
		 * Create the listener of the elevator which allow us to update the view
		 */
		this.elevator.addNewElevatorListener(new ElevatorViewAnswerElevatorListener(this, elevator));

		/**
		 * Can only display the window when we have at least received the state once
		 */
		java.util.Timer timer = new java.util.Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				new SendServPReq(mqttPublisher).actionPerformed(null);
				System.out.println("Waiting for the state of the elevator..");
			}
		};
		timer.schedule(timerTask, 0, 5000);//period is in ms (every 5sec we ask)
/*
		while(!elevator.getPIm_ready()) {
		}
		timer.cancel();
*/
		this.frame.setVisible(true);

		/**
		 * Asking for all the state every 1min
		 */
		timerTask = new TimerTask() {
			@Override
			public void run() {
				new SendServPReq(mqttPublisher).actionPerformed(null);
			}
		};
		timer.schedule(timerTask, 0, 60000);//period is in ms (every 1min we ask)
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MqttPublisher mqttPublisher, Password password) {
		frame = new JFrame("Elevator");
		frame.setResizable(false);
		frame.setBounds(100, 100, 540, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage((Image) ((ImageIcon) rsc.getIconElevatorClose()).getImage());
		frame.getContentPane().setLayout(null);

		/**
		 * Panel as a fond of the software
		 */
		JPanel panelFont = new JPanel();
		panelFont.setBounds(0,0, 540, 660);
		panelFont.setLayout(null);
		panelFont.setBackground(Color.white);
		frame.add(panelFont);

		/**
		 * Panel to display the elevator
		 */
		JPanel panelElevator = new JPanel();
		panelElevator.setBounds(30, 63, 100, 543);
		panelFont.add(panelElevator);
		panelElevator.setBackground(Color.white);
		panelElevator.setLayout(null);

		labelElevator = new JLabel(rsc.getIconElevatorClose());
		labelElevator.setBounds(0, 408, 100, 135);
		panelElevator.add(labelElevator);

		JPanel panelFloor = new JPanel();
		panelFloor.setBounds(10, 63, 10, 543);
		panelFont.add(panelFloor);
		panelFloor.setLayout(null);

		lblFloorIndicator = new JLabel(rsc.getIconFloorIndicator());
		lblFloorIndicator.setBounds(0, 0, 10, 543);
		panelFloor.add(lblFloorIndicator);

		//Button to call the elevator to go up at the level 0
		btnUp = new JButton(rsc.getIconUp());
		btnUp.setBorder(emptyBorder);
		btnUp.setBounds(150, 512, 50, 50);
		btnUp.setFocusPainted(false);
		btnUp.setFocusable(false);
		btnUp.addActionListener(new SendTravReq(mqttPublisher, "1UP"));
		panelFont.add(btnUp);

		//Button to call the elevator to go up at the level 1
		btnUp_1 = new JButton(rsc.getIconUp());
		btnUp_1.setBorder(emptyBorder);
		btnUp_1.setBounds(150, 347, 50, 50);
		btnUp_1.setFocusPainted(false);
		btnUp_1.setFocusable(false);
		btnUp_1.addActionListener(new SendTravReq(mqttPublisher, "2UP"));
		panelFont.add(btnUp_1);

		//Button to call the elevator to go down at the level 1
		btnDown_1 = new JButton(rsc.getIconDown());
		btnDown_1.setBorder(emptyBorder);
		btnDown_1.setBounds(150, 408, 50, 50);
		btnDown_1.setFocusPainted(false);
		btnDown_1.setFocusable(false);
		btnDown_1.addActionListener(new SendTravReq(mqttPublisher, "2DOWN"));
		panelFont.add(btnDown_1);

		//Button to call the elevator to go up at the level 2
		btnUp_2 = new JButton(rsc.getIconUp());
		btnUp_2.setBorder(emptyBorder);
		btnUp_2.setBounds(150, 212, 50, 50);
		btnUp_2.setFocusPainted(false);
		btnUp_2.setFocusable(false);
		btnUp_2.addActionListener(new SendTravReq(mqttPublisher, "3UP"));
		panelFont.add(btnUp_2);

		//Button to call the elevator to go down at the level 2
		btnDown_2 = new JButton(rsc.getIconDown());
		btnDown_2.setBorder(emptyBorder);
		btnDown_2.setBounds(150, 273, 50, 50);
		btnDown_2.setFocusPainted(false);
		btnDown_2.setFocusable(false);
		btnDown_2.addActionListener(new SendTravReq(mqttPublisher, "3DOWN"));
		panelFont.add(btnDown_2);

		//Button to call the elevator to go down at the level 3
		btnDown_3 = new JButton(rsc.getIconDown());
		btnDown_3.setBorder(emptyBorder);
		btnDown_3.setBounds(150, 108, 50, 50);
		btnDown_3.setFocusPainted(false);
		btnDown_3.setFocusable(false);
		btnDown_3.addActionListener(new SendTravReq(mqttPublisher, "4DOWN"));
		panelFont.add(btnDown_3);

		//Label to indicate the position of the elevator
		lblElevatorIndicator = new JLabel(rsc.getIconElevatorOff());
		lblElevatorIndicator.setBounds(10, 10, 190, 40);
		panelFont.add(lblElevatorIndicator);

		/**
		JPanel for the button inside the elevator available for the user
		 */
		JPanel panel = new JPanel();
		panel.setBounds(230, 250, 110, 230);
		panelFont.add(panel);
		panel.setBackground(Color.white);
		panel.setLayout(null);

		//Button to go at the level 0 from inside the elevator
		btnLevel0 = new JButton(rsc.getIconLevel0());
		btnLevel0.setBorder(emptyBorder);
		btnLevel0.setBounds(0, 0, 50, 50);
		panel.add(btnLevel0);
		btnLevel0.setFocusPainted(false);
		btnLevel0.setFocusable(false);
		btnLevel0.addActionListener(new SendTravReq(mqttPublisher, "1REQ"));

		//Button to go at the level 1 from inside the elevator
		btnLevel1 = new JButton(rsc.getIconLevel1());
		btnLevel1.setBorder(emptyBorder);
		btnLevel1.setBounds(60, 0, 50, 50);
		panel.add(btnLevel1);
		btnLevel1.setFocusable(false);
		btnLevel1.setFocusPainted(false);
		btnLevel1.addActionListener(new SendTravReq(mqttPublisher, "2REQ"));

		//Button to go at the level 2 from inside the elevator
		btnLevel2 = new JButton(rsc.getIconLevel2());
		btnLevel2.setBorder(emptyBorder);
		btnLevel2.setBounds(0, 60, 50, 50);
		panel.add(btnLevel2);
		btnLevel2.setFocusPainted(false);
		btnLevel2.setFocusable(false);
		btnLevel2.addActionListener(new SendTravReq(mqttPublisher, "3REQ"));

		//Button to go at the level 3 from inside the elevator
		btnLevel3 = new JButton(rsc.getIconLevel3());
		btnLevel3.setBorder(emptyBorder);
		btnLevel3.setBounds(60, 60, 50, 50);
		panel.add(btnLevel3);
		btnLevel3.setFocusable(false);
		btnLevel3.setFocusPainted(false);
		btnLevel3.addActionListener(new SendTravReq(mqttPublisher, "4REQ"));

		//Button to stop the elevator from inside
		btnStop = new JButton(rsc.getIconStop());
		btnStop.setBorder(emptyBorder);
		btnStop.setBounds(30, 120, 50, 50);
		panel.add(btnStop);
		btnStop.setFocusable(false);
		btnStop.setFocusPainted(false);
		btnStop.addActionListener(new SendTravReq(mqttPublisher, "STOP"));

		//Button to open the door of the elevator
		btnOpen = new JButton(rsc.getIconOpen());
		btnOpen.setBorder(emptyBorder);
		btnOpen.setBounds(0, 180, 50, 50);
		panel.add(btnOpen);
		btnOpen.setFocusable(false);
		btnOpen.setFocusPainted(false);
		btnOpen.addActionListener(new SendTravReq(mqttPublisher, "OPEN"));

		//Button to close the door of the elevator
		btnClose = new JButton(rsc.getIconClose());
		btnClose.setBorder(emptyBorder);
		btnClose.setBounds(60, 180, 50, 50);
		panel.add(btnClose);
		btnClose.setFocusable(false);
		btnClose.setFocusPainted(false);
		btnClose.addActionListener(new SendTravReq(mqttPublisher, "CLOSE"));

		/**
		 * Supervisor component
		 */
		supervisorOnOff = new JToggleButton(rsc.getIconUser());
		supervisorOnOff.setBorder(emptyBorder);
		supervisorOnOff.addActionListener(new SupervisorOnOffAction(this, mqttPublisher));
		supervisorOnOff.setBounds(390, 10, 120, 21);
		panelFont.add(supervisorOnOff);

		/**
		 * Supervisor Code to auth
		 */
		panelCodeAccessSupervisor = new JPanel();
		panelCodeAccessSupervisor.setBounds(390, 31, 120, 180);
		panelFont.add(panelCodeAccessSupervisor);
		panelCodeAccessSupervisor.setBackground(Color.white);
		panelCodeAccessSupervisor.setVisible(false);
		panelCodeAccessSupervisor.setLayout(null);

		//Button for the digit 1
		btnDigit1 = new JButton(rsc.getIconDigit1());
		btnDigit1.setBorder(emptyBorder);
		btnDigit1.setBounds(0, 20, 40, 40);
		btnDigit1.addActionListener(new WriteIntoPassword(this, password, 1));
		panelCodeAccessSupervisor.add(btnDigit1);

		//Button for the digit 2
		btnDigit2 = new JButton(rsc.getIconDigit2());
		btnDigit2.setBorder(emptyBorder);
		btnDigit2.setBounds(40, 20, 40, 40);
		btnDigit2.addActionListener(new WriteIntoPassword(this, password, 2));
		panelCodeAccessSupervisor.add(btnDigit2);

		//Button for the digit 3
		btnDigit3 = new JButton(rsc.getIconDigit3());
		btnDigit3.setBorder(emptyBorder);
		btnDigit3.setBounds(80, 20, 40, 40);
		btnDigit3.addActionListener(new WriteIntoPassword(this, password, 3));
		panelCodeAccessSupervisor.add(btnDigit3);

		//Button for the digit 4
		btnDigit4 = new JButton(rsc.getIconDigit4());
		btnDigit4.setBorder(emptyBorder);
		btnDigit4.setBounds(0, 60, 40, 40);
		btnDigit4.addActionListener(new WriteIntoPassword(this, password, 4));
		panelCodeAccessSupervisor.add(btnDigit4);

		//Button for the digit 5
		btnDigit5 = new JButton(rsc.getIconDigit5());
		btnDigit5.setBorder(emptyBorder);
		btnDigit5.setBounds(40, 60, 40, 40);
		btnDigit5.addActionListener(new WriteIntoPassword(this, password, 5));
		panelCodeAccessSupervisor.add(btnDigit5);

		//Button for the digit 6
		btnDigit6 = new JButton(rsc.getIconDigit6());
		btnDigit6.setBorder(emptyBorder);
		btnDigit6.setBounds(80, 60, 40, 40);
		btnDigit6.addActionListener(new WriteIntoPassword(this, password, 6));
		panelCodeAccessSupervisor.add(btnDigit6);

		//Button for the digit 7
		btnDigit7 = new JButton(rsc.getIconDigit7());
		btnDigit7.setBorder(emptyBorder);
		btnDigit7.setBounds(0, 100, 40, 40);
		btnDigit7.addActionListener(new WriteIntoPassword(this, password, 7));
		panelCodeAccessSupervisor.add(btnDigit7);

		//Button for the digit 8
		btnDigit8 = new JButton(rsc.getIconDigit8());
		btnDigit8.setBorder(emptyBorder);
		btnDigit8.setBounds(40, 100, 40, 40);
		btnDigit8.addActionListener(new WriteIntoPassword(this, password, 8));
		panelCodeAccessSupervisor.add(btnDigit8);

		//Button for the digit 9
		btnDigit9 = new JButton(rsc.getIconDigit9());
		btnDigit9.setBorder(emptyBorder);
		btnDigit9.setBounds(80, 100, 40, 40);
		btnDigit9.addActionListener(new WriteIntoPassword(this, password, 9));
		panelCodeAccessSupervisor.add(btnDigit9);

		//Button to validate the password
		btnValidate = new JButton(rsc.getIconCheck());
		btnValidate.setBorder(emptyBorder);
		btnValidate.setBounds(0, 140, 40, 40);
		btnValidate.addActionListener(new ValidatePassword(this, password));
		panelCodeAccessSupervisor.add(btnValidate);

		//Button for the digit 0
		btnDigit0 = new JButton(rsc.getIconDigit0());
		btnDigit0.setBorder(emptyBorder);
		btnDigit0.setBounds(40, 140, 40, 40);
		btnDigit0.addActionListener(new WriteIntoPassword(this, password, 0));
		panelCodeAccessSupervisor.add(btnDigit0);

		//Button to remove the last digit
		btnCancel = new JButton(rsc.getIconCross());
		btnCancel.setBorder(emptyBorder);
		btnCancel.setBounds(80, 140, 40, 40);
		btnCancel.addActionListener(new CancelPassword(this, password));
		panelCodeAccessSupervisor.add(btnCancel);

		lblPassword = new JLabel("Tap the password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setToolTipText("");
		lblPassword.setBackground(Color.gray);
		lblPassword.setBounds(0, 0, 120, 20);
		panelCodeAccessSupervisor.add(lblPassword);

		panelSupervisor = new JPanel();
		panelSupervisor.setBounds(360, 40, 182, 500);
		panelFont.add(panelSupervisor);
		panelSupervisor.setBackground(Color.white);
		panelSupervisor.setVisible(false);
		panelSupervisor.setLayout(null);

		//Button for POreset
		btnPOreset = new JButton(rsc.getIconLedOff());
		btnPOreset.setBorder(emptyBorder);
		btnPOreset.setBounds(112, 0, 40, 40);
		btnPOreset.addActionListener(new SendSupPanelReq(mqttPublisher, "manual", "POreset", true));
		panelSupervisor.add(btnPOreset);

		lblPOreset = new JLabel("POreset :");
		lblPOreset.setBounds(10, 10, 92, 13);
		panelSupervisor.add(lblPOreset);

		//Button for POdv2
		btnPOdv2 = new JButton(rsc.getIconLedOff());
		btnPOdv2.setBorder(emptyBorder);
		btnPOdv2.setBounds(112, 44, 40, 40);
		btnPOdv2.addActionListener(new SendSupPanelReq(mqttPublisher, "manual", "POdv2", true));
		panelSupervisor.add(btnPOdv2);

		lblPOdv2 = new JLabel("POdv2 :");
		lblPOdv2.setBounds(10, 54, 92, 13);
		panelSupervisor.add(lblPOdv2);

		//Button for POdv1
		btnPOdv1 = new JButton(rsc.getIconLedOff());
		btnPOdv1.setBorder(emptyBorder);
		btnPOdv1.setBounds(112, 90, 40, 40);
		btnPOdv1.addActionListener(new SendSupPanelReq(mqttPublisher, "manual", "POdv1", true));
		panelSupervisor.add(btnPOdv1);

		lblPOdv1 = new JLabel("POdv1 :");
		lblPOdv1.setBounds(10, 100, 92, 13);
		panelSupervisor.add(lblPOdv1);

		//Button for POuv1
		btnPOuv1 = new JButton(rsc.getIconLedOff());
		btnPOuv1.setBorder(emptyBorder);
		btnPOuv1.setBounds(112, 137, 40, 40);
		btnPOuv1.addActionListener(new SendSupPanelReq(mqttPublisher, "manual", "POuv1", true));
		panelSupervisor.add(btnPOuv1);

		lblPOuv1 = new JLabel("POuv1 :");
		lblPOuv1.setBounds(10, 147, 92, 13);
		panelSupervisor.add(lblPOuv1);

		//Button for POuv2
		btnPOuv2 = new JButton(rsc.getIconLedOff());
		btnPOuv2.setBorder(emptyBorder);
		btnPOuv2.setBounds(112, 180, 40, 40);
		btnPOuv2.addActionListener(new SendSupPanelReq(mqttPublisher, "manual", "POuv2", true));
		panelSupervisor.add(btnPOuv2);

		lblPOuv2 = new JLabel("POuv2 :");
		lblPOuv2.setBounds(10, 190, 92, 13);
		panelSupervisor.add(lblPOuv2);

		//Button for POdclose
		btnPOdclose = new JButton(rsc.getIconLedOff());
		btnPOdclose.setBorder(emptyBorder);
		btnPOdclose.setBounds(112, 224, 40, 40);
		btnPOdclose.addActionListener(new SendSupPanelReq(mqttPublisher, "manual", "POdclose", true));
		panelSupervisor.add(btnPOdclose);

		lblPOdclose = new JLabel("POdclose :");
		lblPOdclose.setBounds(10, 234, 92, 13);
		panelSupervisor.add(lblPOdclose);

		//Button for POdopen
		btnPOdopen = new JButton(rsc.getIconLedOff());
		btnPOdopen.setBorder(emptyBorder);
		btnPOdopen.setBounds(112, 274, 40, 40);
		btnPOdopen.addActionListener(new SendSupPanelReq(mqttPublisher, "manual", "POdopen", true));
		panelSupervisor.add(btnPOdopen);

		lblPOdopen = new JLabel("POdopen :");
		lblPOdopen.setBounds(10, 284, 92, 13);
		panelSupervisor.add(lblPOdopen);

		lblPOv_crawlSelect = new JLabel("POv_crawlSelect :");
		lblPOv_crawlSelect.setBounds(10, 334,110, 13);
		panelSupervisor.add(lblPOv_crawlSelect);

		lblPOv_crawlValue = new JLabel("int");
		lblPOv_crawlValue.setBounds(130, 334,20, 13);
		panelSupervisor.add(lblPOv_crawlValue);

		sliderPOv_crawlSelect = new JSlider(JSlider.HORIZONTAL, -5, 5, 0);
		sliderPOv_crawlSelect.setMajorTickSpacing(1);
		sliderPOv_crawlSelect.setPaintTicks(true);
		sliderPOv_crawlSelect.setMinorTickSpacing(1);
		sliderPOv_crawlSelect.setBounds(5, 354, 150, 60);
		Hashtable labelTable = new Hashtable();
		labelTable.put( -5, new JLabel("-5") );
		labelTable.put( -4, new JLabel("-4") );
		labelTable.put( -3, new JLabel("-3") );
		labelTable.put( -2, new JLabel("-2") );
		labelTable.put( -1, new JLabel("-1") );
		labelTable.put( 0, new JLabel("0") );
		labelTable.put( 1, new JLabel("1") );
		labelTable.put( 2, new JLabel("2") );
		labelTable.put( 3, new JLabel("3") );
		labelTable.put( 4, new JLabel("4") );
		labelTable.put( 5, new JLabel("5") );
		sliderPOv_crawlSelect.setLabelTable(labelTable);
		sliderPOv_crawlSelect.setPaintLabels(true);
		sliderPOv_crawlSelect.setBackground(Color.white);
		sliderPOv_crawlSelect.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				if (!source.getValueIsAdjusting()) {
					int value = (int) source.getValue();
					new SendSupPanelReq(mqttPublisher, "manual", "POv_crawlSelect", value).actionPerformed(null);
				}
			}
		});
		panelSupervisor.add(sliderPOv_crawlSelect);
	}

	public JFrame getFrame() {
		return frame;
	}

	public Elevator getElevator() {
		return elevator;
	}

	public static MqttPublisher getMqttPublisher() {
		return mqttPublisher;
	}

	public static JLabel getLabelElevator() {
		return labelElevator;
	}

	public JLabel getLblFloorIndicator() {
		return lblFloorIndicator;
	}

	public JLabel getLblElevatorIndicator() {
		return lblElevatorIndicator;
	}

	public JButton getBtnUp() {
		return btnUp;
	}

	public JButton getBtnUp_1() {
		return btnUp_1;
	}

	public JButton getBtnDown_1() {
		return btnDown_1;
	}

	public JButton getBtnUp_2() {
		return btnUp_2;
	}

	public JButton getBtnDown_2() {
		return btnDown_2;
	}

	public JButton getBtnDown_3() {
		return btnDown_3;
	}

	public JButton getBtnLevel0() {
		return btnLevel0;
	}

	public JButton getBtnLevel1() {
		return btnLevel1;
	}

	public JButton getBtnLevel2() {
		return btnLevel2;
	}

	public JButton getBtnLevel3() {
		return btnLevel3;
	}

	public JButton getBtnStop() {
		return btnStop;
	}

	public JButton getBtnOpen() {
		return btnOpen;
	}

	public JButton getBtnClose() {
		return btnClose;
	}

	public JButton getBtnDigit1() {
		return btnDigit1;
	}

	public JButton getBtnDigit2() {
		return btnDigit2;
	}

	public JButton getBtnDigit3() {
		return btnDigit3;
	}

	public JButton getBtnDigit4() {
		return btnDigit4;
	}

	public JButton getBtnDigit5() {
		return btnDigit5;
	}

	public JButton getBtnDigit6() {
		return btnDigit6;
	}

	public JButton getBtnDigit7() {
		return btnDigit7;
	}

	public JButton getBtnDigit8() {
		return btnDigit8;
	}

	public JButton getBtnDigit9() {
		return btnDigit9;
	}

	public JButton getBtnDigit0() {
		return btnDigit0;
	}

	public JButton getBtnValidate() {
		return btnValidate;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnPOreset() {
		return btnPOreset;
	}

	public JButton getBtnPOdv2() {
		return btnPOdv2;
	}

	public JButton getBtnPOdv1() {
		return btnPOdv1;
	}

	public JButton getBtnPOdclose() {
		return btnPOdclose;
	}

	public JButton getBtnPOdopen() {
		return btnPOdopen;
	}

	public JButton getBtnPOuv2() {
		return btnPOuv2;
	}

	public JButton getBtnPOuv1() {
		return btnPOuv1;
	}

	public JToggleButton getSupervisorOnOff() {
		return supervisorOnOff;
	}

	public Password getPassword() {
		return password;
	}

	public Boolean getCodeAccessSupervisor() {
		return codeAccessSupervisor;
	}

	public void setCodeAccessSupervisor(Boolean codeAccessSupervisor) {
		this.codeAccessSupervisor = codeAccessSupervisor;
	}

	public void setSupervisor(Boolean supervisor) {
		this.supervisor = supervisor;
	}

	public Boolean getSupervisor() {
		return supervisor;
	}

	public JPanel getPanelCodeAccessSupervisor() {
		return panelCodeAccessSupervisor;
	}

	public JPanel getPanelSupervisor() {
		return panelSupervisor;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public JLabel getLblPOreset() {
		return lblPOreset;
	}

	public JLabel getLblPOdv2() {
		return lblPOdv2;
	}

	public JLabel getLblPOdv1() {
		return lblPOdv1;
	}

	public JLabel getLblPOuv1() {
		return lblPOuv1;
	}

	public JLabel getLblPOuv2() {
		return lblPOuv2;
	}

	public JLabel getLblPOdclose() {
		return lblPOdclose;
	}

	public JLabel getLblPOdopen() {
		return lblPOdopen;
	}

	public JLabel getLblPOv_crawlSelect() {
		return lblPOv_crawlSelect;
	}

	public JLabel getLblPOv_crawlValue() {
		return lblPOv_crawlValue;
	}

	public JSlider getSliderPOv_crawlSelect() {
		return sliderPOv_crawlSelect;
	}
}

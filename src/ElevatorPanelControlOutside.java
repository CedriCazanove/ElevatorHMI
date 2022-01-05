import java.awt.Color;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;

import org.json.JSONException;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class ElevatorPanelControlOutside {

	private JFrame frame;
	
	private static MqttPublisher mqttPublisher;
	
	private Boolean codeAccessSupervisor = false, supervisor = false, isPasswordCorrect = false;
	
	private JButton btnUp, btnDown, btnDigit1, btnDigit2, btnDigit3, btnDigit4, btnDigit5, btnDigit6, btnDigit7, btnDigit8, btnDigit9, btnDigit0, btnValidate, btnCancel;
	
	private JToggleButton supervisorOnOff;
	private JPanel panelCodeAccessSupervisor;
	private JPanel panelSupervisor;
	private JButton btnSpeed1;
	private JButton btnSpeed2;
	JLabel lblPassword;
	
	private static URL urlUp = ElevatorPanelControlOutside.class.getResource("/up.png");
	private static URL urlUpGreen = ElevatorPanelControlOutside.class.getResource("/upGreen.png");
	Icon iconUp = new ImageIcon(urlUp);
	Icon iconUpGreen = new ImageIcon(urlUpGreen);
	
	private static URL urlDown = ElevatorPanelControlOutside.class.getResource("/down.png");
	private static URL urlDownGreen = ElevatorPanelControlOutside.class.getResource("/downGreen.png");
	Icon iconDown = new ImageIcon(urlDown);
	Icon iconDownGreen = new ImageIcon(urlDownGreen);
	
	private static URL urlSpeedFast = ElevatorPanelControlOutside.class.getResource("/speedFast.png");
	private static URL urlSpeedFastGreen = ElevatorPanelControlOutside.class.getResource("/speedFastGreen.png");
	Icon iconSpeedFast = new ImageIcon(urlSpeedFast);
	Icon iconSpeedFastGreen = new ImageIcon(urlSpeedFastGreen);
	
	private static URL urlSpeedSlow = ElevatorPanelControlOutside.class.getResource("/speedSlow.png");
	private static URL urlSpeedSlowGreen = ElevatorPanelControlOutside.class.getResource("/speedSlowGreen.png");
	Icon iconSpeedSlow = new ImageIcon(urlSpeedSlow);
	Icon iconSpeedSlowGreen = new ImageIcon(urlSpeedSlowGreen);

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElevatorPanelControlOutside window = new ElevatorPanelControlOutside();
					//window.frame.setVisible(true);
					try {
						mqttPublisher = new MqttPublisher();
						mqttPublisher.startConnection();
					} catch (Exception e) {
						e.printStackTrace();
					}
					Elevator elevator = new Elevator(DoorState.OPEN, ElevatorState.INSERVICE, CurrentLevel.LEVEL0, Direction.IDLE);
					System.out.println(elevator.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public ElevatorPanelControlOutside(MqttPublisher mqttPublisher) {
		initialize();
		this.mqttPublisher = mqttPublisher;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Outside");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 350, 300);
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
		
		
		btnUp = new JButton(iconUp);
		btnUp.setBounds(40, 59, 50, 50);
		btnUp.setFocusPainted(false);
		btnUp.setFocusable(false);
		btnUp.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnUp.setIcon(iconUpGreen);
		    	Request request = new Request("TravReq", "Elevator Panel", "move to level X");
		    	try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	int delay = 1000; //milliseconds
		    	  ActionListener taskPerformer = new ActionListener() {
		    	      public void actionPerformed(ActionEvent evt) {
		    	    	  btnUp.setIcon(iconUp);
		    	      }
		    	  };
		    	  new Timer(delay, taskPerformer).start();
		    	
		    }
		});
		frame.getContentPane().add(btnUp);
		
		btnDown = new JButton(iconDown);
		btnDown.setBounds(40, 109, 50, 50);
		btnDown.setFocusPainted(false);
		btnDown.setFocusable(false);
		btnDown.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnDown.setIcon(iconDownGreen);
		    	int delay = 1000; //milliseconds
		    	  ActionListener taskPerformer = new ActionListener() {
		    	      public void actionPerformed(ActionEvent evt) {
		    	    	  btnDown.setIcon(iconDown);
		    	      }
		    	  };
		    	  new Timer(delay, taskPerformer).start();
		    }
		});
		frame.getContentPane().add(btnDown);
		
		supervisorOnOff = new JToggleButton("User");
		supervisorOnOff.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if (supervisorOnOff.isSelected()) {
		    		//add something to login
		    		supervisorOnOff.setText("Supervisor");
		    		//we display the code to enter the code to use the panel as supervisor
		    		codeAccessSupervisor = true;
		    		supervisor = true;
		    		
		    	} else {
		    		supervisorOnOff.setText("User");
		    		supervisor = false;
		    		codeAccessSupervisor = false;
		    	}
		    	panelSupervisor.setVisible(supervisor);
		    	panelCodeAccessSupervisor.setVisible(codeAccessSupervisor);
		    }
		});
		supervisorOnOff.setBounds(194, 23, 120, 21);
		frame.getContentPane().add(supervisorOnOff);
		
		panelCodeAccessSupervisor = new JPanel();
		panelCodeAccessSupervisor.setBounds(194, 45, 120, 180);
		frame.getContentPane().add(panelCodeAccessSupervisor);
		panelCodeAccessSupervisor.setVisible(false);
		panelCodeAccessSupervisor.setLayout(null);
		
		btnDigit1 = new JButton("1");
		btnDigit1.setBounds(0, 20, 40, 40);
		panelCodeAccessSupervisor.add(btnDigit1);
		
		btnDigit2 = new JButton("2");
		btnDigit2.setBounds(40, 20, 40, 40);
		panelCodeAccessSupervisor.add(btnDigit2);
		
		btnDigit3 = new JButton("3");
		btnDigit3.setBounds(80, 20, 40, 40);
		panelCodeAccessSupervisor.add(btnDigit3);
		
		btnDigit4 = new JButton("4");
		btnDigit4.setBounds(0, 60, 40, 40);
		panelCodeAccessSupervisor.add(btnDigit4);
		
		btnDigit5 = new JButton("5");
		btnDigit5.setBounds(40, 60, 40, 40);
		panelCodeAccessSupervisor.add(btnDigit5);
		
		btnDigit6 = new JButton("6");
		btnDigit6.setBounds(80, 60, 40, 40);
		panelCodeAccessSupervisor.add(btnDigit6);
		
		btnDigit7 = new JButton("7");
		btnDigit7.setBounds(0, 100, 40, 40);
		panelCodeAccessSupervisor.add(btnDigit7);
		
		btnDigit8 = new JButton("8");
		btnDigit8.setBounds(40, 100, 40, 40);
		panelCodeAccessSupervisor.add(btnDigit8);
		
		btnDigit9 = new JButton("9");
		btnDigit9.setBounds(80, 100, 40, 40);
		panelCodeAccessSupervisor.add(btnDigit9);
		
		btnValidate = new JButton("\u2713");
		btnValidate.setBounds(0, 140, 40, 40);
		panelCodeAccessSupervisor.add(btnValidate);
		
		btnDigit0 = new JButton("0");
		btnDigit0.setBounds(40, 140, 40, 40);
		panelCodeAccessSupervisor.add(btnDigit0);
		
		btnCancel = new JButton("X");
		btnCancel.setBounds(80, 140, 40, 40);
		panelCodeAccessSupervisor.add(btnCancel);
		
		lblPassword = new JLabel("Tap the password");
		lblPassword.setToolTipText("");
		lblPassword.setBounds(0, 0, 120, 20);
		panelCodeAccessSupervisor.add(lblPassword);
		
		panelSupervisor = new JPanel();
		panelSupervisor.setBounds(124, 59, 50, 100);
		frame.getContentPane().add(panelSupervisor);
		panelSupervisor.setVisible(false);
		panelSupervisor.setLayout(null);
		
		btnSpeed2 = new JButton(iconSpeedFast);
		btnSpeed2.setBounds(0, 50, 50, 50);
		btnSpeed2.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnSpeed2.setIcon(iconSpeedFastGreen);
		    	int delay = 1000; //milliseconds
		    	  ActionListener taskPerformer = new ActionListener() {
		    	      public void actionPerformed(ActionEvent evt) {
		    	    	  btnSpeed2.setIcon(iconSpeedFast);
		    	      }
		    	  };
		    	  new Timer(delay, taskPerformer).start();
		    }
		});
		panelSupervisor.add(btnSpeed2);
		
		btnSpeed1 = new JButton(iconSpeedSlow);
		btnSpeed1.setBounds(0, 0, 50, 50);
		btnSpeed1.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnSpeed1.setIcon(iconSpeedSlowGreen);
		    	int delay = 1000; //milliseconds
		    	  ActionListener taskPerformer = new ActionListener() {
		    	      public void actionPerformed(ActionEvent evt) {
		    	    	  btnSpeed1.setIcon(iconSpeedSlow);
		    	      }
		    	  };
		    	  new Timer(delay, taskPerformer).start();
		    }
		});
		panelSupervisor.add(btnSpeed1);
	}
}

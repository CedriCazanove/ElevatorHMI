import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;

public class ElevatorPanelControlInside {

	private JFrame frame;

	private static MqttPublisher mqttPublisher;
	
	private Boolean codeAccessSupervisor = false, supervisor = false;
	
	private JButton btnLevel0, btnLevel2, btnDigit1, btnDigit2, btnDigit3, btnDigit4, btnDigit5, btnDigit6, btnDigit7, btnDigit8, btnDigit9, btnDigit0, btnValidate, btnCancel;
	
	private JToggleButton supervisorOnOff;
	private JPanel panelCodeAccessSupervisor;
	private JPanel panelSupervisor;
	private JButton btnSpeed1;
	private JButton btnSpeed2;
	JLabel lblPassword;
	
	private static URL urlSpeedFast = ElevatorPanelControlInside.class.getResource("/speedFast.png");
	private static URL urlSpeedFastGreen = ElevatorPanelControlInside.class.getResource("/speedFastGreen.png");
	Icon iconSpeedFast = new ImageIcon(urlSpeedFast);
	Icon iconSpeedFastGreen = new ImageIcon(urlSpeedFastGreen);
	
	private static URL urlSpeedSlow = ElevatorPanelControlInside.class.getResource("/speedSlow.png");
	private static URL urlSpeedSlowGreen = ElevatorPanelControlInside.class.getResource("/speedSlowGreen.png");
	Icon iconSpeedSlow = new ImageIcon(urlSpeedSlow);
	Icon iconSpeedSlowGreen = new ImageIcon(urlSpeedSlowGreen);
	
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
	
	private JButton btnLevel1;
	private JButton btnLevel3;
	private JButton btnStop;
	private JButton btnOpen;
	private JButton btnClose;

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
	public ElevatorPanelControlInside(MqttPublisher mqttPublisher) {
		initialize();
		this.mqttPublisher = mqttPublisher;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Inside");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 400, 350, 300);
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
		panelSupervisor.setBounds(124, 23, 50, 100);
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
		
		btnLevel0 = new JButton(iconLevel0);
		btnLevel0.setBounds(10, 23, 50, 50);
		btnLevel0.setFocusPainted(false);
		btnLevel0.setFocusable(false);
		btnLevel0.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnLevel0.setIcon(iconLevel0Green);
		    	int delay = 1000; //milliseconds
		    	  ActionListener taskPerformer = new ActionListener() {
		    	      public void actionPerformed(ActionEvent evt) {
		    	    	  btnLevel0.setIcon(iconLevel0);
		    	      }
		    	  };
		    	  new Timer(delay, taskPerformer).start();
		    	
		    }
		});
		frame.getContentPane().add(btnLevel0);
		
		btnLevel1 = new JButton(iconLevel1);
		btnLevel1.setFocusable(false);
		btnLevel1.setFocusPainted(false);
		btnLevel1.setBounds(60, 23, 50, 50);
		btnLevel1.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnLevel1.setIcon(iconLevel1Green);
		    	int delay = 1000; //milliseconds
		    	  ActionListener taskPerformer = new ActionListener() {
		    	      public void actionPerformed(ActionEvent evt) {
		    	    	  btnLevel1.setIcon(iconLevel1);
		    	      }
		    	  };
		    	  new Timer(delay, taskPerformer).start();
		    	
		    }
		});
		frame.getContentPane().add(btnLevel1);
		
		btnLevel2 = new JButton(iconLevel2);
		btnLevel2.setBounds(10, 73, 50, 50);
		btnLevel2.setFocusPainted(false);
		btnLevel2.setFocusable(false);
		btnLevel2.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnLevel2.setIcon(iconLevel2Green);
		    	int delay = 1000; //milliseconds
		    	  ActionListener taskPerformer = new ActionListener() {
		    	      public void actionPerformed(ActionEvent evt) {
		    	    	  btnLevel2.setIcon(iconLevel2);
		    	      }
		    	  };
		    	  new Timer(delay, taskPerformer).start();
		    	
		    }
		});
		frame.getContentPane().add(btnLevel2);
		
		btnLevel3 = new JButton(iconLevel3);
		btnLevel3.setFocusable(false);
		btnLevel3.setFocusPainted(false);
		btnLevel3.setBounds(60, 73, 50, 50);
		btnLevel3.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnLevel3.setIcon(iconLevel3Green);
		    	int delay = 1000; //milliseconds
		    	  ActionListener taskPerformer = new ActionListener() {
		    	      public void actionPerformed(ActionEvent evt) {
		    	    	  btnLevel3.setIcon(iconLevel3);
		    	      }
		    	  };
		    	  new Timer(delay, taskPerformer).start();
		    	
		    }
		});
		frame.getContentPane().add(btnLevel3);
		
		btnStop = new JButton(iconStop);
		btnStop.setFocusable(false);
		btnStop.setFocusPainted(false);
		btnStop.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnStop.setIcon(iconStopPressed);
		    	int delay = 1000; //milliseconds
		    	  ActionListener taskPerformer = new ActionListener() {
		    	      public void actionPerformed(ActionEvent evt) {
		    	    	  btnStop.setIcon(iconStop);
		    	      }
		    	  };
		    	  new Timer(delay, taskPerformer).start();
		    }
		});
		btnStop.setBounds(35, 123, 50, 50);
		frame.getContentPane().add(btnStop);
		
		btnOpen = new JButton(iconOpen);
		btnOpen.setFocusable(false);
		btnOpen.setFocusPainted(false);
		btnOpen.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnOpen.setIcon(iconOpenGreen);
		    	int delay = 1000; //milliseconds
		    	  ActionListener taskPerformer = new ActionListener() {
		    	      public void actionPerformed(ActionEvent evt) {
		    	    	  btnOpen.setIcon(iconOpen);
		    	      }
		    	  };
		    	  new Timer(delay, taskPerformer).start();
		    }
		});
		btnOpen.setBounds(10, 175, 50, 50);
		frame.getContentPane().add(btnOpen);
		
		btnClose = new JButton(iconClose);
		btnClose.setFocusable(false);
		btnClose.setFocusPainted(false);
		btnClose.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnClose.setIcon(iconCloseGreen);
		    	int delay = 1000; //milliseconds
		    	  ActionListener taskPerformer = new ActionListener() {
		    	      public void actionPerformed(ActionEvent evt) {
		    	    	  btnClose.setIcon(iconClose);
		    	      }
		    	  };
		    	  new Timer(delay, taskPerformer).start();
		    }
		});
		btnClose.setBounds(60, 175, 50, 50);
		frame.getContentPane().add(btnClose);
	}

}

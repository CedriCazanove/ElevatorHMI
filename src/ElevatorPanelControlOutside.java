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
	
	private String password = "1234", textPassword = "";
	
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
	
	private JButton btnFloor1;
	private JButton btnFloor0;
	private JButton btnFloor2;
	private JButton btnFloor3;
	
	private String currentFloorPanel = "0";

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
		btnUp.setBounds(14, 59, 50, 50);
		btnUp.setFocusPainted(false);
		btnUp.setFocusable(false);
		btnUp.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Request request = new Request("TravReq", "Elevator Panel", "move to level " + currentFloorPanel);
		    	try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	btnUp.setIcon(iconUpGreen);
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
		btnDown.setBounds(14, 109, 50, 50);
		btnDown.setFocusPainted(false);
		btnDown.setFocusable(false);
		btnDown.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	Request request = new Request("TravReq", "Elevator Panel", "move to level " + currentFloorPanel);
		    	try {
					System.out.println(request.toJSON());
					mqttPublisher.sendMessage(request.toJSON().toString());
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		supervisorOnOff = new JToggleButton(iconUser);
		supervisorOnOff.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if (supervisorOnOff.isSelected()) {
		    		//add something to login
		    		supervisorOnOff.setIcon(iconSupervisor);
		    		//we display the code to enter the code to use the panel as supervisor
		    		codeAccessSupervisor = true;
		    		supervisor = true;
		    		
		    	} else {
		    		supervisorOnOff.setIcon(iconUser);
		    		supervisor = false;
		    		codeAccessSupervisor = false;
		    	}
		    	panelSupervisor.setVisible(supervisor);
		    	panelCodeAccessSupervisor.setVisible(codeAccessSupervisor);
		    }
		});
		supervisorOnOff.setBounds(194, 10, 120, 21);
		frame.getContentPane().add(supervisorOnOff);
		
		panelCodeAccessSupervisor = new JPanel();
		panelCodeAccessSupervisor.setBounds(194, 33, 120, 180);
		frame.getContentPane().add(panelCodeAccessSupervisor);
		panelCodeAccessSupervisor.setVisible(false);
		panelCodeAccessSupervisor.setLayout(null);
		
		btnDigit1 = new JButton(iconDigit1);
		btnDigit1.setBounds(0, 20, 40, 40);
		btnDigit1.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
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
		
		btnDigit2 = new JButton(iconDigit2);
		btnDigit2.setBounds(40, 20, 40, 40);
		btnDigit2.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
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
		
		btnDigit3 = new JButton(iconDigit3);
		btnDigit3.setBounds(80, 20, 40, 40);
		btnDigit3.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
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
		
		btnDigit4 = new JButton(iconDigit4);
		btnDigit4.setBounds(0, 60, 40, 40);
		btnDigit4.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
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
		
		btnDigit5 = new JButton(iconDigit5);
		btnDigit5.setBounds(40, 60, 40, 40);
		btnDigit5.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
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
		
		btnDigit6 = new JButton(iconDigit6);
		btnDigit6.setBounds(80, 60, 40, 40);
		btnDigit6.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
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
		
		btnDigit7 = new JButton(iconDigit7);
		btnDigit7.setBounds(0, 100, 40, 40);
		btnDigit7.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
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
		
		btnDigit8 = new JButton(iconDigit8);
		btnDigit8.setBounds(40, 100, 40, 40);
		btnDigit8.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
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
		
		btnDigit9 = new JButton(iconDigit9);
		btnDigit9.setBounds(80, 100, 40, 40);
		btnDigit9.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
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
		
		btnValidate = new JButton(iconCheck);
		btnValidate.setBounds(0, 140, 40, 40);
		btnValidate.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
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
		
		btnDigit0 = new JButton(iconDigit0);
		btnDigit0.setBounds(40, 140, 40, 40);
		btnDigit0.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
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
		
		btnCancel = new JButton(iconCross);
		btnCancel.setBounds(80, 140, 40, 40);
		btnCancel.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
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
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 10, 160, 40);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnFloor0 = new JButton(iconDigit0Green);
		btnFloor0.setBounds(0, 0, 40, 40);
		btnFloor0.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnFloor0.setIcon(iconDigit0Green);
	    	    btnFloor1.setIcon(iconDigit1);
	    	    btnFloor2.setIcon(iconDigit2);
	    	    btnFloor3.setIcon(iconDigit3);
	    	    currentFloorPanel = "0";
		    }
		});
		panel.add(btnFloor0);
		
		btnFloor1 = new JButton(iconDigit1);
		btnFloor1.setBounds(40, 0, 40, 40);
		btnFloor1.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnFloor1.setIcon(iconDigit1Green);
	    	    btnFloor2.setIcon(iconDigit2);
	    	    btnFloor0.setIcon(iconDigit0);
	    	    btnFloor3.setIcon(iconDigit3);
	    	    currentFloorPanel = "1";
		    }
		});
		panel.add(btnFloor1);
		
		btnFloor2 = new JButton(iconDigit2);
		btnFloor2.setBounds(80, 0, 40, 40);
		btnFloor2.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnFloor2.setIcon(iconDigit2Green);
	    	    btnFloor1.setIcon(iconDigit1);
	    	    btnFloor0.setIcon(iconDigit0);
	    	    btnFloor3.setIcon(iconDigit3);
	    	    currentFloorPanel = "2";
		    }
		});
		panel.add(btnFloor2);
		
		btnFloor3 = new JButton(iconDigit3);
		btnFloor3.setBounds(120, 0, 40, 40);
		btnFloor3.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	btnFloor3.setIcon(iconDigit3Green);
	    	    btnFloor1.setIcon(iconDigit1);
	    	    btnFloor0.setIcon(iconDigit0);
	    	    btnFloor2.setIcon(iconDigit2);
	    	    currentFloorPanel = "3";
		    }
		});
		panel.add(btnFloor3);
	}
}

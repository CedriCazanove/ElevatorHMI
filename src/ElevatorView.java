import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ElevatorView {

	private JFrame frame;
	
	private Elevator elevator;
	
	Timer timer;
	
	private static JLabel labelElevator;
	
	private JLabel lblFloorIndicator;
	
	private static URL urlFloorIndicator = ElevatorView.class.getResource("/floorIndicator.png");
	
	private static URL urlElevatorOpen = ElevatorView.class.getResource("/elevatorOpen.png");
	private static URL urlElevatorClose = ElevatorView.class.getResource("/elevatorClose.png");
	private static URL urlElevatorInTransition = ElevatorView.class.getResource("/elevatorInTransition.png");
	
	private static Icon iconElevatorOpen = new ImageIcon(urlElevatorOpen);
	private static Icon iconElevatorClose = new ImageIcon(urlElevatorClose);
	private static Icon iconElevatorInTransition = new ImageIcon(urlElevatorInTransition);

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
	public ElevatorView(Elevator elevator) {
		initialize();
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
				int delay = 1; //milliseconds
				
		    	timer = new Timer(delay, new ActionListener() {
		    		
		    		public void actionPerformed(ActionEvent evt) {
		    			int previousLevel = labelElevator.getY();
						int nextLevel = (3 - elevatorView.getCurrentLevel())*135 + 3;
						//System.out.println("previousLevel : " + previousLevel);
						//System.out.println("nextLevel : " + nextLevel);
						int direction = 0;
						if (previousLevel > nextLevel) {
							direction = -1;
						} else {
							direction = 1;
						}
						if (previousLevel == nextLevel) {
							timer.stop();
						} else {
							labelElevator.setBounds(0, labelElevator.getY() + direction * elevatorView.getSpeed().toInteger(), 100, 135);
						}
		    			
		    		}
		    	});
		    	timer.start();
				
				
				
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
		frame.setBounds(450, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelElevator = new JPanel();
		panelElevator.setBounds(29, 10, 100, 543);
		frame.getContentPane().add(panelElevator);
		panelElevator.setLayout(null);
		
		
		labelElevator = new JLabel(iconElevatorOpen);
		labelElevator.setBounds(0, 408, 100, 135);
		panelElevator.add(labelElevator);
		
		JPanel panelFloor = new JPanel();
		panelFloor.setBounds(9, 10, 10, 543);
		frame.getContentPane().add(panelFloor);
		panelFloor.setLayout(null); 
		
		Icon iconFloorIndicator = new ImageIcon(urlFloorIndicator);
		lblFloorIndicator = new JLabel(iconFloorIndicator);
		lblFloorIndicator.setBounds(0, 0, 10, 543);
		panelFloor.add(lblFloorIndicator);
	}
}

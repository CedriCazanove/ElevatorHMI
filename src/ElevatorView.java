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
	public ElevatorView() {
		initialize();
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(229, 224, 85, 21);
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	System.out.println(labelElevator.getY());
		    	labelElevator.setBounds(0, labelElevator.getY() - 50, 100, 135);
		    }
		});
		frame.getContentPane().add(btnNewButton);
	}
}

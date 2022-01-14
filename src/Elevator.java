
public class Elevator {
	
	public interface ElevatorListener {

		//Action to trigger when the door state of the elevator change
		public void doorStateChanged();
      
		//Action to trigger when the current level of the elevator change
		public void currentLevelChanged();
		
		//Action to trigger when the state of the elevator change
		public void elevatorStateChanged();
		
		//Action to trigger when the direction of the elevator change
		public void directionChanged();
		
		//Action to trigger when the speed of the speed of the elevator
		public void speedChanged();
	      
	}
	
	private DoorState doorState;
	
	private ElevatorState elevatorState;
	
	private int currentLevel;
	
	private Direction direction;
	
	private ElevatorListener listener;
	
	private ElevatorSpeed speed;
	
	public Elevator(DoorState doorState, ElevatorState elevatorState, int currentLevel, Direction direction, ElevatorSpeed speed) {
		this.doorState = doorState;
		this.elevatorState = elevatorState;
		this.direction = direction;
		this.currentLevel = currentLevel;
		this.setSpeed(speed);
		this.setListener(null);
	}

	public DoorState getDoorState() {
		return doorState;
	}

	public void setDoorState(DoorState doorState) {
		this.doorState = doorState;
		if (listener != null) {
            listener.doorStateChanged();
		}
	}

	public ElevatorState getElevatorState() {
		return elevatorState;
	}

	public void setElevatorState(ElevatorState elevatorState) {
		this.elevatorState = elevatorState;
		if (listener != null) {
            listener.elevatorStateChanged();
		}
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
		if (listener != null) {
            listener.directionChanged();
		}
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
		if (listener != null) {
            listener.currentLevelChanged();
		}
	}

	public ElevatorListener getListener() {
		return listener;
	}

	public void setListener(ElevatorListener listener) {
		this.listener = listener;
	}
	
	public ElevatorSpeed getSpeed() {
		return speed;
	}

	public void setSpeed(ElevatorSpeed speed) {
		this.speed = speed;
	}
	
	public String toString() {
		return "Elevator : \n - DoorState : " + this.doorState + 
						  "\n - ElevatorState : " + this.elevatorState +
						  "\n - CurrentLevel : " + this.currentLevel +
						  "\n - Direction : " + this.direction;
	}
	
	public void treatRequestBackState(RequestBackState requestState) {
		System.out.println("Elevator received a state request to treat");
		if (requestState.getType().equals("DoorState")) {
			if (requestState.getState().equals("opened")) {
				setDoorState(DoorState.OPEN);
			} else if (requestState.getState().equals("closed")) {
				setDoorState(DoorState.CLOSE);
			} else if (requestState.getState().equals("in motion")) {
				setDoorState(DoorState.CLOSING);
			}
			//System.out.println(toString());
		}
	}
	
	public void treatRequestBackLevel(RequestBackLevel requestLevel) {
		System.out.println("Elevator received a level request to treat");
		try {
			System.out.println(" New Level : " + requestLevel.getLevel().toString());
			setCurrentLevel(Integer.parseInt(requestLevel.getLevel()));
			System.out.println(toString());
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
}

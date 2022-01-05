
public class Elevator {
	
	private DoorState doorState;
	
	private ElevatorState elevatorState;
	
	private CurrentLevel currentLevel;
	
	private Direction direction;
	
	public Elevator(DoorState doorState, ElevatorState elevatorState, CurrentLevel currentLevel, Direction direction) {
		this.doorState = doorState;
		this.elevatorState = elevatorState;
		this.direction = direction;
		this.currentLevel = currentLevel;
	}

	public DoorState getDoorState() {
		return doorState;
	}

	public void setDoorState(DoorState doorState) {
		this.doorState = doorState;
	}

	public ElevatorState getElevatorState() {
		return elevatorState;
	}

	public void setElevatorState(ElevatorState elevatorState) {
		this.elevatorState = elevatorState;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public CurrentLevel getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(CurrentLevel currentLevel) {
		this.currentLevel = currentLevel;
	}
	
	public String toString() {
		return "Elevator : \n - DoorState : " + this.doorState + 
						  "\n - ElevatorState : " + this.elevatorState +
						  "\n - CurrentLevel : " + this.currentLevel +
						  "\n - Direction : " + this.direction;
	}
	
	
	

}

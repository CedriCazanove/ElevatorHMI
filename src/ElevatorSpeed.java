
public enum ElevatorSpeed {
	
	SPEED1(1), SPEED2(5);


	private final int speed;
	
	private ElevatorSpeed(int speed) {
	    this.speed = speed;
	}

	public String toString() {
	    return Integer.toString(speed);
	}
	
	public int toInteger() {
		return speed;
	}
}

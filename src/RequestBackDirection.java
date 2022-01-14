
public class RequestBackDirection implements RequestBack {
	
	private String type;
	
	private String device;
	
	private String direction;
	
	private String time;
	
	private TypeRequestBack requestBackType = TypeRequestBack.DIRECTION;
	
	public RequestBackDirection(String type, String device, String direction, String time) {
		this.type = type;
		this.device = device;
		this.direction = direction;
		this.time = time; 
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	@Override
	public String getRequestBack() {
		return getDirection();
	}

	@Override
	public TypeRequestBack getTypeRequestBack() {
		return requestBackType;
	}

}

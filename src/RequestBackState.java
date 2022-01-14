
public class RequestBackState implements RequestBack {
	
	private String type;
	
	private String device;
	
	private String state;
	
	private String time;
	
	private TypeRequestBack requestBackType = TypeRequestBack.STATE;
	
	public RequestBackState(String type, String device, String state, String time) {
		this.type = type;
		this.device = device;
		this.state = state;
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
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String getRequestBack() {
		return getState();
	}

	@Override
	public TypeRequestBack getTypeRequestBack() {
		return requestBackType;
	}


}

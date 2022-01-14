
public class RequestBackLevel implements RequestBack {

	private String type;
	
	private String device;
	
	private String level;
	
	private String time;
	
	private TypeRequestBack requestBackType = TypeRequestBack.LEVEL;
	
	public RequestBackLevel(String type, String device, String level, String time) {
		this.type = type;
		this.device = device;
		this.level = level;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	@Override
	public String getRequestBack() {
		return getLevel();
	}

	@Override
	public TypeRequestBack getTypeRequestBack() {
		return requestBackType;
	}


}

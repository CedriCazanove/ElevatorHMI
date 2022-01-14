
public class RequestBackReset implements RequestBack {
	
	private String type;
	
	private String device;
	
	private String reset;
	
	private String time;
	
	private TypeRequestBack requestBackType = TypeRequestBack.RESET;
	
	public RequestBackReset(String type, String device, String reset, String time) {
		this.type = type;
		this.device = device;
		this.reset = reset;
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

	public String getReset() {
		return reset;
	}

	public void setReset(String reset) {
		this.reset = reset;
	}
	
	@Override
	public String getRequestBack() {
		return getReset();
	}

	@Override
	public TypeRequestBack getTypeRequestBack() {
		return requestBackType;
	}

}

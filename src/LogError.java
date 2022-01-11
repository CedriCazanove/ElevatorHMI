
public class LogError implements RequestBack {
	
	private String type;
	
	private String message;
	
	private String device;
	
	private String time;
	
	private String severity;
	
	private TypeRequestBack requestBackType = TypeRequestBack.LOGERROR;
	
	public LogError(String type, String message, String device, String time, String severity) {
		this.type = type;
		this.message = message;
		this.device = device;
		this.severity = severity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	@Override
	public String getRequestBack() {
		return getSeverity() + " : " + getMessage();
	}

	@Override
	public TypeRequestBack getTypeRequestBack() {
		return requestBackType;
	}

}

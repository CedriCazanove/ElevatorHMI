package Controller.Request;

import org.json.JSONException;
import org.json.JSONObject;

public class LogError implements Request {
	
	private String type;
	
	private String message;
	
	private String device;
	
	private String time;
	
	private String severity;
	
	public LogError(String type, String message, String device, String time, String severity) {
		this.type = type;
		this.message = message;
		this.device = device;
		this.severity = severity;
	}

	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("type", this.type);
		obj.put("message", this.message);
		obj.put("device", this.device);
		obj.put("severity", this.severity);
		obj.put("time", this.time);
		return obj;
	}

	@Override
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

	@Override
	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	@Override
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

}

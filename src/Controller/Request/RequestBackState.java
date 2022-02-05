package Controller.Request;

import org.json.JSONException;
import org.json.JSONObject;

public class RequestBackState implements Request {
	
	private String type;
	
	private String device;
	
	private String state;
	
	private String time;
	
	public RequestBackState(String type, String device, String state, String time) {
		this.type = type;
		this.device = device;
		this.state = state;
		this.time = time; 
	}

	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("type", this.type);
		obj.put("device", this.device);
		obj.put("state", this.state);
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
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


}

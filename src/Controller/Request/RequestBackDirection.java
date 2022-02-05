package Controller.Request;

import org.json.JSONException;
import org.json.JSONObject;

public class RequestBackDirection implements Request {
	
	private String type;
	
	private String device;
	
	private String direction;
	
	private String time;
	
	public RequestBackDirection(String type, String device, String direction, String time) {
		this.type = type;
		this.device = device;
		this.direction = direction;
		this.time = time; 
	}

	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("type", this.type);
		obj.put("device", this.device);
		obj.put("direction", this.direction);
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

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}

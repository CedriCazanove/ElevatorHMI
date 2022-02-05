package Controller.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestBackPanelAnswer implements Request {
	
	private String type;
	
	private String device;
	
	private JSONArray states;
	
	private String time;
	
	public RequestBackPanelAnswer(String type, String device, JSONArray states, String time) {
		this.type = type;
		this.device = device;
		this.states = states;
		this.time = time; 
	}

	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("type", this.type);
		obj.put("device", this.device);
		obj.put("states", this.states);
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

	public JSONArray getAnswer() {
		return states;
	}

	public void setAnswer(JSONArray states) {
		this.states = states;
	}

	@Override
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}

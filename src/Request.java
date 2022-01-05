import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.json.JSONException;
import org.json.JSONObject;

public class Request {
	
	private String type;
	
	private String device;
	
	private String request;
	
	private String time;
	
	public Request(String type, String device, String request) {
		this.type = type;
		this.device = device;
		this.request = request;
		Date date = new Date(System.currentTimeMillis());
		// Conversion
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		sdf.setTimeZone(TimeZone.getTimeZone("CET"));
		this.time = sdf.format(date); 
	}
	
	public JSONObject toJSON() throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("type", this.type);    
		obj.put("device", this.device);    
		obj.put("request", this.request);
		obj.put("time", this.time);
		return obj;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getDevice() {
		return this.device;
	}
	
	public String getRequest() {
		return this.request;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setDevice(String device) {
		this.device = device;
	}
	
	public void setRequest(String request) {
		this.request = request;
	}
	
	public void setTime(String time) {
		this.time = time;
	}

}

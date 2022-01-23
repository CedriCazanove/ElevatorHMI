import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class RequestBackLevel implements Request {

	private String type;
	
	private String device;
	
	private String level;
	
	private String time;

	public RequestBackLevel(String type, String device, String level) {
		this.type = type;
		this.device = device;
		this.level = level;
		Date date = new Date(System.currentTimeMillis());
		// Conversion
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		sdf.setTimeZone(TimeZone.getTimeZone("CET"));
		this.time = sdf.format(date);
	}
	
	public RequestBackLevel(String type, String device, String level, String time) {
		this.type = type;
		this.device = device;
		this.level = level;
		this.time = time; 
	}

	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("type", this.type);
		obj.put("device", this.device);
		obj.put("level", this.level);
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}


}

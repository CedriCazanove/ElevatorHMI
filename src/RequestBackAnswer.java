import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class RequestBackAnswer implements RequestBack {
	
	private String type;
	
	private String device;
	
	private String answer;
	
	private String time;
	
	private TypeRequestBack requestBackType = TypeRequestBack.ANSWER;
	
	public RequestBackAnswer(String type, String device, String answer, String time) {
		this.type = type;
		this.device = device;
		this.answer = answer;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String getRequestBack() {
		return getAnswer();
	}

	@Override
	public TypeRequestBack getTypeRequestBack() {
		return requestBackType;
	}

}

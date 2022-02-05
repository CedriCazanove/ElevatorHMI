package Controller.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class SupervisorRequest implements Request {

    private String type;

    private String device;

    private String mode;

    private String control;

    private Object state;

    private String time;

    public SupervisorRequest(String type, String device, String mode, String control, Object state) {
        this.type = type;
        this.device = device;
        this.mode = mode;
        this.control = control;
        this.state = state;
        Date date = new Date(System.currentTimeMillis());
        // Conversion
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        sdf.setTimeZone(TimeZone.getTimeZone("CET"));
        this.time = sdf.format(date);
    }

    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("type", this.type);
        obj.put("device", this.device);
        obj.put("mode", this.mode);
        obj.put("control", this.control);
        obj.put("state", this.state);
        obj.put("time", this.time);
        return obj;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getDevice() {
        return this.device;
    }

    public String getControl() {
        return this.control;
    }

    @Override
    public String getTime() {
        return this.time;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }
}

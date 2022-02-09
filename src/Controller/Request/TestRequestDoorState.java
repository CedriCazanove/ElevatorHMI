package Controller.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class TestRequestDoorState implements Request {

    private String type;

    private String device;

    private String state;

    private String time;

    private static int floor = 4;

    private static boolean bool = true;

    public TestRequestDoorState() throws JSONException {
        this.type = "DoorState";
        this.device = "Elevator";
        this.state = "IN MOTION";
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

    public Object getState() {
        return this.state;
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

    public void setState(String state) {
        this.state = state;
    }

    public void setTime(String time) {
        this.time = time;
    }

}

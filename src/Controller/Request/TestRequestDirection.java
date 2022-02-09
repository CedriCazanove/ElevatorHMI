package Controller.Request;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class TestRequestDirection implements Request {

    private String type;

    private String device;

    private String direction;

    private String time;

    private static boolean bool = true;

    public TestRequestDirection() throws JSONException {
        this.type = "DirInd";
        this.device = "Elevator";
        this.direction = (bool ? "idle" : "up");
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
        obj.put("direction", this.direction);
        obj.put("time", this.time);
        bool = ! bool;
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

    public Object getDirection() {
        return this.direction;
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

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setTime(String time) {
        this.time = time;
    }

}

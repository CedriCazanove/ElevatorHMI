package Controller.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class TestRequestCurrentLevel implements Request {

    private String type;

    private String device;

    private Object level;

    private String time;

    private static int floor = 1;

    private static boolean bool = true;

    public TestRequestCurrentLevel() throws JSONException {
        this.type = "CurrentLevel";
        this.device = "Elevator";
        this.level = floor++;
        if ((int) this.level >= 5) {
            floor = 1;
            this.level = floor;
        }
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
        obj.put("level", this.level);
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

    public Object getLevel() {
        return this.level;
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

    public void setLevel(Object level) {
        this.level = level;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
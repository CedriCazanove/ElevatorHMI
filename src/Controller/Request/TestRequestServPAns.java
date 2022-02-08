package Controller.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class TestRequestServPAns implements Request {

    private String type;

    private String device;

    private JSONArray states;

    private String time;

    private static boolean bool = true;

    public TestRequestServPAns() throws JSONException {
        this.type = "ServPAns";
        this.device = "Elevator";
        JSONObject obj = new JSONObject();
        obj.put("name","1REQ");
        obj.put("value", bool);

        JSONObject obj2 = new JSONObject();
        obj2.put("name","CLOSE");
        obj2.put("value", bool);

        JSONArray ja = new JSONArray();
        ja.put(obj);
        ja.put(obj2);
        this.states = ja;
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
        obj.put("states", this.states);
        obj.put("time", this.time);
        bool = !bool;
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

    public JSONArray getStates() {
        return this.states;
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

    public void setStates(JSONArray states) {
        this.states = states;
    }

    public void setTime(String time) {
        this.time = time;
    }

}

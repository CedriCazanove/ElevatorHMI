package Controller.Request;

import org.json.JSONException;
import org.json.JSONObject;

public interface Request {

    //Getting the type of the request
    public String getType();

    //Getting the device of the request
    public String getDevice();

    //Getting the time of the request
    public String getTime();

    //converting a request in a json object
    public JSONObject toJSON() throws JSONException;



}

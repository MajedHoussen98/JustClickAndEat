package ps.ns.just_click_and_eat.network.utils;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppResponse {

    @SerializedName("statusCode")
    @Expose
    private int statusCode;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("items")
    @Expose
    private Object items;

    @SerializedName("status")
    @Expose
    private Boolean status;

    /**
     * Instantiates a new App response.
     */
    public AppResponse() {
    }

    public String getResult() {
        return new Gson().toJson(items);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getItems() {
        return items;
    }

    public void setItems(Object items) {
        this.items = items;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

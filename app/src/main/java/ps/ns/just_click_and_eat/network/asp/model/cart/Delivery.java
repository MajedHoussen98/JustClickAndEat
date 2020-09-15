package ps.ns.just_click_and_eat.network.asp.model.cart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Delivery {

    @SerializedName("method")
    @Expose
    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}

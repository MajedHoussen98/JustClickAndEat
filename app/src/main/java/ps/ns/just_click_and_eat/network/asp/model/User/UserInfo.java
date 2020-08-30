package ps.ns.just_click_and_eat.network.asp.model.User;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ps.ns.just_click_and_eat.network.asp.model.User.Token;
import ps.ns.just_click_and_eat.network.asp.model.User.UserData;

public class UserInfo {

    @SerializedName("token")
    @Expose
    private Token token;

    @SerializedName("user")
    @Expose
    private UserData userData;

    public UserInfo(Token token, UserData userData) {
        this.token = token;
        this.userData = userData;
    }

    public Token getTokenData() {
        return token;
    }

    public void setTokenData(Token tokenModel) {
        this.token = tokenModel;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}

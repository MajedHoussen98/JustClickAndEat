package ps.ns.just_click_and_eat.network.asp.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("mobile")
    @Expose
    private String mobile;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("email_verified_at")
    @Expose
    private String emailVerifiedAt;

    @SerializedName("verification_code")
    @Expose
    private String verificationCode;

    @SerializedName("verification_code_expired")
    @Expose
    private String verificationCodeExpired;

    @SerializedName("is_social")
    @Expose
    private Integer isSocial;

    @SerializedName("last_login_date")
    @Expose
    private String lastLoginDate;

    @SerializedName("last_password_change_date")
    @Expose
    private Object lastPasswordChangeDate;

    @SerializedName("lang_id")
    @Expose
    private Integer langId;

    @SerializedName("stripe_id")
    @Expose
    private Integer stripeId;

    @SerializedName("is_verified_code")
    @Expose
    private Integer isVerifiedCode;

    @SerializedName("is_active")
    @Expose
    private Integer isActive;

    @SerializedName("photo_thumb")
    @Expose
    private String photoThumb;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(String emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getVerificationCodeExpired() {
        return verificationCodeExpired;
    }

    public void setVerificationCodeExpired(String verificationCodeExpired) {
        this.verificationCodeExpired = verificationCodeExpired;
    }

    public Integer getIsSocial() {
        return isSocial;
    }

    public void setIsSocial(Integer isSocial) {
        this.isSocial = isSocial;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Object getLastPasswordChangeDate() {
        return lastPasswordChangeDate;
    }

    public void setLastPasswordChangeDate(Object lastPasswordChangeDate) {
        this.lastPasswordChangeDate = lastPasswordChangeDate;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Integer getStripeId() {
        return stripeId;
    }

    public void setStripeId(Integer stripeId) {
        this.stripeId = stripeId;
    }

    public Integer getIsVerifiedCode() {
        return isVerifiedCode;
    }

    public void setIsVerifiedCode(Integer isVerifiedCode) {
        this.isVerifiedCode = isVerifiedCode;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getPhotoThumb() {
        return photoThumb;
    }

    public void setPhotoThumb(String photoThumb) {
        this.photoThumb = photoThumb;
    }
}
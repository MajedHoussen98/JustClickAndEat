package ps.ns.just_click_and_eat.network.asp.model.User;


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
    private String lastPasswordChangeDate;
    @SerializedName("lang_id")
    @Expose
    private Integer langId;
    @SerializedName("stripe_id")
    @Expose
    private String stripeId;
    @SerializedName("is_verified_code")
    @Expose
    private Integer isVerifiedCode;
    @SerializedName("is_active")
    @Expose
    private Integer isActive;
    @SerializedName("Deleted_by")
    @Expose
    private String deletedBy;
    @SerializedName("deleted_at")
    @Expose
    private String deletedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("photo_thumb")
    @Expose
    private String photoThumb;


    public UserData(Integer id, String name, String email, String mobile, String avatar, String photoThumb) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.avatar = avatar;
        this.photoThumb = photoThumb;
    }

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

    public Object getEmailVerifiedAt() {
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

    public void setLastPasswordChangeDate(String lastPasswordChangeDate) {
        this.lastPasswordChangeDate = lastPasswordChangeDate;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Object getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
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

    public Object getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPhotoThumb() {
        return photoThumb;
    }

    public void setPhotoThumb(String photoThumb) {
        this.photoThumb = photoThumb;
    }

}
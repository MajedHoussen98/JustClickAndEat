package ps.ns.just_click_and_eat.network.asp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeModel {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("slug")
    @Expose
    private String slug;

    @SerializedName("mobile")
    @Expose
    private String mobile;

    @SerializedName("tel")
    @Expose
    private String tel;

    @SerializedName("logo")
    @Expose
    private String logo;

    @SerializedName("lat")
    @Expose
    private String lat;

    @SerializedName("lng")
    @Expose
    private String lng;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("feature")
    @Expose
    private String feature;

    @SerializedName("open_time")
    @Expose
    private String openTime;

    @SerializedName("close_time")
    @Expose
    private String closeTime;

    @SerializedName("CancelledAfter")
    @Expose
    private Integer cancelledAfter;

    @SerializedName("rating")
    @Expose
    private Integer rating;

    @SerializedName("orders_number")
    @Expose
    private Integer ordersNumber;

    @SerializedName("is_active")
    @Expose
    private Integer isActive;

    @SerializedName("restaurant_type")
    @Expose
    private Integer restaurantType;

    @SerializedName("commission")
    @Expose
    private Integer commission;

    @SerializedName("membership")
    @Expose
    private Integer membership;

    @SerializedName("first_login")
    @Expose
    private Integer firstLogin;

    @SerializedName("ordering_id")
    @Expose
    private Integer orderingId;

    @SerializedName("city_id")
    @Expose
    private Integer cityId;

    @SerializedName("is_online")
    @Expose
    private Integer isOnline;

    @SerializedName("extra_charge_ingredients")
    @Expose
    private Integer extraChargeIngredients;

    @SerializedName("last_offline_date")
    @Expose
    private Object lastOfflineDate;

    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("logo_url")
    @Expose
    private String logoUrl;

    @SerializedName("logo_thumb")
    @Expose
    private String logoThumb;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("is_favorite")
    @Expose
    private Boolean isFavorite;

    @SerializedName("share_link")
    @Expose
    private String shareLink;

    @SerializedName("cart_items_count")
    @Expose
    private Integer cartItemsCount;

    @SerializedName("work_hour")
    @Expose
    private Object workHour;

    @SerializedName("week_workHour")
    @Expose
    private List<WeekWorkModel> weekWorkHour = null;

    @SerializedName("images")
    @Expose
    private List<ImageModelRestaurant> images = null;

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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Integer getCancelledAfter() {
        return cancelledAfter;
    }

    public void setCancelledAfter(Integer cancelledAfter) {
        this.cancelledAfter = cancelledAfter;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getOrdersNumber() {
        return ordersNumber;
    }

    public void setOrdersNumber(Integer ordersNumber) {
        this.ordersNumber = ordersNumber;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(Integer restaurantType) {
        this.restaurantType = restaurantType;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Integer getMembership() {
        return membership;
    }

    public void setMembership(Integer membership) {
        this.membership = membership;
    }

    public Integer getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Integer firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Integer getOrderingId() {
        return orderingId;
    }

    public void setOrderingId(Integer orderingId) {
        this.orderingId = orderingId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public Integer getExtraChargeIngredients() {
        return extraChargeIngredients;
    }

    public void setExtraChargeIngredients(Integer extraChargeIngredients) {
        this.extraChargeIngredients = extraChargeIngredients;
    }

    public Object getLastOfflineDate() {
        return lastOfflineDate;
    }

    public void setLastOfflineDate(Object lastOfflineDate) {
        this.lastOfflineDate = lastOfflineDate;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getLogoThumb() {
        return logoThumb;
    }

    public void setLogoThumb(String logoThumb) {
        this.logoThumb = logoThumb;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public Integer getCartItemsCount() {
        return cartItemsCount;
    }

    public void setCartItemsCount(Integer cartItemsCount) {
        this.cartItemsCount = cartItemsCount;
    }

    public Object getWorkHour() {
        return workHour;
    }

    public void setWorkHour(Object workHour) {
        this.workHour = workHour;
    }

    public List<WeekWorkModel> getWeekWorkHour() {
        return weekWorkHour;
    }

    public void setWeekWorkHour(List<WeekWorkModel> weekWorkHour) {
        this.weekWorkHour = weekWorkHour;
    }

    public List<ImageModelRestaurant> getImages() {
        return images;
    }

    public void setImages(List<ImageModelRestaurant> images) {
        this.images = images;
    }
}

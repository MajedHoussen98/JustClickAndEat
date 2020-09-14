package ps.ns.just_click_and_eat.network.asp.model.menu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Menu {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("rst_id")
    @Expose
    private Integer rstId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("lang_id")
    @Expose
    private Integer langId;

    @SerializedName("is_promotion")
    @Expose
    private Integer isPromotion;

    @SerializedName("day1")
    @Expose
    private Integer day1;

    @SerializedName("day2")
    @Expose
    private Integer day2;

    @SerializedName("day3")
    @Expose
    private Integer day3;

    @SerializedName("day4")
    @Expose
    private Integer day4;

    @SerializedName("day5")
    @Expose
    private Integer day5;

    @SerializedName("day6")
    @Expose
    private Integer day6;

    @SerializedName("day7")
    @Expose
    private Integer day7;

    @SerializedName("is_active")
    @Expose
    private Integer isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRstId() {
        return rstId;
    }

    public void setRstId(Integer rstId) {
        this.rstId = rstId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public Integer getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Integer isPromotion) {
        this.isPromotion = isPromotion;
    }

    public Integer getDay1() {
        return day1;
    }

    public void setDay1(Integer day1) {
        this.day1 = day1;
    }

    public Integer getDay2() {
        return day2;
    }

    public void setDay2(Integer day2) {
        this.day2 = day2;
    }

    public Integer getDay3() {
        return day3;
    }

    public void setDay3(Integer day3) {
        this.day3 = day3;
    }

    public Integer getDay4() {
        return day4;
    }

    public void setDay4(Integer day4) {
        this.day4 = day4;
    }

    public Integer getDay5() {
        return day5;
    }

    public void setDay5(Integer day5) {
        this.day5 = day5;
    }

    public Integer getDay6() {
        return day6;
    }

    public void setDay6(Integer day6) {
        this.day6 = day6;
    }

    public Integer getDay7() {
        return day7;
    }

    public void setDay7(Integer day7) {
        this.day7 = day7;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", rstId=" + rstId +
                ", name='" + name + '\'' +
                ", langId=" + langId +
                ", isPromotion=" + isPromotion +
                ", day1=" + day1 +
                ", day2=" + day2 +
                ", day3=" + day3 +
                ", day4=" + day4 +
                ", day5=" + day5 +
                ", day6=" + day6 +
                ", day7=" + day7 +
                ", isActive=" + isActive +
                '}';
    }
}

package ps.ns.just_click_and_eat.network.asp.model.meals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pivot {

    @SerializedName("tag_id")
    @Expose
    private Integer tagId;
    @SerializedName("favorite_id")
    @Expose
    private Integer favoriteId;
    @SerializedName("favorite_type")
    @Expose
    private String favoriteType;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    public String getFavoriteType() {
        return favoriteType;
    }

    public void setFavoriteType(String favoriteType) {
        this.favoriteType = favoriteType;
    }
}

package ps.ns.just_click_and_eat.network.asp.model.HomeActivity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageRestaurant {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;

    @SerializedName("image_url")
    @Expose
    private String imageUrl;

    @SerializedName("image_thumb")
    @Expose
    private String imageThumb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageThumb() {
        return imageThumb;
    }

    public void setImageThumb(String imageThumb) {
        this.imageThumb = imageThumb;
    }
}

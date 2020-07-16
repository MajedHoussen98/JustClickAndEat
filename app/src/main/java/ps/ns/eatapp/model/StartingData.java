package ps.ns.eatapp.model;

import android.graphics.drawable.Drawable;

public class StartingData {

    int imageStart;
    String titleStart;
    String description;
    int imageCircle;


    public StartingData(int imageStart, String titleStart, String description, int imageCircle) {
        this.imageStart = imageStart;
        this.titleStart = titleStart;
        this.description = description;
        this.imageCircle = imageCircle;
    }


    public int getImageStart() {
        return imageStart;
    }

    public void setImageStart(int imageStart) {
        this.imageStart = imageStart;
    }

    public String getTitleStart() {
        return titleStart;
    }

    public void setTitleStart(String titleStart) {
        this.titleStart = titleStart;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageCircle() {
        return imageCircle;
    }

    public void setImageCircle(int imageCircle) {
        this.imageCircle = imageCircle;
    }
}

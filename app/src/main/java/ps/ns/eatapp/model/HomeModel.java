package ps.ns.eatapp.model;

public class HomeModel {

    int resturant_pic;
    String resturant_name;
    String resturant_status;
    String resturant_address;
    Float resturant_rating;
    Float rating_number;

    public HomeModel(int resturant_pic, String resturant_name, String resturant_status, String resturant_address, Float resturant_rating, Float rating_number) {
        this.resturant_pic = resturant_pic;
        this.resturant_name = resturant_name;
        this.resturant_status = resturant_status;
        this.resturant_address = resturant_address;
        this.resturant_rating = resturant_rating;
        this.rating_number = rating_number;
    }

    public int getResturant_pic() {
        return resturant_pic;
    }

    public void setResturant_pic(int resturant_pic) {
        this.resturant_pic = resturant_pic;
    }

    public String getResturant_name() {
        return resturant_name;
    }

    public void setResturant_name(String resturant_name) {
        this.resturant_name = resturant_name;
    }

    public String getResturant_status() {
        return resturant_status;
    }

    public void setResturant_status(String resturant_status) {
        this.resturant_status = resturant_status;
    }

    public String getResturant_address() {
        return resturant_address;
    }

    public void setResturant_address(String resturant_address) {
        this.resturant_address = resturant_address;
    }

    public Float getResturant_rating() {
        return resturant_rating;
    }

    public void setResturant_rating(Float resturant_rating) {
        this.resturant_rating = resturant_rating;
    }

    public Float getRating_number() {
        return rating_number;
    }

    public void setRating_number(Float rating_number) {
        this.rating_number = rating_number;
    }
}

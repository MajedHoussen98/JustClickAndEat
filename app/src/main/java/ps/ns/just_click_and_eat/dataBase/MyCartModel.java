package ps.ns.just_click_and_eat.dataBase;

public class MyCartModel {

    String meal_pic;
    String meal_name;
    String meal_description;
    String meal_price;
    String meal_quantity;

    public MyCartModel() {
    }

    public MyCartModel(String meal_pic, String meal_name, String meal_description, String meal_price, String meal_quantity) {
        this.meal_pic = meal_pic;
        this.meal_name = meal_name;
        this.meal_description = meal_description;
        this.meal_price = meal_price;
        this.meal_quantity = meal_quantity;
    }

    public String getMeal_pic() {
        return meal_pic;
    }

    public void setMeal_pic(String meal_pic) {
        this.meal_pic = meal_pic;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }

    public String getMeal_description() {
        return meal_description;
    }

    public void setMeal_description(String meal_description) {
        this.meal_description = meal_description;
    }

    public String getMeal_price() {
        return meal_price;
    }

    public void setMeal_price(String meal_price) {
        this.meal_price = meal_price;
    }

    public String getMeal_quantity() {
        return meal_quantity;
    }

    public void setMeal_quantity(String meal_quantity) {
        this.meal_quantity = meal_quantity;
    }
}

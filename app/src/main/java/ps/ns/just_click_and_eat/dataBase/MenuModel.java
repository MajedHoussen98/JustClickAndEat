package ps.ns.just_click_and_eat.dataBase;

public class MenuModel {

    String mealsPic;
    String mealsName;
    String mealsBody;
    String mealsPrice;

    public MenuModel(String mealsPic, String mealsName, String mealsBody, String mealsPrice) {
        this.mealsPic = mealsPic;
        this.mealsName = mealsName;
        this.mealsBody = mealsBody;
        this.mealsPrice = mealsPrice;
    }


    public String getMealsPic() {
        return mealsPic;
    }

    public void setMealsPic(String mealsPic) {
        this.mealsPic = mealsPic;
    }

    public String getMealsName() {
        return mealsName;
    }

    public void setMealsName(String mealsName) {
        this.mealsName = mealsName;
    }

    public String getMealsBody() {
        return mealsBody;
    }

    public void setMealsBody(String mealsBody) {
        this.mealsBody = mealsBody;
    }

    public String getMealsPrice() {
        return mealsPrice;
    }

    public void setMealsPrice(String mealsPrice) {
        this.mealsPrice = mealsPrice;
    }
}

package ps.ns.eatapp.model;

public class MealsFavoritesModel {

    String mealsPicFavorites;
    String mealsNameFavorites;
    String mealsBodyFavorites;
    String mealsPriceFavorites;

    public MealsFavoritesModel(String mealsPicFavorites, String mealsNameFavorites, String mealsBodyFavorites, String mealsPriceFavorites) {
        this.mealsPicFavorites = mealsPicFavorites;
        this.mealsNameFavorites = mealsNameFavorites;
        this.mealsBodyFavorites = mealsBodyFavorites;
        this.mealsPriceFavorites = mealsPriceFavorites;
    }


    public String getMealsPicFavorites() {
        return mealsPicFavorites;
    }

    public void setMealsPicFavorites(String mealsPicFavorites) {
        this.mealsPicFavorites = mealsPicFavorites;
    }

    public String getMealsNameFavorites() {
        return mealsNameFavorites;
    }

    public void setMealsNameFavorites(String mealsNameFavorites) {
        this.mealsNameFavorites = mealsNameFavorites;
    }

    public String getMealsBodyFavorites() {
        return mealsBodyFavorites;
    }

    public void setMealsBodyFavorites(String mealsBodyFavorites) {
        this.mealsBodyFavorites = mealsBodyFavorites;
    }

    public String getMealsPriceFavorites() {
        return mealsPriceFavorites;
    }

    public void setMealsPriceFavorites(String mealsPriceFavorites) {
        this.mealsPriceFavorites = mealsPriceFavorites;
    }
}

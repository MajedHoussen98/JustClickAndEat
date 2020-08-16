package ps.ns.just_click_and_eat.model;

public class RestaurantsFavoritesModel {

    String restaurantsPicFavorites;
    String restaurantsNameFavorites;
    String restaurantsBodyFavorites;

    public RestaurantsFavoritesModel(String restaurantsPicFavorites, String restaurantsNameFavorites, String restaurantsBodyFavorites) {
        this.restaurantsPicFavorites = restaurantsPicFavorites;
        this.restaurantsNameFavorites = restaurantsNameFavorites;
        this.restaurantsBodyFavorites = restaurantsBodyFavorites;
    }

    public String getRestaurantsPicFavorites() {
        return restaurantsPicFavorites;
    }

    public void setRestaurantsPicFavorites(String restaurantsPicFavorites) {
        this.restaurantsPicFavorites = restaurantsPicFavorites;
    }

    public String getRestaurantsNameFavorites() {
        return restaurantsNameFavorites;
    }

    public void setRestaurantsNameFavorites(String restaurantsNameFavorites) {
        this.restaurantsNameFavorites = restaurantsNameFavorites;
    }

    public String getRestaurantsBodyFavorites() {
        return restaurantsBodyFavorites;
    }

    public void setRestaurantsBodyFavorites(String restaurantsBodyFavorites) {
        this.restaurantsBodyFavorites = restaurantsBodyFavorites;
    }
}

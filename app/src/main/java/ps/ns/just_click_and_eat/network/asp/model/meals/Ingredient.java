package ps.ns.just_click_and_eat.network.asp.model.meals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ingredient {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("max_free_ingredients")
    @Expose
    private Integer maxFreeIngredients;
    @SerializedName("data")
    @Expose
    private List<IngredientData> data = null;
}

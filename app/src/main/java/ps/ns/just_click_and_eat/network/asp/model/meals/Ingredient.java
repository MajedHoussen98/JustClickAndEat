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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxFreeIngredients() {
        return maxFreeIngredients;
    }

    public void setMaxFreeIngredients(Integer maxFreeIngredients) {
        this.maxFreeIngredients = maxFreeIngredients;
    }

    public List<IngredientData> getData() {
        return data;
    }

    public void setData(List<IngredientData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", maxFreeIngredients=" + maxFreeIngredients +
                ", data=" + data +
                '}';
    }
}

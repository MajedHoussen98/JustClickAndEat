package ps.ns.just_click_and_eat.network.asp.model.cart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ps.ns.just_click_and_eat.network.asp.model.meals.IngredientData;
import ps.ns.just_click_and_eat.network.asp.model.meals.Meals;

public class CartItem {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("item_id")
    @Expose
    private Integer itemId;
    @SerializedName("size_id")
    @Expose
    private Integer sizeId;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("ingredients")
    @Expose
    private List<IngredientData> ingredients = null;
    @SerializedName("my_size")
    @Expose
    private String mySize;
    @SerializedName("meal")
    @Expose
    private Meals meal;
    @SerializedName("meal_size")
    @Expose
    private Object mealSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<IngredientData> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientData> ingredients) {
        this.ingredients = ingredients;
    }

    public String getMySize() {
        return mySize;
    }

    public void setMySize(String mySize) {
        this.mySize = mySize;
    }

    public Meals getMeal() {
        return meal;
    }

    public void setMeal(Meals meal) {
        this.meal = meal;
    }

    public Object getMealSize() {
        return mealSize;
    }

    public void setMealSize(Object mealSize) {
        this.mealSize = mealSize;
    }
}

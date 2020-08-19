package ps.ns.just_click_and_eat.network.asp.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaginationBean {

    @SerializedName("data")
    @Expose
    Object data;

    @SerializedName("total_pages")
    @Expose
    int totalPages;

    @SerializedName("current_page")
    @Expose
    int currentPage;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public String getResult() {
        return new Gson().toJson(data);
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}

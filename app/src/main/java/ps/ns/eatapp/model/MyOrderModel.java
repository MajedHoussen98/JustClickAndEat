package ps.ns.eatapp.model;

public class MyOrderModel {

    String orderId;
    String orderDescription;
    String orderPrice;
    String orderTime;
    String orderStatus;

    public MyOrderModel() {
    }

    public MyOrderModel(String orderId, String orderDescription, String orderPrice, String orderTime, String orderStatus) {
        this.orderId = orderId;
        this.orderDescription = orderDescription;
        this.orderPrice = orderPrice;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}

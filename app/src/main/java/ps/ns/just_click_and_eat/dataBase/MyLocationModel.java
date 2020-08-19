package ps.ns.just_click_and_eat.dataBase;

public class MyLocationModel {

    String addressName;
    String detailsAddress;

    public MyLocationModel(String addressName, String detailsAddress) {
        this.addressName = addressName;
        this.detailsAddress = detailsAddress;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getDetailsAddress() {
        return detailsAddress;
    }

    public void setDetailsAddress(String detailsAddress) {
        this.detailsAddress = detailsAddress;
    }
}

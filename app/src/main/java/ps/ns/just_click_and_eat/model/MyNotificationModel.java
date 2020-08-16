package ps.ns.just_click_and_eat.model;

public class MyNotificationModel {

    String notificationPic;
    String notificationTitle;
    String notificationBody;
    String notificationTime;

    public MyNotificationModel(String notificationPic, String notificationTitle, String notificationBody, String notificationTime) {
        this.notificationPic = notificationPic;
        this.notificationTitle = notificationTitle;
        this.notificationBody = notificationBody;
        this.notificationTime = notificationTime;
    }

    public String getNotificationPic() {
        return notificationPic;
    }

    public void setNotificationPic(String notificationPic) {
        this.notificationPic = notificationPic;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationBody() {
        return notificationBody;
    }

    public void setNotificationBody(String notificationBody) {
        this.notificationBody = notificationBody;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }
}

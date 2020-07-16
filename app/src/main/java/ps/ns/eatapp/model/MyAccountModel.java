package ps.ns.eatapp.model;

public class MyAccountModel {

    String titleEditAccount;
    String bodyEditAccount;

    public MyAccountModel(String titleEditAccount, String bodyEditAccount) {
        this.titleEditAccount = titleEditAccount;
        this.bodyEditAccount = bodyEditAccount;
    }


    public String getTitleEditAccount() {
        return titleEditAccount;
    }

    public void setTitleEditAccount(String titleEditAccount) {
        this.titleEditAccount = titleEditAccount;
    }

    public String getBodyEditAccount() {
        return bodyEditAccount;
    }

    public void setBodyEditAccount(String bodyEditAccount) {
        this.bodyEditAccount = bodyEditAccount;
    }
}

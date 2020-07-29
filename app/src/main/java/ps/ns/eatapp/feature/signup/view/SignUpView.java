package ps.ns.eatapp.feature.signup.view;

import ps.ns.eatapp.utils.BaseView;

public interface SignUpView extends BaseView {


    void formData(String name , String email, String mobile, String password, String confirmPassword);

}

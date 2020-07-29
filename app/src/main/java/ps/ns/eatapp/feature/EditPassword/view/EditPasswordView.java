package ps.ns.eatapp.feature.EditPassword.view;

import ps.ns.eatapp.utils.BaseView;

public interface EditPasswordView extends BaseView {

    void formData(String currentPassword, String newPassword, String confirmPassword);
}

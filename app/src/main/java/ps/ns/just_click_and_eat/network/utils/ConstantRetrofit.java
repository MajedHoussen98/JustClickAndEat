package ps.ns.just_click_and_eat.network.utils;

public interface ConstantRetrofit {

    public static final String BASE_URL = "https://justclickandeat.ca/api/v1/";
    String AUTHORIZATION = "token";
    String BEARER = "Bearer ";
    String BASE_URL_GOOGLE = "https://maps.googleapis.com/maps/api/";

    /// keys after register app
    String HEADER_CONTENT_TYPE = "Content-Type";
    String HEADER_ACCEPT_LANGUAGE = "Accept-Language";
    String ANDROID = "android";
    String ACCEPT_TYPE = "application/json";
    String CONTENT_TYPE = "application/x-www-form-urlencoded";
    String CONTENT_TYPE_MULTI_PART = "multipart/form-data";
    String HTTP_METHOD_OVERRIDE = "X-HTTP-Method-Override";
    String HTTP_PUT_TYPE = "PUT";
    String HTTP_DELETE_TYPE = "DELETE";
    String HEADER_ACCEPT_TYPE = "Accept";
    // String BEARER = "";
    String CLIENT_SECRET = "client_secret";
    String CLIENT_SECRET_VALUE = "Fb5oeK1kIgMA7SgXwP80eL54wmNchnq4gerKuru7";
    String GRANT_TYPE_KEY = "grant_type";
    String PASSWORD_GRANT_TYPE_VALUE = "password";
    String SOCIAL_GRANT_TYPE_VALUE = "social";
    String CLIENT_ID_KEY = "client_id";
    String CLIENT_ID_VALUE = "2";
    String REFRESH_TOKEN_KEY = "refresh_token";
    String REFRESH_TOKEN_GRANT_TYPE_VALUE = "refresh_token";
    int REFRESH_TOKEN_COD = 401;
    int EMPTY_CODE = 422;

    // login and sign up screen
    String FIRST_NAME_KEY = "first_name";
    String LAST_NAME_KEY = "last_name";
    String USERNAME_KEY = "username";
    String EMAIL_KEY = "email";
    String PASSWORD_KEY = "password";
    String DOB_KEY = "dob";
    String LANGUAGE_KEY = "language";
    String GENDER_KEY = "gender";
    String COUNTRY_ID_KEY = "country_id";
    String CITY_ID_KEY = "city_id";
    String PHONE_NUMBER_KEY = "phone_number";
    String DEVICE_TYPE_KEY = "os";
    String FCM_TOKEN_KEY = "fcmToken";
    String LAT_KEY = "lat";
    String LNG_KEY = "lng";

    String USER_ID = "user_id";
    String ID = "id";
    String NAME_KEY = "name";
    String CONFIRM_PASSWORD_KEY = "password_confirmation";
    String MOBILE_KEY = "mobile";
    String COUNTRY_CODE_KEY = "country_code";
    String DEVICE_ID_KEY = "device_id";
    String ACCESS_TOKEN_KEY = "access_token";
    String USER_TYPE_KEY = "user_type";
    String SERVICE_PROVIDER_TYPE_KEY = "sp_type";
    String GOOGLE_TYPE_VALUE = "google";
    String FACEBOOK_TYPE_VALUE = "facebook";

    // user type and sp type
    String TYPE_USER = "user";
    String TYPE_SERVICE_PROVIDER = "service-provider";
    String SERVICE_PROVIDER_INDIVIDUAL = "individual";
    String SERVICE_PROVIDER_COMPANY = "company";

    //type of services
    String SERVICE_TYPE = "service";
    String GOODS_TYPE = "goods";

    // type of payment
    String WHOLE_SERVICES = "whole-service";
    String PER_HOUR = "per-hour";

    // order status
    String PENDING_STATUS = "pending";
    String IN_PROGRESS_STATUS = "in-progress";
    String COMPLETED_STATUS = "completed";
    String CANCELED_STATUS = "canceled";
    String ASSIGNED_STATUS = "in-progress";

    // jobs status
    String AVAILABLE_TAB = "available";
    String SUBMITTED_TAB = "submitted";
    String INVITATIONS_TAB = "invitations";
    String ARCHIVE_TAB = "archive";
    String MY_SERVICES_TAB = "my-services";

    // type of estimated times
    String LESS_THAN_ONE_HOUR = "less than one hour";
    String ONE_TO_THREE_HOURS = "1 to 3 hours";
    String THREE_TO_SIX_HOURS = "3 to 6 hours";
    String MORE_THAN_SIX_HOUR = "more than 6 hours";

    // verification
    String CODE_KEY = "verify_code";


    String LATITUDE_KEY = "latitude";
    String LONGITUDE_KEY = "longitude";
    String FILTER_KEY = "filter";


    String LANGUAGE = "Accept-Language";

    //pagination
    String PAGE_SIZE = "page_size";
    int NUM_ROWS_VALUE = 10;
    String PAGE_NUMBER = "page_number";
    String SEARCH_KEY = "search";

    //file types
    String VIDEO_TYPE = "video";


    // notifications actions
    String RATE_ACTION = "rate";
    String HIRE_ACTION = "hire";

}

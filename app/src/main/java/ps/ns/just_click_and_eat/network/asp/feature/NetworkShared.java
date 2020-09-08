package ps.ns.just_click_and_eat.network.asp.feature;

public class NetworkShared {

    private static ASP asp;

    public static ASP getAsp() {
        if (asp == null)
            asp = new ASP();
        return asp;
    }

    public static class ASP {

        private General mGeneral;
        private User mUser;
        private Location mLocation;
        private Favorites mFavorites;

        private ASP() {
            mGeneral = new General();
            mUser = new User();
            mLocation = new Location();
            mFavorites = new Favorites();
        }

        public General getGeneral() {
            return mGeneral;
        }

        public User getUser() {
            return mUser;
        }

        public Location getLocation() {
            return mLocation;
        }

        public Favorites getFavorites() {
            return mFavorites;
        }

    }
}

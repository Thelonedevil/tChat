package ml.tchat.plugins.bot.users;


public class User {
    private final String userName;
    private UserLevel userLevel;

    public User(String userName, UserLevel userLevel) {
        this.userName = userName;
        this.userLevel = userLevel;
    }

    public User(String userName) {
        this(userName, UserLevel.DEFAULT);
    }

    public String getUserName() {
        return userName;
    }

    public UserLevel getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(UserLevel userLevel) {
        this.userLevel = userLevel;
    }
}

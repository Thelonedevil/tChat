package ml.tchat.plugins.bot.users;


public enum UserLevel {
    DEFAULT(0), SUBSCRIBER(3), REGULAR(5), MODERATOR(10), SUPER_MODERATOR(15), BROADCASTER(20), NO_ONE(100);

    private final int value;

    UserLevel(int userLevel) {
        this.value = userLevel;
    }

    public int getValue() {
        return value;
    }
}

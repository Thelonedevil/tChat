package ml.tchat.plugins.bot.commands;


import ml.tchat.plugins.bot.users.User;
import ml.tchat.plugins.bot.users.UserLevel;

public class BotCommand {
    private String name;
    private boolean responding;
    private String response;
    private UserLevel minUserLevel;
    private int count;

    private UserLevel nameModifyingUL;
    private UserLevel responseModifyingUL;
    private UserLevel userLevelModifyingUL;

    public BotCommand(String name, boolean responding, String response, UserLevel minUserLevel, UserLevel nameModifyingUL, UserLevel responseModifyingUL, UserLevel userLevelModifyingUL) {
        this.name = name;
        this.responding = responding;
        this.response = response;
        this.minUserLevel = minUserLevel;
        this.nameModifyingUL = nameModifyingUL;
        this.responseModifyingUL = responseModifyingUL;
        this.userLevelModifyingUL = userLevelModifyingUL;
        this.count = 0;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name, UserLevel userLevel) {
        if (userLevel.getValue() >= this.nameModifyingUL.getValue()) {
            this.name = name;
            return true;
        }
        return false;
    }

    public boolean setName(String name, User user) {
        return this.setName(name, user.getUserLevel());
    }

    public boolean isResponding() {
        return responding;
    }

    public boolean setResponding(boolean responding, UserLevel userLevel) {
        if (userLevel.getValue() >= this.responseModifyingUL.getValue()) {
            this.responding = responding;
            return true;
        }
        return false;
    }

    public boolean setResponding(boolean responding, User user) {
        return this.setResponding(responding, user.getUserLevel());
    }

    public String getResponse() {
        return response;
    }

    public boolean setResponse(String response, UserLevel userLevel) {
        if (userLevel.getValue() >= this.responseModifyingUL.getValue()) {
            this.response = response;
            return true;
        }
        return false;
    }

    public boolean setResponse(String response, User user) {
        return this.setResponse(response, user.getUserLevel());
    }

    public UserLevel getMinUserLevel() {
        return minUserLevel;
    }

    public boolean setMinUserLevel(UserLevel minUserLevel, UserLevel userLevel) {
        if (userLevel.getValue() >= this.userLevelModifyingUL.getValue()) {
            this.minUserLevel = minUserLevel;
            return true;
        }
        return false;
    }

    public boolean setMinUserLevel(UserLevel minUserLevel, User user) {
        return this.setMinUserLevel(minUserLevel, user.getUserLevel());
    }

    public boolean meetsUserLevel(UserLevel userLevel) {
        return (userLevel.getValue() >= this.minUserLevel.getValue());
    }

    public boolean meetsUserLevel(User user) {
        return meetsUserLevel(user.getUserLevel());
    }

    public UserLevel getNameModifyingUL() {
        return nameModifyingUL;
    }

    public boolean setNameModifyingUL(UserLevel nameModifyingUL, UserLevel userLevel) {
        if (userLevel.getValue() >= this.userLevelModifyingUL.getValue()) {
            this.nameModifyingUL = nameModifyingUL;
            return true;
        }
        return false;
    }

    public boolean setNameModifyingUL(UserLevel nameModifyingUL, User user) {
        return this.setNameModifyingUL(nameModifyingUL, user.getUserLevel());
    }

    public UserLevel getResponseModifyingUL() {
        return responseModifyingUL;
    }

    public boolean setResponseModifyingUL(UserLevel responseModifyingUL, UserLevel userLevel) {
        if (userLevel.getValue() >= this.userLevelModifyingUL.getValue()) {
            this.responseModifyingUL = responseModifyingUL;
            return true;
        }
        return false;
    }

    public boolean setResponseModifyingUL(UserLevel responseModifyingUL, User user) {
        return this.setResponseModifyingUL(responseModifyingUL, user.getUserLevel());
    }

    public UserLevel getUserLevelModifyingUL() {
        return userLevelModifyingUL;
    }

    public boolean setUserLevelModifyingUL(UserLevel userLevelModifyingUL, UserLevel userLevel) {
        if (userLevel.getValue() >= this.userLevelModifyingUL.getValue() && userLevel.getValue() >= this.userLevelModifyingUL.getValue()) {
            this.userLevelModifyingUL = userLevelModifyingUL;
            return true;
        }
        return false;
    }

    public boolean setUserLevelModifyingUL(UserLevel userLevelModifyingUL, User user) {
        return this.setUserLevelModifyingUL(userLevelModifyingUL, user.getUserLevel());
    }

    public int getCount() {
        return count;
    }

    // TODO perms?
    public void incrementCount() {
        count++;
    }

    public void resetCount() { count = 0; }
}

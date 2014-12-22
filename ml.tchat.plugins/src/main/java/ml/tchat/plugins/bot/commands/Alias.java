package ml.tchat.plugins.bot.commands;

import ml.tchat.plugins.bot.users.User;
import ml.tchat.plugins.bot.users.UserLevel;

public class Alias {
    private String name;
    private String command;
    private UserLevel modifyingUL;

    public Alias(String name, String command, UserLevel modifyingUL) {
        this.name = name;
        this.command = command;
        this.modifyingUL = modifyingUL;
    }

    public Alias(String name, String command) {
        this(name, command, UserLevel.DEFAULT);
    }

    public boolean setName(String name, UserLevel userLevel) {
        if (userLevel.getValue() >= this.modifyingUL.getValue()) {
            this.name = name;
            return true;
        }
        return false;
    }

    public boolean setName(String name, User user) {
        return this.setName(name, user.getUserLevel());
    }

    public boolean setName(String name) {
        return this.setName(name, UserLevel.DEFAULT);
    }

    public String getName() {
        return name;
    }

    public boolean setCommand(String command, UserLevel userLevel) {
        if (userLevel.getValue() >= this.modifyingUL.getValue()) {
            this.command = command;
            return true;
        }
        return false;
    }

    public boolean setCommand(String command, User user) {
        return this.setCommand(command, user.getUserLevel());
    }

    public boolean setCommand(String command) {
        return this.setCommand(command, UserLevel.DEFAULT);
    }

    public String getCommand() {
        return command;
    }

    public boolean setModifyingUL(UserLevel modifyingUL, UserLevel userLevel) {
        if (userLevel.getValue() >= this.modifyingUL.getValue()) {
            this.modifyingUL = modifyingUL;
            return true;
        }
        return false;
    }

    public boolean setModifyingUL(UserLevel modifyingUL, User user) {
        return this.setModifyingUL(modifyingUL, user.getUserLevel());
    }

    public boolean setModifyingUL(UserLevel modifyingUL) {
        return this.setModifyingUL(modifyingUL, UserLevel.DEFAULT);
    }

    public UserLevel getModifyingUL() {
        return modifyingUL;
    }
}

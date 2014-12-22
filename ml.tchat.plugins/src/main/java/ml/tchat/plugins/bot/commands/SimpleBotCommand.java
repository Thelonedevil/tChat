package ml.tchat.plugins.bot.commands;

import ml.tchat.plugins.bot.users.UserLevel;

public class SimpleBotCommand extends BotCommand {

    public SimpleBotCommand(String name, boolean responding, String response, UserLevel minUserLevel) {
        super(name, responding, response, minUserLevel, UserLevel.DEFAULT, UserLevel.DEFAULT, UserLevel.DEFAULT);
    }

    public SimpleBotCommand(String name, String response, UserLevel minUserLevel) {
        this(name, true, response, minUserLevel);
    }

    public SimpleBotCommand(String name, String response) {
        this(name, true, response, UserLevel.DEFAULT);
    }

    public SimpleBotCommand(String name, UserLevel minUserLevel) {
        this(name, false, "", minUserLevel);
    }

    public void setName(String name) {
        setName(name, UserLevel.DEFAULT);
    }

    public void setResponding(boolean responding) {
        setResponding(responding, UserLevel.DEFAULT);
    }

    public void setResponse(String response) {
        setResponse(response, UserLevel.DEFAULT);
    }

    public void setMinUserLevel(UserLevel minUserLevel) {
        setMinUserLevel(minUserLevel, UserLevel.DEFAULT);
    }
}

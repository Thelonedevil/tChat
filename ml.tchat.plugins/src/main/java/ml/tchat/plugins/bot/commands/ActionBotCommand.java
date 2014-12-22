package ml.tchat.plugins.bot.commands;

import ml.tchat.plugins.bot.users.User;
import ml.tchat.plugins.bot.users.UserLevel;


public class ActionBotCommand extends BotCommand {
    private boolean enabled;
    private String script; // TODO figure out how to set up/run
    private UserLevel actionModifyingUL;

    public ActionBotCommand(String command, boolean responding, String response, UserLevel minUserLevel, UserLevel commandModifyingUL, UserLevel responseModifyingUL, UserLevel userLevelModifyingUL, boolean enabled, String script, UserLevel actionModifyingUL) {
        super(command, responding, response, minUserLevel, commandModifyingUL, responseModifyingUL, userLevelModifyingUL);
        this.enabled = enabled;
        this.script = script;
        this.actionModifyingUL = actionModifyingUL;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public boolean setEnabled(boolean enabled, UserLevel userLevel) {
        if (userLevel.getValue() >= this.actionModifyingUL.getValue()) {
            this.enabled = enabled;
            return true;
        }
        return false;
    }

    public boolean setEnabled(boolean enabled, User user) {
        return this.setEnabled(enabled, user.getUserLevel());
    }

    public String getScript() {
        return script;
    }

    public boolean setScript(String script, UserLevel userLevel) {
        if (userLevel.getValue() >= this.actionModifyingUL.getValue()) {
            this.script = script;
            return true;
        }
        return false;
    }

    public boolean setScript(String script, User user) {
        return this.setScript(script, user.getUserLevel());
    }

    public UserLevel getActionModifyingUL() {
        return actionModifyingUL;
    }

    public boolean setActionModifyingUL(UserLevel actionModifyingUL, UserLevel userLevel) {
        if (userLevel.getValue() >= this.getUserLevelModifyingUL().getValue()) {
            this.actionModifyingUL = actionModifyingUL;
            return true;
        }
        return false;
    }

    public boolean setActionModifyingUL(UserLevel actionModifyingUL, User user) {
        return this.setActionModifyingUL(actionModifyingUL, user.getUserLevel());
    }
}

package ml.tchat.plugins.bot.commands.scripts

import ml.tchat.plugins.bot.commands.SimpleBotCommand
import ml.tchat.plugins.bot.users.UserLevel


class AddcomScript {
    static void main(String[] args) {
        String name = args[0]
        UserLevel ul = UserLevel.DEFAULT
        SimpleBotCommand newCommand
        String response = "";

        // TODO deal with UL of user running command

        if (args[1] ==~ /^--ul=.*/) {
            switch (args[1]) {
                case "--ul=sub":
                    ul = UserLevel.SUBSCRIBER
                    break
                case "--ul=reg":
                    ul = UserLevel.REGULAR
                    break
                case "--ul=mod":
                    ul = UserLevel.MODERATOR
                    break
                case "--ul=smod":
                    ul = UserLevel.SUPER_MODERATOR
                    break
                case "--ul=bc":
                    ul = UserLevel.BROADCASTER
                    break
                case "--ul=default":
                case "--ul=none":
                case "--ul=any":
                case "--ul=all":
                    ul = UserLevel.DEFAULT
                    break
                default:
                    // TODO deal with invalid arg here
                    break
            }

            for (int i = 2; i < args.size(); i++) {
                response += args[i]
            }
            newCommand = new SimpleBotCommand(name, response, ul)
        }
        else {
            for (int i = 1; i < args.size(); i++) {
                response += args[i]
            }
            newCommand = new SimpleBotCommand(name, response)
        }

        // TODO add command to some database or something
    }
}

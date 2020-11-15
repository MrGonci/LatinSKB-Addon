package net.latinplay.skb.Utils.Interfaces;

public interface ServerSender extends SKAddon {
    static void send(String input) {
        plugin.getServer().getConsoleSender().sendMessage(StringUtils.toColor(input));
    }

    static void send(String input, Object... replaces) {
        for (int i = 0; i < replaces.length; i++) {
            input = input.replace("{" + i + "}", replaces[i].toString());
        }
        send(input);
    }
}

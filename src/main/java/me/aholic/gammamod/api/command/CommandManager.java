package me.aholic.gammamod.api.command;

import me.aholic.gammamod.impl.commands.*;

import java.util.ArrayList;

public class CommandManager {

    public static ArrayList<Command> commandList;

    public CommandManager() {
        commandList =  new ArrayList<>();

        commandList.add(new GammaCommand());
    }

    public static ArrayList<Command> getCommands() {
        return commandList;
    }


    public static Command getCommandByName(String name) {
        for (Command c : getCommands()) {
            if (c.getName().equalsIgnoreCase(name)) return c;
        }
        return null;
    }

    public static void runCommand(String message) {
        try {
            String[] string = message.split("\\s+");
            String command = string[0];
            String args = message.substring(command.length()).trim();
            for (Command c : getCommands()) {
                if (c.getName().toLowerCase().startsWith(command.toLowerCase())) {
                    c.runCmd(args, args.split("\\s+"));
                    return;
                }
            }
        } catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}

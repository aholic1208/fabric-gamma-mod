package me.aholic.gammamod.impl.commands;

import me.aholic.gammamod.Helper;
import me.aholic.gammamod.api.command.Command;

public class GammaCommand extends Command {
    @Override
    public String getName() {
        return "Gamma";
    }

    @Override
    public String getDescription() {
        return "Changes in-game gamma.";
    }

    @Override
    public String getSyntax() {
        return "{prefix}gamma <value>";
    }

    @Override
    public void runCmd(String s, String[] args) {
        try {
            MC.options.gamma = Float.parseFloat(args[0]);
            Helper.sendLocalMessage(String.format("Your gamma has been changed to %s", args[0]));
        } catch (NumberFormatException e) {
            Helper.sendLocalMessage("That is not a float!");
        }
    }
}

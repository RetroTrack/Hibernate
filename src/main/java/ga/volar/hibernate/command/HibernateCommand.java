package ga.volar.hibernate.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import ga.volar.hibernate.Variables;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;


public class HibernateCommand {

    /*public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("hibernate").requires((source)
                -> source.hasPermissionLevel(2)).then(CommandManager.argument("args", EntityArgumentType.entities()).executes((context)
                -> execute(context.getSource(), StringArgumentType.getString(context, "args")))));
    }
    private static int execute(ServerCommandSource source, String args) {
        if(args.equalsIgnoreCase("")){
            Variables.enabled = !Variables.enabled;
            source.sendMessage(Text.literal("[Hibernate] Hibernate is now " + (Variables.enabled ? "enabled" : "disabled")));
            //this.saveConfig();
            return 1;
        }
        if(args.equalsIgnoreCase("reload")){
            //this.reloadConfig();
            return 1;
        }
        if(args.equalsIgnoreCase("status")) {
            source.sendMessage(Text.translatable("[Hibernate] Hibernation is currently ", Variables.enabled ? "enabled" : "disabled"));
            source.sendMessage(Text.translatable("[Hibernate] The server is currently ", source.getServer().getCurrentPlayerCount() == 0 && Variables.status ? "sleeping" : "awake"));
            return 1;
        }
        return 0;
    }

     */
}

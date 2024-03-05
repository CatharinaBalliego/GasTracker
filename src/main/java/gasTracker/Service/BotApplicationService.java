package gasTracker.Service;

import gasTracker.BotApplication;
import gasTracker.Listener;
import gasTracker.Model.Global;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;


public class BotApplicationService implements BotService{
    private JDA bot;

    public  BotApplicationService(){
        bot =  JDABuilder.createDefault(Global.JDAToken)
                .addEventListeners(new Listener())
                .setActivity(Activity.customStatus("Surfing on the internet"))
                .build();

    }

    public JDA starter() {
        CommandListUpdateAction commands = bot.updateCommands();

        commands.addCommands(Commands.slash("ping", "Calcula o ping do bot"));
        commands.addCommands(Commands.slash("gas", "Retorna a taxa de gas atual"));
        commands.addCommands(Commands.slash("trigger", "avisar quando o gas estiver abaixo de 20"));
        commands.addCommands(Commands.slash("stop", "Desativar notificação"));

        commands.queue();

        return bot;
    }


}

package gasTracker;

import gasTracker.Model.Global;
import gasTracker.Service.BotApplicationService;
import gasTracker.Service.BotService;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class BotApplication{

    private  BotService botService = new BotApplicationService();

    public BotApplication() {
        botService.starter();
    }
    public static void main(String[] args) throws InterruptedException {
       new BotApplication();
    }

}

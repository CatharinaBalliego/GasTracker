package gasTracker;

import gasTracker.Model.Global;
import gasTracker.Service.BotService;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;


public class Main extends ListenerAdapter {

    private static BotService botService;
    public static JDA bot;
    EtherscanApi etherApi = new EtherscanApi();


    public static void main(String[] args) throws InterruptedException {
       bot = botService.starter();
    }


    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        //event.deferReply().queue();
        switch (event.getName()) {
            case "ping":
                long time = System.currentTimeMillis();
                event.reply("Pong:  " + time).queue();
                break;

            case "start":
                event.reply("Safe gas price: " + etherApi.getCurrentGasPrice()).queue();
				break;

//			case "trigger":
//				Global.scheduledNotifcation = true;
//				//TextChannel textChannel = bot.get
//				if(textChannel.canTalk()) {
//					textChannel.sendMessage("").queue();
//				}
//				break;


            case "stop":
                Global.scheduledNotifcation = false;
                break;

            default:
                System.out.printf("Unknown command %s used by %#s %n", event.getName(), event.getUser());
                break;
        }
    }

}

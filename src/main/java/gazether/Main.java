package gazether;

import gazether.Model.Global;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;


public class Main extends ListenerAdapter {

	Api etherApi = new Api();
	public static void main(String[] args) throws InterruptedException {

		JDA bot = JDABuilder.createDefault(Global.JDAToken)
				.addEventListeners(new Main())
				.setActivity(Activity.customStatus("Surfing on the internet"))
				.build().awaitReady();
		
		CommandListUpdateAction commands = bot.updateCommands();
		
		commands.addCommands(Commands.slash("ping", "Calcula o ping do bot"));
		
		commands.addCommands(Commands.slash("start","Inicia a aplicação"));
		
		commands.queue();
	}

	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
		//event.deferReply().queue();
		switch(event.getName()) {
		case "ping":
			long time = System.currentTimeMillis();
			event.reply("Pong:  " + time).queue();
			//also send current eth fee
			break;
			
		case "start":
			Global.scheduledNotifcation = true;
			event.reply("Safe gas price: " + etherApi.getGwei()).queue();
			break;

		case "stop":
			Global.scheduledNotifcation = false;
			break;
			
		default:
			System.out.printf("Unknown command %s used by %#s %n", event.getName(), event.getUser());
			break;
		}
	}

}

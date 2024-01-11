package gazether;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Main extends ListenerAdapter{

	public static void main(String[] args) throws InterruptedException {

		JDA bot = JDABuilder.createDefault(Global.JDAToken)
				.addEventListeners(new Main())
				.setActivity(Activity.customStatus("Watching ETH gas fees"))
				//.addEventListeners(new BulkDeleteMessage())
				//.setBulkDeleteSplittingEnabled(true)
				.build().awaitReady();
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
			
		case "stop":
			Global.scheduledNotifcation = false;
			
		default:
			System.out.printf("Unknown command %s used by %#s %n", event.getName(), event.getUser());
		}
	}

}

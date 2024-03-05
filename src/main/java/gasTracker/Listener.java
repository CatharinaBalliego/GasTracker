package gasTracker;

import gasTracker.Model.Global;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener  extends ListenerAdapter {
    EtherscanApi etherApi = new EtherscanApi();
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        //event.deferReply().queue();
        switch (event.getName()) {
            case "ping":
                long time = System.currentTimeMillis();
                event.reply("Pong:  " + time).queue();
                break;

            case "gas":
                event.reply("Safe gas price: " + etherApi.getCurrentGasPrice()).queue();
                break;

			case "trigger":
                event.reply("Notificações ativadas").queue();
				Global.scheduledNotifcation = true;

                sendMessage(event);

				break;


            case "stop":
                event.reply("Notificações desativadas").queue();
                Global.scheduledNotifcation = false;
                break;

            default:
                System.out.printf("Unknown command %s used by %#s %n", event.getName(), event.getUser());
                break;
        }
    }
    private void sendMessage(SlashCommandInteractionEvent event){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TextChannel textChannel = event.getJDA().getTextChannelById("1195037384610422824");
        textChannel.sendMessage("Hello").queue();
    }
}

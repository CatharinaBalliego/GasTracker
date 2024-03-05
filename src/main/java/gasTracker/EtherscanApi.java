package gasTracker;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import gasTracker.Model.GasPriceMapper;
import gasTracker.Model.GasResponse;
import gasTracker.Model.Global;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class EtherscanApi {

	public GasResponse getCurrentGasPrice() {
		try {
			GasPriceMapper gas;

			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI(Global.EtherApi))
					.build();
			
			HttpClient httpClient = HttpClient.newHttpClient();

			HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
			
			if(response.statusCode() != 200) {
				System.out.println("erro ao conectar com a api");
			}
			
			else {
				var gasResponse = new GasResponse(GasPriceMapper.fromJson(response.body()));
				return gasResponse;
			}
			
		} catch(Exception e) {
			System.out.println("erro: " + e.getLocalizedMessage());
		}
		return null;
	}

	public void getLowGasPrice(SlashCommandInteractionEvent event) throws Exception {
		while (Global.scheduledNotifcation) {
			GasResponse gasResponse = getCurrentGasPrice();
			if (gasResponse.getProposeGasPrice() <= 25) {
				Global.scheduledNotifcation = false;

			}
			else {
				Thread.sleep(1000);
			}
		}
    }
}

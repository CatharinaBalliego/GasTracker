package gazether;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import gazether.Model.GasPriceResponse;
import gazether.Model.Global;

public class Api {

	public String getGwei() {
		try {
			GasPriceResponse gas;

			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI(Global.EtherApi))
					.build();
			
			HttpClient httpClient = HttpClient.newHttpClient();

			HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
			
			if(response.statusCode() != 200) {
				//wait
				//continue;
				return "Erro ao conectar com a API!";
			}
			
			else {

				gas = GasPriceResponse.fromJson(response.body());
				System.out.println(gas.getResult().getProposeGasPrice());
				return gas.getResult().getProposeGasPrice();
			}
			
		} catch(Exception e) {
			System.out.println("erro: " + e.getLocalizedMessage());
		}
		return "error";
		
	}
}

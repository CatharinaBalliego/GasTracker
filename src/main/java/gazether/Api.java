package gazether;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import gazether.Model.Gas;

public class Api {

	public String getGwei() {
		try {	
			Gas gas = new Gas();
			Gson gson = new Gson();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI("https://api.etherscan.io/api?module=gastracker&action=gasoracle&apiKey=B9ZVBJE4ZD94RBVM678Y2NBK9YQPUJJDWT"))
					.build();
			
			HttpClient httpClient = HttpClient.newHttpClient();

			HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
			
			if(response.statusCode() != 200) {
				//wait
				//continue;
				return "Erro ao conectar com a API!";
			}
			
			else {
				gas = gson.fromJson(response.body(), Gas.class);
				System.out.println(gas.getStatus());
				return response.body();
			}
			
		} catch(Exception e) {
			System.out.println("erro: " + e.getLocalizedMessage());
		}
		return "error";
		
	}
}

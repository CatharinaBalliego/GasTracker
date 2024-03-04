package gazether.Model;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Getter
@Setter
public class GasPriceResponse {
	public String status;
	public String message;
	public Result result;


	public static GasPriceResponse fromJson(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, GasPriceResponse.class);
	}

	@Getter
	@Setter
	public static class Result {
		@JsonProperty("LastBlock")
		private String lastBlock;
		@JsonProperty("SafeGasPrice")
		private String safeGasPrice;
		@JsonProperty("ProposeGasPrice")
		private String proposeGasPrice;
		@JsonProperty("FastGasPrice")
		private String fastGasPrice;
		@JsonProperty("suggestBaseFee")
		private String suggestBaseFee;
		@JsonProperty("gasUsedRatio")
		private String gasUsedRatio;
	}
}



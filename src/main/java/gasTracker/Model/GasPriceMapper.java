package gasTracker.Model;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Getter
@Setter
public class GasPriceMapper {
	public String status;
	public String message;
	public Result result;


	public static GasPriceMapper fromJson(String json) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, GasPriceMapper.class);
	}

	@Getter
	@Setter
	public static class Result {
		@JsonProperty("LastBlock")
		private String lastBlock;
		@JsonProperty("SafeGasPrice")
		private int safeGasPrice;
		@JsonProperty("ProposeGasPrice")
		private int proposeGasPrice;
		@JsonProperty("FastGasPrice")
		private int fastGasPrice;
		@JsonProperty("suggestBaseFee")
		private String suggestBaseFee;
		@JsonProperty("gasUsedRatio")
		private String gasUsedRatio;
	}
}



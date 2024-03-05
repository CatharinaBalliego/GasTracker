package gasTracker.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GasResponse {
    private int safeGasPrice;
    private int proposeGasPrice;
    private int fastGasPrice;

    public GasResponse(GasPriceMapper gasPriceMapper){
        this.safeGasPrice = gasPriceMapper.getResult().getSafeGasPrice();
        this.proposeGasPrice = gasPriceMapper.getResult().getProposeGasPrice();
        this.fastGasPrice = gasPriceMapper.getResult().getFastGasPrice();
    }
}

package gazether.Model;

import java.math.BigDecimal;

public class Gas {
	public String status;
	public String message;
	public long lastBlock;
	public String safeGasPrice;
	public String proposeGasPrice;
	public String fastGasPrice;
	public BigDecimal suggestBaseFee;

	public long getLastBlock() {
		return lastBlock;
	}
	public void setLastBlock(long lastBlock) {
		this.lastBlock = lastBlock;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSafeGasPrice() {
		return safeGasPrice;
	}
	public void setSafeGasPrice(String safeGasPrice) {
		this.safeGasPrice = safeGasPrice;
	}
	public String getProposeGasPrice() {
		return proposeGasPrice;
	}
	public void setProposeGasPrice(String proposeGasPrice) {
		this.proposeGasPrice = proposeGasPrice;
	}
	public String getFastGasPrice() {
		return fastGasPrice;
	}
	public void setFastGasPrice(String fastGasPrice) {
		this.fastGasPrice = fastGasPrice;
	}
	public BigDecimal getSuggestBaseFee() {
		return suggestBaseFee;
	}
	public void setSuggestBaseFee(BigDecimal suggestBaseFee) {
		this.suggestBaseFee = suggestBaseFee;
	}

	
	
	
}

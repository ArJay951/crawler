package sample.arjay.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "daily")
public class Daily implements Serializable {

	private static final long serialVersionUID = -3957568766236525309L;

	@Id
	private String id;

	private Date date;

	/**
	 * 證券代號
	 */
	private String securityCode;
	/**
	 * 證券名稱
	 */
	private String stockName;
	/**
	 * 成交股數
	 */
	private Long tradeVolume;
	/**
	 * 成交筆數
	 */
	private Integer transaction;
	/**
	 * 成交金額
	 */
	private Long tradeValue;
	/**
	 * 開盤價
	 */
	private Double openingPrice;
	/**
	 * 最高價
	 */
	private Double highestPrice;

	/**
	 * 最低價
	 */
	private Double lowestPrice;
	/**
	 * 收盤價
	 */
	private Double closingPrice;
	/**
	 * 漲跌(+/-)
	 */
	private String dir;
	/**
	 * 漲跌價差
	 */
	private Double change;
	/**
	 * 最後揭示買價
	 */
	private Double lastBestBidPrice;
	/**
	 * 最後揭示買量
	 */
	private Long lastBestBidVolume;
	/**
	 * 最後揭示賣價
	 */
	private Double lastBestAskPrice;
	/**
	 * 最後揭示賣量
	 */
	private Long lastBestAskVolume;
	/**
	 * 本益比
	 */
	private Double price_EarningRatio;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public Long getTradeVolume() {
		return tradeVolume;
	}

	public void setTradeVolume(Long tradeVolume) {
		this.tradeVolume = tradeVolume;
	}

	public Integer getTransaction() {
		return transaction;
	}

	public void setTransaction(Integer transaction) {
		this.transaction = transaction;
	}

	public Long getTradeValue() {
		return tradeValue;
	}

	public void setTradeValue(Long tradeValue) {
		this.tradeValue = tradeValue;
	}

	public Double getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(Double openingPrice) {
		this.openingPrice = openingPrice;
	}

	public Double getHighestPrice() {
		return highestPrice;
	}

	public void setHighestPrice(Double highestPrice) {
		this.highestPrice = highestPrice;
	}

	public Double getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(Double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public Double getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(Double closingPrice) {
		this.closingPrice = closingPrice;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public Double getChange() {
		return change;
	}

	public void setChange(Double change) {
		this.change = change;
	}

	public Double getLastBestBidPrice() {
		return lastBestBidPrice;
	}

	public void setLastBestBidPrice(Double lastBestBidPrice) {
		this.lastBestBidPrice = lastBestBidPrice;
	}

	public Long getLastBestBidVolume() {
		return lastBestBidVolume;
	}

	public void setLastBestBidVolume(Long lastBestBidVolume) {
		this.lastBestBidVolume = lastBestBidVolume;
	}

	public Double getLastBestAskPrice() {
		return lastBestAskPrice;
	}

	public void setLastBestAskPrice(Double lastBestAskPrice) {
		this.lastBestAskPrice = lastBestAskPrice;
	}

	public Long getLastBestAskVolume() {
		return lastBestAskVolume;
	}

	public void setLastBestAskVolume(Long lastBestAskVolume) {
		this.lastBestAskVolume = lastBestAskVolume;
	}

	public Double getPrice_EarningRatio() {
		return price_EarningRatio;
	}

	public void setPrice_EarningRatio(Double price_EarningRatio) {
		this.price_EarningRatio = price_EarningRatio;
	}

}

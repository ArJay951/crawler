package sample.arjay.pojo;

import java.io.Serializable;

/**
 * @author ArJay <BR>
 *         https://projectmoby.hackpad.com/ep/pad/static/HC9QuIQH1c5
 */
public class BalanceSheet implements Serializable {

	private static final long serialVersionUID = 6453572948509482489L;

	private String stockCode;

	/**
	 * 現金及約當現金
	 */
	private String cashEquivalents;

	/**
	 * CFAFV
	 * 
	 * 透過損益按公允價值衡量之金融資產－流動 (Current Financial Assets at Fair Value through
	 * Profit or Loss)
	 */
	private String cfafv;

	/**
	 * AFIAC
	 * 
	 * 備供出售金融資產-流動 (Available-for-sale Financial Assets (Current))
	 */
	private String afiac;

	/**
	 * HFIA：持有至到期日金融資產 (Held-to-maturity Financial Assets)
	 */
	private String hfia;

	/**
	 * Derivative financial assets for hedging
	 */
	private String dfafh;

	/**
	 * 非流動資產合計
	 */
	private String noncurrentAssets;

	/**
	 * 普通股股本 capital stock common
	 */
	private String ordinaryShare;

	/**
	 * 發行張數
	 * 
	 */
	private String volume;

	/**
	 * 現金淨值
	 * 
	 */
	private String bookValue;

	/**
	 * 股價
	 * 
	 */
	private String stockPrice;

	/**
	 * 現金淨值比
	 * 
	 */
	private String bookValueRate;
	/**
	 * 營業收入合計
	 */
	private String operatingRevenue;

	/**
	 * 營業毛利
	 */
	private String grossProfitLossFromOperations;

	/**
	 * 營業毛利（毛損）淨額
	 * 
	 */
	private String grossProfitLossFromOperationsNet;

	/**
	 * 毛利率
	 * 
	 */
	private String grossMargin;

	/**
	 * 
	 * 營業利益（損失）
	 */
	private String netOperatingIncomeLoss;

	/**
	 * 營業利益率
	 */
	private String netOperatingIncomeLossRate;

	/**
	 * 去年同期營業利益率
	 */
	private String lastOperatingProfitRate;

	/**
	 * 營業利益成長率
	 */
	private String operatingProfitGrowthRate;

	/**
	 * 
	 * 營業外收入及支出合計
	 */
	private String nonOperatingIncome;

	/**
	 * 業外收入比率
	 */
	private String nonOperatingIncomeRate;

	/**
	 * 繼續營業單位本期淨利
	 */
	private String profitLossFromContinuingOperations;

	/**
	 * 繼續營業單位淨利（淨損）
	 */
	private String profitLossFromContinuingOperationsRate;

	/**
	 * 稀釋每股盈餘
	 */
	private String dilutedEarningsLossPerShare;

	/**
	 * 本益比
	 */
	private String eps;

	private String epsM;

	/**
	 * 資料修正日期
	 */
	private String modifyDate;

	private String season;

	public String getCashEquivalents() {
		return cashEquivalents;
	}

	public void setCashEquivalents(String cashEquivalents) {
		this.cashEquivalents = cashEquivalents;
	}

	public String getCfafv() {
		return cfafv;
	}

	public void setCfafv(String cfafv) {
		this.cfafv = cfafv;
	}

	public String getAfiac() {
		return afiac;
	}

	public void setAfiac(String afiac) {
		this.afiac = afiac;
	}

	public String getHfia() {
		return hfia;
	}

	public void setHfia(String hfia) {
		this.hfia = hfia;
	}

	public String getDfafh() {
		return dfafh;
	}

	public void setDfafh(String dfafh) {
		this.dfafh = dfafh;
	}

	public String getNoncurrentAssets() {
		return noncurrentAssets;
	}

	public void setNoncurrentAssets(String noncurrentAssets) {
		this.noncurrentAssets = noncurrentAssets;
	}

	public String getOrdinaryShare() {
		return ordinaryShare;
	}

	public void setOrdinaryShare(String ordinaryShare) {
		this.ordinaryShare = ordinaryShare;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getBookValue() {
		return bookValue;
	}

	public void setBookValue(String bookValue) {
		this.bookValue = bookValue;
	}

	public String getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getBookValueRate() {
		return bookValueRate;
	}

	public void setBookValueRate(String bookValueRate) {
		this.bookValueRate = bookValueRate;
	}

	public String getOperatingRevenue() {
		return operatingRevenue;
	}

	public void setOperatingRevenue(String operatingRevenue) {
		this.operatingRevenue = operatingRevenue;
	}

	public String getGrossProfitLossFromOperations() {
		return grossProfitLossFromOperations;
	}

	public void setGrossProfitLossFromOperations(String grossProfitLossFromOperations) {
		this.grossProfitLossFromOperations = grossProfitLossFromOperations;
	}

	public String getGrossProfitLossFromOperationsNet() {
		return grossProfitLossFromOperationsNet;
	}

	public void setGrossProfitLossFromOperationsNet(String grossProfitLossFromOperationsNet) {
		this.grossProfitLossFromOperationsNet = grossProfitLossFromOperationsNet;
	}

	public String getGrossMargin() {
		return grossMargin;
	}

	public void setGrossMargin(String grossMargin) {
		this.grossMargin = grossMargin;
	}

	public String getNetOperatingIncomeLoss() {
		return netOperatingIncomeLoss;
	}

	public void setNetOperatingIncomeLoss(String netOperatingIncomeLoss) {
		this.netOperatingIncomeLoss = netOperatingIncomeLoss;
	}

	public String getNetOperatingIncomeLossRate() {
		return netOperatingIncomeLossRate;
	}

	public void setNetOperatingIncomeLossRate(String netOperatingIncomeLossRate) {
		this.netOperatingIncomeLossRate = netOperatingIncomeLossRate;
	}

	public String getLastOperatingProfitRate() {
		return lastOperatingProfitRate;
	}

	public void setLastOperatingProfitRate(String lastOperatingProfitRate) {
		this.lastOperatingProfitRate = lastOperatingProfitRate;
	}

	public String getOperatingProfitGrowthRate() {
		return operatingProfitGrowthRate;
	}

	public void setOperatingProfitGrowthRate(String operatingProfitGrowthRate) {
		this.operatingProfitGrowthRate = operatingProfitGrowthRate;
	}

	public String getNonOperatingIncome() {
		return nonOperatingIncome;
	}

	public void setNonOperatingIncome(String nonOperatingIncome) {
		this.nonOperatingIncome = nonOperatingIncome;
	}

	public String getNonOperatingIncomeRate() {
		return nonOperatingIncomeRate;
	}

	public void setNonOperatingIncomeRate(String nonOperatingIncomeRate) {
		this.nonOperatingIncomeRate = nonOperatingIncomeRate;
	}

	public String getProfitLossFromContinuingOperations() {
		return profitLossFromContinuingOperations;
	}

	public void setProfitLossFromContinuingOperations(String profitLossFromContinuingOperations) {
		this.profitLossFromContinuingOperations = profitLossFromContinuingOperations;
	}

	public String getProfitLossFromContinuingOperationsRate() {
		return profitLossFromContinuingOperationsRate;
	}

	public void setProfitLossFromContinuingOperationsRate(String profitLossFromContinuingOperationsRate) {
		this.profitLossFromContinuingOperationsRate = profitLossFromContinuingOperationsRate;
	}

	public String getDilutedEarningsLossPerShare() {
		return dilutedEarningsLossPerShare;
	}

	public void setDilutedEarningsLossPerShare(String dilutedEarningsLossPerShare) {
		this.dilutedEarningsLossPerShare = dilutedEarningsLossPerShare;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getEpsM() {
		return epsM;
	}

	public void setEpsM(String epsM) {
		this.epsM = epsM;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BalanceSheet [stockCode=");
		builder.append(stockCode);
		builder.append(", cashEquivalents=");
		builder.append(cashEquivalents);
		builder.append(", cfafv=");
		builder.append(cfafv);
		builder.append(", afiac=");
		builder.append(afiac);
		builder.append(", hfia=");
		builder.append(hfia);
		builder.append(", dfafh=");
		builder.append(dfafh);
		builder.append(", noncurrentAssets=");
		builder.append(noncurrentAssets);
		builder.append(", ordinaryShare=");
		builder.append(ordinaryShare);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", bookValue=");
		builder.append(bookValue);
		builder.append(", stockPrice=");
		builder.append(stockPrice);
		builder.append(", bookValueRate=");
		builder.append(bookValueRate);
		builder.append(", operatingRevenue=");
		builder.append(operatingRevenue);
		builder.append(", grossProfitLossFromOperations=");
		builder.append(grossProfitLossFromOperations);
		builder.append(", grossProfitLossFromOperationsNet=");
		builder.append(grossProfitLossFromOperationsNet);
		builder.append(", grossMargin=");
		builder.append(grossMargin);
		builder.append(", netOperatingIncomeLoss=");
		builder.append(netOperatingIncomeLoss);
		builder.append(", netOperatingIncomeLossRate=");
		builder.append(netOperatingIncomeLossRate);
		builder.append(", lastOperatingProfitRate=");
		builder.append(lastOperatingProfitRate);
		builder.append(", operatingProfitGrowthRate=");
		builder.append(operatingProfitGrowthRate);
		builder.append(", nonOperatingIncome=");
		builder.append(nonOperatingIncome);
		builder.append(", nonOperatingIncomeRate=");
		builder.append(nonOperatingIncomeRate);
		builder.append(", profitLossFromContinuingOperations=");
		builder.append(profitLossFromContinuingOperations);
		builder.append(", profitLossFromContinuingOperationsRate=");
		builder.append(profitLossFromContinuingOperationsRate);
		builder.append(", dilutedEarningsLossPerShare=");
		builder.append(dilutedEarningsLossPerShare);
		builder.append(", eps=");
		builder.append(eps);
		builder.append(", epsM=");
		builder.append(epsM);
		builder.append(", modifyDate=");
		builder.append(modifyDate);
		builder.append(", season=");
		builder.append(season);
		builder.append("]");
		return builder.toString();
	}

	public String toCsv() {
		StringBuilder builder = new StringBuilder();
		builder.append(stockCode);
		builder.append(",");
		builder.append(cashEquivalents);
		builder.append(",");
		builder.append(cfafv);
		builder.append(",");
		builder.append(afiac);
		builder.append(",");
		builder.append(hfia);
		builder.append(",");
		builder.append(dfafh);
		builder.append(",");
		builder.append(noncurrentAssets);
		builder.append(",");
		builder.append(ordinaryShare);
		builder.append(",");
		builder.append(volume);
		builder.append(",");
		builder.append(bookValue);
		builder.append(",");
		builder.append(stockPrice);
		builder.append(",");
		builder.append(bookValueRate);
		builder.append(",");
		builder.append(operatingRevenue);
		builder.append(",");
		builder.append(grossProfitLossFromOperations);
		builder.append(",");
		builder.append(grossProfitLossFromOperationsNet);
		builder.append(",");
		builder.append(grossMargin);
		builder.append(",");
		builder.append(netOperatingIncomeLoss);
		builder.append(",");
		builder.append(netOperatingIncomeLossRate);
		builder.append(",");
		builder.append(lastOperatingProfitRate);
		builder.append(",");
		builder.append(operatingProfitGrowthRate);
		builder.append(",");
		builder.append(nonOperatingIncome);
		builder.append(",");
		builder.append(nonOperatingIncomeRate);
		builder.append(",");
		builder.append(profitLossFromContinuingOperations);
		builder.append(",");
		builder.append(profitLossFromContinuingOperationsRate);
		builder.append(",");
		builder.append(dilutedEarningsLossPerShare);
		builder.append(",");
		builder.append(eps);
		builder.append(",");
		builder.append(epsM);
		builder.append(",");
		builder.append(modifyDate);
		builder.append(",");
		builder.append(season);
		builder.append(",");
		return builder.toString();
	}
}

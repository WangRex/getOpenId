/**   
* @Title: BusinessAddAModel.java 
* @Package com.getOpenId.model 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Rex   
* @date 2017年7月26日 上午11:34:42 
* @version V1.0   
*/
package com.getOpenId.model;

/**
 * @ClassName: BusinessAddAModel
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Rex
 * @date 2017年7月26日 上午11:34:42
 * 
 */
public class BusinessAddAModel {

	private String openid;
	private String name;
	private String tel;
	private String cardid;
	private String bankid;

	/**
	 * @return openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid
	 *            要设置的 openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            要设置的 tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return cardid
	 */
	public String getCardid() {
		return cardid;
	}

	/**
	 * @param cardid
	 *            要设置的 cardid
	 */
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	/**
	 * @return bankid
	 */
	public String getBankid() {
		return bankid;
	}

	/**
	 * @param bankid
	 *            要设置的 bankid
	 */
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}

	/*
	 * (非 Javadoc) <p>Title: toString</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "openid = " + this.openid + ", name = " + this.name + ", tel = " + this.tel + ", cardid = " + this.cardid + ", bankid = " + this.bankid;
	}

}

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
public class BusinessAddBModel {

	private String openid;
	private String cardphoto1;
	private String cardphoto2;
	private String businessphoto;
	private String merid;
	private String kv_type;
	private String terid;
	private String banktype;
	private String kv;
	private String businessname;
	private String businessadress;
	private String recommendperson;
	private String recommenorganization;
	private String cardid;
	private String name;
	private String bankid;
	private String tel;

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
	 * @return cardphoto1
	 */
	public String getCardphoto1() {
		return cardphoto1;
	}

	/**
	 * @param cardphoto1
	 *            要设置的 cardphoto1
	 */
	public void setCardphoto1(String cardphoto1) {
		this.cardphoto1 = cardphoto1;
	}

	/**
	 * @return cardphoto2
	 */
	public String getCardphoto2() {
		return cardphoto2;
	}

	/**
	 * @param cardphoto2
	 *            要设置的 cardphoto2
	 */
	public void setCardphoto2(String cardphoto2) {
		this.cardphoto2 = cardphoto2;
	}

	/**
	 * @return businessphoto
	 */
	public String getBusinessphoto() {
		return businessphoto;
	}

	/**
	 * @param businessphoto
	 *            要设置的 businessphoto
	 */
	public void setBusinessphoto(String businessphoto) {
		this.businessphoto = businessphoto;
	}

	/**
	 * @return merid
	 */
	public String getMerid() {
		return merid;
	}

	/**
	 * @param merid
	 *            要设置的 merid
	 */
	public void setMerid(String merid) {
		this.merid = merid;
	}

	/** 
	* @return kv_type 
	*/
	public String getKv_type() {
		return kv_type;
	}

	/** 
	* @param kv_type 要设置的 kv_type 
	*/
	public void setKv_type(String kv_type) {
		this.kv_type = kv_type;
	}

	/**
	 * @return terid
	 */
	public String getTerid() {
		return terid;
	}

	/**
	 * @param terid
	 *            要设置的 terid
	 */
	public void setTerid(String terid) {
		this.terid = terid;
	}
	

	/** 
	* @return banktype 
	*/
	public String getBanktype() {
		return banktype;
	}

	/** 
	* @param banktype 要设置的 banktype 
	*/
	public void setBanktype(String banktype) {
		this.banktype = banktype;
	}

	/**
	 * @return kv
	 */
	public String getKv() {
		return kv;
	}

	/**
	 * @param kv
	 *            要设置的 kv
	 */
	public void setKv(String kv) {
		this.kv = kv;
	}

	/**
	 * @return businessname
	 */
	public String getBusinessname() {
		return businessname;
	}

	/**
	 * @param businessname
	 *            要设置的 businessname
	 */
	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}

	/**
	 * @return businessadress
	 */
	public String getBusinessadress() {
		return businessadress;
	}

	/**
	 * @param businessadress
	 *            要设置的 businessadress
	 */
	public void setBusinessadress(String businessadress) {
		this.businessadress = businessadress;
	}

	/**
	 * @return recommendperson
	 */
	public String getRecommendperson() {
		return recommendperson;
	}

	/**
	 * @param recommendperson
	 *            要设置的 recommendperson
	 */
	public void setRecommendperson(String recommendperson) {
		this.recommendperson = recommendperson;
	}

	/** 
	* @return recommenorganization 
	*/
	public String getRecommenorganization() {
		return recommenorganization;
	}

	/** 
	* @param recommenorganization 要设置的 recommenorganization 
	*/
	public void setRecommenorganization(String recommenorganization) {
		this.recommenorganization = recommenorganization;
	}

	/** 
	* @return cardid 
	*/
	public String getCardid() {
		return cardid;
	}

	/** 
	* @param cardid 要设置的 cardid 
	*/
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	/** 
	* @return name 
	*/
	public String getName() {
		return name;
	}

	/** 
	* @param name 要设置的 name 
	*/
	public void setName(String name) {
		this.name = name;
	}

	/** 
	* @return bankid 
	*/
	public String getBankid() {
		return bankid;
	}

	/** 
	* @param bankid 要设置的 bankid 
	*/
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}

	/** 
	* @return tel 
	*/
	public String getTel() {
		return tel;
	}

	/** 
	* @param tel 要设置的 tel 
	*/
	public void setTel(String tel) {
		this.tel = tel;
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
		return "openid = " + this.openid + ", cardphoto1 = " + this.cardphoto1 + ", cardphoto2 = " + this.cardphoto2 + ", businessphoto = " + this.businessphoto + ", merid = " + this.merid + ", terid = " + this.terid + ", banktype = " + banktype + ", kv = " + this.kv + ", businessname = " + this.businessname + ", businessadress = " + this.businessadress + ", recommendperson = " + this.recommendperson + ", recommenorganization = " + this.recommenorganization;
	}
}

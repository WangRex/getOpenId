/**   
* @Title: MyX509TrustManager.java 
* @Package com.getOpenId.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Rex   
* @date 2017年7月25日 下午11:37:28 
* @version V1.0   
*/
package com.getOpenId.utils;

/** 
* @ClassName: MyX509TrustManager 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Rex 
* @date 2017年7月25日 下午11:37:28 
*  
*/
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * 证书信任管理器（用于https请求）
 * 
 * @author liufeng
 * @date 2013-08-08
 */
public class MyX509TrustManager implements X509TrustManager {

	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}

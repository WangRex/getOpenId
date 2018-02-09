/**   
* @Title: Constants.java 
* @Package com.getOpenId.constant 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Rex   
* @date 2017年7月26日 上午11:27:02 
* @version V1.0   
*/
package com.getOpenId.constant;

/** 
* @ClassName: Constants 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Rex 
* @date 2017年7月26日 上午11:27:02 
*  
*/
public class Constants {

	public final static String access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

	/*测试服务器路径*/
//	public final static String LINUXPATH = "/yjdata/www/www/getOpenId/";
	
	/*银联服务器路径*/
	public final static String LINUXPATH = "/mnt/apache-tomcat-7.0.29/webapps/getOpenId/";	
	/*银联服务器路径*/
//	public final static String LINUXPATH = "/root/util/apache-tomcat-7.0.29/webapps/getOpenId/";

	/***
	 * 
	* @ClassName: FTP 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author Rex 
	* @date 2017年7月26日 上午11:28:15 
	*
	 */
	public static class FTP {
		/***
		 * PATH
		 */
		public final static String PATH = "10.255.13.23";
		/***
		 * PORT
		 */
		public static final int PORT = 21;
		/***
		 * String
		 */
		public static final String USERNAME = "administrator";
		/***
		 * PASSWORD
		 */
		public static final String PASSWORD = "ums@2016";
		
	}

	/***
	 * 
	* @ClassName: WX 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author Rex 
	* @date 2017年7月26日 上午11:28:15 
	*
	 */
	public static class WX {
		/***
		 * 银联APPID
		 */
//		public static final String APPID = "wx243442c19d980f0b";
		/***
		 * 银联SECRET
		 */
//		public static final String SECRET = "e95cc90a068b171372f9bf606ca1069b";

		/***
		 * 测试APPID
		 */
		public static final String APPID = "wx88197bbba10c338b";
		/***
		 * 测试SECRET
		 */
		public static final String SECRET = "d92cf8ff07c4672ad108ea71aff7dd9f";
		
	}
	/***
	 * 
	* @ClassName: URL 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author Rex 
	* @date 2017年7月26日 上午11:28:15 
	*
	 */
	public static class URL {
		/***
		 * 测试路径
		 */
//		public static final String URL = "http://172.16.159.133:8080/";
		/***
		 * 中转路径
		 */
		public static final String TRANSFER_URL = "http://113.57.148.12/getOpenId/";
		/***
		 * 真实路径
		 */
		public static final String URL = "http://10.255.13.23:8080/";
	}
	/***
	 * 
	* @ClassName: path 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author Rex 
	* @date 2017年7月26日 上午11:28:15 
	*
	 */
	public static class path {
		public static final String SELECTBUSINESS = "SelfRegistration/wechat/selectbusiness";
		public static final String BUSINESSADDA = "SelfRegistration/wechat/businessAddA";
		public static final String BUSINESSADDB = "SelfRegistration/wechat/businessAddB";
		public static final String SELECTTOKEN = "SelfRegistration/wechat/selecttoken";
		public static final String UPDATETOKEN = "SelfRegistration/wechat/updatetoken";
	}
}

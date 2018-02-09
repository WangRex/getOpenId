/**   
* @Title: PropertiesUtils.java 
* @Package com.getOpenId.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Rex   
* @date 2017年7月28日 下午5:47:11 
* @version V1.0   
*/
package com.getOpenId.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: PropertiesUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Rex
 * @date 2017年7月28日 下午5:47:11
 * 
 */
public class PropertiesUtils {
	private static Logger log = LoggerFactory.getLogger(PropertiesUtils.class);
	// 属性文件的路径
	static String filepath = System.getProperty("user.dir");
	static String profilepath = "AccessToken.properties";
	/**
	 * 采用静态方法
	 */
	private Properties props = new Properties();

	/**
	 * 读取属性文件中相应键的值
	 * 
	 * @param key
	 *            主键
	 * @return String
	 */
	public String getKeyValue(String key) {
		try {
			FileInputStream is = new FileInputStream(filepath + "/" + profilepath);
			props.load(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.exit(-1);
		}
		return props.getProperty(key);
	}

	/**
	 * 更新properties文件的键值对 如果该主键已经存在，更新该主键的值； 如果该主键不存在，则插件一对键值。
	 * 
	 * @param keyname
	 *            键名
	 * @param keyvalue
	 *            键值
	 */
	public void updateProperties(String keyname, String keyvalue) {
		try {
			log.debug("path = " + filepath + "/" + profilepath);
			// 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
			// 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
			OutputStream fos = new FileOutputStream(filepath + "/" + profilepath);
			props.setProperty(keyname, keyvalue);
			// 以适合使用 load 方法加载到 Properties 表中的格式，
			// 将此 Properties 表中的属性列表（键和元素对）写入输出流
			props.store(fos, "Update '" + keyname + "' value");
		} catch (IOException e) {
			System.err.println("属性文件更新错误");
		}
	}
}

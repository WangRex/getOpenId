/**   
* @Title: FileUtils.java 
* @Package com.getOpenId.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Rex   
* @date 2017年7月28日 下午5:25:09 
* @version V1.0   
*/
package com.getOpenId.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

/**
 * @ClassName: FileUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Rex
 * @date 2017年7月28日 下午5:25:09
 * 
 */
public class FileUtils {

	public static JSONObject readFile(String path) {
		JSONObject json = new JSONObject();
		try {
			// read file content from file
			StringBuffer sb = new StringBuffer("");

			FileReader reader = new FileReader(path);
			BufferedReader br = new BufferedReader(reader);

			String str = null;

			while ((str = br.readLine()) != null) {
				String content = str.toString();
				String contentArr[] = content.split("=");
				sb.append(str + "/n");
				json.put(contentArr[0], contentArr[1]);
				System.out.println(str);
			}

			br.close();
			reader.close();

			// write string to file
			FileWriter writer = new FileWriter("c://test2.txt");
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(sb.toString());

			bw.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * @Title: getRandomFileName @Description: (这里用一句话描述这个方法的作用) @param
	 *         设定文件 @return void 返回类型 @throws
	 */
	public static String getRandomFileName() {
		// 得到long类型当前时间
		long l = System.currentTimeMillis();
		// new日期对象
		Date date = new Date(l);
		// 转换提日期输出格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = dateFormat.format(date);
		return dateStr;
	}

	/**
	 * 将文件转成base64 字符串
	 * 
	 * @param path文件路径
	 * @return *
	 * @throws Exception
	 */

	public static String encodeBase64File(String path) throws Exception {
		File file = new File(path);
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		return new BASE64Encoder().encode(buffer);

	}

	/**
	 * 将base64字符解码保存文件
	 * 
	 * @param base64Code
	 * @param targetPath
	 * @throws Exception
	 */

	public static byte[] decoderBase64File(String base64Code) throws Exception {
		byte[] b = null;
		if (base64Code != null && !("").equals(base64Code)) {
			// 解决后台接收base64编码出现空格的问题
			String sst = base64Code.replace(" ", "+");
			try {
				b = new BASE64Decoder().decodeBuffer(sst);
				for (int i = 0; i < b.length; ++i) {
					if (b[i] < 0) {
						// 调整异常数据
						b[i] += 256;
					}
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		return b;
	}
}

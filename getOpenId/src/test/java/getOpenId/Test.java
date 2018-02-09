/**   
* @Title: Test.java 
* @Package getOpenId 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Rex   
* @date 2017年7月28日 下午5:31:37 
* @version V1.0   
*/
package getOpenId;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.getOpenId.constant.Constants;
import com.getOpenId.utils.AES;
import com.getOpenId.utils.AccessTokenService;
import com.getOpenId.utils.HttpPostJson;
import com.getOpenId.utils.PropertiesUtils;
import com.getOpenId.utils.StrChange;

/**
 * @ClassName: Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Rex
 * @date 2017年7月28日 下午5:31:37
 * 
 */
public class Test {

	/**
	 * @Title: main @Description: TODO(这里用一句话描述这个方法的作用) @param @param args
	 * 设定文件 @return void 返回类型 @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String filepath=System.getProperty("user.dir");
//		System.out.println(filepath);
//		PropertiesUtils propertiesUtils = new PropertiesUtils();
//		System.out.println(propertiesUtils.getKeyValue("date"));
//		propertiesUtils.updateProperties("date", new Date().toLocaleString());
//		System.out.println(propertiesUtils.getKeyValue("date"));
		
		AccessTokenService accessTokenService = new AccessTokenService();
//		System.out.println(accessTokenService.getSignature("http://www.wegoaldx.com"));
		System.out.println(accessTokenService.getSignature("http%3a%2f%2fwww.wegoaldx.com%2f"));
		
//		String msg = "F0E0F7C18D3E66412414C2CC3C800D32";
//		// 解密
//		// 解密后的concent
//		String dtconcent;
//		String decryptResult;
//		try {
//			decryptResult = AES.decrypt(msg, AES.AesPd);
//			JSONObject resjson1 = JSONObject.parseObject(decryptResult);
//			System.out.println("解密的msg：" + resjson1);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// 转成Json解析
		
		// 发送请求参数
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("accesstoken", "sss");
//		map.put("date", "2017-07-30 16:09:00");
//		map.put("expires_in", "7200");
//		map.put("id", "2");
//		JSONObject itemJSONObj = JSONObject.parseObject(JSON.toJSONString(map));
////		String url = Constants.URL.URL + Constants.path.UPDATETOKEN;
//		String url = Constants.URL.URL + Constants.path.SELECTTOKEN;
//		JSONObject rtnJson = HttpPostJson.jsonpost(url, itemJSONObj);
//		System.out.println("rtnJson = " + rtnJson.toJSONString());
	}

}

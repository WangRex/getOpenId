/**   
* @Title: GetOpenId.java 
* @Package com.getOpenId.controller 
* @Description: (用一句话描述该文件做什么) 
* @author Rex   
* @date 2017年7月26日 上午12:02:34 
* @version V1.0   
*/
package com.getOpenId.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.getOpenId.constant.Constants;
import com.getOpenId.model.AccessToken;
import com.getOpenId.model.Base64Model;
import com.getOpenId.model.BusinessAddAModel;
import com.getOpenId.model.BusinessAddBModel;
import com.getOpenId.utils.AES;
import com.getOpenId.utils.AccessTokenService;
import com.getOpenId.utils.FTPUpload;
import com.getOpenId.utils.FileUtils;
import com.getOpenId.utils.HttpPostJson;
import com.getOpenId.utils.PersonalUtils;
import com.getOpenId.utils.SendMessage;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/get")
public class GetOpenId {

	private static Logger log = LoggerFactory.getLogger(GetOpenId.class);

	public SendMessage sm = new SendMessage();

	@RequestMapping(value = "/getOpenId", method = RequestMethod.GET)
	@ResponseBody
	public String getOpenId(String code) {
		log.debug("获取OpenId方法开始,入参code = " + code);
		return PersonalUtils.getopenid(code);
	}

	/***
	 * 获取微信签名 @Title: getOpenId @Description: (这里用一句话描述这个方法的作用) @param @param
	 * code @param @return 设定文件 @return String 返回类型 @throws
	 */
	@RequestMapping(value = "/getSignature", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getSignature(String requrl) {
		log.debug("获取微信签名方法开始,入参requrl = " + requrl);
		AccessTokenService accessTokenService = new AccessTokenService();
		/*
		 * try { requrl = java.net.URLDecoder.decode(requrl, "utf-8");
		 * log.debug("获取微信签名方法开始,入参requrl解码后 = " + requrl); } catch
		 * (UnsupportedEncodingException e) { e.printStackTrace(); }
		 */
		return accessTokenService.getSignature(requrl);
	}

	/***
	 * 查询接口 @Title: selectbusiness
	 * 
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param @param
	 *            openid @param @return 设定文件 @return String 返回类型 @throws
	 */
	@RequestMapping(value = "/selectbusiness", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject selectbusiness(String openid) {
		log.debug("查询接口,入参openid = " + openid);
		String url = Constants.URL.TRANSFER_URL + "/get/selectbusinessTransfer?openid=" + openid;
		// 发布在临时服务器
		JSONObject rtnJson = HttpPostJson.httpGet(url);
		log.debug(rtnJson.toString());
		return rtnJson;
	}

	/***
	 * 查询接口 @Title: selectbusiness
	 * 
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param @param
	 *            openid @param @return 设定文件 @return String 返回类型 @throws
	 */
	@RequestMapping(value = "/selectbusinessTransfer", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject selectbusinessTransfer(String openid) {
		log.debug("查询接口,入参openid = " + openid);
		String url = Constants.URL.URL + Constants.path.SELECTBUSINESS;
		JSONObject json = new JSONObject();
		// 发送请求参数
		JSONObject mapJson = new JSONObject();
		mapJson.put("openid", openid);
		String encryptResultStr = "";
		try {
			// 加密
			encryptResultStr = AES.encrypt(mapJson.toString(), AES.AesPd);
			log.debug("加密串  = " + encryptResultStr);
			// 解密
			String dtconcent1 = AES.decrypt(encryptResultStr, AES.AesPd);
			// 转成Json解析
			JSONObject resjson1 = JSONObject.fromObject(dtconcent1);
			log.debug("发送前encryptResultStr解密后 = " + resjson1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		json.put("concent", encryptResultStr);
		// 发布在中转服务器
		JSONObject rtnJson = HttpPostJson.jsonpost(url, json);
		// 发布在临时服务器
		// JSONObject rtnJson = HttpPostJson.httpGet(url);
		log.debug(rtnJson.toString());
		if ("02".equals(rtnJson.get("result"))) {
			String msg = rtnJson.get("msg").toString();
			// 解密
			// 解密后的concent
			try {
				String dtconcent = AES.decrypt(msg, AES.AesPd);
				// 转成Json解析
				JSONObject resjson1 = JSONObject.fromObject(dtconcent);
				rtnJson.put("msg", resjson1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rtnJson;
	}

	/***
	 * 注册A(五要素)接口 @Title: businessAddA @Description:
	 * (这里用一句话描述这个方法的作用) @param @param model @param @return 设定文件 @return String
	 * 返回类型 @throws
	 */
	@RequestMapping(value = "/businessAddA", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject businessAddA(@RequestBody BusinessAddAModel model) {
		log.debug("注册A(五要素)接口方法开始,入参model = " + model.toString());
		String url = Constants.URL.URL + Constants.path.BUSINESSADDA;
		JSONObject json = new JSONObject();
		// 发送请求参数
		Map<String, String> map = new HashMap<String, String>();
		map.put("openid", model.getOpenid());
		map.put("name", model.getName());
		map.put("tel", model.getTel());
		map.put("cardid", model.getCardid());
		map.put("bankid", model.getBankid());
		JSONObject itemJSONObj = JSONObject.fromObject(map);
		log.debug("itemJSONObj = " + itemJSONObj);
		try {
			// // 加密
			String encryptResultStr = AES.encrypt(itemJSONObj.toString(), AES.AesPd);
			log.debug("encryptResultStr = " + encryptResultStr);
			json.put("concent", encryptResultStr);
			// 解密
			String dtconcent = AES.decrypt(encryptResultStr, AES.AesPd);
			// 转成Json解析
			JSONObject resjson1 = JSONObject.fromObject(dtconcent);
			log.debug("发送前encryptResultStr解密后 = " + resjson1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject rtnJson = HttpPostJson.jsonpost(url, json);
		log.debug("rtnJson = " + rtnJson.toString());
		return rtnJson;
	}

	/***
	 * 注册B(基本信息)接口 @Title: businessAddB @Description:
	 * (这里用一句话描述这个方法的作用) @param @param model @param @return 设定文件 @return String
	 * 返回类型 @throws
	 */
	@RequestMapping(value = "/businessAddB", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject businessAddB(@RequestBody BusinessAddBModel model) {
		log.debug("注册B(基本信息)接口方法开始,入参model = " + model.toString());
		String url = Constants.URL.URL + Constants.path.BUSINESSADDB;
		JSONObject json = new JSONObject();
		// 发送请求参数
		JSONObject itemJSONObj = new JSONObject();
		itemJSONObj.put("openid", model.getOpenid());
		itemJSONObj.put("cardphoto1", model.getCardphoto1());
		itemJSONObj.put("cardphoto2", model.getCardphoto2());
		itemJSONObj.put("businessphoto", model.getBusinessphoto());
		itemJSONObj.put("merid", model.getMerid());
		itemJSONObj.put("kv_type", model.getKv_type());
		itemJSONObj.put("banktype", model.getBanktype());
		itemJSONObj.put("kv", model.getKv());
		itemJSONObj.put("businessname", model.getBusinessname());
		itemJSONObj.put("businessadress", model.getBusinessadress());
		itemJSONObj.put("recommendperson", model.getRecommendperson());
		itemJSONObj.put("recommenorganization", model.getRecommenorganization());
		itemJSONObj.put("cardid", model.getCardid());
		itemJSONObj.put("name", model.getName());
		itemJSONObj.put("bankid", model.getBankid());
		itemJSONObj.put("tel", model.getTel());
		// // 加密
		JSONObject rtnJson = new JSONObject();
		String encryptResultStr;
		try {
			encryptResultStr = AES.encrypt(itemJSONObj.toString(), AES.AesPd);
			json.put("concent", encryptResultStr);
			rtnJson = HttpPostJson.jsonpost(url, json);
			log.debug(rtnJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rtnJson;
	}

	/***
	 * 查询接口 @Title: selectbusiness
	 * 
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param @param
	 *            openid @param @return 设定文件 @return String 返回类型 @throws
	 */
	@RequestMapping(value = "/selecttoken", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject selecttoken(String id) {
		log.debug("查询token接口,入参id = " + id);
		String url = Constants.URL.URL + Constants.path.SELECTTOKEN;
		// 发送请求参数
		JSONObject mapJson = new JSONObject();
		mapJson.put("id", id);
		JSONObject rtnJson = HttpPostJson.jsonpost(url, mapJson);
		return rtnJson;
	}

	/***
	 * 查询接口 @Title: selectbusiness
	 * 
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param @param
	 *            openid @param @return 设定文件 @return String 返回类型 @throws
	 */
	@RequestMapping(value = "/updatetoken", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updatetoken(@RequestBody AccessToken model) {
		log.debug("更新token接口,入参model = " + model.toString());
		String url = Constants.URL.URL + Constants.path.UPDATETOKEN;
		// 发送请求参数
		JSONObject mapJson = new JSONObject();
		mapJson.put("accesstoken", model.getAccesstoken());
		mapJson.put("date", model.getDate());
		mapJson.put("expires_in", model.getExpires_in());
		mapJson.put("id", model.getId());
		JSONObject json = new JSONObject();
		json.put("concent", mapJson);
		JSONObject rtnJson = HttpPostJson.jsonpost(url, json);
		// JSONObject rtnJson = HttpPostJson.httpGet(url);
		return rtnJson;
	}

	@RequestMapping(value = "/uploadBase64", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject base64UpLoad(@RequestBody Base64Model model) {
		JSONObject result = new JSONObject();
		try {
			log.debug("上传文件的数据：" + model.getBase64().substring(0, 50));
			String dataPrix = "";
			String data = "";

			log.debug("对数据进行判断");
			if (model.getBase64() == null || "".equals(model.getBase64())) {
				throw new Exception("上传失败，上传图片数据为空");
			} else {
				String[] d = model.getBase64().split("base64,");
				log.debug("上传文件的数据：" + model.getBase64().substring(0, 50));
				if (d != null && d.length == 2) {
					dataPrix = d[0];
					data = d[1];
					log.debug("base64前50位 = " + data.substring(0, 50));
				} else {
					throw new Exception("上传失败，数据不合法");
				}
			}

			log.debug("对数据进行解析，获取文件名和流数据");
			String suffix = "";
			if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {// data:image/jpeg;base64,base64编码的jpeg图片数据
				suffix = ".jpg";
			} else if ("data:image/x-icon;".equalsIgnoreCase(dataPrix)) {// data:image/x-icon;base64,base64编码的icon图片数据
				suffix = ".ico";
			} else if ("data:image/gif;".equalsIgnoreCase(dataPrix)) {// data:image/gif;base64,base64编码的gif图片数据
				suffix = ".gif";
			} else if ("data:image/jgp;".equalsIgnoreCase(dataPrix)) {// data:image/png;base64,base64编码的jgp图片数据
				suffix = ".jpg";
			} else if ("data:image/png;".equalsIgnoreCase(dataPrix)) {// data:image/png;base64,base64编码的png图片数据
				suffix = ".png";
			} else {
				suffix = ".jpg";
			}
			String tempFileName = FileUtils.getRandomFileName() + suffix;
			log.debug("生成文件名为：" + tempFileName);

			// 因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
			byte[] bs = null;
			try {
				bs = FileUtils.decoderBase64File(data);
			} catch (Exception ex) {
				log.error("base64转换异常 = " + ex.getMessage());
			}
			try {
				log.debug("上传图片路径 = " + Constants.LINUXPATH + tempFileName);
				OutputStream os = new FileOutputStream(Constants.LINUXPATH + tempFileName);
				os.write(bs);
				os.flush();
				os.close();
				FTPUpload ftpUpload = new FTPUpload();
				ftpUpload.connect("", Constants.FTP.PATH, Constants.FTP.PORT, Constants.FTP.USERNAME, Constants.FTP.PASSWORD);
				File file = new File(Constants.LINUXPATH + tempFileName);
				ftpUpload.upload(file);
				java.io.File myDelFile = new java.io.File(Constants.LINUXPATH + tempFileName);
				myDelFile.delete();
			} catch (Exception ee) {
				throw new Exception("上传失败，写入文件失败，" + ee.getMessage());
			}
			result.put("result", "00");
			result.put("msg", "上传成功");
			result.put("data", tempFileName);
			log.debug("上传成功");
		} catch (Exception e) {
			log.debug("上传失败," + e.getMessage());
			result.put("result", "01");
			result.put("msg", "上传失败," + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 根据文件id下载文件
	 * 
	 * 
	 * 
	 * @param mediaId
	 * 
	 *            媒体id
	 * 
	 * @throws Exception
	 * 
	 */
	public InputStream getInputStream(String mediaId) {
		AccessTokenService accessTokenService = new AccessTokenService();
		InputStream is = null;
		String url = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=" + accessTokenService.refreshAccessToken().getAccesstoken() + "&media_id=" + mediaId;
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
			http.setRequestMethod("GET"); // 必须是get方式请求
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
			http.connect();
			// 获取文件转化为byte流
			is = http.getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

	/**
	 * 
	 * 获取下载图片信息（jpg）
	 * 
	 * 
	 * 
	 * @param mediaId
	 * 
	 *            文件的id
	 * 
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "/saveImageToDisk", method = RequestMethod.GET)
	@ResponseBody
	public void saveImageToDisk(String mediaId) throws Exception {
		log.debug("mediaId = " + mediaId);
		InputStream inputStream = getInputStream(mediaId);
		byte[] data = new byte[1024];
		int len = 0;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("/root/yjdata/www/www/getOpenId/test1.jpg");
			while ((len = inputStream.read(data)) != -1) {
				fileOutputStream.write(data, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @desc 设置行业信息
	 * @param industry_id1
	 * @param industry_id2
	 * @return
	 */
	@RequestMapping(value = "/SetIndustry", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject SetIndustry(String industry_id1, String industry_id2) {
		JSONObject result = new JSONObject();
		try {
			result = sm.SetIndustry(industry_id1, industry_id2);
			return result;
		} catch (Exception e) {
			log.error("SetIndustry exception", e);
			return null;
		}
	}

	/**
	 * @desc 获取设置的行业信息
	 * @return
	 */
	@RequestMapping(value = "/GetIndustry", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject GetIndustry() {
		JSONObject result = new JSONObject();
		try {
			result = sm.GetIndustry();
			return result;
		} catch (Exception e) {
			log.error("GetIndustry exception", e);
			return null;
		}
	}

	/**
	 * @desc 获取模板ID
	 * @param jsonObject
	 * @return
	 */
	@RequestMapping(value = "/GetTemplateId", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject GetTemplateId(String template_id_short) {
		JSONObject result = new JSONObject();
		try {
			result = sm.GetTemplateId(template_id_short);
			return result;
		} catch (Exception e) {
			log.error("Send exception", e);
			return null;
		}
	}

	/**
	 * @desc 推送信息
	 * @param jsonObject
	 * @return
	 */
	@RequestMapping(value = "/Send", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject Send(@RequestBody JSONObject jsonObject) {
		JSONObject result = new JSONObject();
		try {
			result = sm.Send(jsonObject);
			return result;
		} catch (Exception e) {
			log.error("Send exception", e);
			return null;
		}
	}

}

package com.getOpenId.utils;

import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import net.sf.json.JSONObject;

public class AES {
	public static String AesPd = "1dl2ysasdqwe1234";  
	public static void main(String[] args) {
	    //加密  
		//四要素测试数据
		Map<String, String> map = new HashMap<String, String>();
		map.put("openid", "0726002");
		map.put("tel", "15542688830");
		map.put("name", "孙雷");
		map.put("bankid", "6217710400330403");
		map.put("cardid", "230703199003201010");
		JSONObject jsonmap = JSONObject.fromObject(map);
	    System.out.println("加密前：" + jsonmap);  
	    String encryptResult = "";
		try {
			encryptResult = encrypt(jsonmap.toString(), AesPd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    
	    
	    System.out.println("加密后：" + encryptResult);  
	    //解密  
	    String decryptResult = "";
		try {
			decryptResult = decrypt(encryptResult,AesPd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    System.out.println("解密后：" + new String(decryptResult));  
	}

    /** 
     * 加密 
     *  
     * @param content 需要加密的内容 
     * @param password  加密密码 
     * @return 
     */  
    // 加密
    public static String encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return StrChange.parseByte2HexStr(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }
    
    /**解密 
     * @param content  待解密内容 
     * @param password 解密密钥 
     * @return 
     */  
    public static String decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = StrChange.parseHexStr2Byte(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

}

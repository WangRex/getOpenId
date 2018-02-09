/**   
* @Title: FTPUpload.java 
* @Package com.getOpenId.utils 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Rex   
* @date 2017年7月26日 下午1:39:42 
* @version V1.0   
*/
package com.getOpenId.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import com.getOpenId.constant.Constants;

/**
 * @ClassName: FTPUpload
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Rex
 * @date 2017年7月26日 下午1:39:42
 * 
 */
public class FTPUpload {
	
	private FTPClient ftp;

	/**
	 * 
	 * @param path
	 *            上传到ftp服务器哪个路径下
	 * @param addr
	 *            地址
	 * @param port
	 *            端口号
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 * @throws Exception
	 */
	public boolean connect(String path, String addr, int port, String username, String password) throws Exception {
		boolean result = false;
		ftp = new FTPClient();
		int reply;
		ftp.connect(addr, port);
		ftp.login(username, password);
		ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			return result;
		}
		ftp.changeWorkingDirectory(path);
		result = true;
		return result;
	}

	/**
	 * 
	 * @param file
	 *            上传的文件或文件夹
	 * @throws Exception
	 */
	public void upload(File file) throws Exception {
		if (file.isDirectory()) {
			ftp.makeDirectory(file.getName());
			ftp.changeWorkingDirectory(file.getName());
			String[] files = file.list();
			for (int i = 0; i < files.length; i++) {
				File file1 = new File(file.getPath() + "\\" + files[i]);
				if (file1.isDirectory()) {
					upload(file1);
					ftp.changeToParentDirectory();
				} else {
					File file2 = new File(file.getPath() + "\\" + files[i]);
					FileInputStream input = new FileInputStream(file2);
					ftp.storeFile(file2.getName(), input);
					file2.getAbsolutePath();
					input.close();
				}
			}
		} else {
			File file2 = new File(file.getPath());
			FileInputStream input = new FileInputStream(file2);
			ftp.storeFile(file2.getName(), input);
			input.close();
		}
	}

	public static void main(String[] args) throws Exception {
		FTPUpload t = new FTPUpload();
		t.connect("", Constants.FTP.PATH, Constants.FTP.PORT, Constants.FTP.USERNAME, Constants.FTP.PASSWORD);
		File file = new File("C:\\Users\\Rex\\Desktop\\银联\\test.txt");
		t.upload(file);
	}
}

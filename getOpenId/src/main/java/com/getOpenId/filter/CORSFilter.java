/**   
* @Title: CORSFilter.java 
* @Package com.rmbih.filter 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Rex   
* @date Jun 2, 2016 11:56:18 AM 
* @version V1.0   
*/
package com.getOpenId.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: CORSFilter
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Rex
 * @date Jun 2, 2016 11:56:18 AM
 * 
 */
public class CORSFilter implements Filter {

	/*
	 * (非 Javadoc) <p>Title: destroy</p> <p>Description: </p>
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * (非 Javadoc) <p>Title: doFilter</p> <p>Description: </p>
	 * 
	 * @param req
	 * 
	 * @param res
	 * 
	 * @param fc
	 * 
	 * @throws IOException
	 * 
	 * @throws ServletException
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
		HttpServletResponse httpServletResponse = (HttpServletResponse) res;
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		fc.doFilter(req, res);
	}

	/*
	 * (非 Javadoc) <p>Title: init</p> <p>Description: </p>
	 * 
	 * @param arg0
	 * 
	 * @throws ServletException
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}

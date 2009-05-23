package com.googlecode.gradlesamples.tipoftheday.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.gradlesamples.tipoftheday.ejb.TipOfTheDayBeanLocal;
import com.googlecode.gradlesamples.tipoftheday.ejb.TipOfTheDayVO;

/**
 * Servlet implementation class TipOfTheDayJSONServlet
 */
public class TipOfTheDayJSONServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(TipOfTheDayJSONServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TipOfTheDayJSONServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		TipOfTheDayBeanLocal bean = null;

		try {
			InitialContext ctx = new InitialContext();
			bean = (TipOfTheDayBeanLocal) ctx
					.lookup("java:comp/env/ejb/TipOfTheDay");
		} catch (NamingException e) {
			logger.error(e.getMessage(), e);
			throw new ServletException(e);
		}

		if (bean != null) {
			TipOfTheDayVO tip = bean.nextTip();
			JSONObject object = (JSONObject) JSONSerializer.toJSON(tip);
			writer.println(object.toString());
		}
	}

}

package com.googlecode.gradlesamples.tipoftheday.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.gradlesamples.tipoftheday.ejb.TipOfTheDayBeanLocal;
import com.googlecode.gradlesamples.tipoftheday.ejb.TipOfTheDayVO;

/**
 * Servlet implementation class TipOfTheDayServlet
 */
public class TipOfTheDayServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(TipOfTheDayServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipOfTheDayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		TipOfTheDayBeanLocal bean = null;
		
		try {
			InitialContext ctx = new InitialContext();
			bean = (TipOfTheDayBeanLocal) ctx.lookup("java:comp/env/ejb/TipOfTheDay");
		} catch (NamingException e) {
			e.printStackTrace(writer);
			logger.error(e.getMessage(), e);
		}
		
		if (bean != null) {
			TipOfTheDayVO tip = bean.nextTip();
			writer.print("<h1>" + tip.getTitle() + "</h1>");
			writer.print("<p>" + tip.getText() + "</p>");
		}

		writer.flush();
	}

}

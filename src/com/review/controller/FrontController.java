package com.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.review.beans.ActionBean;
import com.review.services.Authentication;
import com.review.utilities.Logger;

@WebServlet({ "/FrontController", "/el", "/redirect", "/ajax" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = new Logger();

	public FrontController() {
		super();
	}

	void frontController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("frontController");
		ActionBean action = null;
		Authentication auth = null;

		/* 한글화, 일어화? 지원 */
		request.setCharacterEncoding("UTF-8");

		/* JobCode 분리 */
		String jobCode = request.getRequestURI().substring(request.getContextPath().length() + 1);
		logger.info(jobCode);
		switch (jobCode) {
		case "el":
		case "redirect":
		case "ajax":
			auth = new Authentication(logger);
			action = auth.backController(request);
			break;
		case "4":
			break;
		case "5":
			break;
		}

		if (action.getAjaxData() != null) {
			/* Ajax */
			logger.info(action.getAjaxData());
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(action.getAjaxData());
		} else {
			if (action.isDispatcher()) {
				/* EL */
				RequestDispatcher dispatcher = request.getRequestDispatcher(action.getPage());
				dispatcher.forward(request, response);
			} else {
				/* redirect */
				response.sendRedirect(action.getPage());
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// <form method="get" action="action">
		// <input name="name" value="value" />
		// </form>

		logger.info("doGet");
		// get 방식으로 전송 받으면 이 함수로 들어옴

		logger.info(request.getRequestURI());
		// /review/action

		logger.info(request.getRequestURL());
		// http://192.168.35.169/review/action

		logger.info(request.getContextPath());
		// /review

		logger.info(request.getLocalAddr());
		logger.info(request.getRemoteAddr());
		logger.info(request.getParameter("name"));
		// value

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// <form method="post" action="action">
		// <input name="name" value="value" />
		// </form>

		logger.info("doPost");
		// post 방식으로 전송 받으면 이 함수로 들어옴		

		logger.info(request.getRequestURI());
		// /review/action

		logger.info(request.getRequestURL());
		// 192.168.35.169/review/action

		logger.info(request.getContextPath());
		// /review

		logger.info(request.getLocalAddr());
		logger.info(request.getRemoteAddr());
		logger.info(request.getParameter("name"));
		// value
		
		this.frontController(request, response);
	}
}

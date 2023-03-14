package com.review.services;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import com.review.beans.ActionBean;
import com.review.utilities.Logger;

public class Authentication {
	private Logger logger;
	
	public Authentication(Logger logger) {
		this.logger = logger;
	}
	public ActionBean backController(HttpServletRequest request) {
		logger.info("auth backCongroller");
		ActionBean action = null;
		
		/* JobCode 분리 */
		String jobCode = request.getRequestURI().substring(request.getContextPath().length() + 1);
		logger.info(jobCode);
		switch(jobCode) {
		case "el":
			action = this.el(request);
			break;
		case "redirect":
			action = this.redirect(request);
			break;
		case "ajax":
			action = this.ajax(request);
			break;
		case "3":
			action = null;
			break;
		case "4":
			action = null;
			break;
		case "5":
			action = null;
			break;
		}
		return action;
	}
	
	private ActionBean el(HttpServletRequest request) {
		ActionBean action = null;
		action = new ActionBean();
		action.setDispatcher(true);
		action.setPage("another.jsp");
	
		request.setAttribute("name", request.getParameter("name"));
		
		return action;
	}
	private ActionBean redirect(HttpServletRequest request) {
		ActionBean action = null;
		action = new ActionBean();
		action.setDispatcher(false);
		action.setPage("another.jsp");
			
		return action;
	}
	private ActionBean ajax(HttpServletRequest request) {
		logger.info("ajax");
		ActionBean action = null;
		action = new ActionBean();
	
		action.setAjaxData("ajax : " + request.getParameter("name"));
		
		return action;
	}
}

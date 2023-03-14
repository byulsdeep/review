package com.review.beans;

public class ActionBean {
	private String page;
	private boolean isDispatcher;
	private String ajaxData;
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public boolean isDispatcher() {
		return isDispatcher;
	}
	public void setDispatcher(boolean isDispatcher) {
		this.isDispatcher = isDispatcher;
	}
	public String getAjaxData() {
		return ajaxData;
	}
	public void setAjaxData(String ajaxData) {
		this.ajaxData = ajaxData;
	}
}

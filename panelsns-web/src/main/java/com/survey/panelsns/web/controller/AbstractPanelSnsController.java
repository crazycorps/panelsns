package com.survey.panelsns.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.survey.panelsns.model.entity.Users;
import com.survey.tools.util.ServletUtils;

public abstract class AbstractPanelSnsController {

	/**
	 * panel_sns_session_user_key
	 */
	public static final String SESSION_USER_KEY="p_s_s_u_k";
	
	protected Users getSessionUsers(HttpServletRequest request){
		Users users=null;
		HttpSession session=ServletUtils.getSession(request);
		users=(Users)session.getAttribute(SESSION_USER_KEY);
		return users;
	}
}

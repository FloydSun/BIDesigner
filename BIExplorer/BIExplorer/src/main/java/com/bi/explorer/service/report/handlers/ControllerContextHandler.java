package com.bi.explorer.service.report.handlers;

import com.xml.frame.report.component.Component;
import com.xml.frame.report.component.controller.ControllerRequest;
import com.xml.frame.report.component.entity.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ControllerContextHandler implements ContextHandler{

	@Override
	public void onHandle(Context context) {
		HttpServletRequest request = (
				(ControllerRequest) context.get(Component.REQUEST))
					.getRequest();
		HttpServletResponse resp = (
				(HttpServletResponse) context.get(Component.RESPONSE));
		onHandle(context, request, resp);
	}

	abstract void onHandle(Context context, HttpServletRequest request, HttpServletResponse resp);

}

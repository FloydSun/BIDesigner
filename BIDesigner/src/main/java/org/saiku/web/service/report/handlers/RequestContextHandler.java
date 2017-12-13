package org.saiku.web.service.report.handlers;

import com.xml.frame.report.component.Component;
import com.xml.frame.report.component.controller.ControllerRequest;
import com.xml.frame.report.component.controller.ControllerSession;
import com.xml.frame.report.component.entity.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestContextHandler implements ContextHandler {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	public RequestContextHandler(HttpServletRequest request,
			HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
	}

	@Override
	public void onHandle(Context context) {
		context.put(Component.REQUEST, new ControllerRequest(request));
		context.put(Component.SESSION, new ControllerSession(request.getSession()));
		context.put(Component.RESPONSE, response);
	}

}

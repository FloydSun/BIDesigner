package com.bi.explorer.service.report.handlers;

import com.util.tools.PathUtil;
import com.xml.frame.report.component.Component;
import com.xml.frame.report.component.entity.Context;
import com.xml.frame.report.util.EasyCalendar;

import java.net.URISyntaxException;


public class UtilContextHandler implements ContextHandler {

	static String templatePath = null;
	static {
		try {
			templatePath = PathUtil.getClassRoot() + "META-INF/templates/";
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onHandle(Context context){
		context.put(Component.CALENDAR, new EasyCalendar());
		context.put("template", templatePath);
		context.put("counterFactory", new Counter());
	}


}
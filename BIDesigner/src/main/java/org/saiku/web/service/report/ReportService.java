package org.saiku.web.service.report;

import com.util.tools.DataNode;
import com.xml.frame.report.component.entity.Context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ReportService {

	Context doController(HttpServletRequest request, HttpServletResponse response, String controllor) throws Exception;

	Context doService(String service) throws Exception;

	Context doService(Context context, String service) throws Exception;

	Context doService(HttpServletRequest request, HttpServletResponse response, String service) throws Exception;

	DataNode getCSN();

	Context doController(HttpServletRequest request, HttpServletResponse response, String controllor, Context context)
			throws Exception;

}

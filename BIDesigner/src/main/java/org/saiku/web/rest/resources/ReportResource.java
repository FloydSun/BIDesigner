package org.saiku.web.rest.resources;

import com.xml.frame.report.component.entity.Context;
import org.saiku.web.service.report.ReportService;
import org.saiku.web.service.report.ReportServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@org.springframework.stereotype.Component
@Path("/report")
public class ReportResource {
	@Resource(name= ReportServiceImpl.NAME)
	ReportService reportService;

//	@RequestMapping(value = "console/show")
//	public ModelAndView consoleShow(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		DataNode tree = reportService.getCSN();
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("componentTree", JSONObject.fromObject(tree).toString());
//		return new ModelAndView("report/report_console", model);
//	}
    @GET
    @Produces( {"application/json"})
	@Path("/{controller}")
	public String onController(@javax.ws.rs.core.Context HttpServletRequest request,
                                 @javax.ws.rs.core.Context HttpServletResponse response,
			@PathParam("controller") String controllor) throws Exception {
		
		Context context = reportService.doController(request, response, controllor);
//		if (null != context){
//			ModelAndView mv = (ModelAndView) context.get(Controller.MODEL_AND_VIEW);
//			return mv;
//		}
		return "";
	}
}

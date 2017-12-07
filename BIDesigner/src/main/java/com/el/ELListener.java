package com.el;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

public class ELListener implements WebApplicationInitializer {





    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        Enumeration<String> enu = servletContext.getInitParameterNames();
        while(enu.hasMoreElements()){
            String name = enu.nextElement();
            String val = servletContext.getInitParameter(name);
            val = PathUtil.parseEl(val);
            servletContext.setAttribute(name, val);
        }
    }
}

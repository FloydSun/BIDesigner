package com.bi.explorer.controller.servlet.login;

import com.bi.explorer.model.entity.Account;
import com.bi.explorer.model.entity.NavigateItemEntity;
import com.bi.explorer.service.login.LoginService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "home")
public class LoginServlet {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = {"index.do"})
    public ModelAndView index(HttpServletRequest request,
                              HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        SecurityContext securityContext = (SecurityContext) request
                .getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        if (request.getSession().getAttribute("account") == null){
            request.setAttribute("account", loginService.getAccount(securityContext.getAuthentication().getName()));
        }

        if (request.getSession(false).getAttribute("navTree") == null){
            Account account = (Account) request.getSession().getAttribute("account");
            List<NavigateItemEntity> navTree = loginService.getNavigateItems(account);
            request.getSession().setAttribute("navTree", navTree);
        }

        map.put("navTree", JSONArray.fromObject(request.getSession(false).getAttribute("navTree")).toString());
        map.put("item", request.getParameter("item"));
        map.put("userName", securityContext.getAuthentication().getName());
        return new ModelAndView("index", map);
    }

    @RequestMapping(value = {"login.do"})
    public ModelAndView login(HttpServletRequest request,
                              HttpServletResponse response) {
        return new ModelAndView("login");
    }
}
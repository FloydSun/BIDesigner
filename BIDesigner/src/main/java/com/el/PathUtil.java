package com.el;

import org.springframework.web.WebApplicationInitializer;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class PathUtil {

    final static String WEBROOT = PathUtil.getWebRoot() + "/";
    final static String CLASSROOT = PathUtil.getClassRoot() + "/";


    public static String getClassRoot(){
        try{
            File f = new File(PathUtil.class.getClassLoader().getResource("").toURI());
            return f.getAbsolutePath();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getWebRoot() {
        try{
            File f = new File(PathUtil.class.getClassLoader().getResource("").toURI());
            File wroot = f.getParentFile().getParentFile();
            return wroot.getAbsolutePath();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String parseEl(String param) {
        Querier elq = new ELBlockQuerier(param);
        List<Object[]> ls = null;
        while (elq.hasNext()){
            if (null == ls){
                ls = new ArrayList<Object[]>();
            }
            ls.add(new Object[]{elq.start(), elq.end(), elq.next()});
        }

        if (ls != null){
            for (int i = ls.size() - 1; i >= 0; --i){
                Object[] el = ls.get(i);
                String elv = null;
                if ("webroot".equals(el[2])){
                    elv = WEBROOT;
                } else if ("classroot".equals(el[2])){
                    elv = CLASSROOT;
                } else {
                    elv = System.getProperty((String) el[2]);
                }

                if (elv != null){
                    param = param.substring(0, (Integer) el[0]) +
                            elv +
                            param.substring(((Integer)el[1]));
                }
            }
        }
        return param;
    }
}

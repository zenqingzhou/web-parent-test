package com.bidewu.web.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * WebUtil 负责Cookie/Session等的管理。通常，所有对Cookie/Session的操作都通过此类来完成。 <br>
 * 
 * Session最终是采用 容器来管理，
 */
public class WebUtil {
    /***
     * Cookie约定的名称
     */
    // PropertiesUtil propertiesUtil =
    // PropertiesUtil.createPropertiesUtil("sso.properties");
    public static String tokenPName     = "Token";    // propertiesUtil.getProperty("cookieTokenName");
    public static String uIdPName       = "UID";      // t_user.id
    public static String subUserIdPName = "SubUserId"; // 如：employee.id ,
                                                       // member.id等
    public static String userIdPName    = "UserId";   // t_user.userId==loginName
    public static String niceNamePName  = "NiceName"; // t_user.name
    public static int    maxAge         = 60 * 60;    // Integer.valueOf(propertiesUtil.getProperty("cookieage"));
    public static String path           = "/";

    /**
     * 获取调用方IP
     * 
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 根据名字从Session中获取一个对象
     * 
     * @param request
     *            HttpServletRequest对象
     * @param name
     *            Session中对象的名字
     * @return Object
     */
    @SuppressWarnings("unchecked")
    public static <T> T getObject(HttpServletRequest request, String name) {
        return (T) request.getSession().getAttribute(name);
    }

    /**
     * 根据名字从Session中获取验证码
     * 
     * @param request
     *            HttpServletRequest对象
     * @param name
     *            Session中对象的名字
     * @return Object
     */
    @SuppressWarnings("unchecked")
    public static <T> T getSessionObject(HttpServletRequest request, String name) {
        return (T) request.getSession().getAttribute(name);
    }

    /**
     * 根据给定的name将一个对象保存到Session中
     * 
     * @param request
     *            HttpServletRequest对象
     * @param name
     *            Session中对象的名字
     * @param object
     *            需要保存到Session的对象
     */
    public static <T> void putObject(HttpServletRequest request, String name, T object) {
        request.getSession().setAttribute(name, object);
    }

    /**
     * 将Session置为无效状态，通常在注销时调用
     * 
     * @param request
     *            HttpServletRequest
     */
    public static void invalidateSession(HttpServletRequest request) {
        request.getSession().invalidate();
    }

    /**
     * 将Session 去掉属性值
     * 
     * @param request
     *            HttpServletRequest
     */
    public static void removeSessionAttr(HttpServletRequest request, String name) {
        request.getSession().removeAttribute(name);
    }

    /**
     * 获取URI的路径,如路径为http://www.example.com/example/user.do?method=add,
     * 得到的值为"/example/user.do"
     * 
     * @param request
     * @return String
     */
    public static String getRequestURI(HttpServletRequest request) {
        return request.getRequestURI();
    }

    /**
     * 获取不包含应用名字的URI的路径, 并去掉最前面的"/", <br>
     * 如路径为http://localhost:8080/appName/user/list.do,
     * 得到的值为"user/list.do",其中appNames为应用的名字
     * 
     * @param request
     * @return String
     */
    public static String getNoAppNamedRequestURI(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String uri = request.getRequestURI();
        String realUri = uri.replace(contextPath, "");
        while (realUri.startsWith("/")) {
            realUri = realUri.substring(1);
        }
        realUri = realUri.replaceAll("/+", "/");
        return realUri;
    }

    /**
     * 获取应用的根目录
     * 
     * @param request
     * @return
     */
    public static String getContextPath(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        if (contextPath.equals("/")) {
            return "";
        }
        return contextPath;
    }

    /**
     * 获取完整请求路径(含内容路径及请求参数)
     * 
     * @param request
     * @return
     */
    public static String getRequestURIWithParam(HttpServletRequest request) {
        return getRequestURI(request)
               + (request.getQueryString() == null ? "" : "?" + request.getQueryString());
    }

    /**
     * 获取处理用户连接,拦截器用
     * 
     * @param request
     * @param url
     * @return
     */
    public static String getUrl(HttpServletRequest request, String url) {
        StringBuffer forword = new StringBuffer();
        StringBuffer beginUrl = new StringBuffer();
        StringBuffer backUrl = new StringBuffer();
        beginUrl.append(url);
        Map<String, String[]> paramMap = request.getParameterMap();
        if (paramMap != null) {
            for (String s : paramMap.keySet()) {
                String[] value = paramMap.get(s);
                for (String val : value) {
                    backUrl.append(s).append("=").append(val).append("&");
                }
            }
        }
        forword.append(beginUrl);
        if (backUrl.length() > 0) {
            forword.append("?").append(backUrl);
        }
        if (forword.length() > 1) {
            if (forword.substring(forword.length() - 1, forword.length()).indexOf("&") > -1) {
                return String.valueOf(forword.subSequence(0, forword.length() - 1));
            }
        }
        return String.valueOf(forword);
    }

    /** 
     * Title: 从request获取字符串<br/> 
     * Description: <br />
     * 

     */
    public static String getString(HttpServletRequest request, String param) {
        try {
            String value = request.getParameter(param).trim();
            if (StringUtils.isBlank(value)) {
                value = request.getAttribute(param).toString().trim();
            }
            return value == null ? "" : value;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 
     * 功能描述：从request获取字符串数组<br/> 
     *
     * @param request
     * @param param
     * @return
     */
    public static String[] getStringValues(HttpServletRequest request, String param) {
        try {
            String[] values = request.getParameterValues(param);
            if (StringTool.isEmpty(values)) {
                values = (String[]) request.getAttribute(param);
            }
            return values == null ? new String[] {} : values;
        } catch (Exception e) {
            return new String[] {};
        }
    }

    /** 
     * Title: 从request获取Long型数字<br/> 
     * Description: <br />
     * 

     */
    public static Long getLong(HttpServletRequest request, String param) {
        String value = getString(request, param);
        if (StringUtils.isBlank(value) || !StringUtils.isNumeric(value)) {
            return null;
        }
        return Long.valueOf(value);
    }

    /** 
     * Title: 从request中获取int数字<br/> 
     * Description: <br />

     */
    public static int getInt(HttpServletRequest request, String param) {
        Long value = getLong(request, param);
        if (value == null) {
            return 0;
        }
        return value.intValue();
    }

    /**
     * 功能描述：包装分页url
     *
     * @param request
     * @param url
     * @param paramMap
     * @return
     */
    public static String toPageUrl(HttpServletRequest request, String url,
                                   Map<String, Object> paramMap) throws Exception{
        // 返回新的URL
        String newURL = request.getContextPath() + url + "?pageNo=pageNow";
        if (null != paramMap && paramMap.size() > 0) {
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                String value = entry.getValue() + "";
                if (StringUtils.isNotBlank(value)) {
                    newURL += "&" + entry.getKey() + "=" + value;
                }
            }
        }
        return newURL;
    }

    /**
     * 
     * 功能描述：通过Referer头信息获取来源URL
     *
     * @param request
     * @return
     */
    public static String getFromUrl(HttpServletRequest request) {
        // 原URL
        String fromUrl = StringUtils.trimToEmpty(request.getHeader("Referer"));
        if (StringUtils.isBlank(fromUrl)) {
            return "";
        }
        try {
            return new URL(fromUrl).getPath();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        }
    }

}

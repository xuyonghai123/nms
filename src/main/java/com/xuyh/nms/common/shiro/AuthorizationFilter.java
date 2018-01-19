package com.xuyh.nms.common.shiro;

import com.zabbix4j.utils.json.JSONObject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class AuthorizationFilter extends FormAuthenticationFilter {

    @Override
    public boolean onAccessDenied(ServletRequest request, ServletResponse response){
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("returnCode", ErrorEnum.E_20011.getErrorCode());
//        jsonObject.put("returnMsg", ErrorEnum.E_20011.getErrorMsg());
//        jsonObject.put("role","admin");
//        jsonObject.put("token","admin");
//        jsonObject.put("introduction","我是超级管理员1");
//        jsonObject.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
//        jsonObject.put("name","Super Admin");
        PrintWriter out = null;
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            res.setCharacterEncoding("UTF-8");
            res.setContentType("application/json");
            out = response.getWriter();
            out.println(jsonObject);
        } catch (Exception ignored) {
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
        return false;
    }

}

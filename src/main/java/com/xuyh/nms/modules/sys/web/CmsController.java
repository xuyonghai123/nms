package com.xuyh.nms.modules.sys.web;

import com.google.gson.JsonObject;
import com.xuyh.nms.modules.sys.entity.Form;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@RestController
public class CmsController {

    @RequestMapping(value = "/form/submit",method = RequestMethod.POST)
    public void form(@RequestBody Form form,HttpServletRequest request) throws IOException {
        System.out.println(form.getName());
        System.out.println(form.getDate1());
        Enumeration<String> paraNames=request.getParameterNames();
        for(Enumeration e=paraNames;e.hasMoreElements();) {
            String thisName = e.nextElement().toString();
            String thisValue = request.getParameter(thisName);
            System.out.println(thisName + "--------------" + thisValue);
        }
    }
}

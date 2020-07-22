package com.qiang.springbootweb01.component;



import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public  class MyErrorArrtributes extends DefaultErrorAttributes {
//    @Override
//    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
//
//        return super.getErrorAttributes(webRequest, includeStackTrace);
//    }
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext",ext);
        return map;
    }

}

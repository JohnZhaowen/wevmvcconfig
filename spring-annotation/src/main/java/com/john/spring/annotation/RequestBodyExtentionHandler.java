package com.john.spring.annotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.fastjson.JSONObject;

@Configuration
public class RequestBodyExtentionHandler implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(RequestBodyExtention.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		String argName = getArgName(parameter);
		JSONObject body = getRequestBody(webRequest);
		return getArg(parameter, argName, body);
	}
	
	private JSONObject getRequestBody(NativeWebRequest webRequest) throws IOException {
		
		HttpServletRequest nativeRequest = webRequest.getNativeRequest(HttpServletRequest.class);
		ServletInputStream inputStream = nativeRequest.getInputStream();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuffer buffer = new StringBuffer(); 
		String line = "";  
		while ((line = reader.readLine()) != null){  
		     buffer.append(line);  
		}
		
		return JSONObject.parseObject(buffer.toString());
		
	}
	
	private String getArgName(MethodParameter parameter) {
		
		RequestBodyExtention pa = parameter.getParameterAnnotation(RequestBodyExtention.class);
		String annoName = pa.name();
		String annoValue = pa.value();
		
		String paraName = parameter.getParameterName();
		
		String argName = null;
		if(!StringUtils.isEmpty(annoName)) {
			argName = annoName;
		} else if(!StringUtils.isEmpty(annoValue)) {
			argName = annoValue;
		} else {
			argName = paraName;;
		}
		return argName;
	}
	
	private Object getArg(MethodParameter parameter, String argName, JSONObject body) throws Exception {
		RequestBodyExtention pa = parameter.getParameterAnnotation(RequestBodyExtention.class);
		String annoDefaultValue = pa.defaultValue();
		boolean required = pa.required();
		Type type = parameter.getGenericParameterType();
		
		String argStr = body.getString(argName);
		if(required && StringUtils.isEmpty(argStr) && StringUtils.isEmpty(annoDefaultValue)) {
			throw new Exception();
		}
		
		if(StringUtils.isEmpty(argStr)) {
			argStr = annoDefaultValue;			
		}				
		
		return JSONObject.parseObject(argStr, type);
	}
	

}






















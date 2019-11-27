package com.cos.crud.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	public String back(String msg){
	
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+msg+"');");
		sb.append("history.back();");
		sb.append("</script>");
	
		return sb.toString();
	}
	

	
	public String href(String location){
		
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("location.href='"+location+"'");
		sb.append("</script>");

		return sb.toString();
	}
	
}

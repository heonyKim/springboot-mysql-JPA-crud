package com.cos.crud.utils;

public class Script {
	public String back(String msg){
	
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+msg+"');");
		sb.append("history.back();");
		sb.append("</script>");
	
		return sb.toString();
	}
	
	public String backHref(String msg, String location){
		
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('"+msg+"');");
		sb.append("location.href='"+location+"'");
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

package com.hjp.shop.controller;

import java.io.StringWriter;
import java.util.Date;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import com.jfinal.core.Controller;

public class AdminControlller extends Controller {
	
	public void index() {
		
		//ȡ������
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "WebRoot/admin");
		try {
			
			
			//��ʼ������
			ve.init();
			
			//ȡ��velocity��ģ��
			Template template = ve.getTemplate("index.vm");
			
			//ȡ��������
			VelocityContext content = new VelocityContext();
			
			//��������������
			content.put("name", "huangjiangping");
			content.put("date", new Date().toString());
			
			//�����
			StringWriter writer = new StringWriter();
			
			//ת�����
			template.merge(content, writer);
			renderVelocity(writer.toString());
			//renderHtml(writer.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

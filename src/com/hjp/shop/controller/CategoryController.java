package com.hjp.shop.controller;

import com.hjp.shop.model.Category;
import com.jfinal.core.Controller;

public class CategoryController extends Controller {
		public void list(){
			
		}
		public void add(){
			String name = getPara("name");
			String descr = getPara("descr");
			if(name!=null && descr!=null){
				Category c = new Category();
				c.set("name", name);
				c.set("descr", descr);
				c.set("pid", 0);
				c.set("isleaf", 1);
				c.set("grade", 1);
				if(c.save()){
					setAttr("info", "��ӳɹ�");
				}else{
					setAttr("info", "���ʧ��");
				}
			}
			render("add.html");
		}
		public void delete(){
			
		}
		public void update(){
			
		}
}

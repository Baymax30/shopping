package com.hjp.shop.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class Salesorder extends Model<Salesorder> {

	private static final long serialVersionUID = 1L;
	
	public static Salesorder dao = new Salesorder();
	
	/**
	 * ͨ���û�idȡ��ĳһ���û������ж���
	 * @param uid �û�id
	 * @return �����б�
	 * 
	 */
	public List<Salesorder> getOrdersByUid(int uid) {
		String sql = "select * from tbl_salesorder where userid = " +uid;
		return find(sql);
	}
	/**
	 * ȡ�������Ǹ�id��һ������ȡ�ø��Զ����ɵ��Ǹ�id������漰����������
	 * @return int id 
	 */
	public int getLastId(){
		return findFirst("select id from tbl_salesorder order by id desc limit 1").getInt("id");
	}
}

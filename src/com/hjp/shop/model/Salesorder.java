package com.hjp.shop.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

public class Salesorder extends Model<Salesorder> {

	private static final long serialVersionUID = 1L;
	private static final int pageSize = 5;
	public static Salesorder dao = new Salesorder();
	/**
	 * ȡ�����ݿ��еļ�¼����/pagesize
	 * @return int ҳ��
	 */
	public long  getCountPage(){
		long count = findFirst("select count(*) count from tbl_salesorder").getLong("count");
		return (count +Salesorder.pageSize -1)/Salesorder.pageSize ;
	}
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
	/**
	 * ȡ��ĳһҳ�Ķ���
	 * @param pageNo �ڼ�ҳ
	 * @return list for order
	 */
	public List<Salesorder> getAllOrder(int pageNo) {
		return this.paginate(pageNo,Salesorder.pageSize, "select * ", " from tbl_salesorder order by id asc").getList();
	}
}

package com.hjp.shop.model;


import java.security.MessageDigest;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class User extends Model<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3025124637286140521L;
	
	private static final int pageSize = 5;	
	
	public static User dao = new User();
	
	/**
	 * ȡ�����ݿ��е�ĳһҳ����
	 * @param pageNo �ڼ�ҳ
	 * @return  pageSize ����¼
	 */
	public Page<User> getAlldate(int pageNo) {
		
		return this.paginate(pageNo,User.pageSize, "select * ", " from tbl_user order by id asc");
	}
	
	/**
	 *������ݿ�����û������û���
	 * @param username String  Ҫ�����û���
	 * @return String û�з���yes���з���no
	 */
	public String verify(String username) {
		String sqlString = "select * from tbl_user where username='" + username + "'";
		return User.dao.findFirst(sqlString)==null ? "yes" : "no";
	}
	/**
	 * �����û���ȡ�����ݿ�User��һ����¼
	 * @param name String �û���
	 * @return  User 
	 */
	public User getUserByName(String name){
		String sqlString = "select * from tbl_user where username = '" + name + "'";
		return User.dao.findFirst(sqlString);
	}
	/**
	 * �����û���ȡ�����Ӧ���û�����
	 * @param username �û���
	 * @return String password
	 */
	public String getPasswordByusername(String username) {
		String sqlString = "select password from tbl_user where username = '" + username + "'";
		return User.dao.findFirst(sqlString).getStr("password");
	}
	
	/**
	 * ����MD5���м��� ����
	 * @author hjp
	 * @param String str �����ܵ��ַ���
	 * @return ��String ���ܺ���ַ���
	 */
	public  static String EncoderByMd5(String str) {
		// ȷ�����㷽��
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			md5.update(str.getBytes("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte[] byteArray = md5.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			} else {
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
			}
		}
		return md5StrBuff.toString();
	}

	public long getPageCount() {
		long count = findFirst("select count(*) count from tbl_user").getLong("count");
		return (count + User.pageSize -1)/User.pageSize;
	}
}

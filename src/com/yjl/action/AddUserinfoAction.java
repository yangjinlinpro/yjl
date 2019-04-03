package com.yjl.action;
	
import java.io.IOException;	
import java.io.PrintWriter;	
import java.sql.*;
import javax.servlet.ServletException;	
import javax.servlet.http.HttpServlet;	
import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;
import com.yjl.db.DBManager;
/**
 * 添加用户
 *
 */
public class AddUserinfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)	
			throws ServletException, IOException {
		response.setContentType("text/html");	
		PrintWriter out = response.getWriter();	
		String name=request.getParameter("name");//登陆名
		String pwd=request.getParameter("pwd"); //密码
		String age=request.getParameter("age"); //年龄
		String tel=request.getParameter("tel"); //电话
		DBManager dbm = new DBManager();
		//添加用户
		String sql = "insert into userinfo(name,pwd,age,tel,jine) values('"+name+"','"+pwd+"','"+age+"','"+tel+"','0')";
		Statement stat = null;	
		Connection conn=null;	
		try {
			conn=dbm.getConnection();
			stat = conn.createStatement();	
			System.out.println(sql);	
			stat.execute(sql);	
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {	
			try {
				if(stat!=null)	
					stat.close();	
				if(conn!=null)	
					conn.close();	
			} catch (SQLException e) {
				e.printStackTrace();	
			}	
		}	
		response.sendRedirect("userinfo/list.jsp");	
		out.flush();	
		out.close();	
	}	
	 
}	

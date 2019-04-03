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
 * 添加车位
 *
*/
public class AddCheweiAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)	
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		String hao=request.getParameter("hao");//车位号
		String info=request.getParameter("info");//备注
		String qu=request.getParameter("qu");//区域
		String chepai="";//车牌
		String adate="";//缴费时间
		DBManager dbm = new DBManager();
		//添加车位
		String sql = "insert into chewei(hao,info,qu,chepai,adate) values('"+hao+"','"+info+"','"+qu+"','"+chepai+"','"+adate+"')";
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
		response.sendRedirect("chewei/list.jsp");	
		out.flush();	
		out.close();	
	}	
 
}	

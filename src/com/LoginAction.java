package com;
import com.yjl.db.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class LoginAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/head.jsp");
            dispatcher.forward(request, response);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        this.doPost(request, response);
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        String type = request.getParameter("type");

        DBManager dbm = new DBManager();


        request.getSession().setAttribute("fei", dbm.getSF());

        if (type.equals("用户")) {
            int uid = dbm.loginYH(username, userpwd);
            if (uid > 0) {
                request.getSession().setAttribute("user", username);
                request.getSession().setAttribute("uid", uid + "");
                request.getSession().setAttribute("type", "用户");
                //1.账号密码正确跳转到首页
                response.sendRedirect("index.jsp");

            } else {
                out.println("<script>alert('用户名或密码有误！');window.location.href='login.jsp'</script>");
            }

        } else if (type.equals("管理员")) {
            boolean login = dbm.login(username, userpwd);
            if (login) {

                request.getSession().setAttribute("user", username);
                request.getSession().setAttribute("type", "管理员");
                response.sendRedirect("index.jsp");

            } else {
                out.println("<script>alert('用户名或密码有误！');window.location.href='login.jsp'</script>");
            }
        } else {
            out.println("<script>alert('用户名或密码有误！');window.location.href='login.jsp'</script>");
        }

        out.flush();
        out.close();
    }
}
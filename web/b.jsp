<%--
  Created by IntelliJ IDEA.
  User: yjl
  Date: 2018/8/31
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<headj>
    <title>Title</title>
</headj>
<body>
<%
 //接收参数
    String code = request.getParameter("code");
    String name = request.getParameter("name");
    //控制台输出表单数据
    System.out.println("code="+code+",name="+name);
    //检查code的合法性
    if(code==null || code.trim().length()==0)
    {
        out.println("用户代码不能为空");
    }else if(code !=null&&code.equals("admin"))
    {
        out.println("不能用管理员代码！");
    }else
    {
        out.println("正确");
    }
%>
</body>
</html>

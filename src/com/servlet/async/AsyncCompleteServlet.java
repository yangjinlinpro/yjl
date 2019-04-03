package com.servlet.async;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AsyncCompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 78234L;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.encodeURL("utf-8");
        response.setContentType("text/html");
        final PrintWriter writer = response.getWriter();
        writer.println("<html><head><title>" +
                "Async Servlet</title></head>");
        writer.println("<body><div id='progress'></div>");
        final AsyncContext asyncContext = request.startAsync();
        asyncContext.setTimeout(60000);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                System.out.println("new thread:"+Thread.currentThread());
                System.out.println("new thread:"+Thread.currentThread().getName());
                System.out.println("new Thread:"+Thread.currentThread().getName());
                for(int i=0;i<10;i++)
                {
                    writer.println("<script>");
                    writer.println("document.getElementById(" +" 'progress').innerHTML='"+
                            (i*10)+"% complete'");
                    writer.println("</script>");
                    writer.flush();
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e)
                    {

                    }
                }
                writer.println("<script>");
                writer.println("document.getElementById("+"'progress').innerHTML='DONE'");
                writer.println("</script>");
                writer.println("</body></html>");
                asyncContext.complete();
            }
        });
    }
}

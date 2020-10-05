package cs544.exercise17_2;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentsCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        try {
            String studentIdStr = request.getParameter("studentid");
            long studentid = -1;
            Student student = null;
            ServletContext context = getServletContext();
            WebApplicationContext applicationContext =
                    WebApplicationContextUtils.getWebApplicationContext(context);

            if (studentIdStr != null && studentIdStr.matches("\\d+")) {

                //get studentService bean from spring
                StudentService studentService = applicationContext.getBean("studentService", StudentService.class);

                studentid = Long.parseLong(studentIdStr);
                student = studentService.getStudent(studentid);
            }

            request.setAttribute("student", student);
            request.getRequestDispatcher("student.jsp").forward(request, response);


        } catch (RuntimeException rtEx) {
            rtEx.printStackTrace();
        }
    }

}

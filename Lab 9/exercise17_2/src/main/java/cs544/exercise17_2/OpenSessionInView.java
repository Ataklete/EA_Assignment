package cs544.exercise17_2;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;

public class OpenSessionInView implements Filter {
    private SessionFactory sf;

    public void init(FilterConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        WebApplicationContext applicationContext =
                WebApplicationContextUtils.getWebApplicationContext(context);
        sf = applicationContext.getBean("sessionFactory", SessionFactory.class);
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        Transaction tx = null;
        try {
            tx = sf.getCurrentSession().beginTransaction();
            chain.doFilter(req, resp);
            tx.commit();
        } catch (RuntimeException ex) {
            try {
                ex.printStackTrace();
                tx.rollback();
            } catch (RuntimeException rbEx) {
                System.out.println("Could not rollback transaction " + rbEx);
                rbEx.printStackTrace();
            }
            throw ex;
        }
    }
}

package cs544.exercise16_2;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;
import javax.management.RuntimeErrorException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.transaction.Transaction;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {
    private SessionFactory sf;

    public void init(FilterConfig arg0) throws ServletException {
        sf = HibernateUtil.getSessionFactory();
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // TODO implement actual session in view filter code
        Transaction tx = null;
        try {
            tx = sf.getCurrentSession().beginTransaction();
            //chain.doFilter(request, response);
            // pass the request along the filter chain
            System.out.println("receiving request");
            chain.doFilter(request, response);
            System.out.println("sending response");
            tx.commit();
        } catch (RuntimeException rtEx) {
            try {
                rtEx.printStackTrace();
                tx.rollback();
            } catch (RuntimeErrorException rbEx) {
                System.out.println("Could not rollback transaction " + rbEx);
                rbEx.printStackTrace();
            }
            throw rtEx;
        }

    }

    public void destroy() {
    }


}

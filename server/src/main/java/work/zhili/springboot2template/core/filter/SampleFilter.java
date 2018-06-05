package work.zhili.springboot2template.core.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Title : work.zhili.springboot2template.core.filter <br>
 * Description :
 *   a sample filter
 *
 * @author chile
 * @version 1.0
 * @date 2018/6/5 10:29
 */
public class SampleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}

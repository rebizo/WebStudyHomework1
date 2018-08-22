package services;

import templater.PageGenerator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet2 extends HttpServlet {

    public class AllRequestsServlet extends HttpServlet {

        public void doGet(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

            Map<String, Object> pageVariables = createPageVariablesMap(request);
            pageVariables.put("message", "");

            //response.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
            response.getWriter().println(pageVariables.get("key").toString());

             if (pageVariables.containsKey("value")) {
                response.getWriter().println(pageVariables.get("value"));
            } else {
                response.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
            }

            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);

        }

        public Map<String, Object> createPageVariablesMap(HttpServletRequest request) { // static was
            Map<String, Object> pageVariables = new HashMap<>();
            pageVariables.put("method", request.getMethod());
            pageVariables.put("URL", request.getRequestURL().toString());
            pageVariables.put("pathInfo", request.getPathInfo());
            pageVariables.put("sessionId", request.getSession().getId());
            pageVariables.put("parameters", request.getParameterMap().toString());
            return pageVariables;//dsa
        }

    }
}

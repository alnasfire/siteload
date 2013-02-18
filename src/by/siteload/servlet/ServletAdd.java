package by.siteload.servlet;

import by.siteload.solr.SearchHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

public class ServletAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    /*
        generate the page showing all the request parameters
    */
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SearchHelper search = new SearchHelper();

        response.setStatus(200);

        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        // Get the values of all request parameters
        Enumeration en = request.getParameterNames();
        while (en.hasMoreElements()) {
            // Get the name of the request parameter
            String name = (String) en.nextElement();
//            out.println(name);

            // Get the value of the request parameter
            String value = request.getParameter(name);

            // If the request parameter can appear more than once in the query string, get all values
            String[] values = request.getParameterValues(name);

//            for (int i = 0; i < values.length; i++) {
            try {
                if (values.length > 0) {
                    List<String> links = search.getResults(values[0]);
                    for (String s : links) {
                        out.println(s);
                    }
                } else {
                    out.println("No results");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
//                out.println(" " + values[i]);
//            }
        }
        out.close();
    }
}
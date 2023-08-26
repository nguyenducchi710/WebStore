package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.UserDAO;
import java.util.ArrayList;
import Model.User;

public final class usermanagement_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("         <style>\n");
      out.write("            body {\n");
      out.write("                font-family: Arial, sans-serif;\n");
      out.write("                background-color: #f4f4f4;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("            h1 {\n");
      out.write("                background-color: #333;\n");
      out.write("                color: #fff;\n");
      out.write("                padding: 10px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            h2 {\n");
      out.write("                background-color: #333;\n");
      out.write("                color: #fff;\n");
      out.write("                padding: 10px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            form {\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            table {\n");
      out.write("                width: 100%;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("            th, td {\n");
      out.write("                border: 1px solid #ddd;\n");
      out.write("                padding: 8px;\n");
      out.write("                text-align: left;\n");
      out.write("            }\n");
      out.write("            th {\n");
      out.write("                background-color: #f2f2f2;\n");
      out.write("            }\n");
      out.write("            tr:nth-child(even) {\n");
      out.write("                background-color: #f2f2f2;\n");
      out.write("            }\n");
      out.write("            tr:hover {\n");
      out.write("                background-color: #ddd;\n");
      out.write("            }\n");
      out.write("            input[type=\"text\"], input[type=\"submit\"] {\n");
      out.write("                padding: 5px;\n");
      out.write("            }\n");
      out.write("            input[type=\"submit\"] {\n");
      out.write("                background-color: #333;\n");
      out.write("                color: #fff;\n");
      out.write("                border: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>User Management</h1>\n");
      out.write("        ");

            String keyword = request.getParameter("keyword");

        
      out.write("\n");
      out.write("        <form action=\"MainController\" method=\"post\">\n");
      out.write("            <input type=\"hidden\" value=\"searchuser\" name=\"action\"/>\n");
      out.write("            <p>Search Product: <input type=\"text\" name=\"txtsearch\" value=\"");
      out.print( (keyword != null) ? keyword : "");
      out.write("\"/> <input type=\"submit\" value=\"Search\"/></p>\n");
      out.write("        </form>\n");
      out.write("        ");

            ArrayList<User> list = (ArrayList) request.getAttribute("list");
            if (list != null && list.size() > 0) {

        
      out.write("\n");
      out.write("        <h2>Search List</h2>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>ID</th>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th>Address</th>\n");
      out.write("                <th>Phone</th>\n");
      out.write("                <th>Email</th>\n");
      out.write("                <th>Username</th>\n");
      out.write("                <th>Password</th>\n");
      out.write("                <th>RoleID</th>\n");
      out.write("                <th>Action</th>\n");
      out.write("            </tr>\n");
      out.write("            ");
                for (User i : list) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(i.getUserid());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getFullname());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getAddress());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getPhone());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getEmail());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getUsername());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getPassword());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getRole());
      out.write("</td>\n");
      out.write("                <td>\n");
      out.write("                    <form action=\"MainController\" method=\"post\">\n");
      out.write("                        <input type=\"hidden\" value=\"");
      out.print(i.getUserid());
      out.write("\" name=\"productid\"/>\n");
      out.write("                        <input type=\"submit\" value=\"Edit User\" name=\"action\"/>\n");
      out.write("                    </form>\n");
      out.write("                    <form action=\"MainController\" method=\"post\">\n");
      out.write("                        <input type=\"hidden\" value=\"");
      out.print(i.getUserid());
      out.write("\" name=\"productid\"/>\n");
      out.write("                        <input type=\"submit\" value=\"Delete User\" name=\"action\"/>\n");
      out.write("                    </form>\n");
      out.write("                </td>    \n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        ");

            ArrayList<User> list2 = UserDAO.getAllUser();
            if (list2 != null && list2.size() > 0) {

        
      out.write("\n");
      out.write("        <h2>User List</h2>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>ID</th>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th>Address</th>\n");
      out.write("                <th>Phone</th>\n");
      out.write("                <th>Email</th>\n");
      out.write("                <th>Username</th>\n");
      out.write("                <th>Password</th>\n");
      out.write("                <th>RoleID</th>\n");
      out.write("                <th>Action</th>\n");
      out.write("            </tr>\n");
      out.write("            ");
                for (User i : list2) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(i.getUserid());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getFullname());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getAddress());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getPhone());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getEmail());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getUsername());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getPassword());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getRole());
      out.write("</td>\n");
      out.write("                <td>\n");
      out.write("                    <form action=\"MainController\" method=\"post\">\n");
      out.write("                        <input type=\"hidden\" value=\"");
      out.print(i.getUserid());
      out.write("\" name=\"productid\"/>\n");
      out.write("                        <input type=\"submit\" value=\"Edit User\" name=\"action\"/>\n");
      out.write("                    </form>\n");
      out.write("                    <form action=\"MainController\" method=\"post\">\n");
      out.write("                        <input type=\"hidden\" value=\"");
      out.print(i.getUserid());
      out.write("\" name=\"productid\"/>\n");
      out.write("                        <input type=\"submit\" value=\"Delete User\" name=\"action\"/>\n");
      out.write("                    </form>\n");
      out.write("                </td>    \n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

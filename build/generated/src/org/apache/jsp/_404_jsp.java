package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _404_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("        <!-- Title -->\n");
      out.write("        <title>Modern | Extra - 404</title>\n");
      out.write("        \n");
      out.write("        <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"/>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"description\" content=\"Admin Dashboard Template\" />\n");
      out.write("        <meta name=\"keywords\" content=\"admin,dashboard\" />\n");
      out.write("        <meta name=\"author\" content=\"Steelcoders\" />\n");
      out.write("        \n");
      out.write("        <!-- Styles -->\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href=\"assets/plugins/pace-master/themes/blue/pace-theme-flash.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"assets/plugins/uniform/css/uniform.default.min.css\" rel=\"stylesheet\"/>\n");
      out.write("        <link href=\"assets/plugins/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"assets/plugins/fontawesome/css/font-awesome.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"assets/plugins/line-icons/simple-line-icons.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\n");
      out.write("        <link href=\"assets/plugins/offcanvasmenueffects/css/menu_cornerbox.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\n");
      out.write("        <link href=\"assets/plugins/waves/waves.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\n");
      out.write("        <link href=\"assets/plugins/switchery/switchery.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"assets/plugins/3d-bold-navigation/css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\t\n");
      out.write("        \n");
      out.write("        <!-- Theme Styles -->\n");
      out.write("        <link href=\"assets/css/modern.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"assets/css/themes/green.css\" class=\"theme-color\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"assets/css/custom.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        \n");
      out.write("        <script src=\"assets/plugins/3d-bold-navigation/js/modernizr.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/offcanvasmenueffects/js/snap.svg-min.js\"></script>\n");
      out.write("        \n");
      out.write("        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body class=\"page-error\">\n");
      out.write("        <main class=\"page-content\">\n");
      out.write("            <div class=\"page-inner\">\n");
      out.write("                <div id=\"main-wrapper\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-4 center\">\n");
      out.write("                            <h1 class=\"text-xxl text-primary text-center\">404</h1>\n");
      out.write("                            <div class=\"details\">\n");
      out.write("                                <h3>Oops ! Something went wrong</h3>\n");
      out.write("                                <p>We can't find the page you're looking for. Return <a href=\"index.html\">Home</a> or search.</p>\n");
      out.write("                            </div>\n");
      out.write("                            <form class=\"input-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" placeholder=\"Search\">\n");
      out.write("                                <span class=\"input-group-btn\">\n");
      out.write("                                    <button class=\"btn btn-default\"><i class=\"fa fa-search\"></i></button>\n");
      out.write("                                </span>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div><!-- Row -->\n");
      out.write("                </div><!-- Main Wrapper -->\n");
      out.write("            </div><!-- Page Inner -->\n");
      out.write("        </main><!-- Page Content -->\n");
      out.write("        \n");
      out.write("        <!-- Javascripts -->\n");
      out.write("        <script src=\"assets/plugins/jquery/jquery-2.1.4.min.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/jquery-ui/jquery-ui.min.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/pace-master/pace.min.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/jquery-blockui/jquery.blockui.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/switchery/switchery.min.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/uniform/jquery.uniform.min.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/offcanvasmenueffects/js/classie.js\"></script>\n");
      out.write("        <script src=\"assets/plugins/waves/waves.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/modern.min.js\"></script>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>");
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

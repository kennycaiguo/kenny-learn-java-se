package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>easyUI组件练习</title>\r\n");
      out.write("\t \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t <!-- 导入css文件，没有顺序-->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../themes/default/easyui.css\" type=\"text/css\"></link>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../themes/icon.css\" type=\"text/css\"></link>\r\n");
      out.write("     <!-- 导入js文件，有顺序-->\r\n");
      out.write("     <script type=\"text/javascript\" src=\"../js/jquery.min.js\"></script>\r\n");
      out.write("     <script type=\"text/javascript\" src=\"../js/jquery.easyui.min.js\"></script>\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body id=\"layoutID\" class=\"easyui-layout\" >\r\n");
      out.write("     <div data-options=\"region:'north',iconCls:'icon-large-chart',title:'North',split:true\" style=\"height:100px;\" ></div>\r\n");
      out.write("\t  <div data-options=\"region:'south',iconCls:'icon-large-smartart',title:'South',split:true\"  style=\"height:100px;\" ></div>\r\n");
      out.write("\t  <div data-options=\"region:'center',iconCls:'icon-large-picture',title:'Center'\" ></div>\r\n");
      out.write("\t  <div data-options=\"region:'east',iconCls:'icon-large-shapes',title:'East',split:true\" style=\"width:200px\"></div>\r\n");
      out.write("\t  <div data-options=\"region:'west',iconCls:'icon-large-shapes',title:'West',split:true\" style=\"width:200px\"></div>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

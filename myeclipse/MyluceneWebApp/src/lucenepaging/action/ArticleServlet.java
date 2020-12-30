package lucenepaging.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lucenepaging.Bean.Page;
import lucenepaging.entity.Article;
import lucenepaging.service.ArticleService;

public class ArticleServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		 this.doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		try {
			request.setCharacterEncoding("utf-8");
			String keyword=request.getParameter("keyword");
			System.out.println(keyword);
			if(keyword==null || keyword.trim().length()==0) {
				keyword="��ѵ";//���û�û�������Ĭ�ϴ���
			}
			 //��ȡ��ǰҳ��
			String temp=request.getParameter("currentPageNo");
			System.out.println(temp);
			if(temp==null || temp.trim().length()==0) {
				temp="1";//���û�û�������Ĭ�ϴ���
			}
			ArticleService asrv=new ArticleService();
			Page page =asrv.show(keyword, Integer.parseInt(temp), 2);
			List<Article> list=page.getArticlelist();
			for(Article a:list) {
				System.out.println(a);
			}
			//��page���󱣴浽request����
			request.setAttribute("page", page);
			//��keyword���浽request����
			request.setAttribute("keyword", keyword);
			//ת����list.jspҳ����
			request.getRequestDispatcher("/list.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}

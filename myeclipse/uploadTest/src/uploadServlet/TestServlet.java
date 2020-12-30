package uploadServlet;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 String header = request.getHeader("filename");
		System.out.println(header);
//		InputStream in=request.getInputStream();
//		InputStreamReader reader=new InputStreamReader(in);
//		BufferedReader br=new BufferedReader(reader);
//		FileWriter fr=new FileWriter("e:/uploaded.text");
		//byte[] buf=new byte[1024];
		BufferedReader br=request.getReader();
		FileWriter fr=new FileWriter("e:/uploaded.text");
		String content=null;
		while((content=br.readLine())!=null) {
			fr.write(content);
			//System.out.println(content);
		}
		
		fr.close();
		br.close();
		out.close();
	}

	 
		 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		this.doGet(request, response);
	}

}

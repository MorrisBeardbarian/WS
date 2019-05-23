package ws;


import java.io.IOException;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.xml.ws.Endpoint;

/**
 * Servlet implementation class HeaderSniffer
 */
@WebServlet("/")
public class HeaderSniffer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HeaderSniffer() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain"); 
		PrintWriter out = response.getWriter(); 
		Enumeration names = request.getHeaderNames();
		while(names.hasMoreElements()) { 
			String name = (String)names.nextElement(); 
			String val = request.getHeader(name); 
			if( val != null ) { 
				out.println(name+":"+val ); 
			} 
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

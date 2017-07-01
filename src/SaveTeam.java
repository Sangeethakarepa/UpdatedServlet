
import java.io.*;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SaveTeam")
public class SaveTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String designation=request.getParameter("designation");
		String salary=request.getParameter("salary");
		
		Team e=new Team();
		e.setId(id);
		e.setName(name);
		e.setDesignation(designation);
		e.setSalary(salary);
		
		int status=TeamDao.save(e);
		if(status>0)
		{
			pw.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("Index.html").include(request, response);
		}
		else{
			pw.println("Sorry! unable to save record");
		}
		
		pw.close();
	}

}

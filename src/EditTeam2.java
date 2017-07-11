


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditTeam2")
public class EditTeam2 extends HttpServlet {
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
		
		int status=TeamDao.update(e);
		if(status>0){
			response.sendRedirect("ViewTeam");
		}
		else{
			pw.println("Sorry! unable to update record");
		}
		
		pw.close();
	}

}
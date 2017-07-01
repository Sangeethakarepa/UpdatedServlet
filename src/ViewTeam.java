import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewTeam")
public class ViewTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	pw.println("<a href='Index.html'>Add New Employee</a> ");
	pw.println("<h1>Team list</h1>");
	List<Team> list=TeamDao.getAllTeams();
	pw.print("<table border='1' width='100%'>");
	pw.print("<tr><th>ID</th><th>Name</th><th>Designation</th><th>Salary</th><th>Edit</th><th>Delete</th></tr>");
	for(Team e:list){
	pw.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getDesignation()+"</td><td>"+e.getSalary()+"</td><td><a href='EditTeam?id="+e.getId()+"'>Edit</a></td><td><a href='DeleteTeam?id="+e.getId()+"'>Delete</a></td></tr>");	
	}
	pw.print("</table>");
	pw.close();
	}
}
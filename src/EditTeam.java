
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditTeam")
public class EditTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<h1>Update Employee Details</h1>");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		Team e = TeamDao.getTeamById(id);
		pw.print("<form action='EditTeam2' method='post'>");
		pw.print("<table>");
		pw.print("<tr><td></td><td><input type='hidden' name='id' value=" + e.getId() + "></td></tr>");
		pw.print("<tr><td>Name</td><td><input type='text' name='name' value='" + e.getName() + "'/></td></tr>");
		pw.print("<tr><td>Designation</td><td><input type='text' name='designation' value='" + e.getDesignation()
				+ "'/></td></tr>");
		pw.print("<tr><td>Salary</td><td><input type='text' name='salary' value='" + e.getSalary() + "'/></td></tr>");
		pw.print("</td></tr>");
		pw.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		pw.print("</table>");
		pw.print("</form>");

		pw.close();
	}
}

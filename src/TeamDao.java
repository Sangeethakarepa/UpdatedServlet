
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeamDao {
	public static Connection getConnection(){
	Connection con=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "tiger");
	}
	catch(Exception e){
		System.out.println("Error:"+e);
		
	}
	return con;
}
	public static int save(Team e){
		int status=0;
		try{
			Connection con=TeamDao.getConnection();
			PreparedStatement ps=con.prepareStatement("Insert into Employee(id, name, designation, salary)values(?,?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getDesignation());
			ps.setString(4, e.getSalary());
			status = ps.executeUpdate();

			con.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	public static int update(Team e){
		int status=0;
		try{
			Connection con=TeamDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update Employee set name=?, designation=?, salary=? where id=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getDesignation());
			ps.setString(3, e.getSalary());
			ps.setInt(4, e.getId());
			status = ps.executeUpdate();
			con.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=TeamDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from Employee where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	public static Team getTeamById(int id){
		Team e=new Team();
		try {
			Connection con = TeamDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Employee where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setDesignation(rs.getString(3));
				e.setSalary(rs.getString(4));
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}
	
	public static List<Team> getAllTeams() {
		List<Team> list = new ArrayList<Team>();

		try {
			Connection con = TeamDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Employee");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Team e=new Team();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setDesignation(rs.getString(3));
				e.setSalary(rs.getString(4));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}

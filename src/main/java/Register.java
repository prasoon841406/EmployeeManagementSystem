

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("uname");
		String Password=request.getParameter("psw");
		String Gender=request.getParameter("gender");
		String mobile_number=request.getParameter("mno");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String address=request.getParameter("adr");
		String Email=request.getParameter("email");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##prasoon","pandey");
			PreparedStatement ps=con.prepareStatement("insert into empreg values(?,?,?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,Password);
			ps.setString(3,Gender);
			ps.setString(4, mobile_number);
			ps.setString(5,state);
			ps.setString(6, country);
			ps.setString(7,address);
			ps.setString(8,Email);
			int i=ps.executeUpdate();
			out.print(i+"New Record Inserted...");
			con.close();
		}
		catch (Exception e)
		{
			out.print(e);	
		}
	}

}

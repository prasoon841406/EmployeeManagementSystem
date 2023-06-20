

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
 * Servlet implementation class UpdateCode
 */
@WebServlet("/UpdateCode")
public class UpdateCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCode() {
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
		String mno=request.getParameter("mno");
		String adr=request.getParameter("adr");
		String email=request.getParameter("email");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##prasoon","pandey");
			PreparedStatement ps=con.prepareStatement("update empreg set Password=?,email=?,mno=?,adr=? where name=?");
			ps.setString(1, Password);
			ps.setString(2, mno);
			ps.setString(3, adr);
			ps.setString(4, email);
			ps.setString(5, name);
			int i=ps.executeUpdate();
			out.print(i+"one Record Updated...");
			con.close();
		}
		catch (Exception e)
		{
			out.print(e);
		}
			
		}
				
		
	}


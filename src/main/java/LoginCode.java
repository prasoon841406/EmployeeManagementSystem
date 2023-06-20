

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCode
 */
@WebServlet("/LoginCode")
public class LoginCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCode() {
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
		String password=request.getParameter("psw");
		try
		{
			Class.forName("oracle:jdbc:driver:OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##prasoon","pandey");
			PreparedStatement ps=con.prepareStatement("select * from empreg where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				response.sendRedirect("home.html");
			}
			else
			{
				out.print("please insert valid username and password");
			}
			con.close();
		}
		catch (Exception e)
		{
			out.print(e);
		}
	}

}

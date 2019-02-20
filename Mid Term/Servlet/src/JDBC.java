import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;



@WebServlet("/JDBC")
public class JDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public JDBC() {
        // TODO Auto-generated constructor stub
    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String mobileno = request.getParameter("mobileno");
		String address = request.getParameter("address");
		
		String DB_URL = "jdbc:mysql://localhost:3306/TECOB264WT";
		
		String USER = "root";
		String PASS = "mysql";
		
		Connection conn = null;
		Statement stmt = null;
			   try{
	
			      Class.forName("com.mysql.jdbc.Driver");

			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL, USER, PASS);
			      
			      stmt = conn.createStatement();
			      
			      String sql = "insert into  TEST values('"+fname+"','"+lname+"','"+email+"','"+mobileno+"','"+address+"');";
			      System.out.println(sql);
			  
			    
			      stmt.executeUpdate(sql);
			      
			      System.out.println("Database created successfully...");
			   }catch(SQLException se){
			
			      se.printStackTrace();
			   }catch(Exception e){
			      
			      e.printStackTrace();
			   }finally{
			      
			      
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }
			   }
			   System.out.println("Goodbye!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
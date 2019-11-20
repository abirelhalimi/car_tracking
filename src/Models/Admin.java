package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Admin {
	
	public static String PG_URL="jdbc:postgresql://localhost:5432/jee";
	public static String PG_USER="postgres";
	public static String PG_PASSWORD="postgres";
	
	public static void editAccount(Long idUser,String fname ,String lname,String phone,String day,String month,String year,String pass1,String pass2 ) {
		
		try{  
			Class.forName("org.postgresql.Driver");  
			Connection con= DriverManager.getConnection(Admin.PG_URL,Admin.PG_USER,Admin.PG_PASSWORD);  
			
			
		String query = " update account set fname=?,lname=?,bdate='"+year+"-"+month+"-"+day+"' ,phone=?,password=?"
		        + " where id_account= ?";

		      // create the mysql insert preparedstatement
		PreparedStatement preparedStmt =  con.prepareStatement(query);
		preparedStmt.setString (1, fname);
		preparedStmt.setString (2, lname);
		preparedStmt.setString (3,phone);
		preparedStmt.setString (4, pass1);
		preparedStmt.setLong (5, idUser);

		      // execute the preparedstatement
		preparedStmt.execute();
		
		con.close();  
		}catch(Exception e){System.out.println(e);} 
	}
	
	public static int deleteAccount(User user) {
		int i=0;
		Long idUser=user.getId();
		ArrayList<Long> list=new ArrayList<Long>();
		try{  
			Class.forName("org.postgresql.Driver");  
			Connection con= DriverManager.getConnection(Admin.PG_URL,Admin.PG_USER,Admin.PG_PASSWORD);  
			
			Statement stmt=con.createStatement();  
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM car where id_account= "+idUser+";");  
			
			while(rs.next()) {
				
				list.add( rs.getLong("Id_car")); 
			}
			
			PreparedStatement preparedStmt = null ;
			for(Long id:list) {
				user.deleteCar(id);
			}
			
			preparedStmt=  con.prepareStatement("delete FROM account where id_account= "+idUser);
			preparedStmt.execute();
			
		con.close();  
		}catch(Exception e){System.out.println(e);} 
		return i;
	}
	
	public int createAccount(String fname ,String lname,String email,String phone,String day,String month,String year,String pass1,String pass2 ) {
		int i=0;
		try{  
			Class.forName("org.postgresql.Driver");  
			Connection con= DriverManager.getConnection(Admin.PG_URL,Admin.PG_USER,Admin.PG_PASSWORD);  
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from account where email='"+email+"';");  
			while(rs.next()) {
				i=1;
			}
			
			if( i==0){
				if(pass1.equals(pass2)) {
					String query = " insert into account(fname,lname,bdate,email,phone,password)"
					        + " values (?, ?, '"+year+"-"+month+"-"+day+"', ?, ?, ?)";

					      // create the mysql insert preparedstatement
					PreparedStatement preparedStmt =  con.prepareStatement(query);
					preparedStmt.setString (1, fname);
					preparedStmt.setString (2, lname);
					preparedStmt.setString (3, email);
					preparedStmt.setString (4, phone);
					preparedStmt.setString (5, pass1);

					      // execute the preparedstatement
					preparedStmt.execute();
					
				}
				else {
					i=2;
				}
			}
		con.close();  
		}catch(Exception e){System.out.println(e);} 
		return i;
	}
	
	
	public User correctLogin(String email,String passw) {
		User user=new User();
		try{  
			Class.forName("org.postgresql.Driver");  
			Connection con= DriverManager.getConnection(Admin.PG_URL,Admin.PG_USER,Admin.PG_PASSWORD);  
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from account where email='"+email+"' and password='"+passw+"';");  
			if(rs.next()) {
				user.setEmail(email);
				user.setPassword(passw);
				user.setFname(rs.getString("fname"));
				user.setLname(rs.getString("lname"));
				user.setId(rs.getLong("Id_account"));
				user.setPhone(rs.getString("phone"));
			}
			else user=null;
			con.close();  
			}catch(Exception e){} 
		return user;
	}


}

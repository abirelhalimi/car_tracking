package Models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class User {
	private Long Id;
	private String Email;
	private String Password;
	private String fname;
	private String lname;
	private String phone;
	public User() {
	}
	public User(Long Id,String Email,String Password,String fname,String lname,String phone) {
		this.Id=Id;
		this.Email=Email;
		this.Password=Password;
		this.fname=fname;
		this.lname=lname;
		this.phone=phone;
	}
public static void editCar(Long idCar,String model ,String matricule ) {
		
		try{  
			Class.forName("org.postgresql.Driver");  
			Connection con= DriverManager.getConnection(Admin.PG_URL,Admin.PG_USER,Admin.PG_PASSWORD);  
			
			
		String query = " update car set model=?,matricule=?"
		        + " where id_car= ?";

		      // create the mysql insert preparedstatement
		PreparedStatement preparedStmt =  con.prepareStatement(query);
		preparedStmt.setString (1, model);
		preparedStmt.setString (2, matricule);
		preparedStmt.setLong (3, idCar);

		      // execute the preparedstatement
		preparedStmt.execute();
		
		con.close();  
		}catch(Exception e){System.out.println(e);} 
	}
	public int addCar(String model ,String grayCard,String matricule,Long idUser) {
		int i=0;
		try{  
			Class.forName("org.postgresql.Driver");  
			Connection con= DriverManager.getConnection(Admin.PG_URL,Admin.PG_USER,Admin.PG_PASSWORD);  
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from car where graycard='"+grayCard+"';");  
			while(rs.next()) {
				i=1;
			}
			
			if( i==0){
					String query = " insert into car(model,graycard,matricule,id_account)"
					        + " values (?, ?,?, ?)";

					PreparedStatement preparedStmt =  con.prepareStatement(query);
					preparedStmt.setString (1, model);
					preparedStmt.setString (2, grayCard);
					preparedStmt.setString (3, matricule);
					preparedStmt.setLong (4, idUser);

					      // execute the preparedstatement
					preparedStmt.execute();
					
					 rs=stmt.executeQuery("select * from car;");  
					 Long id = null;
					while(rs.next()) {
						id=rs.getLong("Id_car");
					}
					
					query = " insert into path(date_path,id_car)"
					        + " values ('2019-01-30', ?)";

					 preparedStmt =  con.prepareStatement(query);
					preparedStmt.setLong (1, id);

					preparedStmt.execute();
					
					rs=stmt.executeQuery("select * from path;");  
				
					while(rs.next()) {
						id=rs.getLong("Id_path");
					}
					
					query = " insert into location(latitude,longitude,id_path) values( 33.9857444763 , -6.8646378517,?)";

					 preparedStmt =  con.prepareStatement(query);
					preparedStmt.setLong (1, id);

					preparedStmt.execute();
			}
		con.close();  
		}catch(Exception e){System.out.println(e);} 
		return i;
	}
	public ArrayList<Car> userCars(){
		Long idUser=this.getId();
    	ArrayList<Car> cars=new ArrayList<Car>();

		try{  
			Class.forName("org.postgresql.Driver");  
			Connection con= DriverManager.getConnection(Admin.PG_URL,Admin.PG_USER,Admin.PG_PASSWORD);  
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from car where Id_account="+idUser+";");  
			while(rs.next()) {
				Car car=new Car(rs.getLong("Id_car"),rs.getString("model"),rs.getString("graycard"),rs.getString("matricule"),idUser);
				cars.add(car);
			}
			
			con.close();  
			}catch(Exception e){System.out.println(e);}
		return cars;
		
	}
	public void deleteCar(Long idCar) {
		ArrayList<Integer> list=new ArrayList<Integer>();
    	
		try{  
			Class.forName("org.postgresql.Driver");  
			Connection con=  DriverManager.getConnection(Admin.PG_URL,Admin.PG_USER,Admin.PG_PASSWORD);  
			
			Statement stmt=con.createStatement();  
			//"SELECT * FROM location where Id_location=(select max(id_location) FROM location where id_path=(select max(id_path) FROM path where id_car= "+idCar+"));"
			
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM path where id_car= "+idCar+";");  
			
			while(rs.next()) {
				list.add(rs.getInt("Id_path")); 
			}
			
			PreparedStatement preparedStmt = null ;
			

			for(int id:list) {
				preparedStmt= con.prepareStatement("Delete FROM Location where id_path= "+id);
				
				preparedStmt.execute();
			}

			preparedStmt=  con.prepareStatement("delete FROM path where id_car= "+idCar);
			preparedStmt.execute();

			preparedStmt=  con.prepareStatement("delete FROM car where id_car= "+idCar);
			preparedStmt.execute();


			con.close();  
			}catch(Exception e){System.out.println(e);}
    	
	}
	public void setId(Long Id) {
		this.Id=Id;
	}
	public void setEmail(String Email) {
		this.Email=Email;
	}
	public void setPassword(String Password) {
		this.Password=Password;
	}
	
	public Long getId() {
		return this.Id;
	}
	public String getEmail() {
		return this.Email;
	}
	public String getPassword() {
		return this.Password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}

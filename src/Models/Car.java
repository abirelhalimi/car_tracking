package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Car {
	private Long Id;
	private String model;
	private String grayCard;
	private String matricule;
	private Long IdAccount;
	
	public Car(Long Id) {
		this.Id=Id;
	}
	public Car(Long Id,String model,String grayCard,String matricule,Long IdAccount) {
		this.setId(Id);
		this.setModel(model);
		this.setGrayCard(grayCard);
		this.setMatricule(matricule);
		this.setIdAccount(IdAccount);
	}
	public static Car carById(Long idCar) {
		
		Car car=null;
		try{  
			Class.forName("org.postgresql.Driver");  
			Connection con=  DriverManager.getConnection(Admin.PG_URL,Admin.PG_USER,Admin.PG_PASSWORD);  
			
			Statement stmt=con.createStatement();  
			//"SELECT * FROM location where Id_location=(select max(id_location) FROM location where id_path=(select max(id_path) FROM path where id_car= "+idCar+"));"
			
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM car where Id_car="+idCar);  
			
			while(rs.next()) {
				car=new Car(rs.getLong("Id_car"),rs.getString("model"),rs.getString("graycard"),rs.getString("matricule"),rs.getLong("Id_account"));
				
			}
			
			con.close();  
			}catch(Exception e){System.out.println(e);}
		return car;
	}
	public ArrayList<Path> carPaths(){
		Long idCar=this.getId();
    	ArrayList<Path> paths=new ArrayList<Path>();
    	
    	
		try{  
			Class.forName("org.postgresql.Driver");  
			Connection con= DriverManager.getConnection(Admin.PG_URL,Admin.PG_USER,Admin.PG_PASSWORD);  
			
			Statement stmt=con.createStatement();  
			//"SELECT * FROM location where Id_location=(select max(id_location) FROM location where id_path=(select max(id_path) FROM path where id_car= "+idCar+"));"
			
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM path where id_car= "+idCar+";");  
			
			while(rs.next()) {
				Path path=new Path(rs.getLong("Id_path"),rs.getDate("date_path"),idCar);
				paths.add(path);
			}
			rs=stmt.executeQuery("SELECT * FROM car where id_car= "+idCar+";");  
			
			while(rs.next()) {
				this.model=rs.getString("model");
			}
			
			con.close();  
			}catch(Exception e){System.out.println(e);}
		return paths;
		
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getGrayCard() {
		return grayCard;
	}

	public void setGrayCard(String grayCard) {
		this.grayCard = grayCard;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Long getIdAccount() {
		return IdAccount;
	}

	public void setIdAccount(Long idAccount) {
		IdAccount = idAccount;
	}
	public Location location() {
		Long idCar=this.getId();
		Location location=null;
		try{  
			Class.forName("org.postgresql.Driver");  
			Connection con=  DriverManager.getConnection(Admin.PG_URL,Admin.PG_USER,Admin.PG_PASSWORD);  
			
			Statement stmt=con.createStatement();  
			//"SELECT * FROM location where Id_location=(select max(id_location) FROM location where id_path=(select max(id_path) FROM path where id_car= "+idCar+"));"
			
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM location where Id_location="
			+ "(select max(id_location) FROM location where id_path=(select max(id_path) FROM path where id_car= "+idCar+"));");  
			
			while(rs.next()) {
				location=new Location(rs.getLong("Id_location"),rs.getDouble("longitude"),rs.getDouble("latitude"),rs.getLong("Id_path"));
				
			}
			
			con.close();  
			}catch(Exception e){System.out.println(e);}
		return location;
	}
}

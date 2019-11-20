package Models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Path {

	private Long Id;
	private Date date_path;;
	private Long Id_car;
	
	public Path(Long Id) {
		this.setId(Id);
	}
	public Path(Long Id,Date date_path,Long Id_path) {
		this.setId(Id);
		this.setDate_path(date_path);
		this.setId_car(Id_path);
	}

	public ArrayList<Location> pathLocations(){
		Long idPath=this.getId();
    	ArrayList<Location>locations=new ArrayList<Location>();
    	
    	Location location=null;
		try{  
			Class.forName("org.postgresql.Driver");  
			Connection con= DriverManager.getConnection(Admin.PG_URL,Admin.PG_USER,Admin.PG_PASSWORD);  			
			Statement stmt= con.createStatement();  			
			ResultSet rs=stmt.executeQuery("SELECT * FROM location where Id_Path= "+idPath+";");  
			
			while(rs.next()) {
				location=new Location(rs.getLong("Id_location"),rs.getDouble("longitude"),rs.getDouble("latitude"),rs.getLong("Id_path"));
				locations.add(location);
			}
			
			con.close();  
			}catch(Exception e){System.out.println(e);}
		return locations;	
	}
	
	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public Date getDate_path() {
		return date_path;
	}


	public void setDate_path(Date date_path) {
		this.date_path = date_path;
	}


	public Long getId_car() {
		return Id_car;
	}


	public void setId_car(Long id_car) {
		Id_car = id_car;
	}

}

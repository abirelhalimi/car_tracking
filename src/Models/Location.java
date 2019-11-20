package Models;

public class Location {

	private Long Id;
	private double longitude;
	private double latitude;
	private Long Id_path;
	
	
	public Location(Long Id,double longitude,double latitude,Long Id_path) {
		this.Id=Id;
		this.longitude=longitude;
		this.latitude=latitude;
		this.Id_path=Id_path;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double logitude) {
		this.longitude = logitude;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public Long getId_path() {
		return Id_path;
	}


	public void setId_path(Long id_path) {
		Id_path = id_path;
	}
	
	
	
}
package resources;

public enum EnumResources {
	AddPlaceAPI("maps/api/place/add/json"),
	GetPlaceAPI("maps/api/place/get/json"),
	DeletePlaceAPI("maps/api/place/delete/json");
	
	private String resource;
	
	//Create a Constructor that accepts the same variable as the methods above
	EnumResources(String resource)
	{
		this.resource = resource;
	}
	
	public String getResource()
	{
		return resource;
	}
}

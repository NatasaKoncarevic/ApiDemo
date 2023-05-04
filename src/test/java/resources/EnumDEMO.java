package resources;

public class EnumDEMO {
	String AddPlaceAPI="maps/api/place/add/json";
	String GetPlaceAPI="maps/api/place/get/json";
	String DeletePlaceAPI="maps/api/place/delete/json";
	
	
	
	//Create a Constructor that accepts the same variable as the methods above
	public String getAddPlaceAPI()
	{
		return AddPlaceAPI;
	}
	
	public String getPlaceAPI()
	{
		return GetPlaceAPI;
	}
	
	public String deletePlaceAPI()
	{
		return DeletePlaceAPI;
	}

}

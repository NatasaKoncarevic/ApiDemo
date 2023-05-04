package stepDefinations;

import io.cucumber.core.backend.StepDefinition;
import io.cucumber.java.Before;


public class Hooks {

	
	StepDefination sd = new StepDefination();
	
	@Before("@DeletePlace")
	public void beforeScenario() throws Throwable
	{
		
		//Here we need a code for getting a placeID
		//And Execute this code only when a placeID is null
		
		//So, we are gonna call a method(s) from the StepDefinition04 that will do all the things that we need for this DeletePlaceAPI
		
		//If a variable is static, we can call it class.variable (StepDefinition04.placeIdFromResponse), if not static then object.variable
		//Here since it is static we can do both ways
		if(sd.place_id==null)
		{
			sd.add_place_payload("Natasa", "French", "Nelson Mandela avenue 101");
			sd.user_calls_with_http_request("AddPlaceAPI", "POST");
			sd.verify_place_id_created_maps_to_using("Natasa", "GetPlaceAPI");
		}
		
	}
	
}

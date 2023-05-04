Feature: Validating Place API's
@AddPlace
Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
 Given Add Place Payload "<name>" "<language>" "<address>"
 When user calls "AddPlaceAPI" with "POST" http request 
 Then the API call got succes with status code 
 And "status" in response body is "OK"
 And "scope" in response body is "APP"
 And verify place_id created maps to "<name>" using "GetPlaceAPI"
 
 Examples:
 |name   | language|address           |
 |AAhouse|English  |World cross center|
 #|BBhouse|Spanish  |Sea cross center  |
 
@DeletePlace
Scenario: Verify if Delete Place functionality is wokring

 Given DeletePlace Payload
 When user calls "AddPlaceAPI" with "POST" http request 
 Then user calls "DeletePlaceAPI" with "POST" http request 
 And "status" in response body is "OK"
 
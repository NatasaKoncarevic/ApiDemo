package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req1;
public RequestSpecification requestSpecification() throws IOException {
	if(req1==null) {
	PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
 req1=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
		 .addFilter(RequestLoggingFilter.logRequestTo(log))
		 .addFilter(ResponseLoggingFilter.logResponseTo(log))
			.setContentType(ContentType.JSON).build();
 return req1;
	}
	return req1;
}
public static String getGlobalValue(String key) throws IOException {
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream ("C:\\Users\\nako2508\\Desktop\\Udemy\\Workspace2\\MyAPIFramework\\src\\test\\java\\resources\\global.properties");
	prop.load(fis);
	prop.get(key);
	
	return prop.getProperty(key);
}

public  String getJsonPath(Response response, String key) {
	 String r=response.asString();
	 JsonPath js=new JsonPath(r);
	 
		return js.get(key).toString();
}

}

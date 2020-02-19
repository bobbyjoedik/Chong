package Utils;
 
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;
 
public class RestUtil {
    //Global Setup Variables
    public static String path;
    public static String jsonPathTerm;//Rest request path
 
    /*
    ***Sets Base URI***
    Before starting the test, we should set the RestAssured.baseURI
    */
    public static void setBaseURI (String baseURI){
        RestAssured.baseURI = "https://api.redtube.com";
    }
 
    /*
    ***Sets base path***
    Before starting the test, we should set the RestAssured.basePath
    */
    public static void setBasePath(String basePathTerm){
        RestAssured.basePath = basePathTerm;
    }
 
    /*
    ***Reset Base URI (after test)***
    After the test, we should reset the RestAssured.baseURI
    */
    public static void resetBaseURI (){
        RestAssured.baseURI = null;
    }
 
    /*
    ***Reset base path (after test)***
    After the test, we should reset the RestAssured.basePath
    */
    public static void resetBasePath(){
        RestAssured.basePath = null;
    }
 
    /*
    ***Sets ContentType***
    We should set content type as JSON or XML before starting the test
    */
    public static void setContentType (ContentType Type){
        given().contentType(Type);
    }
 
    /*
    ***search query path of first example***
    It is  equal to "barack obama/videos.json?num_of_videos=4"
    
     https://api.redtube.com/?data=redtube.Videos.searchVideos&output=json&search=hard&tags[]=Teen&thumbsize=medium 
    */
    public static void  createSearchQueryPath(String searchType, String searchTerm) {
        path = "?data=redtube.Videos." + searchType + "&output=json" + "&search=" + searchTerm;
        		
    }
 
    /*
    ***Returns response***
    We send "path" as a parameter to the Rest Assured'a "get" method
    and "get" method returns response of API
    */
    public static Response getResponse() {
        //System.out.print("path: " + path +"\n");
        return get(path);
    }
 
    /*
    ***Returns JsonPath object***
    * First convert the API's response to String type with "asString()" method.
    * Then, send this String formatted json response to the JsonPath class and return the JsonPath
    */
    public static JsonPath getJsonPath (Response res) {
        String json = res.asString();
        //System.out.print("returned json: " + json +"\n");
        return new JsonPath(json);
    }
    
    public static Response doGetRequest(String endpoint) {
    	RestAssured.defaultParser = Parser.JSON;
    	
    	return
    			given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
    					when().get(endpoint).
    					then().contentType(ContentType.JSON).extract().response();
    }
    
    public static Response postNewEmployee()
    
    {
    	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
    	
    	RequestSpecification httpRequest = RestAssured.given();
    	
    	//Construct JSON PUT Req
    	JSONObject requestParams = new JSONObject();
    	requestParams.put("name", "dlo");
    	requestParams.put("salary", "700000");
    	requestParams.put("age", "27");
    	
    	//Add header stating req body is JSON
    	httpRequest.header("Content-Type", "application/json");
    	
    	// Add body to REQ
    	httpRequest.body(requestParams.toString());
    	
    	// POST
    	return 
    		httpRequest.request(Method.POST, "/create" );
    	
    }
}
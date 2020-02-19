package ApiTests;
 
import Utils.*;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
 
public class Example1Test {
 
    //First, I declared Response and JsonPath objects.
    private Response res = null; //Response object
    private JsonPath jp = null; //JsonPath object
 
    /*
    Second, we should do setup operations, get JSON response from the API and put it into JsonPath object
    Then we will do query and manipulations with JsonPath class’s methods.
    We can do all of the preparation operations after @Before Junit annotation.
    */
 //   @Before
  //  public void setup (){
        //Test Setup
    	
    /*    RestUtil.setBaseURI("https://api.redtube.com"); //Setup Base URI
        RestUtil.setBasePath("/?data"); //Setup Base Path
        RestUtil.path = "=redtube.Stars.getStarList&output=json";
        RestUtil.setContentType(ContentType.JSON); //Setup Content Type
        res = RestUtil.getResponse(); //Get response
        jp = RestUtil.getJsonPath(res); //Set JsonPath
        */
   // 	Response res = RestUtil.doGetRequest(" https://api.redtube.com/?data=redtube.Categories.getCategoriesList&output=json");
    	
 //   }
    
  //  @After
   // public void teardown() {
   // 	RestUtil.resetBasePath();
   // 	RestUtil.resetBaseURI();
   // }
    

//	@Test
//	public void T01_CheckStatusIs200() {
//		assertEquals("u fucked up", 200, res.getStatusCode());
		
//	}
	
	@Test
	public void T02_AssertIsAmateur() {
		Response rsp = RestUtil.doGetRequest(" https://api.redtube.com/?data=redtube.Categories.getCategoriesList&output=json");
		List<Map<String, String>> categories = rsp.jsonPath().getList("categories");
		int i = 5;
		String s = categories.get(i).get("category");
		System.out.println(s);		
		assertEquals("Amateur", s );
		i++;		
		}
		
	
	@Test
	public void T03_PrintHeaders() {
		Response rsp = RestUtil.doGetRequest(" https://api.redtube.com/?data=redtube.Categories.getCategoriesList&output=json");
		String rspBody = rsp.getBody().asString();
		
		Headers allHeaders = rsp.headers();
		
//		for (Header header:allHeaders) {
//			System.out.println(header.getName()+ "     " +header.getValue());
			
		}
	
	
	@Test
	public void T04_PostNewEmployee() 
	
	{
		Response rsp = RestUtil.postNewEmployee();
		String rspBody = rsp.getBody().asString();
		assertEquals(rspBody.contains("dlo"), true);
		assertEquals(rspBody.contains("700000"), true);
		assertEquals(rspBody.contains("27"), true);
		assertEquals("Dont fuck up", 200, rsp.getStatusCode());
		System.out.println(rspBody);
	}
		

		
		
	
}
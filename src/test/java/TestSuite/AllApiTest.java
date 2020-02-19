package TestSuite;
 
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ApiTests.Example1Test;
 
 
@RunWith(Suite.class)
@Suite.SuiteClasses({
	Example1Test.class,
        
})
public class AllApiTest {
}
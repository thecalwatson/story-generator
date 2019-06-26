import com.example.callum.storygenerator.generator.DataReaderTest;
import com.example.callum.storygenerator.generator.StoryGeneratorTest;
import com.example.callum.storygenerator.generator.StoryWriterTest;
import com.example.callum.storygenerator.generator.StringFormatterTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// http://www.cavdar.net/2008/07/21/junit-4-in-60-seconds/

// specify a runner class: Suite.class
@RunWith(Suite.class)

// specify an array of test classes
@Suite.SuiteClasses(
{ 
	DataReaderTest.class,
	StoryGeneratorTest.class,
	StoryWriterTest.class,
	StringFormatterTest.class
	}
)

// the actual class is empty
public class AllTests
{
}

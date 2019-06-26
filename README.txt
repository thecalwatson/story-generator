Will read text from file and store keys along with logical values they can go with.
The data is then used to generate new story of defined number of paragraphs and lines.
Output sent to file.

Spring Boot application can imported as maven project in IntelliJ and be run via main method com.example.callum.storygenerator.StoryGeneratorApplication
Once application started go to http://localhost:8080/generate to create your story

Output will be in story.txt file.
Can configure number of paragraphs, sentences, word in sentence etc in application.properties.

Other endpoints:
http://localhost:8080/swagger-ui.html
http://localhost:8080/hello
http://localhost:8080/actuator
http://localhost:8080/actuator/health
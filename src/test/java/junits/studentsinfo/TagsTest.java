package junits.studentsinfo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;
import testbase.TestBase;

@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase {

    @WithTag("studentfeature:NEGATIVE")
    @Title("Provide a 405 status code when incorrect HTTP method is used")
    @Test
    public void invalidMethod() {
        SerenityRest.rest().given().when().post("/list")
                .then().statusCode(405).log().all();
    }

    @WithTags({
            @WithTag("studentfeature:SMOKE"),
            @WithTag("studentfeature:POSITIVE")
    })
    @Title("This will verify is a status of 200 is returned for GET request")
    @Test
    public void verifyIfTheStatusCodeis200() {
        SerenityRest.rest().given().get("/list")
                .then().statusCode(200);
    }

    @WithTags({
            @WithTag("studentfeature:SMOKE"),
            @WithTag("studentfeature:NEGATIVE")
    })
    @Title("This test will provide error of 400 when user tries to access invalid data")
    @Test
    public void incorrectResource() {
        SerenityRest.rest().given().get("/test")
                .then().statusCode(400).log().all();
    }
}
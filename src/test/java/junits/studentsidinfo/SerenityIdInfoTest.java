package junits.studentsidinfo;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@RunWith(SerenityRunner.class)
public class SerenityIdInfoTest {

    @BeforeClass
    public static void initialization() {
        RestAssured.baseURI = "http://localhost:8085/student/";
    }

    @Test
    public void getAllStudents() {
        SerenityRest.given() // SerenityRest is a wrapper on top of RestAssured
                             // which lets us see more details on the index.html report
                .when().get("/list")
                .then().log().all().statusCode(200);
    }

    @Test
    public void thisIsFailingTest() {
        SerenityRest.given()
                .when().get("/list")
                .then().log().all().statusCode(500);
    }

    @Pending
    @Test
    public void ThisIsPendingTest() {

    }

    @Test
    public void ThisIsSkippedTest() {
        System.out.println("This is an error: " + (5/0));
    }

    @Test
    public void FileDoesNotExist() throws FileNotFoundException {
        File file = new File("/src/file.txt");
        FileReader fr = new FileReader(file);
    }

    @Manual
    @Test
    public void ThisIsAManualTest() {

    }

    @Title("This Test gets all the information from StudentApp")
    @Test
    public void test01() {
        SerenityRest.given() // SerenityRest is a wrapper on top of RestAssured
                // which lets us see more details on the index.html report
                .when().get("/list")
                .then().log().all().statusCode(200);
    }
}
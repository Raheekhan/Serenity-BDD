package junits.studentsinfo;

import io.restassured.http.ContentType;
import model.StudentClass;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import serenity.StudentSerenitySteps;
import testbase.TestBase;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentsCRUDTest extends TestBase {

    static String firstName = TestUtils.getRandomString();
    static String lastName = TestUtils.getRandomString();
    static String email = TestUtils.getRandomString() + "@test.com";
    static String programme = "Computer Science";
    static int studentID;

    @Steps
    StudentSerenitySteps steps;

    @Title("This Test will create a new Student")
    @Test
    public void test01() {

        ArrayList<String> courses = new ArrayList<>();
        courses.add("Java");
        courses.add("Selenium");

        steps.createStudent(firstName, lastName, email, programme, courses)
        .statusCode(201);
    }

    @Title("Verify if the student was added")
    @Test
    public void test02() {
        HashMap<String, Object> value = steps.getStudentInfoByFirstName(firstName);
        assertThat(value, hasValue(firstName));
        studentID = (int) value.get("id");
    }

    @Title("Update user information and verify")
    @Test
    public void test03() {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("Java");
        courses.add("Selenium");

        firstName = firstName + "_Updated";
        steps.updateStudent(studentID, firstName, lastName, email, programme, courses);

        HashMap<String, Object> value = steps.getStudentInfoByFirstName(firstName);
        assertThat(value, hasValue(firstName));
    }

    @Title("Delete student and verify")
    @Test
    public void test04() {
        steps.deleteStudent(studentID);
        steps.getStudentByID(studentID).statusCode(404);
    }
}
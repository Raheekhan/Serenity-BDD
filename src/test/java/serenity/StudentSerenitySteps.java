package serenity;

import io.restassured.response.ValidatableResponse;
import model.StudentClass;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import utils.ReusableSpecifications;

import java.util.HashMap;
import java.util.List;

public class StudentSerenitySteps {

    @Step("Creating student with firstname: {0}, lastname: {1}, email: {2}, programme: {3}, courses: {4}")
    public ValidatableResponse createStudent(String firstname, String lastname,
                                             String email, String programme, List<String> courses) {
        StudentClass student = new StudentClass();
        student.setFirstName(firstname);
        student.setLastName(lastname);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);

        return SerenityRest.rest().given()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .when().body(student).post().then();
    }

    @Step("Getting the student information with firstname: {0}")
    public HashMap<String, Object> getStudentInfoByFirstName(String firstname) {
        return SerenityRest.rest().given()
                        .when().get("/list")
                        .then().log().all().statusCode(200)
                        .extract().path("findAll{it.firstName=='" + firstname + "'}.get(0)");
    }

    @Step("Updating student with studentID: {0}, firstname: {1}, lastname: {2}, email: {3}, programme: {4}, courses: {5}")
    public ValidatableResponse updateStudent(int studentID, String firstname, String lastname, String email, String programme, List<String> courses) {
        StudentClass student = new StudentClass();
        student.setFirstName(firstname);
        student.setLastName(lastname);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);

        return SerenityRest.rest().given()
                .spec(ReusableSpecifications.getGenericRequestSpec())
                .log().all().when().body(student)
                .put("/" + studentID).then();
    }

    @Step("Deleting student with StudentID: {0}")
    public void deleteStudent(int studentID) {
        SerenityRest.rest().given().when().delete("/" + studentID);
    }

    @Step("Getting studentID: {0}")
    public ValidatableResponse getStudentByID(int studentID) {
        return SerenityRest.rest().given().when().get("/" + studentID).then();
    }
}
package junits.studentsinfo;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenity.StudentSerenitySteps;
import testbase.TestBase;

import java.util.ArrayList;

// SerenityParameterizedRunner is used for DataDriven
//@Concurrent(threads = "4x") // number of threads per CPU Core
@UseTestDataFrom("testdata/studentinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentDataDrivenTest extends TestBase {

    String firstname;
    String lastname;
    String email;
    String programme;
    String course;

    @Steps
    StudentSerenitySteps steps;

    @Title("DataDriven Test for adding multiple students")
    @Test
    public void createMultipleStudents() {
        ArrayList<String> courses = new ArrayList<>();
        courses.add(course);
        steps.createStudent(firstname, lastname, email, programme, courses);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}

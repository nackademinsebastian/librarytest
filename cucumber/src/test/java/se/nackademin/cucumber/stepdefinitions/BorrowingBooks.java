package se.nackademin.cucumber.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import se.nackademin.cucumber.CucumberTestBase;

import java.util.UUID;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static junit.framework.TestCase.assertEquals;

public class BorrowingBooks {

    String uuid;

    @Given("^I am logged in as a loaner$")
    public void iAmLoggedInAsALoaner() {
        uuid = UUID.randomUUID().toString();
        $("#side-menu-link-add-user").click();
        sleep(1000);
        $("#gwt-uid-3").setValue(uuid);
        $("#gwt-uid-5").setValue(uuid);
        $("#add-user-button").click();
        $("#side-menu-link-sign-in").click();
        sleep(1000);
        $("#input-username").setValue(uuid);
        $("#input-password").setValue(uuid);
        $("#login-button").click();
    }

    @Given("^I am allowed to borrow a book$")
    public void iAmAllowedToBorrowABook() {
        //?? no way to find out as of yet
    }

    @When("^I borrow a book$")
    public void iBorrowABook() {
        $("#side-menu-link-browse-books").click();
        sleep(1000);
        $("#gwt-uid-3").setValue("Good Omens");
        $("#search-books-button").click();
        $("td.v-grid-cell:nth-child(1) > a:nth-child(1)").click();
        $("#borrow-book-button").click();
        $("#confirmdialog-ok-button").click();
    }

    @Then("^the book shows up on my profile page$")
    public void theBookShowsUpOnMyProfilePage() {
        sleep(1000);
        $("#side-menu-link-my-profile").click();
        sleep(1000);
        assertEquals("Good Omens has been borrowed", "Good Omens", $("td.v-grid-cell:nth-child(1) > a:nth-child(1)").getText());
    }
}

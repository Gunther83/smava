package smava.test.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import smava.test.pages.LoanDetailResultPage;
import smava.test.pages.PageFactory;
import smava.test.pages.ScoreCompassHome;
import smava.test.pages.SmavaHome;

/**
 * A simple POJO, which will contain the Java methods that are mapped to the
 * textual steps The methods need to annotated with one of the JBehave
 * annotations and the annotated value should contain a regex pattern that
 * matches the textual step
 */
public class Steps {

	private SmavaHome smava;
	private LoanDetailResultPage result;
	private ScoreCompassHome scoreCompass;

	public Steps(PageFactory pageFactory) {
		smava = pageFactory.newHome();
		result = pageFactory.newResult();
		scoreCompass = pageFactory.newScoreCompass();

	}

	@Given("The user navegates on smava")
	public void homepageOnSmavaDotCom() {
		smava.go();
	}

	@When("The user selectes <amount>")
	public void selectAmount(@Named("amount") int amount) {
		smava.searchAmount(amount);
	}

	@When("The user selectes <duration>")
	public void selectDuration(@Named("duration") int duration) {
		smava.selectDuration(duration);
	}

	@When("The user selectes <purpose>")
	public void selectPurpose(@Named("purpose") String purpose) {
		smava.selectPurpose(purpose);
	}

	@When("The user presses the button next")
	public void pressNext() {
		smava.pressNext();
	}

	@Then("the application is redirected to the result loan detail page")
	public void goDetailPage() {
		result.verifyLoanDetail();
	}

	@Given("The user accesses to Score Compass Home with basic authentication handling")
	public void browseToTheFeaturedVideosPage() {
		scoreCompass.go();
	}

	@Then("the page is loaded correctly")
	public void thereAreVideosListed() {
		scoreCompass.verifyLoadedPage();
	}
}

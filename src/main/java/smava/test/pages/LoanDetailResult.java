package smava.test.pages;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

/**
 * Page object defining the page Detail loan of Smava
 */
public class LoanDetailResult extends FluentWebDriverPage {

	public static final String PAGE_RESULT_TITLE = "Kredit beantragen | Kreditantrag in 4 Schritten | SMAVA";

	/**
	 * Default constructor
	 * 
	 * @param webDriverProvider
	 */
	public LoanDetailResult(WebDriverProvider webDriverProvider) {
		super(webDriverProvider);
	}

	public void goToPageResult(String currentURL) {
		get(currentURL);
		// wait for page to load
		getDriverProvider().get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void verifyLoanDetail() {
		assertThat("The page is correctly load", getTitle().equals(PAGE_RESULT_TITLE));
	}
}

package smava.test.pages;

import org.jbehave.web.selenium.WebDriverProvider;

/**
 * PageFactory that is used to instantiate desired page object
 */
public class PageFactory {

	private final WebDriverProvider webDriverProvider;

	public PageFactory(WebDriverProvider webDriverProvider) {
		this.webDriverProvider = webDriverProvider;
	}

	public SmavaHome newHome() {
		return new SmavaHome(webDriverProvider);
	}

	public LoanDetailResult newResult() {
		return new LoanDetailResult(webDriverProvider);
	}

	public ScoreCompassHome newScoreCompass() {
		return new ScoreCompassHome();
	}

}

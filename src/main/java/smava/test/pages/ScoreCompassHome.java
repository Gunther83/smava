package smava.test.pages;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * Page object defining the page of ScoreCompass
 */
public class ScoreCompassHome {

	private static final String SCORECOMPASS_ADRESS_WEB_SITE = "https://ostdteam:ostdteam@test.scorecompass.ostdlabs.com/";
	public static final String SCORECOMPASS_TITLE = "Bonitätsprüfung Online - Ihre kostenlose Bonitätsauskunft | Score Kompass";
	private FirefoxDriver webDriverFirefoxDriver;

	public ScoreCompassHome() {
	}

	/*
	 * Go directly to this page which is loaded ignoring self signed SSL
	 * certificate without manual authentication input
	 */
	public void go() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAssumeUntrustedCertificateIssuer(false);
		this.webDriverFirefoxDriver = new FirefoxDriver(profile);
		this.webDriverFirefoxDriver.get(SCORECOMPASS_ADRESS_WEB_SITE);
		this.webDriverFirefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void verifyLoadedPage() {
		assertThat("The page is correctly load", this.webDriverFirefoxDriver.getTitle().equals(SCORECOMPASS_TITLE));
		this.webDriverFirefoxDriver.close();
	}
}
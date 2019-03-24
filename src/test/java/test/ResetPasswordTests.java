package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ChooseNewPasswordPage;
import page.RequestPasswordResetPage;
import page.RequestPasswordResetSubmitPage;

public class ResetPasswordTests extends BaseTest {

    @Test
    public void successfulPasswordResetTest() {

        String userEmail = "nct.test1@gmail.com";

        RequestPasswordResetPage requestPasswordResetPage =
                landingPage.clickOnForgotPasswordLink();
        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(),
                "RequestPasswordReset page is not loaded.");

        RequestPasswordResetSubmitPage requestPasswordResetSubmitPage =
                requestPasswordResetPage.findAccount(userEmail);

        ChooseNewPasswordPage chooseNewPasswordPage =
                requestPasswordResetSubmitPage.navigateToLinkFromEmail();




    }
}

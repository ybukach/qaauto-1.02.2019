package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.RequestPasswordResetPage;

public class ResetPasswordTests extends BaseTest {

    @Test
    public void successfulPasswordResetTest() {

        String userEmail = "nct.test1@gmail.com";

        RequestPasswordResetPage requestPasswordResetPage =
                landingPage.clickOnForgotPasswordLink();
        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(),
                "RequestPasswordResetPage is not loaded");

        requestPasswordResetPage.findAccount(userEmail);

        String resetPasswordURL =


    }
}

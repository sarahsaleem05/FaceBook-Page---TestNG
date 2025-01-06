### Facebook Login UI Automation Test

This project contains an automated test suite for verifying various elements of the Facebook login page using **Selenium WebDriver** and **TestNG**. The tests cover several aspects of the login page UI, including:

- **Title Verification**: Checking if the page title matches the expected "Log in to Facebook".
- **URL Validation**: Verifying the current URL to ensure it remains correct.
- **Field Validations**: Ensuring that the username field is cleared after an invalid input.
- **CSS Style Validation**: Verifying the border style of the username input field when invalid data is entered.
- **Error Message Validation**: Checking if the correct error message appears when invalid login credentials are provided.
- **Warning Sign Display**: Ensuring that a warning sign appears when the username is invalid.

The test suite utilizes **Soft Assertions** for non-blocking checks and **TestNG** for parallel test execution and reporting.
 

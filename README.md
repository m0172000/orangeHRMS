Application Under Test (AUT): Orange HRM Demo Portal
URL: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login

 

Scenario: Employee Management – Add & Search Employee
Objective
Verify that an employee can be successfully added in OrangeHRM and later searched using the PIM (Personnel Information Management) module.

 

Test Steps

Login to OrangeHRM
Navigate to the OrangeHRM demo portal.
Enter valid credentials (Admin/admin123).
Verify that the Dashboard is displayed.
Navigate to PIM → Add Employee
Click on the PIM module.
Select Add Employee option.
Enter employee details:
First Name: John
Last Name: Doe
Employee ID: Auto-generated or custom
Enable Create Login Details and provide username/password.
Save the employee.
Verify Employee Creation
After saving, confirm that the Personal Details page is displayed with the entered details.
Search Employee in PIM
Navigate back to PIM → Employee List.
Search using the newly created employee’s ID or Name.
Verify that the employee appears in the search results.

**Expected Results
**
Employee is created successfully.
Employee details are saved and visible under PIM.
Employee can be searched and retrieved in the Employee List.


**Automation Requirement (Selenium)
**
Automate the above test case using Selenium WebDriver (Java or Python).
Use Page Object Model (POM) for better structure.
Add assertions for login validation, employee creation, and employee search.
Ensure proper logging and exception handling.

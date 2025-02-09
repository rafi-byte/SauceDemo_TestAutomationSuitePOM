# Sauce Demo Test Automation Suite (POM)

## Overview
This project contains automated test scripts for https://www.saucedemo.com/ using Selenium WebDriver with Java, TestNG, and Page Object Model (POM) design pattern. The test suite covers various functionalities including login, shopping cart operations, checkout process, and product sorting.

## Prerequisites

### Required Software
1. **Java Development Kit (JDK) 11 or higher**
   - Download: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/)
   - Installation Steps:
     1. Download JDK for your operating system
     2. Run the installer
     3. Set JAVA_HOME environment variable:
        - Windows:
          ```
          1. Search for "Environment Variables"
          2. Click "New" under System Variables
          3. Variable name: JAVA_HOME
          4. Variable value: C:\Program Files\Java\jdk-11 (your JDK path)
          ```
        - Mac/Linux:
          ```
          echo 'export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home' >> ~/.bash_profile
          source ~/.bash_profile
          ```

2. **IntelliJ IDEA**
   - Download: [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/)
   - Installation:
     1. Run the installer
     2. Follow installation wizard
     3. Launch IntelliJ IDEA

3. **Google Chrome Browser**
   - Latest version required
   - Download from: [Chrome Download Page](https://www.google.com/chrome/)

## Project Setup

### Clone Repository
```
git clone https://github.com/rafi-byte/SauceDemo_TestAutomationSuitePOM.git
cd SauceDemo_TestAutomationSuitePOM
```

### Open Project in IntelliJ
1. Launch IntelliJ IDEA
2. Click "File" → "Open"
3. Navigate to cloned repository
4. Select the folder and click "OK"
5. Wait for project indexing to complete

### Install Dependencies
1. Right-click on `pom.xml`
2. Select "Maven" → "Reload project"
3. Wait for dependencies to download

## Project Structure
```
src/
├── main/java/com/saucedemo/
│   ├── pages/                    # Page Object Classes
│   │   ├── LoginPage.java       # Login page elements and methods
│   │   ├── ProductsPage.java    # Product listing page
│   │   ├── CartPage.java        # Shopping cart page
│   │   ├── CheckoutPage.java    # Checkout process
│   │   ├── NavigationPage.java  # Navigation elements
│   │   └── BasePage.java        # Base page configuration
│   └── utils/
│       └── TestBase.java        # Test configuration and setup
└── test/java/com/saucedemo/tests/
    ├── LoginTest.java           # Login test cases
    ├── AddToCartTest.java       # Cart functionality tests
    ├── CheckoutTest.java        # Checkout process tests
    ├── SortingTest.java         # Product sorting tests
    ├── LogoutTest.java          # Logout functionality
    ├── LockedUserTest.java      # Locked user scenarios
    └── CartBadgeTest.java       # Cart badge updates
```

## Running Tests

### Method 1: Using IntelliJ
1. Open Project in IntelliJ
2. Navigate to any test class (e.g., `LoginTest.java`)
3. Right-click on the class
4. Select "Run 'LoginTest'"

### Method 2: Using TestNG XML
1. Open `testng.xml` in project root
2. Right-click inside the file
3. Select "Run 'testng.xml'"

### Method 3: Using Maven
1. Open terminal in IntelliJ
2. Run command:
```
mvn clean test
```

## Test Cases

### 1. Login Functionality
- Valid user login
- Invalid credentials
- Locked out user

### 2. Shopping Cart
- Add products to cart
- Remove products
- Verify cart badge count

### 3. Checkout Process
- Complete checkout flow
- Form validation
- Order confirmation

### 4. Product Management
- Sort by price (low to high)
- Sort by price (high to low)
- Sort by name (A to Z)
- Sort by name (Z to A)

## Test Data

### User Credentials
```
Standard User:
- Username: standard_user
- Password: secret_sauce

Locked Out User:
- Username: locked_out_user
- Password: secret_sauce
```

## Troubleshooting

### Common Issues and Solutions

1. **Test Execution Failed**
   - Verify Chrome browser is installed
   - Update Chrome to latest version
   - Clear browser cache and cookies

2. **Element Not Found Errors**
   - Check if website UI has changed
   - Verify element locators
   - Increase wait time in TestBase.java

3. **Build Errors**
   ```
   # Try these steps:
   1. mvn clean install
   2. Delete target folder
   3. Reload Maven project
   ```

4. **Maven Dependencies Not Loading**
   - Right-click pom.xml → Maven → Reload project
   - File → Invalidate Caches / Restart

### Still Having Issues?
1. Check error message in test report
2. Verify all prerequisites are installed
3. Try running with a clean Maven install:
```
mvn clean install -U
```

## Contributing
1. Fork the repository
2. Create feature branch
3. Commit changes
4. Push to branch
5. Create Pull Request

## Author
[Abdullah AL Rafi]

## License
This project is licensed under the MIT License
```

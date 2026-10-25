# Automated Service Desk Workflow Validator

An automated quality assurance framework designed to test mock client portals, ensuring service agreements, disclosures, and SLA routing rules function perfectly before deployment.

## Tech Stack
* **Java** - Core programming language
* **Selenium WebDriver** - Browser automation
* **TestNG** - Testing framework for assertions and test management
* **Maven** - Build automation and dependency management

## Features
* Validates SLA compliance UI indicators.
* Simulates end-to-end customer ticket submission.
* Verifies pop-up disclosures and legal agreements.
* Confirms correct department routing workflows.

## Setup Instructions
1. Import the project into your IDE (Eclipse/IntelliJ) as a Maven project.
2. Allow Maven to download the dependencies listed in `pom.xml`.
3. Right-click on `testng.xml` and select "Run as TestNG Suite".

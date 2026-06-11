# Selenium Automation - Synchronization (Waits Handling)

This repository contains practical implementations of various **Synchronization Techniques (Waits)** in Selenium WebDriver using Java. Proper synchronization is crucial in automation to handle asynchronous web element loading and prevent `NoSuchElementException` or `TimeoutException`.

## 🚀 Topics Covered

### 1. Implicit Wait
- Configured globally for the entire WebDriver instance lifecycle.
- Automatically polls the DOM at regular intervals for all elements before throwing an exception.

### 2. Explicit Wait (WebDriverWait)
- Applied to specific web elements based on targeted conditions (`ExpectedConditions`).
- **Type 1 Style:** Standard single-condition wait (e.g., waiting for element visibility).
- **Type 2 Style:** Multi-conditional and complex dynamic waits (e.g., waiting for specific text to appear inside an element after an asynchronous update).

### 3. Fluent Wait
- Highly customized wait where we can define the maximum timeout, polling frequency, and ignore specific exceptions (like `NoSuchElementException`) during the polling period.

---

## 🛠️ Tech Stack & Dependencies

- **Language:** Java 11 / 17
- **Automation Tool:** Selenium WebDriver (v4.x)
- **Build Tool:** Maven

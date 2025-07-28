Feature: Add Product to Cart

  Scenario: User adds MLM product to the cart
    Given the user is on the homepage
    When the user clicks the cart icon
    Then the cart should be empty
    When the user navigates to Golf > Mobile Launch Monitor
    When clicks Shop MLM
    Then the page title should contain "Mobile Launch Monitor"
    When the user clicks Add to Cart
    Then the user should be redirected to the cart screen
    And the product price should match the previous screen
    When the user increases the quantity to 2
    Then the total price should be correct

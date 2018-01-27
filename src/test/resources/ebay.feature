@ebay
Feature: ebay

Background:
    Given User launch the website "https://www.ebay.com/"
    
  @Regression
  Scenario: Search and Add to Cart
    Given User search for an item "Nokia 3310 red"
    When User selects the First Item listed
    Then User adds the item to cart
    And Verify Item is succesfully added to cart

    
   @Regression,@Smoke
  Scenario Outline: Search and Add multiple Items to Cart
    Given User search for an item "<Mobile>"
    When User selects the First Item listed
    Then User adds the item with "<Color>" color and "<Ram>" RAM to cart
    And Verify Item is succesfully added to cart
     Examples:
      |Mobile  | Color | Ram |
      |IPhone 6| Silver| 16GB|
      |Iphone 7| Black | 128GB|
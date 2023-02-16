@smoke
Feature: F08_Wishlist
  Scenario: User add product to wishlist
    When User click wishlist button
    Then Success msg appear and background is green
  Scenario:  User add product to wishList and go to withlist tab
    When User click wishlist button
    Then Success msg appear and background is green
    And Wait until sccessmsg disappear then click wishListtab
    And Quantity value should be more than one
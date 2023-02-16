@smoke
Feature: F05_HoverCategories
  Scenario: User Hover on categories and select one of them
    When Select one of main categories
    And Hover on the Selected
    Then Select one of sub-categories & get Text & click on it


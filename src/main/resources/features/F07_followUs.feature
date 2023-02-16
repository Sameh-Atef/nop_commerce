@smoke
Feature: F07_followUs | users could open followUs links
  Scenario: user opens facebook link
  When user opens facebook link
    #https://www.facebook.com/nopCommerce
  Then Facebook is opened in new tab
  Scenario: user opens twitter link
  When user opens twitter link
    #https://twitter.com/nopCommerce
  Then Twitter is opened in new tab
  Scenario: user opens rss link
  When user opens rss link
    #https://demo.nopcommerce.com/new-online-store-is-open
  Then Store is opened in new tab
  Scenario: user opens youtube link
  When user opens youtube link
    #https://www.youtube.com/user/nopCommerce
  Then Youtube is opened in new tab
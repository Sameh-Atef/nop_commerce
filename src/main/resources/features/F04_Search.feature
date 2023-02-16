Feature: F04_Search | Facebook account
Scenario Outline: Login functionality for a social networking site.
Given user navigates to Facebook
When I enter Username as "<username>" and Password as "<password>"
Then login should be unsuccessful
Examples:
| username | password |
| Test1 | Pass1 |
| Test2 | Pass2 |
| Test3 | Pass3 |
  @smoke
Scenario Outline: user could search using product name
  When User select search & write "<productname>"
  Then URL change
  And Search Show relevents results for "<productname>"

  Examples:
  |productname|
  |apple|
  |laptop|
  |nike|
@smoke
Scenario Outline: user could search for product using sku
  When    User select search & write "<sku>"
  Then URL change
  And click in each relative result "<sku>" verify that sku is the same

  Examples:
  |sku|
  |SCI_FAITH|
  |APPLE_CAM|
  |SF_PRO_11|

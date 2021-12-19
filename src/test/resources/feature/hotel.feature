Feature: Search hotel on https://www.booking.com/searchresults.en-gb.htm

  Scenario Outline: Find hotel and its rating
    Given User opens Booking.com page
    And User type '<Hotel>' in search field
    When User click on Search button
    Then Hotel '<Hotel>' should be on the first page
    And Hotel '<Hotel>' rating is '<Rating>'

    Examples:
      | Hotel                              | Rating |
      | NYX Hotel Milan by Leonardo Hotels | 8.8 |
      | Hotel VIU Milan                    | 8.9 |
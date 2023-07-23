Feature: User Loging
  i want to check user can Log in Shop  website

  Scenario Outline: User Registeration
    Given The user in home page
    When i entered data user "<email>" ,"<password>"
    Then the page of Log in  displayed successfuly

    Examples:
      | email                    | password      |
      | SaeedMohamed99@gmail.com | Saeedsaeed111 |
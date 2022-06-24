Feature: Performing CRUD operations on the application -- tests

  @create
  Scenario Outline: Create new computer data and check the data

    Given admin is in create computer page
    When he creates the computer with fields "<Computer name>","<Introduced>","<Company>"
    Then the computer created is displayed "<Computer name>"
    Then he should logout


    Examples:
      | Computer name   |     Introduced  | Company              |
      | Acer Iconia     | 2022-01-01      | IBM                  |


    @update
  Scenario Outline: Update  computer data created

    Given admin is in computer landing page
    When he searches and edit "<Computer name>"
    Then the computer details are updated
    Then he should logout

    Examples:
    |Computer name          |
    | Acer Iconia           |

  @delete
  Scenario Outline: Delete  computer data created

    Given admin is in computer landing page
    When user searches and delete "<Computer name>"
    Then user deletes the data
    Then he should logout

    Examples:
      |Computer name          |
      | Acer Iconia           |
@api
Feature: Pet Store simple CRUD

  Scenario Outline: Validating the 4 APIs (I understand this is not the single point of failure strategy, I just didn't have time)
    When user searches for pets by "<status>"
    And user creates a new pet with status as "<creation_status>"
    Then check for pet details
    And user updates the pet status to "<updated_status>"
    Then check for pet details
    And user deletes the pet
    Then user completes the test validating if the pet is deleted

    Examples:
      | status    | creation_status  | updated_status |
      | available | available        | sold           |
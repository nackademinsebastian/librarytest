Feature: Loaners borrowing books 
    Scenario: it is possible to borrow a book
        Given I am logged in as a loaner
        And I am allowed to borrow a book
        When I borrow a book
        Then the book shows up on my profile page 
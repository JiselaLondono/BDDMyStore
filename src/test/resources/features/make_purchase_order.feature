#Autor: Jisela Londoño Herrera

Feature: Make a purchase order in MyStore
  As a customer of the clothing store MyStore
  I want to make a purchase order in the store
  To get the products I need

  Scenario: Successful purchase order paid by check
    Given that Jisela is a customer with an active MyStore account
    When she chooses the 'blouses and dresses' that she wants to buy
    And she confirms the summary of the chosen products
    And she chooses the delivery address 'Home address'
    And she chooses 'My carrier' as the shipping option for her order
    And she pays the order by 'check'
    Then she should see the following message 'Your order on My Store is complete.'
    And she should see that the total cost of the order is correct
    And she should see that the order was recorded in her account's order history

  Scenario: Successful purchase order paid by bank wire
    Given that Jisela is a customer with an active MyStore account
    When she chooses the 't-shirts and blouses' that she wants to buy
    And she confirms the summary of the chosen products
    And she chooses the delivery address 'Company address'
    And she chooses 'My carrier' as the shipping option for her order
    And she pays the order by 'bank wire'
    Then she should see the following message 'Your order on My Store is complete.'
    And she should see that the total cost of the order is correct
    And she should see that the order was recorded in her account's order history
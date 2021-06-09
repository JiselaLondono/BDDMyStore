#Autor: Jisela Londoño Herrera

Feature: Make a purchase order in MyStore
  As a customer of the clothing store MyStore
  I want to make a purchase order in the sotre
  To get the products I need

Scenario: Successful purchase order
  Given that Jisela is a customer with an active MyStore account
  When she chooses the dresses she wants to buy
  And she confirm her purchase
  And she chooses the delivery address 'My address 2'
  And she chooses a shipping option for her address 'My carrier'
  And she chooses to pay by 'check' and confirms her order
  Then she should see the following message 'Your order on My Store is complete.'
  And she should see that the total cost of the order is correct
  And she should see that the order was recorded in her account's order history

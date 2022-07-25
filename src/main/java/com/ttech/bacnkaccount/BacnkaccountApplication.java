package com.ttech.bacnkaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
ROUTES TO DO STUFF:
/customers : returns all customers in DB [GET]

/accounts : returns all accounts in DB [GET]

/transactions : returns all transactions in DB [GET]

/customers/{customerId} : returns customer with id=customerId [GET]

/customers/add-customer : to add new customer [POST]
	{
		"id" : 1,
		"name" : "Alex"
	}

/customers/{customerId}/accounts : returns all account of customer with id=customerId [GET]

/customers/accounts/{accountId} : returns account with id=accountId [GET]

/customers/{customerId}/add-account : add new account to DB [POST]
	{
		"id" : 1000,
		"balance : 0"	
	}


/customers/{customerId}/{accountId}/transactions : return all transactions of account with id=accountId [GET]

/customers/{customerId}/{accountId}/transactions/{transactionId} : reutrns transaction with id=transactionId [GET]

/customers/{customerId}/{accountId}/new-transaction : adds a transaction to DB and updates account balance value [POST]
	{
		"id" : 123456789
		"amount" : 30000
	}
*/


@SpringBootApplication
public class BacnkaccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(BacnkaccountApplication.class, args);
	}

}

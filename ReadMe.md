
# Code Simple Library

This libarary contains four microservices, created using spring boot framework.

	1. Eureka Service Registry
	2. API Gateway 
	3. Book Service
	4. Subscription Service

## Book Service
This service provides five API endpoints to create book entry and retrieve the book information and runs at port 9081
This service will be registred with API Gateway and Eureka server as client. This service can be accessed through Gateway.

Below are the endpoints

- GET http://localhost:9081/books
Get the list of books
- GET http://localhost:9081/books/{bookId}
Get the book info based on the BookId
- GET http://localhost:9081/books/{bookId}/availableforsubscription
Returns true when book is available for subscription (available_copies > 0)
- POST http://localhost:9081/books
Add a new book info
- PUT http://localhost:9081/books
Update a book info
- POST http://localhost:9081/books/{bookid}}/subscribe
Reduce the available copies

## Subscription Service
This service provides five API endpoints to create book entry and retrieve the book information and runs at port 9082
This service will be registred with API Gateway and Eureka server as client. This service can be accessed through Gateway.

Below are the endpoints

- GET http://localhost:9082/subscriptions 
Return all subscriptions
- GET http://localhost:9082/subscriptions?subscriberName=Mohan
Retrieves book subscription of a specific subscriber by name.
- POST http://localhost:9082/subscriptions
This endpoint creates new subscrption in database and invoke book service api using Feign Client.

## API Gateway Service
This is the gateway to access book and susbscription microservices. This will run in the port 8080.
This service will be registred with Eureka server as client.
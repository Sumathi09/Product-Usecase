# Product-Usecase

Use case 2:
 
Schema 
	Product ID, 
	Product Description, 
	Product Name

Write a Rest API to do CURD operations and use NOSQL DBs to store the details

Write a Rest API to publish the messages to Kafka-	
	Message Format – Product ID, Prize
		
Write a Rest API to aggregate-	
	Given the productid as an input – output should be Product iD, Product Name, Product Prize
 
Expectations:

Use any language for Rest API

Unit testing coverage

Use public git to upload the code

Technologies Leveraged: 
	Spring Boot, 
	Apache Kafka, 
	MongoDB, 
	Redis, 
	Junit & Mockito.


#RESTful Web Services
*BUILD*

Requirement 1:
Write a Rest API to do CURD operations and use NOSQL DBs to store the details
Product
* Used Spring Boot Framework for building REST endpoints
* MongoDB- NOSQL database is used, data name is productdatabase and Collection name is product
* Redis Cache is used for performance. Upon user request, data will be fetched from cache and if not in cache will hit DB and provide response to client
* Following URI's are exposed for CURD operations for Product model
	Retrieve all Products    - GET		/product
	Create a Product         - POST 	/product
	Retrieve one Product     - GET 		/product/{id}
	Delete a Product         - DELETE	/product/{id}
* Exception handling & and Logging is done
* Unit testing is performed using Junit and Mockito

Requirement 2:
Service to publish message to Kafka
* Publish Product Price to Kafka  - POST  /kafka/publish

Requirement 3:
Service to get all details of Product- Name and Description from MongoDB and Price from Kafka
* Given the productid as an input – output should be Product iD, Product Name, Product Price-   GET	/getProductDetails/{id}

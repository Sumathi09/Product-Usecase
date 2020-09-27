# Product-Usecase
Use case 2:
 
Schema
 
1. Product ID
2. Product Description
3. Product Name
 
1. Write a Rest API to do CURD operations and use NOSQL DBs to store the details
2. Write a Rest API to publish the messages to Kafka
                Message Format – Product ID, Prize
3. Write a Rest API to aggregate
                Given the productid as an input – output should be Product iD, Product Name, Product Prize
 
Expectations:
1. Use any language for Rest API
2. Unit testing coverage
3. Use public git to upload the code

Technologies Leveraged: 
	1. Spring Boot
	2. Apache Kafka
	3. MongoDB
	4. Redis
	5. Junit & Mockito


#RESTful Web Services
 
	1. Product Services for CURD Operations
    Retrieve all Products  - GET    /product
    Create a Product       - POST 	/product
    Retrieve one Product   - GET    /product/{id}
    Delete a Product       - DELETE	/product/{id}


	2. Service to publish message to Kafka
     Publish Product Price to Kafka  - POST  /kafka/publish

	3. Service to get all details of Product- Name and Description from MongoDB and Price from Kafka
     Given the productid as an input – output should be Product iD, Product Name, Product Price-   GET	/getProductDetails/{id}

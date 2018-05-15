# adobe-restapi

##Build Instructions
run mvn clean install -X -U
mvn eclipse:eclipse
-Deploy war located in target directory to tomcat.
-Start tomcat

##Apis
  
:GET /adobe-restapi/v1/customer/get/{cust_id}
  
:POST /adobe-restapi/v1/customer/post

Sample Data :
Headers :
  Accept : application/json
  Content-Type : application/json
  
Post Body
{
    "cust_id": 1,
    "firstName": "this changed",
    "lastName": "testlastname",
    "age": 22,
    "address": "test address",
    "phoneNumber": "4081112222",
    "email": "test@customer.com",
    "country": "US",
    "created_at": "2018-05-14"
}
 
  
:PUT /adobe-restapi/v1/customer/put/{cust_id}
  
:DELETE /adobe-restapi/v1/customer/delete/{cust_id}

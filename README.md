### Build Instructions
```
run mvn clean install -X -U
mvn eclipse:eclipse
Deploy war located in target directory to tomcat.
Start tomcat
```

### Apis

 ``` 
:GET /adobe-restapi/v1/customer/get/{cust_id}
 ```
 ```
:POST /adobe-restapi/v1/customer/post
```
 ```
:PUT /adobe-restapi/v1/customer/put/{cust_id}
 ```
 ``` 
:DELETE /adobe-restapi/v1/customer/delete/{cust_id}
 ```

### Sample Request Response

 ```
PUT /adobe-restapi/v1/customer/post/ HTTP/1.1
Host: localhost:8080
Accept: application/json
Content-Type: application/json
Cache-Control: no-cache

{
    "cust_id": 3,
    "firstName": "testfirstname",
    "lastName": "testlastname",
    "age": 45,
    "address": "777 test address",
    "phoneNumber": "4081112222",
    "email": "test@customer.com",
    "country": "US",
    "created_at": "2018-05-14"
}
 ```

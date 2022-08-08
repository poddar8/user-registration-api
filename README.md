# 

REST API to accept a payload of username, password, and IP address.
- All parameters must not be blank (!= empty and null). Return error messages if not valid
- Password need to be greater than 8 characters, containing at least 1 number, 1 
Capitalized letter, 1 special character in this set “_ # $ % .” Return error messages if not 
valid
- Calls the IP-API.com  - Geolocation API -  end point to get geolocation for the provided IP: 
- If the IP is not in Canada, return error message that user is not 
eligible to register
- When all validation is passed, returns a random uuid and a welcome message with his 
username and his City Name (resolved using ip-geolocation api)
- The API is implemented using OpenAPI specification.

Rest Endpoint : http://localhost:8080/register 
Swagger URL: http://localhost:8080/swagger-ui/index.html

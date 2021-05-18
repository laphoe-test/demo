# demo

run command below to start the demo

```
./mnvw spring-boot:run
```

swagger ui
```
http://localhost:8080/swagger-ui.html
```

h2 console
```
http://localhost:8080/h2-console/login.jsp?jsessionid=117da1ab3b5809f9d21f2c56c568c9e9
```

1. get jwt by cURL, by using below credential.
username: user
password: password
```
curl -X POST "http://localhost:8080/api/jwt/authenticate" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"password\": \"password\", \"username\": \"user\"}"
```

2. get the distance by input the target postcode and destination postcode, with the jwt.
```
curl --location --request GET 'http://localhost:8080/api/geographic/distance/[target postcode]/[destination postcode]' \
--header 'Authorization: Bearer [jwt]' \
```

## 1. Steps to Run the Application (without Docker)
    1. Start the application: ./mvnw spring-boot:run
    2. Stop the service with Ctrl + C
    3. Comment out the createDummyData() function in the DummyDataService.java class
    4. In application.properties, change spring.jpa.hibernate.ddl-auto=drop-and-create to spring.jpa.hibernate.ddl-auto=update
    5. Restart the application with: ./mvnw spring-boot:run
## 2. To access the API using Swagger:
    1. Open a web browser and go to: http://localhost:8080/swagger-ui/index.html
    2. You can explore and test all available API endpoints directly from the Swagger UI page.

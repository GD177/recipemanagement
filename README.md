# Recipe management

## Build the application

Build the project using your IDE's build tools or 
by running the command below from the command line in the project's root directory.
```Shell
mvn clean install
```

## Start/Run the application

In the root run the application by using the command below

```Shell
mvn spring-boot:run
```
OR

You can run the application from your IDE by executing 
the main class with the main() method.

This will run the server on port 8081.
The application should now start.

## API Documentation

API documentation for this project is available using Swagger.

To view the API documentation, follow these steps:

1. Make sure the project is running.
2. Open a web browser and go to: `http://localhost:8081/swagger-ui.html` (replace `localhost:8081` with the appropriate host and port if different).
3. Explore the available endpoints, request/response models, and make API calls directly from the Swagger UI.

Alternatively, you can access the raw API specification in JSON format at: [API Documentation](./src/main/resources/swagger.json).


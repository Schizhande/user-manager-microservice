# user-manager-microservice

# This app is made up of the following services.

1. User manager service - this service has APIs for managing users (basic CRUD)

2. Config server service - this service contains the microservices' configuration server. All other services rely on this service to access configuration files.

3. Discovery server service - this is a service for the Eureka server that allows for service discovery.
 
4. Api gateway service - this is a Zuul gateway service.

# Pre-requisites

- Copy the absolute path for the config file folder within the project and replace it in the application.yml file for the inside config server service.

- Change the database credentials in the user-manager-service-test.yml configuration file to correspond to your local database credentials.

- Install java 11 and maven 

# Using the command line to run the system

Step 1: Navigate to the config-server-service folder and run the command 'mvn spring-boot:run -Dspring-boot.run.profiles=dev'

Step 2: Navigate to the discovery-server-service folder and run the command 'mvn spring-boot:run -Dspring-boot.run.profiles=dev'

Step 3: Navigate to the api-gateway-service folder and run the command 'mvn spring-boot:run -Dspring-boot.run.profiles=dev'

Step 4: Natigate to the user-manager-service folder and run the command 'mvn spring-boot:run -Dspring-boot.run.profiles=dev'

NB: For the application to run successfully, the preceding steps must be completed in the order listed.

Accessing Swagger url using http://localhost:8303/swagger-ui/

To test APIs add /user-manager route in all APIs for example in swagger API for getting all users is http://localhost:8303/v1/users/all then testing API behind Zuul gateway full url will be http://localhost:8302/api/user-manager/v1/users/all

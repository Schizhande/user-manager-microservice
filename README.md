# user-manager-microservice

Pre-requisites

Copy the absolute path for the config file folder within the project and replace it in the application.yml file for the inside config server service.
Change the database credentials in the user-manager-service-test.yml configuration file to correspond to your local database credentials.

Using the command line to run the system

Step 1: Navigate to the config-server-service folder and run the command./mvnw spring-boot:run.

Step 2: Navigate to the discovery-server-service folder and run the command./mvnw spring-boot:run.

Step 3: Navigate to the api-gateway-service folder and run the command./mvnw spring-boot:run.

Step 4: Natigate to the user-manager-service folder and run the command ./mvnw spring-boot:run

NB: For the application to run successfully, the preceding steps must be completed in the order listed.

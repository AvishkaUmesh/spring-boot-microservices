# Spring-Boot-Microservices
**Repository Name:** spring-boot-microservices

**Description:**
This repository contains a collection of microservices developed using Spring Boot, demonstrating the implementation of a microservices architecture. The microservices cover different aspects of an organization, including organization service, department service, and employee service. Additionally, the repository includes other components such as an API gateway, a config server, and a service registry.

**Table of Contents:**
1. [Installation](#installation)
2. [Usage](#usage)
3. [Services](#services)
    - [Organization Service](#organization-service)
    - [Department Service](#department-service)
    - [Employee Service](#employee-service)
4. [Additional Components](#additional-components)
    - [API Gateway](#api-gateway)
    - [Config Server](#config-server)
    - [Service Registry](#service-registry)
5. [Contributing](#contributing)

## Installation
To run these microservices locally, follow the steps below:

1. Clone the repository:
   ```bash
   git clone https://github.com/AvishkaUmesh/spring-boot-microservices.git
   ```
   
2. Navigate to the project directory:
   ```bash
   cd spring-boot-microservices
   ```

3. Build the microservices using Maven:
   ```bash
   mvn clean install
   ```

## Usage
1. Start the Config Server:
   ```bash
   cd config-server
   mvn spring-boot:run
   ```

2. Start the Service Registry:
   ```bash
   cd service-registry
   mvn spring-boot:run
   ```

3. Start each microservice individually:
   - Organization Service:
     ```bash
     cd organization-service
     mvn spring-boot:run
     ```
   - Department Service:
     ```bash
     cd department-service
     mvn spring-boot:run
     ```
   - Employee Service:
     ```bash
     cd employee-service
     mvn spring-boot:run
     ```
   
4. Start the API Gateway:
   ```bash
   cd api-gateway
   mvn spring-boot:run
   ```

Now you can access the microservices and the API gateway at the appropriate endpoints.

## Services

### Organization Service
- Responsible for managing organizations and their related information.
- Provides endpoints for creating organizations, retrieving organization details.

### Department Service
- Manages departments.
- Offers functionality for creating departments, retrieving department details.

### Employee Service
- Handles employee-related operations.
- Provides endpoints for creating employees, retrieving employee details.

## Additional Components

### API Gateway
- Acts as a single entry point for accessing the microservices.
- Provides routing and load balancing capabilities.
- Simplifies client-side interactions with the microservices.

### Config Server
- Centralized configuration server for the microservices.
- Stores and manages configuration files for each microservice.
- Enables dynamic configuration updates without requiring service restarts.

### Service Registry
- Registers and tracks the availability of microservices.
- Allows services to discover and communicate with each other dynamically.
- Facilitates load balancing and fault tolerance.

## Contributing
Contributions to this repository are welcome. If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.

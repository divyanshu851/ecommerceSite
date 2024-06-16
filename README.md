# Ecommerce Project

This project is a simple ecommerce application built with Java and Spring Boot.

## Technologies Used

- Java
- Spring Boot
- Maven
- JavaScript

## Features

- Product management: Add, update, delete, and view products.
- Cart management: View cart for a specific user.
- Integration with a fake store API for product data.

## How the Project Works

The project is structured around the MVC (Model-View-Controller) pattern, with the addition of Services and Data Transfer Objects (DTOs).

- **Controllers** handle incoming HTTP requests and return responses. They use services to perform business logic and data manipulation.
- **Services** contain the business logic of the application. They interact with the repositories to fetch, create, update, and delete data.
- **DTOs** are used to transfer data between processes. They are used to send data in HTTP responses and receive data in HTTP requests.
- **Mappers** are used to convert between entities and DTOs.

The application has two main parts: product management and cart management.

### Product Management

Product management is handled by the `ProductController` and `ProductService`. The controller handles HTTP requests and uses the service to perform operations on products. The `ProductService` uses the `ProductRepository` to interact with the database.

The application also integrates with a fake store API to fetch product data. This is handled by the `FakeStoreClient` and `FakeStoreProductService`.

### Cart Management

Cart management is handled by the `CartController` and `FakeStoreClient`. The controller handles HTTP requests and uses the `FakeStoreClient` to fetch cart data from the fake store API.

## Project Structure

The project follows a typical Spring Boot project structure. Here are some of the key files and directories:

- `src/main/java/org/example/ecommerceproject/controller`: Contains the controller classes for handling HTTP requests.
- `src/main/java/org/example/ecommerceproject/dtos`: Contains the Data Transfer Object (DTO) classes used for transferring data between processes.
- `src/main/java/org/example/ecommerceproject/mapper`: Contains the mapper class for converting between entity and DTO.
- `src/main/java/org/example/ecommerceproject/services`: Contains the service classes for business logic.

## Setup and Installation

1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn clean install` to build the project.
4. Run `mvn spring-boot:run` to start the application.

## Usage

- Use the `/product` endpoint to manage products.
- Use the `/cart/{userId}` endpoint to view the cart for a specific user.

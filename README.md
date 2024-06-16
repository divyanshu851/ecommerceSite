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
- Category management : we can also add, delete, and view category.
- Integration with a fake store API for product data.

## How the Project Works

The project is structured around the MVC (Model-View-Controller) pattern, with the addition of Services and Data Transfer Objects (DTOs).

- **Controllers** handle incoming HTTP requests and return responses. They use services to perform business logic and data manipulation.
- **Services** contain the business logic of the application. They interact with the repositories to fetch, create, update, and delete data.
- **DTOs** are used to transfer data between processes. They are used to send data in HTTP responses and receive data in HTTP requests.
- **Mappers** are used to convert between entities and DTOs.
- **Models** containing all the models of the projects.

The application has three main parts: product management, category management and cart management.

### Product Management

Product management is handled by the `ProductController` and `ProductService`. The controller handles HTTP requests and uses the service to perform operations on products. The `ProductService` uses the `ProductRepository` to interact with the database.

The application also integrates with a fake store API to fetch product data. This is handled by the `FakeStoreClient` and `FakeStoreProductService`.
### Category Management
Category management is handled by the 'CategoryController' and 'CategoryService'. The controller handles HTTP requests and uses the service to perform operations on category. The `CategoryService` uses the `CategoryRepository` to interact with the database.

### Cart Management

Cart management is handled by the `CartController` and `FakeStoreClient`. The controller handles HTTP requests and uses the `FakeStoreClient` to fetch cart data from the fake store API.

## Project Structure

The project follows a typical Spring Boot project structure. Here are some of the key files and directories:

- `src/main/java/org/example/ecommerceproject/controller`: Contains the controller classes for handling HTTP requests.
- `src/main/java/org/example/ecommerceproject/dtos`: Contains the Data Transfer Object (DTO) classes used for transferring data between processes.
- `src/main/java/org/example/ecommerceproject/mapper`: Contains the mapper class for converting between entity and DTO.
- `src/main/java/org/example/ecommerceproject/services`: Contains the service classes for business logic.


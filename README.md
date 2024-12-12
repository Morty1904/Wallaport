# Wallaport

## Summary

Wallaport is a second-hand product online marketplace application, based on a backend system created with Java, Spring Boot, and H2. In this project, users will be able to register, post products, send messages to other users, and search or mark products as favorites. This development focuses solely on the backend layer, and the endpoints will be tested and validated using Postman.

*(Disclaimer: This app could be specialized in a certain product type, similar to how "Vinted" is a platform similar to Wallapop, but primarily focused on clothing, but I haven't decided yet...)*

## Project Objective

Create a backend system that allows managing users, products, and messages, providing a secure platform for user interaction through functionalities similar to those of a online marketplace application.

## Key Features

### Authentication and Authorization

- **Registered Users and Roles**: Implement a registration and login system for users, assigning them specific roles and permissions.
- **JWT Security Management**: Generation and validation of JWT tokens to protect endpoints and ensure access is granted only to authorized users.

### Product Management (CRUD)

- **Product Posting**: Create, view, update, and delete products.
- **Product Fields**: Each product will have attributes such as title, description, price, and category, allowing for clear and consistent organization.

### User Messaging System

- **Basic Chat**: Implement a messaging system that allows users to communicate with each other about specific products.
- **Message Storage**: All messages will be stored in the database, providing a chat history.

### Search and Favorites Features

- **advanced Search**: Users will be able to search for products, filtering results by categories and price ranges.
- **Favorites System**: Option for users to mark products as favorites, providing quick access to products of interest.

## Technologies and Tools

- **Java and Spring Boot**: To develop the API and organize the backend structure.
- **H2 Database**: In-memory database to store user, product, and message information.
- **Spring Security and JWT**: Security configuration for user authentication and authorization.
- **Postman**: Tool for testing endpoints and validating the correct operation of the API.
- **GitHub**: Version control platform to manage the code in an organized manner.

## Testing and Validation

- Creation of a Postman test collection to ensure the functionality of each endpoint.
- Authentication and authorization tests to verify that only authenticated users can access restricted endpoints.
- Validation of the messaging system, product CRUD, favorites system, and advanced searches.

## Development Methodology

This project will be developed in iterative stages, focusing on the progressive delivery of complete functionalities.

## UML

![UML proyecto personal v1](https://github.com/user-attachments/assets/5512708d-4c8d-4444-aae9-58ea2f03ca90)

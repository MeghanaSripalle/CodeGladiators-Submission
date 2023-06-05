# E-commerce Management System

This is a simple inventory management system for an e-commerce platform, developed using Java. It provides basic functionalities such as adding, updating, and removing products, as well as checking the available stock. The system uses Maven as the build tool, Dropwizard for APIs, and Exposed for interacting with the database.

## Prerequisites

Before running the application, make sure you have the following installed:

- Java JDK (version 8 or above)
- Apache Maven

## Getting Started

Follow these steps to set up and run the e-commerce management system:

1. Clone the repository from GitHub:

```
git clone https://github.com/your-username/ecommerce-management-system.git
```

2. Change into the project directory:

```
cd ecommerce-management-system
```

3. Build the project using Maven:

```
mvn clean package
```

4. Start the application:

```
java -jar target/ecommerce-1.0-SNAPSHOT.jar server config.yml
```

The application should now be running on `http://localhost:8080`.

## Database Setup

The e-commerce management system creates a database named `EcommerceDatabase` and a table named `Products` if they don't already exist. The necessary database and table will be automatically created during the first run of the application.

## API Endpoints

The following API endpoints are exposed by the system:

- `POST /ecommerce/add/product`: Add a new product.
- `POST /ecommerce/delete/product`: Delete one or more products by providing their IDs.
- `GET /ecommerce/getStock/product/{productId}`: Get the stock of a product by its ID.
- `PUT /ecommerce/update/product`: Update an existing product.

Please note that all API endpoints require authentication, and you should include the appropriate headers or tokens for authorization purposes.

## Error Handling

The system handles the following exceptions:

- `ProductNotFoundException`: Thrown when a product with the provided ID is not found.
- `ProductIdNotFoundException`: Thrown when one or more product IDs are not found for deletion.

When an exception occurs, the API will return an appropriate error response with a corresponding status code and error message.

## Object-Oriented Programming (OOP) and Singleton

The e-commerce management system takes advantage of object-oriented programming principles and utilizes the Singleton design pattern. Here's how it helps:

1. **Abstraction**: The system is designed using classes, which allow for abstraction, encapsulation, and modularization of code. This promotes code reusability and maintainability.

2. **Encapsulation**: The system encapsulates related data and functionality within classes, providing a clear separation of concerns. Each class focuses on a specific aspect of the system, such as product management or database interaction.

3. **Singleton**: The Singleton pattern ensures that there is only one instance of a class created and provides a global point of access to it. In this system, the database connection and product management classes are implemented as singletons. This approach helps in managing resources efficiently and avoids unnecessary object creation.

By leveraging OOP principles and the Singleton pattern, the e-commerce management system achieves a modular, scalable, and maintainable architecture.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more information.


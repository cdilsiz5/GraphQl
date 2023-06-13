# User Management Application GraphQL API

This project is a simple User Management Application implemented with GraphQL. The application exposes several GraphQL queries and mutations that enable clients to manage users in the system.

## Queries and Mutations

Here are some examples of the queries and mutations that you can execute with this API:

### Query All Users

This query retrieves all the users from the system:

```graphql
{
  getAllUsers {
    id,
    username,
    role,
    created,
    updated
  }
}
```

### Query User by ID

This query retrieves a specific user by their ID:

```graphql
{
  getUserById(id:1) {
    id,
    username,
    created,
    updated
  }
}
```

### Update a User

This mutation updates a user's information. You need to pass a `UserRequest` input type with the details of the user to update. The mutation returns the updated username:

```graphql
mutation {
  updateUser(userRequest: {
    id:1,
    username:"Murat",
    mail:"cihandilsizdev@gmail.com",
    role:ADMIN
  }) {
    username
  }
}
```

### Delete a User

This mutation deletes a user from the system:

```graphql
mutation {
  deleteUser(id:1)
}
```

### Create a User

This mutation creates a new user in the system. You need to pass a `UserRequest` input type with the details of the user to create:

```graphql
mutation {
  createUser(userRequest: {
    username:"Cihan",
    mail:"cihandilsizdev@gmail.com",
    role:ADMIN
  }) {
    username
  }
}
```

## Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

- Java 17
- Maven
- H2 Database

### Installation

1. Clone the repository
2. Update the `application.properties` file with your database credentials
3. Run the application using `mvn spring-boot:run`

Enjoy exploring the project!


## Contact

Cihan Dilsiz - cihandilsizdev@gmail.com

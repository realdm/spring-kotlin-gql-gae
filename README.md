# spring-kotlin-gql-gae
This is a sample skeleton of a backend app that was built using:
* [Spring Boot(Kotlin)](https://spring.io/projects/spring-boot)
* [Reactive Web](https://spring.io/guides/gs/reactive-rest-service/)
* [Sprinng Data R2DBC with MYSQL](https://spring.io/projects/spring-data-r2dbc)
* [Expedia Graphql Kotlin](https://opensource.expediagroup.com/graphql-kotlin/docs/server/graphql-server/)

This app can be deployed on [Google AppEngine Flex environment](https://cloud.google.com/appengine/docs/flexible/java) with a [Google Cloud SQL(MySQL)](https://cloud.google.com/sql) database.

# Getting Started

## Running Locally

This section will cover the changes you will need to make to run the project locally.

### Clone the project
After cloning the project open it using your favourite IDE. I recommend you [InteliJ](https://www.jetbrains.com/idea/) by Jetbrains

### Install Mysql ( Mac OS) (🚨) **Important Step**
Install mysql on your machine using homebrew and create a database. I found this [post](https://flaviocopes.com/mysql-how-to-install/) very useful and with all of the information you will need to do that.
**Note**: Remember to record the USER_NAME, PASSWORD and DATABASE_NAME you will create. You will need it later.

**Installation TLDR; ( Do the following on your terminal)**
1. `brew install mysql`
2. `brew services start mysql`
3. `mysql_secure_installation`
4. `mysql.server start`
5. `mysql -u root -p`
6. `mysql> CREATE DATABASE <DATABASE_NAME>;`
7. `mysql> CREATE USER '<USER>'@'localhost' IDENTIFIED BY '<PASSWORD>';`
8. `mysql> GRANT ALL PRIVILEGES ON <DATABASE_NAME>.* TO '<USER>'@'localhost';`
9. `mysql> exit`

### Configure the Database Connection on the project
1. Open the project then the file **application.yml). The file is located at **src/main/resources/application.yml**
2. Edit the spring configuration for the **dev** profile by adding the information about how to connect to your database
```yml
spring:
  config:
    activate:
      on-profile: dev
  r2dbc:
    initialization-mode: always
    url: r2dbc:mysql://localhost:3306/<DATABASE_NAME>
    username: <USER>
    password: <PASSWORD>
```

### Run the application
You can run the application by executing the main function inside the **SampleApplication.kt** file or by executing the **bootRun** task that can be accessible through the tasks panel of your IDE if you are using InteliJ.

As it is mentioned on [this](https://opensource.expediagroup.com/graphql-kotlin/docs/server/spring-server/spring-overview) page, after running the application you will get the following default routes:

Your newly created GraphQL server starts up with following preconfigured default routes:

/graphql - GraphQL server endpoint used for processing queries and mutations
/subscriptions - GraphQL server endpoint used for processing subscriptions
/sdl - Convenience endpoint that returns current schema in Schema Definition Language format
/playground - Prisma Labs GraphQL Playground IDE endpoint

### Go to playground and test
If all of your configurations are correct, you should now be able to have the GraphQL explorer by typing the following address on your browser:
***http://localhost:8080/playground.

This will open a [Graphql IDE](https://github.com/graphql/graphql-playground) which will allow you to execute your GraphQL Operations and see your schema documentation.

Here are some of the things you can do with what we have setup now:

***Create an Account***
```graphql
mutation CreateAccount($input: CreateAccountInput!) {
  createAccount(input: $input){
    account {
      firstName
      lastName
      email
      createdAt
      id
    }
  }
}
```

***Load an account by Id**
```graphql
query GetAccount($id: ID!) {
  account(id: $id) {
    firstName
    lastName
    email
    createdAt
  }
}
```

## Building your own schema
To build your own schema I recommend you follow the documentation that can be found [here](https://opensource.expediagroup.com/graphql-kotlin/docs/server/spring-server/spring-schema). I found that part of the process very clear and as a result I see no need of repeating the steps here.






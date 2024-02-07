## Microunaut API Documentation.

## Getting Started

### Prerequisites

- JDK 11 or later
- Gradle 6.0 or later (optional if using Gradle wrapper)
- Docker (for containerization)

### Setup Instructions

1. Clone the repository:
   ```shell
   git clone https://github.com/naveeez10/micronaut-projects.git
   cd micronaut-projects/micronaut-api
   ```

2. Install dependencies:
   ```shell
   ./gradlew build
   ```

3. Configure environment (if necessary, modify `src/main/resources/application.yml`).

### Running the Application

- To run the application locally:
  ```shell
  ./gradlew run
  ```

- To run the application using Docker:
  ```shell
  docker pull mariadb
  docker-compose up --build
  ```

## Project Structure

  Every API has MVM Architecture. The project structure is as follows:
  ## Controllers -> Services -> Repositories
  - `Controllers`: Handles incoming requests and outgoing responses.
  - `Services`: Contains business logic.
  - `Repositories`: Handles data access.
  

- `src/`: Contains source code for the project.
- `build.gradle`: Defines project dependencies and plugins.
- `.gitignore`: Specifies intentionally untracked files to ignore.
- `docker-compose.yaml`: Docker compose file for containerization.


## Building and Deployment

- Run the project:
  ```shell
  ./gradlew run
  ```

- Deploy:
  Detailed steps for deploying the application, including any platform-specific instructions.

## Additional Resources

- [Micronaut Framework Documentation](https://docs.micronaut.io/latest/guide/)
- [Gradle Documentation](https://gradle.org/guides/)

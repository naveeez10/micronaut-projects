## Microunaut API Documentation.

## Getting Started

### Prerequisites

- JDK 11 or later
- Gradle 7.4 or later
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

- If not pulled the image, pull the image first.
  ```shell
  docker pull mariadb
  ```
- Run the docker image.
- 
  ```shell
  docker-compose up
  ```
  
- Run the application:
  ```shell
  ./gradlew run
  ```

## Project Structure

  Every API has MVM Architecture. The project structure is as follows:
  ### Controllers -> Services -> Repositories
  - `Controllers`: Handles incoming requests and outgoing responses.
  - `Services`: Contains business logic.
  - `Repositories`: Handles data access.
  

- `src/`: Contains source code for the project.
- `build.gradle`: Defines project dependencies and plugins.
- `.gitignore`: Specifies intentionally untracked files to ignore.
- `docker-compose.yaml`: Docker compose file for containerization.


## Additional Resources

- [Micronaut Framework Documentation](https://docs.micronaut.io/latest/guide/)
- [Gradle Documentation](https://gradle.org/guides/)

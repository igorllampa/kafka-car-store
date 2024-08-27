## kafka-car-store
Project to implement features of microservices using kafka to manage distributed event streaming

There are three springboot projects, as follows:

- **Api**
  - The main service where all of the requests begin and it is responsible for redirect this request to the respective microservice or produce messages at Kafka.
- **Car**
  - Microservice responsible for store data of car announcements and owner. There are service that are listeners of kafka service to get data and store them inside a postgre database.
- **Data**
  - Microservice responsible for store data for analytics and reports purpose. There are listener to monitor kafka service and get data to be store inside a postgre database.


### How to Prepare the environment to run the project:

#### 1. Tutorial for using a container docker with Kafka
https://www.youtube.com/watch?v=Zq8aMrRnvQE

https://github.com/conduktor/kafka-stack-docker-compose

#### 2. Docker hub image for PostgreSQL database
https://hub.docker.com/_/postgres

#### 3. Conduktor: visually view and manage Kafka 
https://conduktor.io/download

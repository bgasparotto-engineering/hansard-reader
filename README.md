# Hansard Reader
Microservice for reading data from the [British Hansard API](http://www.data.parliament.uk/dataset), transforming and
publishing the results on Apache Kafka, to later be processed by Apache Spark driver scripts.

## Main stack
- Spring Boot
- Java 11
- Apache Kafka
- Apache Avro
- Confluent schema-registry
- Flyway
- Postgres

## Running the service
This service and many others in this organisation requires Apache Kafka and Schema Registry to run. They-are centralised
in the project [environment](https://github.com/bgasparotto-engineering/environment).

### Environment's docker-compose
```shell script
git clone https://github.com/bgasparotto-engineering/environment
cd environment
docker-compose up -d
```

### This docker-compose
```shell script
git clone https://github.com/bgasparotto-engineering/hansard-reader
cd hansard-reader
docker-compose up -d
```

### Run
Run the main class `HansardReaderApplication.java`

## Interacting with the service
1. Produce Kafka messages to `message.scheduler.run-hansard-update` using the schema from `RunUpdate.avsc`;
2. Check the logs where the consumed messages will be displayed as a result;
3. Visit the Schema Registry at http://localhost:8081/subjects and you should see the created subject by Avro;
4. Visit the Control Center at http://http://localhost:9091 to find details about the Kafka cluster.

### Generating Avro source code
This project uses [Gradle Avro Plugin](https://github.com/davidmc24/gradle-avro-plugin) for generating Java classes for
schemas defined in `.avsc` files:
```shell script
./gradlew generateAvroJava
```

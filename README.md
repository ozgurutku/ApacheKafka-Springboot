# ApacheKafka-Springboot
Simple kafka application on spring boot. It consists of 1 topic and 4 consumer groups.
<br>
https://reflectoring.io/spring-boot-kafka/ You can find detailed information about using Kafka in Springboot from this site.

# How to run
If you don't have zookeeper and kafka installed, you can run docker-compose.yml and install it. Go to the location of the downloaded file and run `docker-compose up` in the terminal.
<br>
### Install depedencies

```sh
$ mvn clean install
```

### Start

```sh
$ mvn spring-boot:run
```

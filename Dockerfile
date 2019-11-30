FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY ./build/libs/* ./thymeleaf-parser.jar
CMD java -jar thymeleaf-parser.jar
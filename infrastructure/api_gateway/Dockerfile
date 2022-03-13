FROM java:8
RUN mkdir /app
COPY ./infrastructure/api_gateway/target/api_gateway-0.0.1-SNAPSHOT.jar /app
COPY ./wait-for-it.sh /app
WORKDIR /app
CMD ["java", "-jar", "api_gateway-0.0.1-SNAPSHOT.jar"]
FROM java:8
RUN mkdir /app
COPY ./service/service_vod/target/service_vod-1.0SNAPSHOT.jar /app
COPY ./wait-for-it.sh /app
WORKDIR /app
CMD ["java", "-jar", "service_vod-1.0-SNAPSHOT.jar"]
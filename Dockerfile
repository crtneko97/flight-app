FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# ← this must match the name you saw above
COPY build/libs/flight-booking-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

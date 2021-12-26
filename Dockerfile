FROM ibm-semeru-runtimes:open-11-jdk as build
WORKDIR /app/build
COPY modules /app/build/modules
COPY client/java/*gradle* /app/build/client/java/
COPY gradle /app/build/gradle
COPY settings.gradle /app/build/settings.gradle
COPY gradlew /app/build/gradlew
RUN /app/build/gradlew tasks
LABEL type="gradle build"
RUN /app/build/gradlew bootJar --no-daemon && mv /app/build/modules/app/build/libs/*.jar /app/build/app.jar && /app/build/gradlew clean --no-daemon

FROM ibm-semeru-runtimes:open-11-jre
RUN mkdir "/app"
WORKDIR /app
COPY --from=build /app/build/app.jar /app/bin.jar
EXPOSE 8080
ENV DB_URL=jdbc:h2:file:./db
ENV DB_USER=sa
ENV DB_PASSWORD=sa
ENTRYPOINT ["java", "-jar", "/app/bin.jar"]
CMD []
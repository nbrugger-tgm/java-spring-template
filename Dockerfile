FROM ibm-semeru-runtimes:open-17-jdk as build
WORKDIR /app/build
LABEL type="gradle build"
COPY gradlew /app/build/gradlew
COPY settings.gradle /app/build/settings.gradle
#this is just so the build doesn't fail, the client is not built here
COPY client/java/*gradle* /app/build/client/java/
COPY gradle /app/build/gradle
COPY modules /app/build/modules
RUN /app/build/gradlew bootJar --no-daemon && mv /app/build/modules/app/build/libs/*.jar /app/build/app.jar && /app/build/gradlew clean --no-daemon

FROM ibm-semeru-runtimes:open-17-jre
RUN mkdir "/app"
COPY --from=build /app/build/app.jar /app/bin.jar
EXPOSE 8080
ENV DB_URL=jdbc:h2:file:./db
ENV DB_USER=sa
ENV DB_PASSWORD=sa
WORKDIR /app
ENTRYPOINT ["java", "-jar", "/app/bin.jar"]
CMD []
FROM openjdk

WORKDIR /app

COPY target/cantina-dh-0.0.1-SNAPSHOT.jar /app/cantina-dh.jar

ENTRYPOINT [ "java","-jar","cantina-dh.jar" ]
EXPOSE 8080
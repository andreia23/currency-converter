FROM maven:3.6.3-openjdk-11
EXPOSE 9037
ADD target/currency-converter-1.0.0.jar /app/currency-converter.jar
ENTRYPOINT ["java", "-jar", "/app/currency-converter.jar"]

           


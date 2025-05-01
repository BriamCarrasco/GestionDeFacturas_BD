# Dockerfile

FROM openjdk:21-ea-24-oracle

WORKDIR /app
COPY target/gestionfacturasbd-0.0.1-SNAPSHOT.jar app.jar

COPY Wallet_O60Z3CLZXPPALS3A /app/oracle_wallet/
EXPOSE 8082

CMD ["java", "-jar", "app.jar"]


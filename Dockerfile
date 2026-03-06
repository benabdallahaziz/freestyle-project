# Base légère avec Java 17
FROM eclipse-temurin:17-jre-alpine

# Créer un répertoire de travail
WORKDIR /app

# Copier uniquement le JAR final
COPY target/*.jar app.jar

# Exposer le port de ton app
EXPOSE 8089

# Entrée de l'application
ENTRYPOINT ["java", "-jar", "app.jar"]

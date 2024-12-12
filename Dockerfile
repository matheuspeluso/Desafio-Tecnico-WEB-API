# Etapa 1: Compilar o projeto com Maven
FROM maven:3.9.4-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .  
# Copiar apenas o pom.xml para resolver dependências inicialmente
RUN mvn dependency:go-offline  
# Fazer o download das dependências para otimizar o cache
COPY . .  
# Copiar todo o projeto
RUN mvn clean package -DskipTests  
# Construir o pacote

# Etapa 2: Rodar a aplicação
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/Desafio-tecnico-Web-API-1.0.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]

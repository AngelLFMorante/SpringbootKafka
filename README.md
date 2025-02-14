# Kafka Example

Este repositorio contiene un ejemplo de integración de **Kafka** con **Spring Boot**, diseñado para ser utilizado en entrevistas técnicas o pruebas. El proyecto incluye una configuración básica de productor y consumidor de mensajes usando Kafka, y un ejemplo de una API REST para gestionar empleados.

## Descripción

Este proyecto demuestra cómo configurar un consumidor y productor de Kafka utilizando Spring Boot. El sistema permite la creación de empleados a través de un endpoint REST y envía un mensaje a Kafka cuando se crea un nuevo empleado.

**Tecnologías utilizadas**:
- **Spring Boot** (Framework principal)
- **Spring Kafka** (Para la integración con Kafka)
- **JPA y H2 Database** (Base de datos en memoria)
- **Lombok** (Para reducir código boilerplate)
- **Maven** (Gestor de dependencias)

## ¿Cómo funciona?

- **Kafka Producer**: Envia mensajes a un tema de Kafka cuando se crea un nuevo empleado.
- **Kafka Consumer**: Escucha el tema `example-topic` y procesa los mensajes recibidos.
- **API REST**: Se expone un endpoint para crear empleados y obtener la lista de empleados.

## Tecnologías utilizadas

- **Spring Boot**: Framework para la construcción de la aplicación web.
- **Spring Kafka**: Para el manejo de los mensajes de Kafka (productor y consumidor).
- **H2 Database**: Base de datos en memoria utilizada para almacenar la información de los empleados.
- **Maven**: Para gestionar dependencias y ejecutar el proyecto.

## Instrucciones para ejecutar el proyecto

### 1. Clonando el repositorio

Para descargar el proyecto, usa el siguiente comando en tu terminal:

```bash
git clone <url-del-repositorio>
cd <nombre-del-repositorio>
```

## 2. Levantar Kafka y Zookeeper

Este proyecto requiere que Kafka y Zookeeper estén en funcionamiento.
- **Opción 1**: Usando Kafka en tu máquina local
  - Descargar Kafka: Si no tienes Kafka descargado, puedes obtenerlo desde Kafka Downloads.
  - Levantar Zookeeper: En la carpeta bin/windows de tu instalación de Kafka, ejecuta:
    ```bash
    .\zookeeper-server-start.bat ..\..\config\zookeeper.properties
    ```
  - Levantar Kafka: En la misma carpeta bin/windows, ejecuta:
    ```bash
    .\kafka-server-start.bat ..\..\config\server.properties
    ```
- **Opción 2**: Usando Kafka con Docker

  - Si prefieres usar Docker, puedes levantar Kafka y Zookeeper con los siguientes pasos:
    - Asegúrate de tener Docker instalado.
    - Crea un archivo docker-compose.yml con el siguiente contenido:

        ```yaml
            version: '2'
            services:
              zookeeper:
                image: wurstmeister/zookeeper:3.4.6
                ports:
                  - "2181:2181"
              kafka:
                image: wurstmeister/kafka:latest
                ports:
                  - "9092:9092"
                environment:
                  KAFKA_ADVERTISED_LISTENER: INSIDE
                  KAFKA_LISTENER_SECURITY_PROTOCOL: PLAINTEXT
                  KAFKA_LISTENER_NAME: INSIDE
                  KAFKA_LISTENER_PORT: 9093
                  KAFKA_LISTENER_INTER_BROKER_SECURITY_PROTOCOL: PLAINTEXT
                  KAFKA_LISTENER_INTER_BROKER_PORT: 9093
                  KAFKA_LISTENER_NAME_INNER: INSIDE
                  KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
                  KAFKA_LISTENER_SECURITY_PROTOCOL: PLAINTEXT
                depends_on:
                  - zookeeper
        ```
    - Levanta los servicios con Docker Compose:
        ```bash 
          docker-compose up
        ```
##  3. Ejecutar el proyecto

Una vez que Kafka y Zookeeper estén en funcionamiento, puedes ejecutar el proyecto en tu máquina local.

- Maven: Si no tienes Maven instalado, puedes descargarlo desde aquí.
- Para ejecutar el proyecto:
    ```bash 
      mvn spring-boot:run
    ```
## 4. Endpoints disponibles

- POST /employees: Crea un nuevo empleado. Ejemplo de request body:
```json
  {
    "name": "John Doe",
    "position": "Developer"
  }
```
- GET /employees: Devuelve la lista de empleados.  

## Preguntas frecuentes en entrevistas sobre Kafka

1. ¿Qué es Kafka? 
   - Kafka es una plataforma distribuida de mensajería diseñada para manejar grandes volúmenes de datos en tiempo real. Se utiliza principalmente para la transmisión de datos y eventos entre aplicaciones.
2. ¿Qué es un productor en Kafka? 
   - Un productor en Kafka es una aplicación que envía mensajes (o eventos) a un tema específico de Kafka.
3. ¿Qué es un consumidor en Kafka? 
   - Un consumidor en Kafka es una aplicación que lee mensajes de un tema específico.
4. ¿Qué es un "topic" en Kafka? 
   - Un "topic" es un canal de mensajes al que los productores envían mensajes y los consumidores los leen.
5. ¿Cómo se garantiza la entrega de mensajes en Kafka?
   - Kafka garantiza la entrega de mensajes a través de la configuración de los factores de replicación y la confirmación de los consumidores.
6. ¿Qué es un "Consumer Group"? 
   - Un "Consumer Group" es un grupo de consumidores que trabajan juntos para leer mensajes de un tema de Kafka. Los mensajes se distribuyen entre los miembros del grupo.
7. ¿Qué es un offset en Kafka? 
   - El offset es un número que representa la posición de un mensaje dentro de un tema en Kafka. Los consumidores usan los offsets para saber qué mensajes han leído.
      
## Estructura del Proyecto

Este proyecto tiene la siguiente estructura:
```css 
src/
├── main/
│   ├── java/
│   │   ├── com/
│   │   │   ├── example/
│   │   │   │   ├── kafka/
│   │   │   │   │   ├── KafkaTopicConfig.java
│   │   │   │   │   ├── KafkaConsumer.java
│   │   │   │   │   ├── KafkaProducer.java
│   │   │   │   │   ├── EmployeeController.java
│   │   │   │   │   ├── EmployeeService.java
│   │   │   │   │   ├── EmployeeRepository.java
│   │   │   │   │   ├── Employee.java
│   ├── resources/
│   │   ├── application.properties
```

## Contribución
Si encuentras mejoras o quieres aportar, envía un **Pull Request** o abre un **Issue** en el repositorio.

## Licencia
Este proyecto es de código abierto y está disponible bajo la licencia MIT.
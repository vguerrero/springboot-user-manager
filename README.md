# UserManager SpringBoot app

instrucciones

1- correr: mvn clean install
para limpiar el proyecto e instalar las librerias necesarias

2- despues: mvn spring-boot:run
para correr el proyecto


version de java
17

3- url de servicios en swagger
http://localhost:8081/api/swagger-ui/index.html

-se obtiene el token jwt generado de forma simple
mandando el usuario: victorg
en este endpoint: http://localhost:8081/api/auth/login

- despues se copia ese token y se pega en la parte de authorization bearer token:
endpoint: POST - http://localhost:8081/api/user

-se pueden acceder a todos los usuarios en el endpoint
http://localhost:8081/api/user/all

se coloca folder de evidencia de funcionamiento en este proyecto
Muchas Gracias.
 


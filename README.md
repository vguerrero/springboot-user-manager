# UserManager SpringBoot app

instrucciones

version java 11 en adelante
maven instalado

*correr: mvn clean install en la raiz del proyecto
para limpiar el proyecto e instalar las librerias necesarias

- despues: mvn spring-boot:run
para correr el proyecto

![img.png](evidence/img.png)

*se obtiene el token jwt generado de forma simple
mandando el usuario: victorg
en este endpoint: http://localhost:8081/api/auth/login

quedando de esta forma en postman
![Captura de pantalla_2024-02-27_15-40-48.png](evidence%2FCaptura%20de%20pantalla_2024-02-27_15-40-48.png)


* despues se copia ese token y se pega en la parte de authorization bearer token:
endpoint: POST - http://localhost:8081/api/user
![Captura desde 2024-04-18 09-07-18.png](evidence%2FCaptura%20desde%202024-04-18%2009-07-18.png)

al enviar el usuario queda guardado respondiendo el servicio lo siguiente
![Captura de pantalla_2024-02-27_15-41-04.png](evidence%2FCaptura%20de%20pantalla_2024-02-27_15-41-04.png)

*se pueden acceder a todos los usuarios en el endpoint
http://localhost:8081/api/user/all
![Captura de pantalla_2024-02-27_15-41-29.png](evidence%2FCaptura%20de%20pantalla_2024-02-27_15-41-29.png)


* url de servicios en swagger
http://localhost:8081/api/swagger-ui/index.html
![Captura de pantalla_2024-02-27_15-45-48.png](evidence%2FCaptura%20de%20pantalla_2024-02-27_15-45-48.png)

* diagrama de la solucion
* https://drive.google.com/file/d/1vrF7pNX4vGa4oOQzMUTPXKyw8K-N4ROr/view?usp=sharing
![diagrama solucion.drawio (1).png](evidence%2Fdiagrama%20solucion.drawio%20%281%29.png)


*tambien se agrega la coleccion de postman con los request del servicio
[SmartJobs_Test.postman_collection.json](evidence%2FSmartJobs_Test.postman_collection.json)

 


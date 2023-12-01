# Ejercicio-Java
## Requisitos Previos

Asegúrate de tener instalados los siguientes requisitos previos:

- **Java 8 o superior:** Descárgalo [aquí](https://www.oracle.com/java/technologies/javase-downloads.html).
- **Maven:** Descárgalo [aquí](https://maven.apache.org/download.cgi) e instálalo siguiendo las [instrucciones de instalación](https://maven.apache.org/install.html).

## Instalación y Ejecución

Sigue estos pasos para ejecutar el proyecto en tu entorno local:

### Clonar el Repositorio

Abre una terminal y clona el repositorio de GitHub en tu máquina local:

```bash
git clone https://github.com/felipeandradevalenzuela/Ejercicio-Java.git
```

### Configuración

Navega hasta el directorio del proyecto:

```bash
cd rutaDelRepositorio
```

Usa Maven para compilar y construir el proyecto:
```bash
mvn clean install
```
Luego, puedes ejecutar la aplicación con el siguiente comando:
```bash
mvn spring-boot:run
```
La aplicación ahora debería estar en funcionamiento y escuchando en un puerto específico (generalmente el puerto 8080).

### Acceder a la Aplicación
Abre tu navegador web y visita la siguiente dirección:

```bash
http://localhost:8080
```
Esto te llevará a la página de inicio de la aplicación, donde puedes comenzar a utilizarla.

Para revisar los endpoint y schemas mediante Swagger puedes visitar:

[http://localhost:8080/doc/swagger-ui/index.html](http://localhost:8080/doc/swagger-ui/index.html)


Recuerda que el endpoint para ver usuarios es
[http://localhost:8080/user/all](http://localhost:8080/user/all)
[http://localhost:8080/user/{userId}](http://localhost:8080/user/{userId})

Para la creación de usuarios puedes hacer un Post directamente a:
[http://localhost:8080/auth/register](http://localhost:8080/auth/register)

Aquí adjunto un curl para que cargues usuarios.
```bash
curl --location 'http://localhost:8080/auth/register' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=E3E9BA37A02DCA9DBD20B80C3B113940' \
--data-raw '{
"name": "Pedro Test",
"email": "ptest@gmail.org",
"password": "Testing123!",
"phones": [
{
"number": "1212",
"cityCode": "1",
"countryCode": "57"
},
{
"number": "2323",
"cityCode": "25",
"countryCode": "27"
},
{
"number": "4242",
"cityCode": "3",
"countryCode": "87"
}
]
}
'
```

Si deseas ingresar puedes acceder mediante la url:
[http://localhost:8080/auth/login](http://localhost:8080/auth/login)

Agregando el password y username (correo) que agregaste en tu registro.
Esto cambiara tu last_login y actualizara tu Token JWT.

```bash
curl --location 'http://localhost:8080/auth/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username": "ptest@gmail.org",
    "password": "Testing123!"
}
'
```

** Para utilizar endpoints seguros:
Debe guardar el Token entregado en la respuesta de la creación o Login respectivamente:
y hacer un request de este estilo:

** es importante modificar el token de autorización, o no podras acceder al endpoint privado. (/user/**)

```bash
curl --location --request GET 'http://localhost:8080/user/all' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwdGVzdEBnbWFpbC5vcmciLCJpYXQiOjE3MDE0MTU1NzAsImV4cCI6MTcwMTUwMTk3MH0._91J_pLDFPvd96L3fedK0A-x-WILOn1T_I3yTQqpFQQ' \
--data-raw '{
    "email": "ptest@gmail.org",
    "password": "Testing123!"
}'
```

** Para realizar activaciones o desactivaciones de usuario solo basta enviar el token de autorización y las credenciales de acceso en los endpoint privados:
user/deactivate|activate/{userId} --> el userId es un UUID que se puede obtener al registrar un usuario o al hacer un get a todos los usuarios /user/all

** Considera que estamos utilizando metodos POST para activar y desactivar
Este endpoint cambiara el estado de ese usuario y a su vez actualizara la fecha de modificación.

```bash
curl --location 'http://localhost:8080/user/deactivate/7e3faaab-3a0d-476b-b7dd-e9d3ef7aad1f' \
--header 'Content-Type: text/plain' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtbGF6Y2Fub0BnbWFpbC5vcmciLCJpYXQiOjE3MDE0MTE3MjIsImV4cCI6MTcwMTQ5ODEyMn0.7xKjUUmmlp9pBSKpzgOcfvKURzjoLeuWuWdNf9yAihk' \
--data-raw '{
    "email": "ptest@gmail.org",
    "password": "Testing123!"
}'
```

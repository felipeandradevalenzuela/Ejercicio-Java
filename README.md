# Ejercicio-Java

## Problema

Debemos crear endpoints donde los usuarios puedan ser activados o desactivados, estos tambien pueden registrarse y acceder.

## Solución propuesta
Utilizaremos JWT para aplicar una capa de seguridad a los endpoints privados que realizaran modificaciones utilizando distintas dependencias que nos ayudaran en el flujo que se muestra a continuación:
![diagramaF](https://github.com/felipeandradevalenzuela/Ejercicio-Java/assets/84478274/92144255-d57a-430c-a847-23b38c03493c)

## Instalación


Sigue estos pasos para instalar y ejecutar el proyecto:

1. Clona el repositorio: git clone [https://github.com/felipeandradevalenzuela/Ejercicio-Java.git](https://github.com/felipeandradevalenzuela/Ejercicio-Java.git)
2. Navega al directorio del proyecto: cd spring-boot-jwt-authenticadion
3. Construye el proyecto usando Maven: mvn clean install
4. Ejecuta el proyecto: mvn spring-boot:run
5. Prueba la API Rest utilizando Postman u otra aplicación en http://localhost:8080.
6. Para acceder a la consola de H2 basta con ingresar a [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   - Asignar el datasource: jdbc:h2:mem:testdb
   - Ingresar con el usuario: sa
   - No requiere contraseña

## Pruebas
Esto te llevará a la página de inicio de la aplicación, donde podrás comenzar a utilizarla.

Para revisar los endpoint y schemas mediante Swagger puedes visitar:

[http://localhost:8080/doc/swagger-ui/index.html](http://localhost:8080/doc/swagger-ui/index.html)

Para la creación de usuarios puedes hacer un Post directamente a:
- [http://localhost:8080/auth/register](http://localhost:8080/auth/register)

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
- [http://localhost:8080/auth/login](http://localhost:8080/auth/login)

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
Debe guardar el Token entregado en la respuesta de la creación o Login respectivamente y hacer un request de este estilo:

*** es importante modificar el token de autorización, o no podras acceder a endpoints privados

Recuerda que los endpoint para ver usuarios son:
- [http://localhost:8080/user/all](http://localhost:8080/user/all)
- [http://localhost:8080/user/{userId}](http://localhost:8080/user/{userId})


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
- [http://localhost:8080/user/deactivate/a1ecb49e-2364-47a2-ac00-c021085a1ad9](http://localhost:8080/user/deactivate/a1ecb49e-2364-47a2-ac00-c021085a1ad9) 
- [http://localhost:8080/user/activate/a1ecb49e-2364-47a2-ac00-c021085a1ad9](http://localhost:8080/user/activate/a1ecb49e-2364-47a2-ac00-c021085a1ad9)
- el userId es un UUID que se puede obtener al registrar un usuario o al hacer un get a todos los usuarios /user/all

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

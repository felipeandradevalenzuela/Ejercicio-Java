# Ejercicio-Java
Descripción concisa de lo que hace tu proyecto.

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

Asegúrate de que las configuraciones necesarias estén completas, como las credenciales de acceso a la base de datos o las variables de entorno. Puedes encontrar más detalles en la sección de Configuración.

### Configuración

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

Recuerda que el endpoint para ver usuarios es
[http://localhost:8080/user/all](http://localhost:8080/user/all)
[http://localhost:8080/user/{userId}](http://localhost:8080/user/{userId})

Para la creación de usuarios puedes hacer un Post directamente a:
[http://localhost:8080/user/add](http://localhost:8080/user/add)

Aquí adjunto un curl para que cargues usuarios.
```bash
curl --location 'http://localhost:8080/user/add' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "Juan Rodriguez",
"email": "asd@rodriguez.org",
"password": ".22",
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

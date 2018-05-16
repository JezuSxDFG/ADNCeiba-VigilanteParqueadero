# ADNCeiba-VigilanteParqueadero
[![N|Ceiba](https://www.ceiba.com.co/wp-content/uploads/2015/09/logo-ceiba.png)](https://www.ceiba.com.co/es/)

Consiste en un sistema que simula el comportamiento del vigilante de un parqueadero.

  - El parqueadero ecibe carros y motos
  - Parqueadero con limite
  - El parqueadero funciona 24 horas, los 7 días de la semana

### Tech
> La aplicación está construida para la web
> La interfaz gráfica web es responsive
> Los servicios REST aceptan muchas peticiones concurrentes por minuto


### Tarifas
La tabla de precios es la siguiente:
| CONCEPTO | VALOR |
| ------ | ------ |
| Carro x hora | 1000 |
| Moto x hora | 500 |
| Carro x día | 8000 |
| Moto x día | 8000 |

### Instalación

Parqueadero require [Java](https://www.java.com/es/download/) v8+ to run.

Instalar las dependencias y devDependencias e inicie el servidor.

```sh
$ cd VigilanteParqueadero
$ npm install -d
$ java -jar app
```

### Docker
Parqueadero es muy fácil de instalar y desplegar en un Docker container.

De forma predeterminada, Docker expondrá el puerto 8080, por lo tanto, cámbielo en Dockerfile si es necesario. Cuando esté listo, simplemente use Dockerfile para construir la imagen.

```sh
cd parqueadero
docker build -t JezuSxDFG/parqueadero:${package.json.version}
```
Esto creará la imagen de dillinger y atraerá las dependencias necesarias. Asegúrese de cambiar `$ {package.json.version}` con la versión real de Parqueadero. 

Una vez hecho esto, ejecute la imagen Docker y asigne el puerto a lo que desee en su host. En este ejemplo, simplemente asignamos el puerto 8000 del host al puerto 8080 del Docker (o el puerto que quedó expuesto en el Dockerfile):

```sh
docker run -d -p 8000:8080 --restart="always" <youruser>/parqueadero:${package.json.version}
```

Verifique la implementación navegando a la dirección de su servidor en su navegador preferido.

```sh
127.0.0.1:8000
```

### Todos

 - Escribir MÁS Tests
 - Añadir más funcionalidades

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)
 
   [Java]: <https://www.java.com/es/download/>
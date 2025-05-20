# **RETO: GESTIÓN DE RUTAS EN ACTIVIDADES AL AIRE LIBRE**

## Índice de contenido

- [**RETO: GESTIÓN DE RUTAS EN ACTIVIDADES AL AIRE LIBRE**](#reto-gestión-de-rutas-en-actividades-al-aire-libre)
  - [Índice de contenido](#índice-de-contenido)
  - [Introducción](#introducción)
  - [Miembros de RDosM2](#miembros-de-rdosm2)
  - [Implementación y despliegue](#implementación-y-despliegue)
  - [Sobre la web](#sobre-la-web)
  - [Sobre la base de datos](#sobre-la-base-de-datos)
  - [Sobre Java](#sobre-java)
  - [IPE](#ipe)

## Introducción

Documentación del desarrollo de la aplicación de escritorio destinada a la gestión de rutas en actividades al aire libre. Este espacio contendrá los miembros que han participado en el proceso, el desarrollo de la aplicación y su web complementaria, además de los manuales destinados a su compresión y uso.

## Miembros de RDosM2

- Miguel Ángel Quian Díaz
- Maya García Velasco
- Daniel Cabeza Berrazueta
- Raúl Buenaga García
   
## Implementación y despliegue

[Guía de despliegue 📑](/Manuales/MANUAL%20DESPLIEGUE.pdf) | [Manual de usuario 📑](/Manuales/MANUAL%20USUARIO.pdf)

Dentro de las tecnologías existentes, a la hora de desplegar este proyecto nos debatimos principalmente entre las siguientes: VirtualBox, VMware, AWS. Hemos elaborado una tabla comparativa sobre ellas para justificar nuestra elección. 

| | VIrtualBox  | VMware | AWS |
|---|---|---|---|
|**Licencia** |Código abierto | Código cerrado/ propietario|Código cerrado/ propietario|
|**Plataforma** | Local |Local o servidores |  En la nube | 
|**Precio**| Gratuito | Gratuito o de pago según licencia | Pago por consumo | 
|**Virtualización** | Local | Local o centro de datos | En la nube |
|**Escalabilidad** | Limitado por hardware | Limitado (local) escalable (VMware vSphere) | Escalable |
|**Casos de uso** | Pruebas, aprendizaje | Entornos corporativos | Producción |

Después de valorar estos aspectos decidimos decantarnos por VirtualBox. Las razones son principalmente la familiaridad del equipo con la herramienta, su gratuidad, y su flexibilidad.

Para el servidor web investigamos NGINX para explorar otras tecnologías no vistas en clase, y la comparamos con Apache que es el servidor con el que más experiencia contábamos.

| | NGINX | Apache |
|---|---|---|
|**Licencia**|2-Clause BSD | Apache License 2.0|
|**Arquitectura**| asíncrono | multihilo|
|**sistema operativo**|multiplataforma| multiplataforma |
|**Renimiento**| alto, incluso con mucha afluencia| bueno, pero menos eficiente con gran afluencia |
|**consumo**| bajo | alto |
|**soporte de .htaccess** | no | sí |
|**soporte PHP**| por FastCGI | por mod_php |

Como se ve en la tabla NGINX es una opción muy llamativa, pero con las dificultades que afrontamos en su uso y la falta de tiempo finalmente decidimos seguir adelante con Apache.


## Sobre la web

[Servidor web 🗄️](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/ServidorWeb-Equipo1-VF.ova?csf=1&web=1&e=YyC8dQ)



Para la web hemos optado por un diseño sencillo y compacto, facilitando su uso para todo el mundo. Para el estilo nos inclinamos por un tema principalmente verde para acompañar la intención de disfrutar de la naturaleza que tienen los visitantes de la página.  

![web1](/imagenes/web1.PNG)


 Esta primera imagen muestra la pestaña que se abre por defecto al acceder a la página web, muestra las rutas disponibles y puede seleccionarse una para desplegar una nueva pestaña con los detalles de dicha ruta.


![web4](/imagenes/web4.PNG)

Esta imagen muestra los detalles de las rutas mostradas en el apartado anterior. Como podemos ver, se tiene acceso a un gran abanico deelementos de las rutas que incluyen apartados como las fotos, valoraciones, y puntos de interés. 

![web2](/imagenes/web2.PNG)

En este apartado se recoge la información esencial sobre la web, su finalidad y planes a futuro.

![web3](/imagenes/web3.PNG)

Por último, existe una pestaña dedicada para conocer al equipo y porqué se creó esta web. 


[XSLT](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/gpxToHtml?csf=1&web=1&e=D1xcbi)
Toma un archivo gpx para formatearlo con la información de la ruta y lo introduce en la web para ver los datos de interés.


## Sobre la base de datos

<!--Para enlazar imagenes, añade una ! a un enlace normal-->
![Relacional](/imagenes/EER_EQUIPO1_V10.png)



  [Servidor de base de datos 🗄️](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/bd_ubuntu.ova?csf=1&web=1&e=YZO6Oc) |
  [Script (SQL)](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/BD/GeneracionBD_Equipo1.sql?csf=1&web=1&e=hKzkjL) | [Esquema relacional 📑](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/BD/EER_EQUIPO1_V10.pdf?csf=1&web=1&e=KapWHP) | [Script ejemplos](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/BD/DatosEjemploBD_Equipo1.sql?csf=1&web=1&e=DBjGqU) | [Script de TRIGGERS](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/BD/Script%20disparadores-Equipo1.sql?csf=1&web=1&e=PxRWOw)

La base de datos ha sido diseñada para acompañar a las diferentes funciones de la aplicación, entre las que se encuentran la creación y modificación de rutas, su valoración y la gestión de roles de los usuarios y sus permisos, entre otras. 

| ENTIDADES PRINCIPALES|CONTENIDO|
|---|---|
|Usuarios| rol del usuario, credenciales, datos personales
|Rutas| coordenadas, recomendaciones, duración
Valoraciones Técnicas| dificultad, belleza, interés cultural


Las relaciones más importantes se establecen entre usuarios y rutas, pudiendo un usuario crear una o más rutas, rutas con puntos de peligro e interés, pudieno contener uno o varios, y rutas con valoración técnica pudiendo valorar una ruta tan solo una vez por usuario.

## Sobre Java

<!-- FOTOS  -->
  ![Diagrama](imagenes/Diagrama_clases_por_fin.png)

  El diagrama representa nuestro sistema para la gestión  y evaluación de rutas. La clase central es la de Ruta, que se relaciona con todas las demás y cuenta con los datos esenciales de las mismas como atributos. Las rutas pueden ser valoradas mediante ValoracionTecnica (por diseñadores, profesores) o Reseña (por todos los usuarios), ambas heredando de la clase abstracta Valoracion. Los usuarios siguen la siguiente jerarquía: invitado, alumno, profesor, diseñador de ruta, administrador, cada uno con métodos propios que se corresponden con sus permisos. Otra clase esencial a la que se relaciona Rutas es Waypoint, que puede representar los puntos de interés o de peligro. Por último, otra función clave es la de descargar fichas informativas, que se dividen en Ficha de Seguridad, Ficha de Usuario, y Ficha de Organización que cuelgan de una clase abstracta común llamada Ficha Informativa.


A continuación ofrecemos una imagen del diagrama de casos de uso, con un vínculo a su descripción.

  ![Casos de uso](imagenes/casos_uso.png)


[Casos de uso 📷](https://educantabria.sharepoint.com/:i:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/casos_uso.drawio.png?csf=1&web=1&e=hHwa4F) |
[Descripción de casos de uso 📑](https://educantabria.sharepoint.com/:w:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/descripci%C3%B3n%20de%20casos%20de%20uso.docx?d=w5e06507a021a45c7ab6b5103337c9e46&csf=1&web=1&e=00XqIP)




[XSLT ](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/gpxToCSV?csf=1&web=1&e=XLbvS2) que recoge un archivo GPX genera un archivo CSV para usarlo en la generación de rutas mediante ficheros.
## IPE

[Infografia de SS 📑](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/Infografia%20SS.pdf?csf=1&web=1&e=En4MY3) | 
[Factores de Riesgo 📑](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/IDENTIFICACION_DE_RIESGOS_EQUIPO1.pdf?csf=1&web=1&e=Mhk5Ep) |
[Matriz de Riesgo 📑](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/Matriz%20de%20riesgo.pdf?csf=1&web=1&e=s3ks61) |
[Plan de emergencias 📑](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/Plan%20de%20emergencias.pdf?csf=1&web=1&e=8r9907) |
[Tarea 📑](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/Tarea_IT_Equipo1.pdf?csf=1&web=1&e=qgO1M3)

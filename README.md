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

[Guía de despliegue 📑](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/MANUAL%20DESPLIEGUE.pdf?csf=1&web=1&e=sVfAos) | [Manual de usuario 📑](https://educantabria.sharepoint.com/:w:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/MANUAL%20USUARIO.docx?d=w06038e8d45524639a670f50dc6b88509&csf=1&web=1&e=OlXqLQ)

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

## Sobre la web

[XSLT](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/gpxToHtml?csf=1&web=1&e=D1xcbi)
Toma un archivo gpx para formatearlo con la información de la ruta y lo introduce en la web para ver los datos de interés.


Para la web hemos optado por un diseño sencillo y compacto, facilitando su uso para todo el mundo. Para el estilo nos inclinamos por un tema principalmente verde para acompañar la intención de disfrutar de la naturaleza que tienen los visitantes de la página.  

![web1](/imagenes/web1.png)


 Esta primera imagen muestra la pestaña que se abre por defecto al acceder a la página web, muestra las rutas disponibles y puede seleccionarse una para desplegar una nueva pestaña con los detalles de dicha ruta.


![web4](/imagenes/web4.png)

Esta imagen muestra los detalles de las rutas mostradas en el apartado anterior. Como podemos ver, se tiene acceso a un gran abanico deelementos de las rutas que incluyen apartados como las fotos, valoraciones, y puntos de interés. 

![web2](/imagenes/web2.png)

En este apartado se recoge la información esencial sobre la web, su finalidad y planes a futuro.

![web3](/imagenes/web3.png)

Por último, existe una pestaña dedicada para conocer al equipo y porqué se creó esta web. 




## Sobre la base de datos
<!--Para enlazar imagenes, añade una ! a un enlace normal-->
  ![Relacional](/imagenes/EER_EQUIPO1_V9.png)
  [Script (SQL)](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/BD/GeneracionBD_Equipo1.sql?csf=1&web=1&e=hKzkjL) | [Relacional 📑](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/BD/EER_EQUIPO1_V9.pdf?csf=1&web=1&e=KapWHP) | [Script ejemplos](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/BD/DatosEjemploBD_Equipo1.sql?csf=1&web=1&e=DBjGqU) | [Script de TRIGGERS](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/BD/Script%20disparadores-Equipo1.sql?csf=1&web=1&e=PxRWOw)

La base de datos ha sido diseñada para acompañar a las diferentes funciones de la aplicación, entre las que se encuentran la creación y modificación de rutas, su valoración y la gestión de roles de los usuarios y sus permisos, entre otras. 

| ENTIDADES PRINCIPALES|CONTENIDO|
|---|---|
|Usuarios| rol del usuario, credenciales, datos personales
|Rutas| coordenadas, recomendaciones, duración
Valoraciones Técnicas| dificultad, belleza, interés cultural


Las relaciones más importantes se establecen entre usuarios y rutas, pudiendo un usuario crear una o más rutas, rutas con puntos de peligro e interés, pudieno contener uno o varios, y rutas con valoración técnica pudiendo valorar una ruta tan solo una vez por usuario.

  ## Sobre Java

<!-- FOTOS  -->
  ![Diagrama](imagenes/Diagrama_clases_ultimo.png)

  El diagrama representa nuestro sistema para tratar la información relacionada a la gestión de rutas al aire y los usuarios resgistrados. 

  ![Casos de uso](imagenes/casos_uso.png)


[Casos de uso 📷](https://educantabria.sharepoint.com/:i:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/casos_uso.drawio.png?csf=1&web=1&e=hHwa4F) |
[Descripción de casos de uso 📑](https://educantabria.sharepoint.com/:w:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/descripci%C3%B3n%20de%20casos%20de%20uso.docx?d=w5e06507a021a45c7ab6b5103337c9e46&csf=1&web=1&e=00XqIP)




[XSLT ](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/gpxToCSV?csf=1&web=1&e=XLbvS2) XSLT que recoge un archivo GPX genera un archivo CSV para usarlo en la generación de rutas mediante ficheros.
## IPE

[Infografia de SS 📑](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/Infografia%20SS.pdf?csf=1&web=1&e=En4MY3) | 
[Factores de Riesgo 📑](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/IDENTIFICACION_DE_RIESGOS_EQUIPO1.pdf?csf=1&web=1&e=Mhk5Ep) |
[Matriz de Riesgo 📑](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/Matriz%20de%20riesgo.pdf?csf=1&web=1&e=s3ks61) |
[Plan de emergencias 📑](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/Plan%20de%20emergencias.pdf?csf=1&web=1&e=8r9907) |
[Tarea 📑](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/Tarea_IT_Equipo1.pdf?csf=1&web=1&e=qgO1M3)





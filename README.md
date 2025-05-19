# **RETO: GESTIÓN DE RUTAS EN ACTIVIDADES AL AIRE LIBRE**

## Índice de contenido

- [**RETO: GESTIÓN DE RUTAS EN ACTIVIDADES AL AIRE LIBRE**](#reto-gestión-de-rutas-en-actividades-al-aire-libre)
  - [Índice de contenido](#índice-de-contenido)
  - [Implementación y despliegue](#implementación-y-despliegue)
  - [Sobre la web](#sobre-la-web)
  - [Sobre la base de datos](#sobre-la-base-de-datos)
  - [Sobre Java](#sobre-java)
  - [IPE](#ipe)

<!-- Documentación del desarrollo de la aplicación de escritorio destinada a la gestión de rutas en actividades al aire libre. Este espacio contendrá los miembros que han participado en el proceso, el desarrollo de la aplicación y su web complementaria, además de los manuales destinados a su compresión y uso.


## Miembros de RDosM2

- Miguel Ángel Quian Díaz
- Maya García Velasco
- Daniel Cabeza Berrazueta
- Raúl Buenaga García


<!--Para enlazar correctamente, crear un header con #/##/### y vincular -> [texto](#nombreDelHeader)-->
<!-- - [RETO: GESTIÓN DE RUTAS EN ACTIVIDADES AL AIRE LIBRE](#reto-gestión-de-rutas-en-actividades-al-aire-libre)
  - [Indice de contenido](#indice-de-contenido)
  - [Miembros de **RDosM2**](#miembros-de-rdosm2)
  - [Indice de contenido](#indice-de-contenido-1)
  - [Implementación y despliegue](#implementación-y-despliegue)
  - [Sobre la base de datos](#sobre-la-base-de-datos)
  - [Diagrama clases](#diagrama-clases)
  - [Diagrama de casos de uso](#diagrama-de-casos-de-uso)
  - [Manual de usuario](#manual-de-usuario)
  - [Informes de la aplicación](#informes-de-la-aplicación)
  - [Base de datos](#base-de-datos)
  - [Script disparadores](#script-disparadores)
  - [Página web y estilos](#página-web-y-estilos)
  - [XSLT](#xslt)
  - [Infografía sobre Seguridad Social](#infografía-sobre-seguridad-social)
  - [Factores de riesgo](#factores-de-riesgo)
  - [Matriz de riesgo](#matriz-de-riesgo)
  - [Plan de emergencias](#plan-de-emergencias)
  - [Tarea IT](#tarea-it) -->

   
## Implementación y despliegue

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



[Guía de despliegue (PDF)](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/MANUAL%20DE%20DESPLIEGUE%20DAM1.pdf?csf=1&web=1&e=lJPKIP) | [Manual de usuario (PDF)](https://educantabria.sharepoint.com/:w:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/MANUAL%20USUARIO.docx?d=w06038e8d45524639a670f50dc6b88509&csf=1&web=1&e=OlXqLQ)

## Sobre la web


[XSLT](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/gpxToCSV?csf=1&web=1&e=XLbvS2)

## Sobre la base de datos
<!--Para enlazar imagenes, añade una ! a un enlace normal-->
  ![Relacional](/imagenes/EER_EQUIPO1_V9.png)
  [Script (SQL)](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/BD/GeneracionBD_Equipo1.sql?csf=1&web=1&e=hKzkjL) | [Relacional formato PDF](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/BD/EER_EQUIPO1_V9.pdf?csf=1&web=1&e=KapWHP) | [Script ejemplos](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/BD/DatosEjemploBD_Equipo1.sql?csf=1&web=1&e=DBjGqU) | [Script de TRIGGERS](https://educantabria.sharepoint.com/:u:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/BD/Script%20disparadores-Equipo1.sql?csf=1&web=1&e=PxRWOw)

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


[Casos de uso](https://educantabria.sharepoint.com/:i:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/casos_uso.drawio.png?csf=1&web=1&e=hHwa4F) |
[Descripción de casos de uso](https://educantabria.sharepoint.com/:w:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/descripci%C3%B3n%20de%20casos%20de%20uso.docx?d=w5e06507a021a45c7ab6b5103337c9e46&csf=1&web=1&e=00XqIP)


## IPE

[Infografia de SS en PDF](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/Infografia%20SS.pdf?csf=1&web=1&e=En4MY3) | 
[Factores de Riesgo PDF](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/IDENTIFICACION_DE_RIESGOS_EQUIPO1.pdf?csf=1&web=1&e=Mhk5Ep) |
[Matriz de Riesgo en PDF](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/Matriz%20de%20riesgo.pdf?csf=1&web=1&e=s3ks61) |
[Plan de emergencias en PDF](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/Plan%20de%20emergencias.pdf?csf=1&web=1&e=8r9907) |
[Tarea](https://educantabria.sharepoint.com/:b:/r/sites/RETODAM1DAM12025-39009471-DAM1-EQUIPO1/Documentos%20compartidos/DAM1-EQUIPO1/ARCHIVOS%20RETO/Tarea_IT_Equipo1.pdf?csf=1&web=1&e=qgO1M3)





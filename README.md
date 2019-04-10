# Proyecto Compressor
---
  Este sistema permite comprimir una cadena de caracteres de letras, en una forma short de visualización. 

### Ejemplo
---
La comprensión debe hacerse de modo que:

"AAABBAAAAABBBCCCCCCCCAAAAA" = "3A2B5A3B8C5A"
  
### Algoritmo
---
Se aplica recursividad para la solución del problema.
No se distingue mayúscula de minusculas.

### Implementación 
---
Definición de los servicios 
    
    https://compressor-237218.appspot.com/swagger-ui.html

**Respuestas a las indicaciones**:

**1 - Nombre del candidato**

_Request_
    
    curl -X GET --header 'Accept: application/json' 'https://compressor-237218.appspot.com/candidate'

_Response_

    {"name": "Gomez Andres Emilio"}
   
**2 - Compresor**
  
**Periodos de lluvia:**

_Request_
    
    curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \"value": "AAABBAAAAABBBCCCCCCCCAAAAA" \}' 'https://compressor-237218.appspot.com/compress'

_Response_

    {"cantidad": 814}
**Día con pico máximo de lluvia:**

_Request_

    curl -X GET --header 'Accept: application/json' 'https://solarium-222019.appspot.com/lluvia/maximaintensidad'

_Response_

    {"compressed": "3A2B5A3B8C5A}
	
**3 -Echo**

_Request_

    curl -X GET --header 'Accept: application/json' 'https://compressor-237218.appspot.com/echo'

### Construido con 

* [Java 8](https://www.java.com/es/)
* [Eclipse](https://www.eclipse.org/) 
* [Maven](https://maven.apache.org/) 
* [Spring boot](http://spring.io/projects/spring-boot)
* [Swagger](https://swagger.io/)
* [Google Cloud Platform - Eclipse Plugin](https://cloud.google.com/eclipse/docs/)
* [App Engine SDK for Java](https://cloud.google.com/appengine/docs/standard/java/download)


## Autor

* **Andres Emilio Gomez** - *andres.e.gomez@gmail.com* - 





---

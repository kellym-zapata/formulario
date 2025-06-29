Formulario de Registro de Cliente

Este proyecto es una aplicación web desarrollada en Java utilizando servlets y JSP, destinada a gestionar el registro de clientes. 
Fue construida con Apache Tomcat, NetBeans como entorno de desarrollo, y conexión a base de datos mediante MySQL Connector/J.

Estructura del Proyecto

- `src/`: Código fuente Java (servlets y clases de modelo).
- `web/`: Archivos JSP, HTML y recursos web.
- `build.xml`: Script de compilación Apache Ant.
- `nbproject/`: Archivos de configuración del proyecto NetBeans.

Funcionalidades

- Formulario HTML para el ingreso de datos personales de un cliente.
- Procesamiento de formularios vía `POST`  con servlets.
- Validación de datos y conexión con base de datos.
- Interfaz estructurada con JSP para feedback y confirmaciones.

Tecnologías Utilizadas

- Java EE (Servlets + JSP)
- Apache Tomcat
- NetBeans IDE
- MySQL y MySQL Connector/J
- HTML5 y CSS3

Requisitos

- Java JDK 8 o superior
- Apache Tomcat 9+
- NetBeans (recomendado)
- MySQL Server

Instalación y Ejecución

1. Clona este repositorio:

   ```bash
   git clone https://github.com/tu-usuario/Formulario.git

2. Abre el proyecto con NetBeans.

3. Configura la conexión a la base de datos en la clase modelo.Conexion.java.

4. Asegúrate de que el driver mysql-connector-j esté correctamente agregado al proyecto (WEB-INF/lib).

5. Ejecuta el proyecto desde NetBeans con Tomcat.

Puntos de Entrada
index.html: Página de inicio o presentación del formulario.

registroCliente.jsp: Interfaz para el registro.

FormularioClienteServlet.java y RecibeDatosServlet.java: Controladores que procesan los formularios.

Autor
Desarrollado por Kelly M Zapata C.
Proyecto académico con fines de aprendizaje.

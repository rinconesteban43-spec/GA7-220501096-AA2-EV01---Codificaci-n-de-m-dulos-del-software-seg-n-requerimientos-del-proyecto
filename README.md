Este proyecto Java demuestra las operaciones de persistencia de datos (CRUD: Crear, Leer, Actualizar, Eliminar) en una tabla de clientes. Utiliza el conector **JDBC** para establecer la conexión directa con una base de datos MySQL, siguiendo un diseño modular para separar las responsabilidades del código.

Estructura del Proyecto

El proyecto está organizado en paquetes lógicos para mantener el código limpio y fácil de mantener:

-   `src/main/java/`
    -   `conexion/`: Contiene la clase `ConexionBD.java`, responsable de establecer y gestionar la conexión con la base de datos MySQL utilizando el driver JDBC.
    -   `modelo/`: Aloja la clase de entidad `Cliente.java`, que representa la estructura de la tabla `cliente` en la base de datos.
    -   `dao/`: Contiene la clase `ClienteDAO.java`, que implementa la capa de acceso a datos (DAO - Data Access Object). Aquí se encuentran los métodos para realizar las operaciones CRUD.
    -   `main/`: Incluye la clase `Main.java`, que sirve como punto de entrada para probar la funcionalidad CRUD, instanciando los métodos de `ClienteDAO`.

Requisitos del Sistema

-   **Java Development Kit (JDK) 8 o superior**: Necesario para compilar y ejecutar la aplicación.
-   **Servidor de Base de Datos MySQL**: El proyecto está configurado para conectarse a una base de datos MySQL local.

Configuración de la Base de Datos

Antes de ejecutar el proyecto, debes configurar la base de datos para que coincida con la estructura del proyecto.

1.  Abre tu cliente de MySQL (por ejemplo, MySQL Workbench o la terminal).
2.  Crea una base de datos con el nombre que se especifique en tu clase `ConexionBD`.
3.  Crea la tabla `cliente` con las siguientes columnas:
    -   `id_usuario` (INT, PRIMARY KEY, AUTO_INCREMENT)
    -   `nombre` (VARCHAR(45))
    -   `apellido` (VARCHAR(45))
    -   `email` (VARCHAR(45))
    -   `telefono` (VARCHAR(45))
    -   `direccion` (VARCHAR(100))
    -   `contrasena` (VARCHAR(225))

Uso y Ejecución

1.  Abre el proyecto en tu IDE (NetBeans, Eclipse, etc.).
2.  Verifica y ajusta los detalles de conexión en la clase `ConexionBD.java` (URL, usuario y contraseña de tu base de datos).
3.  Ejecuta la clase `Main.java` para ver las operaciones CRUD en acción.

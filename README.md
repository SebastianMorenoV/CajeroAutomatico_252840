# 🏦 Arquitectura de Software - Simulador de Cajero Automático (ATM)

Este proyecto implementa el caso de uso de un retiro en un cajero automático (ATM), centrándose en una arquitectura de software MVC limpia, desacoplada y bien definida mediante el uso de patrones de diseño como Observador y Fachada.

Release: 08/10/2025
---

## 🛠️ Tecnologías Utilizadas

* **Java**: Lenguaje de programación principal.
* **Java Swing**: Utilizada para la interfaz gráfica de usuario (GUI).
* **Maven / Gradle**: Para la gestión de dependencias y la construcción del proyecto (sugerido).

---

## 🚀 Cómo Empezar

### 📋 Prerrequisitos

Asegúrate de tener instalado el JDK (Java Development Kit) versión 8 o superior en tu máquina.

### ⚙️ Instalación

1.  **Clonar el repositorio**:
    ```bash
    git clone URL_DEL_REPOSITORIO_AQUI
    ```
2.  **Navegar al directorio del proyecto**:
    ```bash
    cd nombre-del-directorio
    ```
3.  **Hacer clean y build**:
    > [!NOTE]
    > Es crucial realizar un `clean and build with dependencies` en tu IDE (NetBeans, IntelliJ) para asegurar que todas las partes del proyecto se compilen correctamente.

### ▶️ Ejecutar el Programa

> [!TIP]
> Para iniciar la simulación, ejecuta la clase `Main` (o la clase de arranque principal del proyecto).

1.  **Ejecutar la clase principal**:
    Después de compilar el proyecto, localiza y ejecuta la clase que inicializa la vista principal.

## 🏗️ Arquitectura del Software

El proyecto sigue un diseño modular para separar la lógica de negocio de la interfaz de usuario. Las clases de dominio principales incluyen:

* **`Cliente`**: Representa al usuario del banco con sus datos personales.
* **`Cuenta`**: Gestiona la información de la cuenta bancaria, incluyendo el saldo disponible.
* **`Transaccion`**: Almacena los detalles de una operación de retiro, como monto, comisión, estado y fecha.
* **`Cajero`**: Representa la entidad del cajero automático, que contiene el dinero disponible (en esta simulación).


## Arquitectura MVC y Patrones de Diseño:
* **`Vista`**: Responsable de toda la lógica de presentación. Dibuja la interfaz gráfica (`VistaMenuPrincipal`, `PantallaRetiro`) y se actualiza a sí misma cuando recibe notificaciones del modelo. (Implementa el patrón **Observador**).
* **`Controlador`**: Atiende las interacciones del usuario en la Vista (clics de botón) y las dirige como llamadas hacia el Modelo. Actúa como un puente simple.
* **`Modelo`**: Contiene la lógica principal de la aplicación. Orquesta las llamadas a la capa de negocio (`Fachada`) y gestiona el estado. Notifica a la Vista sobre cualquier cambio de estado, pasándose a sí mismo para que la Vista pueda consultar los datos actualizados a través de DTOs.
* **`Fachada`**: Proporciona una interfaz simplificada a la lógica de negocio. `CajeroFachada` encapsula las reglas para calcular y finalizar retiros, ocultando la complejidad al resto de la aplicación.

---

## 👨‍💻 Autor
-Erick Sebastian Moreno Vargas 252840

# IMC-Calculadora
# Refactorizando a MVC – La Calculadora de IMC

## Objetivo de la Práctica
Diseñar e implementar una aplicación de escritorio en Java utilizando el IDE NetBeans y Swing/Matisse, adhiriéndose estrictamente al patrón de diseño **MVC (Modelo-Vista-Controlador)**.

---

## El Problema: Calculadora de IMC
Vamos a construir una herramienta simple pero completa: una calculadora del Índice de Masa Corporal (IMC).

### Requisitos Funcionales
La aplicación debe permitir al usuario:
* **Introducir su peso** en kilogramos (ej. `75.5`).
* **Introducir su altura** en metros (ej. `1.78`).
* **Pulsar un botón** ("Calcular") para iniciar el proceso.
* **Ver dos resultados**:
  * El valor numérico del IMC (ej. *"Tu IMC es: 23.85"*).
  * La clasificación de la OMS correspondiente a ese IMC (ej. *"Clasificación: Peso Normal"*).

La aplicación debe **gestionar entradas incorrectas** (ej. si el usuario escribe *"abc"* en el peso). En ese caso, debe mostrar un mensaje de error claro en la interfaz (ej. *"Error: Introduce solo números válidos"*).

---

## Guía de Desarrollo (La Estructura MVC)
Es obligatorio seguir estrictamente esta estructura de paquetes y responsabilidades dentro de vuestro proyecto en NetBeans.

### 1. Configuración del Proyecto
Crear los siguientes paquetes:
* `com.tuproyecto.imc.model`
* `com.tuproyecto.imc.controller`
* `com.tuproyecto.imc.view`
* `com.tuproyecto.imc.main`

### 2. El Modelo (El Cerebro)
* **Paquete:** `com.tuproyecto.imc.model`
* **Regla de oro:** Aquí irá toda la lógica de negocio pura. Es fundamental que ninguna clase en este paquete importe `javax.swing.*`. El modelo no sabe que existe una interfaz gráfica.

#### Clase `CalculadoraIMC.java`
* Crea un método público: `public double calcular(double peso, double altura)`
  * **Fórmula:** `imc = peso / (altura * altura)`
* Crea un segundo método: `public String clasificar(double imc)`
  * Este método debe devolver un `String` basado en el IMC recibido, según estas reglas de la OMS:
    * **< 18.5:** *"Bajo Peso"*
    * **18.5 – 24.9:** *"Peso Normal"*
    * **25.0 – 29.9:** *"Sobrepeso"*
    * **≥ 30.0:** *"Obesidad"*

### 3. La Vista (La Cara)
* **Paquete:** `com.tuproyecto.imc.view`
* Diseña la interfaz utilizando **Swing/Matisse** (el diseñador visual de NetBeans). No debe haber código manual de creación de componentes en Java.

Añade los componentes necesarios asignándoles nombres de variable claros:
* Dos `JTextField` (`txtPeso`, `txtAltura`)
* Un `JButton` (`btnCalcular`)
* Dos `JLabel` (`lblResultado`, `lblClasificacion`)

### 4. El Controlador (El Intermediario)
* **Paquete:** `com.tuproyecto.imc.controller`
* Esta clase es el pegamento. Conecta la Vista con el Modelo.

#### Clase `IMCController.java`
* Declara las variables miembro para los componentes de la Vista.
* Instancia el modelo de forma privada: `private final CalculadoraIMC calculadora = new CalculadoraIMC();`
* Implementa el método que enlaza al botón "Calcular" siguiendo este flujo:
  1. **Recoger** los `String` de `txtPeso` y `txtAltura`.
  2. **Validar la entrada:** Utilizar un bloque `try-catch` (`NumberFormatException`).
     * **Si ocurre una excepción (catch):** Mostrar un mensaje de error en la interfaz (ej. `lblClasificacion.setText("Error: Datos inválidos");`) y finalizar el método con un `return;`.
     * **Si todo es correcto (try):** Parsear los textos a `double`.
  3. **Llamar al Modelo:** Calcular el valor numérico (`double imc = calculadora.calcular(peso, altura);`).
  4. **Llamar al Modelo:** Obtener la categoría (`String clasificacion = calculadora.clasificar(imc);`).
  5. **Actualizar la Vista:** Mostrar los resultados en `lblResultado` y `lblClasificacion`. *(Pista: usad `String.format("Tu IMC es: %.2f", imc)` para formatear los decimales).*

---

## Reto Adicional (Opcional)
Si terminas rápido, implementa esta mejora estética:
Haz que el `JLabel` de la clasificación cambie de color según el resultado obtenido:
* **"Peso Normal":** Verde
* **"Bajo Peso" o "Sobrepeso":** Naranja
* **"Obesidad":** Rojo

*(Pista: podéis cambiar el color del texto desde el controlador utilizando `lblClasificacion.setForeground(Color.RED);` en Swing).*

---

## Entregables
* Un **único repositorio** que contenga vuestro proyecto completo de NetBeans.
* Aseguraos de que el proyecto esté "limpio" haciendo un **"Clean and Build"** antes de comprimir o subir vuestra entrega.

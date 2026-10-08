# IMC-Calculadora

Refactorizando a MVC – La Calculadora de IMC
Objetivo de la Práctica
Diseñar e implementar una aplicación de escritorio en Java utilizando el IDE NetBeans y Swing/Matisse, adhiriéndose estrictamente al patrón de diseño MVC.
El Problema: Calculadora de IMC
Vamos a construir una herramienta simple pero completa: una calculadora del Índice de Masa Corporal (IMC).
Requisitos Funcionales
La aplicación debe permitir al usuario:
Introducir su peso en kilogramos (ej. 75,5).
Introducir su altura en metros (ej. 1,78).
Pulsar un botón ("Calcular") para iniciar el proceso.
Ver dos resultados:
El valor numérico del IMC (ej. "Tu IMC es: 23.85").
La clasificación de la OMS correspondiente a ese IMC (ej. "Clasificación: Peso Normal").
La aplicación debe gestionar entradas incorrectas (ej. si el usuario escribe "abc" en el peso). En ese caso, debe mostrar un mensaje de error claro en la interfaz (ej. "Error: Introduce solo números válidos").
Guía de Desarrollo (La Estructura MVC)
Os voy a guiar sobre cómo quiero que organicéis el proyecto en NetBeans. Es obligatorio seguir esta estructura de paquetes y responsabilidades.
1. Configuración del Proyecto
Crear los siguientes paquetes:
com.tuproyecto.imc.model.
com.tuproyecto.imc.controller.
com.tuproyecto.imc.main.
com.tuproyecto.imc.view.
2. El Modelo (El Cerebro)
Paquete: com.tuproyecto.imc.model
Aquí irá toda la lógica de negocio pura. Es fundamental que ninguna clase en este paquete importe swing.*. El modelo no sabe que existe una interfaz gráfica.
Clase CalculadoraIMC.java:
Crea un método público public double calcular(double peso, double altura).
La fórmula es: imc = peso / (altura * altura).
Crea un segundo método public String clasificar(double imc).
Este método debe devolver un String basado en el IMC recibido, según estas reglas de la OMS:
< 18.5: "Bajo Peso".
18.5 – 24.9: "Peso Normal".
25.0 – 29.9: "Sobrepeso".
≥ 30.0: "Obesidad".
3. La Vista (La Cara)
Paquete: com.tuproyecto.imc.view
Usa Swing/Matisse para diseñar la interfaz. No quiero ver código de creación de componentes en Java.
Añade los componentes necesarios:
Dos TextField (para peso y altura).
Un Button (para calcular).
Dos Label (para mostrar el resultado numérico y la clasificación).
Asigna variables claras a cada componente interactivo (ej. txtPeso, txtAltura, btnCalcular, lblResultado, lblClasificacion).
4. El Controlador (El Intermediario)
Paquete: com.tuproyecto.imc.controller
Como sabes, esta clase es el pegamento. Conecta la vista con el Modelo (la lógica).
Clase IMCController.java:
Declara las variables miembro para los componentes de la Vista.
Instancia vuestro modelo: private final CalculadoraIMC calculadora = new CalculadoraIMC();.
Implementa el método que enlazaste al botón.
Dentro de este método, el flujo debe ser:
Recoger los String de txtPeso y txtAltura.
Validar la entrada: Usar un bloque try-catch (NumberFormatException).
Si se produce la excepción (catch), debéis mostrar un mensaje de error en los Label de resultado (ej. lblClasificacion.setText("Error: Datos inválidos")) y finalizar el método con return;.
Si todo es correcto (try), parsear los textos a double.
Llamar al Modelo: double imc = calculadora.calcular(peso, altura);
Llamar al Modelo (de nuevo): String clasificacion = calculadora.clasificar(imc);
Actualizar la Vista: Mostrar los resultados en lblResultado y lblClasificacion. (Pista: usad String.format("Tu IMC es: %.2f", imc) para formatear los decimales).
Reto Adicional (Opcional)
Si terminas rápido, aquí tenéis una mejora:
Haz que el Label de la clasificación cambie de color según el resultado:
"Peso Normal": Verde
"Bajo Peso" o "Sobrepeso": Naranja
"Obesidad": Rojo
(Pista: podéis hacerlo desde el controlador con miLabel.setTextFill(Color.RED);).
Entregables
Un único repositorio que contenga vuestro proyecto completo de NetBeans.
Aseguraos de que el proyecto es "limpio" (podéis hacer un "Clean and Build" antes de comprimir).

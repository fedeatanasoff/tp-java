## Programación II - TP1 1er Cuatrimestre 2018

### Requerimientos técnicos:

Grupos de 1 o 2 personas
Se debe utilizar al menos una vez iteradores y stringbuilder (Tecnologías java).
Además de pasar el junit suministrado en el TP, la cátedra testeará los ejercicios con otro junit
adicional, por lo que se recomienda armar un junit propio para probar, antes de entregar el TP.
Se debe escribir el Irep del ej1 en el informe de no más de una página.

### Ejercicio 1. Diseño

1. Se desea modelar el juego del Jenga para dos jugadores. La dinámica del juego es la siguiente:

- Un Jenga se inicializa con n niveles {0…n-1} con n > 0 y con tres piezas por nivel.
  Los jugadores quitan piezas de manera alternada hasta que el Jenga se cae.
- El juego es automático, no se va a realizar una interfaz de usuario, se simulan las jugadas de
  cada jugador (¡esto no significa que se deba diseñar un TAD jugador solo por este
  requerimiento!)
- Cada vez que un jugador quita una pieza, esta pieza se agrega en la cima(nivel n-1) del Jenga.
  El agregado es automático, de manera que cuando se completa un nivel, el Jenga crea un nivel
  nuevo de manera transparente para el usuario.
- Solo se puede quitar una pieza de los niveles 0...n-2.
  El jenga debe mantener la altura de manera consistente y forzar el invariante del juego.
- Según la pieza que se quite existe una diferente probabilidad(%) de perder (i.e. que la torre se
  caiga). Asumiendo un porcentaje máximo de 100 para cada regla.

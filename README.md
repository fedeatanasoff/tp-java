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

### Ejemplo para un Jenga de 10 niveles

![Texto alternativo](https://github.com/fedeatanasoff/tp-java/blob/master/prob.png)

Agregar otras reglas al Irep si hace falta.

#### Modelar al TAD Jenga

Escribir el Irep
Justificar los TAD o clases soporte. Es obligatorio que al menos haya otro TAD
que no sea una clase de java, que no sea una “cascara” que tan solo enmascare
una estructura\*.

#### Implementar el TAD

Debe ser consistente con el Irep elegido
Debe respetar la interfaz propuesta por la cátedra
Debe cumplir satisfactoriamente el junit de la cátedra

\*Por ejemplo
Class Jenga
ArrayList<?> estructura
…
No se considera una solución de diseño válida, porque modelar este problema en un solo Tad.
Tiene mucho acoplamiento, como se explicó en las teóricas.

### Caso de uso de ejemplo 1 "modo automatico"

```
Jenga unJenga = new Jenga(20,”jug0”, “jug1”) // Jenga de 20 niveles 0..19

While unJenga.ganador() <>
unJenga.jugar() // juegan los dos jugadores
system.out.println(unJenga)

system.out.println(unJenga.ganador())
```

- jugar() debe mantener el Jenga consistente.
- “system.out.println(unJenga)” invoca a unJenga.toString(), que debería generar un string consistente en un “resumen” de todos los niveles.

### Caso de uso de ejemplo 2 "modo semi automatico"

```
Jenga unJenga = new Jenga(20, jugadores) // Jenga de 20 niveles 0..19
Nivel ni
While unJenga.ganador() <> “”
    //unJenga.quitar(2,0) quita la pieza 0 del nivel 2*
    ni = unJenga.primerNivelPosible()**
    if (ni ¡= null)
        unJenga.quitar( ni , unJenga.piezaRecomendada(ni))***

system.out.println(unJenga)
system.out.println(unJenga.ganador())
```

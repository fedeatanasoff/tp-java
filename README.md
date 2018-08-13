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

\*Si la pieza o el nivel no existen, debe arrojar una excepción
La interfaz mínima es la descrita en los ejemplos 1 y 2; los jUnit utilizaran dicha interfaz.
No es necesario agregar más métodos, en caso de hacerlo justificar y consultar en la clase de
consulta del TP.

\*\*¿Cuantas piezas tiene que tener un nivel para ser elegible para quitar piezas?

\*\*Notar, que internamente, luego de quitar una pieza hay que agregarla en el último nivel o
agregar un nivel nuevo. ¿Quien se debería encargar de esto?; hablar de esto en Irep

2. Acoplamiento y cohesion

En la práctica a veces se sacrifica algo del diseño por cuestiones de implementación.
Explicar, si existe en su código, un ejemplo de Acoplamiento o de de falta de Cohesión.

Va un ejemplo del código fuente de la cátedra:
“La pieza no será unTAD para nuestro código fuente.
Sera representada por un Integer por carecer de otras propiedades relevantes (además de su
ID) para el modelo del problema.
Notar que la pieza del Jenga tiene tres dimensiones pero elegimos no modelar ese aspecto”

- ¡No significa que si modelan la pieza este mal!
- ¡Dar un ejemplo distinto para el ejercicio b)!

### EJercicio 2. Arboles

Implementar los siguientes métodos del TAD ABB<Integer> extends AB<Integer>.
Implementar también los métodos auxiliares o privados.

Sea abb una instancia de ABB<Integer> :

1. **Void eliminar(Integer elem):** que elimina elem si existe. Si no existe no se puede arrojar
   una excepción.
2. **boolean balanceado():** que devuelve verdadero si el árbol esta balanceado
3. **boolean balanceado():** que devuelve verdadero si abb está balanceado y falso en caso
   contrario.
4. **void rebalancear():** que dado cualquier abb, lo modifica para que balanceado() devuelve
   verdadero.
5. **Integer iesimo(int i):** que devuelve el iesimo nodo, considerando el recorrido inorden.
   Debe hacerse sin utilizar estructuras auxiliares.
   Ayuda: Justificar respecto de la cantidad de veces que se recorre cada nodo.
6. **boolean Irep():** que devuelve verdadero si la cantidad de nodos “alcanzables” difiere de la cantidad de nodos reales.
   Ayuda: Modificar la implementación de ABB, agregar la variable int cantNodos como variable
   de instancia del ABB.
   Luego, comparar la cantidad de nodos alcanzables con esa variable.

En todos los ítems se debe justificar la complejidad de la solución elegida.

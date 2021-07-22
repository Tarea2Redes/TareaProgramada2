saSearch es el proyecto del lado del cliente, este módulo permite que el usuario pueda interactuar con la interfaz gráfica, en este se puede insertar libros, 
ver la lista de libros, y obtener libros que coincidan con la búsqueda del metadato que el usuario inserte.

El saSearch interactúa con el controllerNode, que en este caso es el servidor, a quien le solicita poder insertar libros, libros que se 
encuentran en el diskNode que simula el raid 5.

Este proyecto es útil, ya que contribuye a la simulación de un raid 5, donde desde el lado del cliente, se puede observar cómo los datos 
parecieran que estuvieran en un solo archivo, cuando en realidad son recopilados en n discos con distintas porciones del libro, por medio 
del servidor son unificados y enviados al cliente, para que puedan mostrarse en orden en la interfaz. 

Para poder usar el proyecto saSearch, puede descargarlo y usar el jar que viene en la carpeta dist del proyecto, antes de correrlo, debe ejecutar 
el proyecto del servidor, también si tiene el entorno NetBeans con la versión 8.2 o desea descargarlo, debe usar el jdk versión 8.0.

Una vez que corre el proyecto, para poder buscar libros o ver la lista de libros, debe poder insertar libros desde la opción del menú, por consiguiente, 
al haber insertado libros, puede realizar las consultas mencionadas anteriormente. Es una interfaz amigable con el usuario, que consta de tres módulos, que son, 
insertar libros, buscar libros, lista de libros. 
Este proyecto es contribuido por los estudiantes Valeska Molina y Kevin Calderón, de la Universidad de Costa Rica, bajo la asignación tarea programada 2, I semestre del 2021.

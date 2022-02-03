# Perro y usoPerro

### Perro:
Contendrá atributos, setters, getters y lo que se os ocurra

### usoPerro: 
Se pondrá a prueba varios perros instanciados. 

### ideas.md:
Podeís agregar aqui ideas que aún no tengaís en código, tanto en local haciendo un push como editando el docuemnto desde Github mismo. 

### Uso:
------------- **Recordad que después de clonar el repositorio (donde sea), podeís**  ***importar el proyecto en Eclipse*** ----------
- Clonais este repositorio con `git clone git@github.com:TomasTS14/Perro.git`
- Podeís ver que se os haya clonado con el repositorio remoto correcto con `git remote -v`.
- Podeís comprobar cambios que se hayan hecho en el github con `git diff master origin/master`.
- Si hay algún cambio siempre hacer un `pull` antes de hacer un *commit local* y un `push` o se os desincronizan los commits.
- Intentar documentar los commits con un comentario y comentarios dentro del mismo codigo.  
-----------------------------------------------------------------------------------------------

## Comandos GIT:
- `git init`: iniciliza repositorio, en este caso no hace falta. 
- `git status`: muestra el estado del repositorio, inicialmente solo *untracked files*.
- `git add .`: agrega todo, no useís este o agregará también archivos de config de vuestro eclipse. 
- `git add src/perro src/usoPerro`: agregará estos dos, apartir de ahora no saldrán en *untracked* sino en *modified* si cambiáis algo. 
- `git add -u`: Esté agregará solo los archivos que previamente hayan estado trackeados, en caso de haber hecho en el primer **add** con `git add src/perro src/usoPerro` , solo agregará las versiones modificadas de estos.
- `git commit -m""` : Creará un commit con el comentario que pongaís entre las comillas.
- `git push`: subirá el último **commit** hecho.  

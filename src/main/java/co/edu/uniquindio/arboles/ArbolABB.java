package co.edu.uniquindio.arboles;

public class ArbolABB {

    NodoABB raiz;

    /**
     * Intenta insertar un código en el árbol.
     * Los códigos deben ser únicos, por lo que si el código ya existe no se inserta.
     *
     * @param codigo código del equipo a insertar
     * @return true si el código fue insertado, false si ya existía en el árbol
     */

    public boolean insertar(int codigo) {
        if (buscar(raiz, codigo))
            return false;
        raiz = insertarRecursivo(raiz, codigo);
        return true;
    }


    /**
     * Recorre el árbol de forma recursiva hasta encontrar el lugar vacío
     * donde debe ubicarse el nuevo código, respetando el orden del ABB el cual es:
     * (menores a la izquierda, mayores a la derecha).
     *
     * @param nodo   nodo actual del recorrido (puede ser null)
     * @param codigo código del equipo a insertar
     * @return el nodo actual con el cambio ya hecho, para conservar los enlaces del árbol
     */
    private NodoABB insertarRecursivo(NodoABB nodo, int codigo) {
        if (nodo == null)
            return new NodoABB(codigo);
        if (codigo < nodo.codigo)
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, codigo);
        else
            nodo.derecho = insertarRecursivo(nodo.derecho, codigo);
        return nodo;
    }


    /**
     * Busca de forma recursiva si un código existe en el árbol,
     * aprovechando el orden del ABB para descartar la mitad del árbol en cada paso.
     *
     * @param nodo   nodo actual del recorrido (puede ser null)
     * @param codigo código del equipo que se busca
     * @return true si el código existe en el árbol, false en caso contrario
     */
    private boolean buscar(NodoABB nodo, int codigo) {
        if (nodo == null) {
            return false;
        }
        if (codigo == nodo.codigo) {
            return true;
        }
        if (codigo < nodo.codigo) {
            return buscar(nodo.izquierdo, codigo);
        } else {
            return buscar(nodo.derecho, codigo);
        }
    }
}

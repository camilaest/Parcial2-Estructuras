package co.edu.uniquindio.arboles;

public class MainArboles {

    /**
     * Construye el ABB, cuenta los equipos en el rango [47, 60]
     *
     */

    public static void main(String[] args) {
        ArbolABB abb = new ArbolABB();

        // Nodos que vamos a utilizar
        int[] datos = {41, 20, 52, 47, 60, 43, 50, 44};

        // Inserta cada código en el árbol
        for (int codigo : datos) {
            abb.insertar(codigo);
        }

        int limiteInferior = 47;
        int limiteSuperior = 60;

        int cantidad = ArbolABB.contarEquiposEnRango(abb.raiz, limiteInferior, limiteSuperior);

        System.out.println("Rango [" + limiteInferior + ", " + limiteSuperior + "]");
        System.out.println("Equipos encontrados: " + cantidad);

    }
}

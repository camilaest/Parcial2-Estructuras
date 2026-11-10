package co.edu.uniquindio.pilas_colas;

/**
 * Clase con métodos estáticos sobre pilas propias.
 */
public class OperacionesPila {
    /**
     * Retira la caja con el código indicado y reorganiza las cajas restantes según el valor de la caja retirada (par o impar)
     * @param pila
     * @param codigo
     * @return
     */
    public static boolean retirarCaja(Pila<Caja> pila, String codigo) {
        if(pila.estaVacia()){
            return false;
        }
        Pila<Caja> aux = new Pila<>();
        Caja retirada = null;
        while(!pila.estaVacia() && retirada == null){
            Caja actual = pila.desapilar();
            if(actual.getCodigo().equals(codigo)){
                retirada = actual;
            } else {
                aux.apilar(actual);
            }
        }
        while (!aux.estaVacia()){ //Una vez retirada la caja elegida, se vuelven a apilar los elementos de la pila auxiliar a la principal
            pila.apilar(aux.desapilar());
        }
        if(retirada == null){
            return false;
        }
        Pila<Caja> impares = new Pila<>();
        Pila<Caja> pares = new Pila<>();
        int posicion = 1;

        while (!pila.estaVacia()) {
            Caja c = pila.desapilar();
            if (posicion % 2 == 0) {
                pares.apilar(c);
            } else {
                impares.apilar(c);
            }
            posicion++;
        }

        Pila<Caja> abajo;
        Pila<Caja> arriba;

        if(retirada.getValor() % 2 == 0){
            abajo = pares;
            arriba = impares;
        } else {
            abajo = impares;
            arriba = pares;
        }

        while (!abajo.estaVacia()) {
            pila.apilar(abajo.desapilar());
        }
        while (!arriba.estaVacia()) {
            pila.apilar(arriba.desapilar());
        }
        return true;
    }

    /**
     * Obtiene un segmento del historial de acciones, entre las posiciones de inicio y fin. Las posiciones se cuentan desde la cima, empezando en 1.
     * La pila que resulta conserva el orden de las acciones
     * @param pila
     * @param inicio
     * @param fin
     * @return nueva pila con acciones del segmento
     */
    public static Pila<String> obtenerSegmento(Pila<String> pila, int inicio, int fin) {
        Pila<String> acciones = new Pila<>();
        if(inicio > fin || inicio < 1 || fin > pila.tamanio()){
            return acciones;
        }
        Pila<String> aux = new Pila<>();
        int posicion = 1;
        for (String i : pila) {
            if(posicion >= inicio && posicion <= fin){
                aux.apilar(i);
            }
            posicion++;
        }
        while (!aux.estaVacia()) {
            acciones.apilar(aux.desapilar());
        }
        return acciones;
    }
}

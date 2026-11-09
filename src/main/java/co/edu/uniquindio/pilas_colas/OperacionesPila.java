package co.edu.uniquindio.pilas_colas;

public class OperacionesPila {
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
}

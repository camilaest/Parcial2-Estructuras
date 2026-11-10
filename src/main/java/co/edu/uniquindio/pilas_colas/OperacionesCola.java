package co.edu.uniquindio.pilas_colas;

/**
 * Clase de utilidad llamada OperacionesCola, contiene un método estático recursivo
 */
public class OperacionesCola {
    /**
     * Método estático recursivo, recibe la cola de paquetes pendientes y capacidad disponible.
     * Retira los paquetes de la cola de pendiente una vez se seleccionaron
     * @param cola
     * @param capacidad
     * @return nueva cola de paquetes seleccionados
     */
    public static Cola<Paquete> recursividadPaquetes(Cola<Paquete> cola, int capacidad) {
        Cola<Paquete> seleccionados = new Cola<>();
        if(capacidad <= 0){ //Si la capacidad no es válida o está llena, retorna la lista vacía
            return seleccionados;
        }
        int restante = procesar(cola, seleccionados, TipoEntrega.URGENTE,cola.tamanio(), capacidad);
        //Se empieza con los urgentes, una vez estén todos los urgentes, paso a los normales con la capacidad restante
        procesar(cola, seleccionados, TipoEntrega.NORMAL, cola.tamanio(), restante);
        return seleccionados;
    }
    private static int procesar(Cola<Paquete> cola, Cola<Paquete> seleccionados, TipoEntrega tipo, int t, int capacidad) {
        if(t == 0){
            return capacidad; //caso base
        }
        Paquete p = cola.desencolar();
        if(p.getTipo().equals(tipo)){
            if(p.getPeso() <= capacidad){
                System.out.println(p.getCodigo() + p.getTipo() + ", " + p.getPeso() + " kg : SELECCIONADO");
                seleccionados.encolar(p);
                //Caso recursivo
                return procesar(cola, seleccionados, tipo, t - 1, capacidad - p.getPeso());
            }
            System.out.println(p.getCodigo() + p.getTipo() + ", " + p.getPeso() + " kg : PENDIENTE (no cabe en el vehículo)");
        }
        cola.encolar(p);
        //Caso recursivo
        return procesar(cola, seleccionados, tipo, t - 1, capacidad);
    }

    /**
     * Método recursiva para determinar el peso total de los paquetes seleccionados
     * @param cola
     * @param n
     * @return peso total en kg
     */
    public static int pesoTotal(Cola<Paquete> cola, int n){
        if (n == 0){
            return 0; // caso base: sin paquetes por revisar
        }
        Paquete p = cola.desencolar();
        cola.encolar(p);
        return p.getPeso() + pesoTotal(cola, n-1); //caso recursivo
    }
}

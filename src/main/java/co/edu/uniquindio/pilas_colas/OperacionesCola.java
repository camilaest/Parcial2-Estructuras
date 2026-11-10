package co.edu.uniquindio.pilas_colas;

public class OperacionesCola {

    public static Cola<Paquete> recursividadPaquetes(Cola<Paquete> cola, int capacidad) {
        Cola<Paquete> seleccionados = new Cola<>();
        if(capacidad <= 0){
            return seleccionados;
        }
        int restante = procesar(cola, seleccionados, TipoEntrega.URGENTE,cola.tamanio(), capacidad);

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
                return procesar(cola, seleccionados, tipo, t - 1, capacidad - p.getPeso());
            }
            System.out.println(p.getCodigo() + p.getTipo() + ", " + p.getPeso() + " kg : PENDIENTE (no cabe en el vehículo)");
        }
        cola.encolar(p);
        return procesar(cola, seleccionados, tipo, t - 1, capacidad);
    }
    public static int pesoTotal(Cola<Paquete> cola, int n){
        if (n == 0){
            return 0; // caso base: sin paquetes por revisar
        }
        Paquete p = cola.desencolar();
        cola.encolar(p);
        return p.getPeso() + pesoTotal(cola, n-1);
    }
}

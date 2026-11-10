package co.edu.uniquindio.pilas_colas;

public class MainPilasColas {
    public static void main(String[] args) {
        /**
         * Ejercicio 1 del parcial: Retiro de cajas y evaluación de expresiones
         */
        Pila<Caja> pila = new Pila<>();
        pila.apilar(new Caja("C1", 2));
        pila.apilar(new Caja("C2", 4));
        pila.apilar(new Caja("C3", 6));
        pila.apilar(new Caja("C4", 8));
        pila.apilar(new Caja("C5", 3));
        pila.apilar(new Caja("C6", 9));
        pila.apilar(new Caja("C7", 5));

        System.out.println("1.  Retiro de cajas y evaluación de expresiones");
        System.out.println("Pila inicial:\n " + pila.mostrar());


        System.out.println("Solicitamos retirar caja C3");
        System.out.println("Retorna: " + OperacionesPila.retirarCaja(pila,"C3"));
        System.out.println(pila.mostrar());
        System.out.println("Solicitamos retirar caja C4");
        System.out.println("Retorna: " + OperacionesPila.retirarCaja(pila,"C4"));
        System.out.println(pila.mostrar());
        System.out.println("Solicitamos retirar caja C7");
        System.out.println("Retorna: " + OperacionesPila.retirarCaja(pila,"C7"));
        System.out.println(pila.mostrar());


        System.out.println("Pila final:\n " + pila.mostrar());

        /**
         * Ejercicio 2 del parcial: Obtener un segmento del historial
         */
        Pila<String> acciones = new Pila<>();
        acciones.apilar("A1");
        acciones.apilar("A2");
        acciones.apilar("A3");
        acciones.apilar("A4");
        acciones.apilar("A5");
        acciones.apilar("A6");

        System.out.println("\n2. Obtener un segmento del historial");
        System.out.println("Pila inicial:\n " + acciones.mostrar());

        System.out.println("Ejemplo con inicio = 2 y fin = 4");
        Pila<String> ejemplo = OperacionesPila.obtenerSegmento(acciones,2,4);
        System.out.println(ejemplo.mostrar());
        System.out.println("La pila inicial queda intacta: " + acciones.mostrar());
        System.out.println("Si la posición inicial y final son iguales: ");
        Pila<String> iguales = OperacionesPila.obtenerSegmento(acciones,5,5);
        System.out.println(iguales.mostrar());
        System.out.println("Si la posición no es valida: ");
        Pila<String> invalida = OperacionesPila.obtenerSegmento(acciones,9,6);
        System.out.println(invalida.mostrar());
        /**
         * Ejercicio 3 del parcial: Selección para una jornada
         */
        Cola<Paquete> pendientes = new Cola<>();
        pendientes.encolar(new Paquete("P1", TipoEntrega.NORMAL, 4));
        pendientes.encolar(new Paquete("P2", TipoEntrega.URGENTE, 7));
        pendientes.encolar(new Paquete("P3", TipoEntrega.NORMAL, 3));
        pendientes.encolar(new Paquete("P4", TipoEntrega.URGENTE, 5));
        pendientes.encolar(new Paquete("P5", TipoEntrega.NORMAL, 6));
        pendientes.encolar(new Paquete("P6", TipoEntrega.URGENTE, 4));
        pendientes.encolar(new Paquete("P7", TipoEntrega.NORMAL, 2));

        int capacidad = 14;

        System.out.println("\n3. Selección de solicitudes para una jornada");
        System.out.println("Cola inicial:\n" + pendientes.mostrar());
        System.out.println("Capacidad disponible: " + capacidad + " kg");

        Cola<Paquete> seleccionados = OperacionesCola.recursividadPaquetes(pendientes, capacidad);

        System.out.println("Cola retornada:\n" + seleccionados.mostrar());
        System.out.println("Cola de pendientes:\n" + pendientes.mostrar());

        int usado = OperacionesCola.pesoTotal(seleccionados, seleccionados.tamanio());
        System.out.println("Capacidad restante: " + (capacidad - usado) + " kg");
    }


}

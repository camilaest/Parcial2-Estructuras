package co.edu.uniquindio.pilas_colas;

public class MainPilasColas {
    public static void main(String[] args) {

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
        System.out.println();

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
    }


}

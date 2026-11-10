package co.edu.uniquindio.pilas_colas;

/**
 * Clase Paquete con atributos código, tipo de entrega (URGENTE o NORMAL) y peso en kilogramos.
 * Se utiliza para el ejercicio 3, asignar paquetes a un vehículo según su capacidad.
 */
public class Paquete {
    private String codigo;
    private TipoEntrega tipo;
    private int peso;
    public Paquete(String codigo, TipoEntrega tipo, int peso) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoEntrega getTipo() {
        return tipo;
    }

    public void setTipo(TipoEntrega tipo) {
        this.tipo = tipo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        if (peso < 0){
            throw new IllegalArgumentException("El peso no puede ser negativo");
        }
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Paquete{ "
                + codigo  +
                ", tipo= " + tipo +
                ", peso= " + peso +
                "}\n";
    }
}

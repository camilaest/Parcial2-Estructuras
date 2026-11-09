package co.edu.uniquindio.pilas_colas;

public class Caja {
    private String codigo;
    private int valor;

    public Caja(String codigo, int valor) {
        this.codigo = codigo;
        this.valor = valor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return codigo + ": " + valor;
    }
}

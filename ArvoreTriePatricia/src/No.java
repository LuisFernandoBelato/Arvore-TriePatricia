public class No
{
    private int nivel;
    private NoPatricia No;
    private No prox;

    public No (NoPatricia No, int nivel, No prox) {
        this.nivel = nivel;
        this.No = No;
        this.prox = prox;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public NoPatricia getInfo() {
        return No;
    }

    public void setInfo(NoPatricia No) {
        this.No = No;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}

public class NoPatricia
{
    private char[] vLetras;
    private NoPatricia[] vLig;
    private String Palavra;
    private int Numero;

    public NoPatricia ()
    {
        vLetras = new char[26];
        vLig = new NoPatricia[26];
    }

    public NoPatricia(String palavra) {
        vLetras = new char[26];
        vLig = new NoPatricia[26];
        Palavra = palavra;
        Numero = 0;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        this.Numero = numero;
    }

    public char getvLetras(int pos) {
        return vLetras[pos];
    }

    public void setvLetras(int pos, char caracter) {
        vLetras[pos] = caracter;
    }

    public NoPatricia getvLig(int pos) {
        return vLig[pos];
    }

    public void setvLig(int pos, NoPatricia no) {
        vLig[pos] = no;
    }

    public String getPalavra() {
        return Palavra;
    }

    public void setPalavra(String palavra) {
        Palavra = palavra;
    }
}

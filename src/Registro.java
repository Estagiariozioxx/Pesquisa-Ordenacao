import java.io.IOException;
import java.io.RandomAccessFile;

public class Registro {
    private int codigo;

    public Registro()
    {
    }

    public Registro(int codigo)
    {
        this.codigo = codigo; //this � variavel de estancia

    }

    public int getCodigo()
    {
        return (codigo);
    }


    public void gravaNoArq(RandomAccessFile arquivo)
    {
        try
        {
            arquivo.writeInt(codigo);

        } catch (IOException e)
        { }
    }

    public void leDoArq(RandomAccessFile arquivo)
    {
        try
        {
            this.codigo = arquivo.readInt();

        } catch (IOException e)
        { }
    }

    public void exibirReg()
    {
        int i;
        System.out.print(" "+this.codigo);
       // System.out.println("\n----------------------------------");
    }

    static int length()
    {
        return (4); //int codigo, tl=20, idade; ------------> 12 bytes
        //private char nome[] = new char[20]; --> 40 bytes
        //------------------------------------------------- +
        //                      Total : 40 + 12 = 52 bytes
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}

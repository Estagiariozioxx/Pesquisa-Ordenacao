import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TabelaTxt {
    private RandomAccessFile arq;
    public TabelaTxt() throws IOException {

        arq=new RandomAccessFile("Tab.txt","rw");
        arq.writeBytes(String.format("%-40s %-82s %-82s %-82s\n", "Métodos de Ordenação", "Arquivo ordenado", "Arquivo em ordem Reversa", "Arquivo Randomico"));
        arq.writeBytes(String.format("%-40s %-15s %-15s %-15s %-15s %-18s %-15s %-15s %-15s %-15s %-18s %-15s %-15s %-15s %-15s %-18s\n", "", "Comp Prog.*", "Comp Equa*", "Movi Prog*", "Movi equs", "Tempo", "Comp Prog.*", "Comp Equa*", "Movi Prog*", "Movi equa", "Tempo", "Comp Prog.*", "Comp Equa*", "Movi Prog*", "Movi equs", "Tempo"));
        arq.writeBytes("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

    }


    public void Grava(String nome,int compProg,int compEqua,int moviProg,int moviEqua,long tempo,int compProg2,int compEqua2,int moviProg2,int moviEqua2,long tempo2,int compProg3,int compEqua3,int moviProg3,int moviEqua3,long tempo3) throws IOException {
        arq.writeBytes(String.format("%-40s %-15s %-15s %-15s %-15s %-18s %-15s %-15s %-15s %-15s %-18s %-15s %-15s %-15s %-15s %-18s\n",nome,compProg,compEqua,moviProg,compEqua,tempo,compProg2,compEqua2,moviProg2,moviEqua2,tempo2,compProg3,compEqua3,moviProg3,moviEqua3,tempo3));

    }
}


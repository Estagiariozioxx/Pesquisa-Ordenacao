import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main {



    public static void PopulaArqs(Arquivo_Java arqrand,Arquivo_Java arqord,Arquivo_Java arqdecre){
        arqrand.popularandom();
        arqord.populaordenado();
        arqdecre.populadecre();
    }

    public static void GeraTabela ( Arquivo_Java ArqOrd, Arquivo_Java ArqRev, Arquivo_Java ArqRand) throws IOException {
        Long tempo_inicial,tempo_final,tempoOrd,tempoDecre,tempoRand;

        Arquivo_Java auxrand=new Arquivo_Java("auxRand.dat");
        Arquivo_Java auxord=new Arquivo_Java("auxOrd.dat");
        Arquivo_Java auxdecre=new Arquivo_Java("auxDecre.dat");
        TabelaTxt tab =new TabelaTxt();
        System.out.println("Iniciando Inserção direta...");

        //INSERÇÃO DIRETA
        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.inser_direta();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.inser_direta();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.inser_direta();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;
        System.out.println("Finalizado");



        tab.Grava("Inserção Direta",auxrand.getCompProg(),
                ((int)Math.pow(auxrand.getTF(), 2) + auxrand.getTF() - 2) / 4,
                auxrand.getMovProg(),
                ((int)Math.pow(auxrand.getTF(), 2) + 9 * auxrand.getTF() - 10) / 4,tempoRand,

                auxord.getCompProg(), auxord.getTF()-1,
                auxord.getMovProg(),
                3*(auxord.getTF()-1),
                tempoOrd,

                auxdecre.getCompProg(),
                ((int)Math.pow(auxdecre.getTF(),2)+auxdecre.getTF()-4),
                auxdecre.getMovProg(),
                ((int)Math.pow(auxdecre.getTF(),2)+ 3 * auxdecre.getTF()-4)/2,
                tempoDecre
        );


        //SELECAO DIRETA

        System.out.println("Iniciando Seleção Direta...");


        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.selecao_direta();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.selecao_direta();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.selecao_direta();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;
        System.out.println("Finalizado");


        tab.Grava("Seleção Direta",auxrand.getCompProg(),
                (int)Math.pow(auxrand.getTF(), 2) - auxrand.getTF() / 2,
                auxrand.getMovProg(),auxrand.getTF() * (int)(Math.log10(auxrand.getTF()) + 0.5772),tempoRand,

                auxord.getCompProg(), (int)Math.pow(auxord.getTF(), 2) - auxord.getTF() / 2,
                auxord.getMovProg(),
                3 * (auxord.getTF() - 1),
                tempoOrd,

                auxdecre.getCompProg(),
                (int)Math.pow(auxdecre.getTF(), 2) - auxdecre.getTF() / 2,
                auxdecre.getMovProg(),
                (int)Math.pow(auxdecre.getTF(), 2) / (4 + 3 * (auxdecre.getTF() - 1)),
                tempoDecre
        );

        //BOLHA
        System.out.println("Iniciando Bolha...");


        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.bolha();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.bolha();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.bolha();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;
        System.out.println("Finalizado");


        tab.Grava("Bolha",auxrand.getCompProg(),
                ((int)Math.pow(auxrand.getTF(), 2) - auxrand.getTF()) / 2,
                auxrand.getMovProg(),(3 * ((int)Math.pow(auxrand.getTF(), 2) - auxrand.getTF())) / 4,tempoRand,

                auxord.getCompProg(), ((int)Math.pow(auxord.getTF(), 2) - auxord.getTF()) / 2,
                auxord.getMovProg(),
                0,
                tempoOrd,

                auxdecre.getCompProg(),
                ((int)Math.pow(auxdecre.getTF(), 2) - auxdecre.getTF()) / 2,
                auxdecre.getMovProg(),
                (3 * ((int)Math.pow(auxdecre.getTF(), 2) - auxdecre.getTF())) / 2,
                tempoDecre
        );


        //quick com pivo
        System.out.println("Iniciando Quick Com Pivo...");

        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.quickcpivo();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.quickcpivo();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.quickcpivo();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;
        System.out.println("Finalizado");


        tab.Grava("Quick Com Pivo",auxrand.getCompProg(),
                0,
                auxrand.getMovProg(),0,tempoRand,

                auxord.getCompProg(), 0,
                auxord.getMovProg(),
                0,
                tempoOrd,

                auxdecre.getCompProg(),
                0,
                auxdecre.getMovProg(),
                0,
                tempoDecre
        );




        //quick sem pivo
        System.out.println("Iniciando Quick Sem Pivo...");


        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.quicksp();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.quicksp();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.quicksp();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;
        System.out.println("Finalizado");


        tab.Grava("Quick Sem Pivo",auxrand.getCompProg(),
                0,
                auxrand.getMovProg(),0,tempoRand,

                auxord.getCompProg(), 0,
                auxord.getMovProg(),
                0,
                tempoOrd,

                auxdecre.getCompProg(),
                0,
                auxdecre.getMovProg(),
                0,
                tempoDecre
        );

        //SHELL
        System.out.println("Iniciando Shell...");


        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.shell();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.shell();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.shell();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;

        System.out.println("Finalizado");


        tab.Grava("Shell",auxrand.getCompProg(),
                0,
                auxrand.getMovProg(),0,tempoRand,

                auxord.getCompProg(), 0,
                auxord.getMovProg(),
                0,
                tempoOrd,

                auxdecre.getCompProg(),
                0,
                auxdecre.getMovProg(),
                0,
                tempoDecre
        );

        //Heap
        System.out.println("Iniciando Heap...");

        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.heap();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.heap();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.heap();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;
        System.out.println("Finalizado");


        tab.Grava("Heap",auxrand.getCompProg(),
                0,
                auxrand.getMovProg(),0,tempoRand,

                auxord.getCompProg(), 0,
                auxord.getMovProg(),
                0,
                tempoOrd,

                auxdecre.getCompProg(),
                0,
                auxdecre.getMovProg(),
                0,
                tempoDecre
        );

        //MERGE PRIMEIRA IMPLEMENTAÇÃO
        System.out.println("Iniciando Merge Primeira Implementação...");


        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.merge_1();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.merge_1();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.merge_1();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;
        System.out.println("Finalizado");


        tab.Grava("Merge Primeira Implementação",auxrand.getCompProg(),
                0,
                auxrand.getMovProg(),0,tempoRand,

                auxord.getCompProg(), 0,
                auxord.getMovProg(),
                0,
                tempoOrd,

                auxdecre.getCompProg(),
                0,
                auxdecre.getMovProg(),
                0,
                tempoDecre
        );

        //Merge Segunda Implementação

        System.out.println("Iniciando Merge Segunda Implementação...");
        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.mergeSort();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.mergeSort();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.mergeSort();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;

        System.out.println("Finalizado");


        tab.Grava("Merge Segunda Implementação",auxrand.getCompProg(),
                0,
                auxrand.getMovProg(),0,tempoRand,

                auxord.getCompProg(), 0,
                auxord.getMovProg(),
                0,
                tempoOrd,

                auxdecre.getCompProg(),
                0,
                auxdecre.getMovProg(),
                0,
                tempoDecre
        );

        //Shake
        System.out.println("Iniciando Shake...");


        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.ShakeSort();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.ShakeSort();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.ShakeSort();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;
        System.out.println("Finalizado");


        tab.Grava("Shake Sort",auxrand.getCompProg(),
                0,
                auxrand.getMovProg(),0,tempoRand,

                auxord.getCompProg(), 0,
                auxord.getMovProg(),
                0,
                tempoOrd,

                auxdecre.getCompProg(),
                0,
                auxdecre.getMovProg(),
                0,
                tempoDecre
        );

        //Couting
        System.out.println("Iniciando Couting...");


        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.couting();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.couting();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.couting();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;

        System.out.println("Finalizado");


        tab.Grava("Couting",auxrand.getCompProg(),
                0,
                auxrand.getMovProg(),0,tempoRand,

                auxord.getCompProg(), 0,
                auxord.getMovProg(),
                0,
                tempoOrd,

                auxdecre.getCompProg(),
                0,
                auxdecre.getMovProg(),
                0,
                tempoDecre
        );

        //Gnome
        System.out.println("Iniciando Gnome...");


        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.Gnome();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.Gnome();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.Gnome();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;
        System.out.println("Finalizado");


        tab.Grava("Gnome",auxrand.getCompProg(),
                0,
                auxrand.getMovProg(),0,tempoRand,

                auxord.getCompProg(), 0,
                auxord.getMovProg(),
                0,
                tempoOrd,

                auxdecre.getCompProg(),
                0,
                auxdecre.getMovProg(),
                0,
                tempoDecre
        );


        //BUCKET
        System.out.println("Iniciando Bucket...");


        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.Bucket(20);
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.Bucket(20);
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.Bucket(20);
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;


        tab.Grava("Bucket",auxrand.getCompProg(),
                0,
                auxrand.getMovProg(),0,tempoRand,

                auxord.getCompProg(), 0,
                auxord.getMovProg(),
                0,
                tempoOrd,

                auxdecre.getCompProg(),
                0,
                auxdecre.getMovProg(),
                0,
                tempoDecre
        );
        System.out.println("Finalizado");


        //COMB

        System.out.println("Iniciando Comb...");
        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.comb();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.comb();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.comb();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;


        tab.Grava("Comb",auxrand.getCompProg(),
                0,
                auxrand.getMovProg(),0,tempoRand,

                auxord.getCompProg(), 0,
                auxord.getMovProg(),
                0,
                tempoOrd,

                auxdecre.getCompProg(),
                0,
                auxdecre.getMovProg(),
                0,
                tempoDecre
        );
        System.out.println("Finalizado");


        //RADIX

        System.out.println("Iniciando Radix...");

        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.Radix();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.Radix();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.Radix();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;
        System.out.println("Finalizado");


        tab.Grava("Radix",auxrand.getCompProg(),
                0,
                auxrand.getMovProg(),0,tempoRand,

                auxord.getCompProg(), 0,
                auxord.getMovProg(),
                0,
                tempoOrd,

                auxdecre.getCompProg(),
                0,
                auxdecre.getMovProg(),
                0,
                tempoDecre
        );


        //insercao binaria
        System.out.println("Iniciando Inserção binaria...");

        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.insercaobinaria();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.insercaobinaria();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.insercaobinaria();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;
        System.out.println("Finalizado");


        tab.Grava("Inserção Binaria",auxrand.getCompProg(),
                auxrand.getTF() * (int)(Math.log10(auxrand.getTF()) + Math.log10(Math.E)),
                auxrand.getMovProg(),((int)Math.pow(auxrand.getTF(), 2) + 9 * auxrand.getTF() - 10) / 4,tempoRand,

                auxord.getCompProg(), auxord.getTF() * (int)(Math.log10(auxord.getTF()) + Math.log10(Math.E)),
                auxord.getMovProg(),
                3 * (auxord.getTF() - 1),
                tempoOrd,

                auxdecre.getCompProg(),
                auxdecre.getTF() * (int)(Math.log10(auxdecre.getTF()) + Math.log10(Math.E)),
                auxdecre.getMovProg(),
                ((int)Math.pow(auxdecre.getTF(), 2) + 3 * auxdecre.getTF() - 4) / 2,
                tempoDecre
        );



        System.out.println("Iniciando Tim...");

        ArqOrd.replicaArq(auxrand);
        auxrand.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxrand.Tim();
        tempo_final=System.currentTimeMillis();
        tempoRand=tempo_final-tempo_inicial;

        ArqOrd.replicaArq(auxord);
        tempo_inicial=System.currentTimeMillis();
        auxord.Tim();
        tempo_final=System.currentTimeMillis();
        tempoOrd=tempo_final-tempo_inicial;

        ArqRev.replicaArq(auxdecre);
        auxdecre.init_zera_tudo();
        tempo_inicial=System.currentTimeMillis();
        auxdecre.Tim();
        tempo_final=System.currentTimeMillis();
        tempoDecre=tempo_final-tempo_inicial;
        System.out.println("Finalizado");


        tab.Grava("Tim",auxrand.getCompProg(),
                0,
                auxrand.getMovProg(),0,tempoRand,

                auxord.getCompProg(), 0,
                auxord.getMovProg(),
                0,
                tempoOrd,

                auxdecre.getCompProg(),
                0,
                auxdecre.getMovProg(),
                0,
                tempoDecre
        );

    }

    public static void popula_lista(Lista listarand, Lista listadecre, Lista listaord){

        Random random = new Random();
        for (int i = 0; i <32; i++) {
            int numero = random.nextInt(1025);
            listarand.inserefinal(numero);
        }
        for (int i = 0; i < 32; i++) {
            int numero = i;
            listaord.inserefinal(numero);
        }
        for (int i = 32; i > 0; i--) {
            int numero = i;
            listadecre.inserefinal(numero);
        }

    }

    public static void ordena_listas(Lista listarand, Lista listadecre, Lista listaord){
        Lista auxrand=new Lista();
        Lista auxord=new Lista();
        Lista auxdecre=new Lista();

        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Inserção Direta------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.insercaoDireta();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.insercaoDireta();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.insercaoDireta();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();



        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Seleção Direta------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.sele();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.sele();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.sele();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();


        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Bucket------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.Bucket(20);
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.Bucket(20);
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.Bucket(20);
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();



        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Comb------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.comb();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.comb();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.comb();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();


        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Radix------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.Radix();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.Radix();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.Radix();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();


        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Inserção Binaria------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.insercaobinaria();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.insercaobinaria();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.insercaobinaria();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();



        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Shake------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.Shake();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.Shake();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.Shake();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();



        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Shell------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.Shell();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.Shell();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.Shell();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();


        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Heap------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.heap();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.heap();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.heap();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();


        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Gnome------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.Gnome();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.Gnome();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.Gnome();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();



        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Merge Primeira Implementação------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.merge_1();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.merge_1();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.merge_1();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();



        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Merge Segunda Implementação------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.mergesort();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.mergesort();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.mergesort();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();



        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Couting------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.Counting();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.Counting();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.Counting();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();


        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Bolha------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.bolha();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.bolha();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.bolha();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();


        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Quick Sem pivo------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.quickspivo();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.quickspivo();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.quickspivo();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();


        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Quick Com pivo------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.quickCpivo();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.quickCpivo();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.quickCpivo();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();



        auxrand.Mata_lista();
        listarand.copia_lista(auxrand);
        System.out.println("--------------------------Tim Sort------------------------------------");
        System.out.println("------ lista randomica:");
        auxrand.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxrand.Tim();
        System.out.println("------ lista ordenada:");
        auxrand.exibe();
        System.out.println();
        System.out.println();

        auxord.Mata_lista();
        listaord.copia_lista(auxord);
        System.out.println("------ lista em ordem:");
        auxord.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxord.Tim();
        System.out.println("------ lista ordenada:");
        auxord.exibe();
        System.out.println();
        System.out.println();

        auxdecre.Mata_lista();
        listadecre.copia_lista(auxdecre);
        System.out.println("------ lista Decrescente:");
        auxdecre.exibe();
        System.out.println();
        System.out.println("Iniciando Metodo de Ordenação....");
        auxdecre.Tim();
        System.out.println("------ lista ordenada:");
        auxdecre.exibe();
        System.out.println();
        System.out.println();









    }


    public static void main(String[] args) throws IOException {
        System.out.println("------Iniciado Metodos no Arquivo---------");
        Arquivo_Java ArqOrd = new Arquivo_Java("ArqOrd.dat");
        Arquivo_Java ArqRev = new Arquivo_Java("ArqRev.dat");
        Arquivo_Java ArqRand = new Arquivo_Java("ArqRand.dat");
        PopulaArqs(ArqRand,ArqOrd,ArqRev);
        GeraTabela(ArqOrd,ArqRev,ArqRand);

      /*  Arquivo_Java ArqOrd = new Arquivo_Java("ArqOrd.dat");
        Arquivo_Java ArqRev = new Arquivo_Java("ArqRev.dat");
        Arquivo_Java ArqRand = new Arquivo_Java("ArqRand.dat");
        PopulaArqs(ArqRand,ArqOrd,ArqRev);
        ArqRev.exibirArq();
        System.out.println();
        ArqRev.Tim();
        ArqRev.exibirArq();*/





        System.out.println("------Finalizado em Arquivo---------");
        System.out.println();
        System.out.println("------Iniciado Metodos em lista---------");
        System.out.println();
        System.out.println();

        Lista listarand = new Lista();
        Lista listadecre = new Lista();
        Lista listaord = new Lista();

        popula_lista(listarand,listadecre,listaord);

        ordena_listas(listarand,listadecre,listaord);
    }
}
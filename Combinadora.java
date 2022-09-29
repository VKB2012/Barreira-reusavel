package PBL5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Semaphore;

public class Combinadora extends Thread {
Semaphore mutex;
Semaphore barreira;
int[]contador;

Combinadora(Semaphore mutex,Semaphore barreira,int[]contador){
    this.mutex=mutex;
    this.contador=contador;
    this.barreira=barreira;
}

    public void run() {
        while (true) {
            try {

            mutex.acquire();

            System.out.print("ENTRO\n");

                if(contador[0]==4){
                    barreira.release();
                    System.out.print("==BARREIRA ABERTA==\n");
                    contador[0]=0;
                    for (int i=1;i<5;) {

                        File path =new File("C:\\Users\\vinik\\IdeaProjects\\lllll\\src\\PBL5\\Ordem"+i+".txt");
                        path.delete();
                        System.out.print("Arquivo removido: "+Inicializacao.ArquivosGerados.get(0)+"\n");
                        Inicializacao.ArquivosGerados.remove(0);

                        sleep(100);
                        i++;
                    }
                    System.out.print("==BARREIRA FECHADA==\n");
                }
            mutex.release();

                barreira.acquire();
                barreira.release();
                System.out.print("SAIU\n");
                sleep(1000);



            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    /*
1. Espera a sinalização de quatro novos arquivos disponibilizados pelas quatro
threads do tipo Trabalhadora.
2. Remove os quatro arquivos da fila de arquivos gerados.
3. Faz o merge dos quatro arquivos, eliminando as repetições de números.
4. Cria um novo arquivo de nome único, contendo o resultado do merge.

Na inicialização do sistema, é criada a única instância da thread Combinadora.

     */

}

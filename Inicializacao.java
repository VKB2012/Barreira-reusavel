package PBL5;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Inicializacao {

    public static ArrayList<String> Arquivos= new ArrayList<>();
    public static ArrayList<String> ArquivosGerados = new ArrayList<>();

    public static void main(String[] args) {
        int[]contador={0};
        Semaphore mutex=new Semaphore(1);
        Semaphore barreira=new Semaphore(1);

        Trabalhadora trabalhadora1 = new Trabalhadora(mutex,contador,barreira);
        Trabalhadora trabalhadora2 = new Trabalhadora(mutex,contador,barreira);
        Trabalhadora trabalhadora3 = new Trabalhadora(mutex,contador,barreira);
        Trabalhadora trabalhadora4 = new Trabalhadora(mutex,contador,barreira);

        Combinadora combinadora = new Combinadora(mutex,barreira,contador);

        combinadora.start();

        trabalhadora1.start();
        trabalhadora2.start();
        trabalhadora3.start();
        trabalhadora4.start();
    }
}

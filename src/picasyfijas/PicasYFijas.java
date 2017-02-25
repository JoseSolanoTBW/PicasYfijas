/**
 * Juego de Picas y fijas
 * Descripción: Recibe los operando y la operacion y hace le calculo
 * Fecha:23 de febrero del 2017
 * Autor:Jose Solano Montoya y Adrián Obando Leitón
 * Fecha de modificación:24-02-17
 * Modificado por: Jose Solano
 */
package picasyfijas;

//Librerias
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class PicasYFijas {

    public static void main(String[] args) throws IOException {
        //Variables
        int numCompu, intento=10, numUsu, pica, fija;
        boolean gana= false;
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        
        //Generar Ramdom
        numCompu = numeroRandom();
        //Ciclo que determina la cantidad de oportunidades 
        do {
            System.out.println("Adivine el numero que pienso(4 cifras), digite una posibilidad");
            numUsu=Integer.parseInt(leer.readLine()); //Leer numero digitado por el usuario
            pica=numeroPicas(numCompu, numUsu);
            fija=numeroFijas(numCompu, numUsu);
            gana=ganoJuego(fija);
            intento--;
            System.out.println("Tiene: "+pica+" picas");
            System.out.println("Tiene: "+fija+" fijas");
            System.out.println("Le quedan " +intento+" intentos");
        }while(intento!=0||gana==true);
            resultado(gana);
            System.out.println("El numero corresponde a:  " +numCompu);
    }

    static int numeroRandom() {
        //Creamos una variable tipo random
        Random rnd = new Random();
        //genera un numero del 9999 al 1000 incluyendo el 1000
        return rnd.nextInt(9999 - 1000 + 1) + 1000;
    }

    static int numeroPicas(int pnumCompu, int pnumUsu) {
        int pica = 0, cont1, digitComp, digitUsu, cont2, permanteUsu=pnumUsu;
        for (cont1=0; cont1<4; cont1++)
        {
            digitComp=pnumCompu%10;
            pnumCompu=pnumCompu/10;
            for(cont2=0; cont2<4; cont2++ )
            {
                digitUsu=permanteUsu%10;
                permanteUsu=permanteUsu/10;
                if(cont1!=cont2)
                {
                    if(digitUsu==digitComp)
                    {
                        pica++;
                    }
                }
            }
            permanteUsu=pnumUsu;
            
        }
        return pica;
    }

    static int numeroFijas(int pnumCompu, int pnumUsu) {
        //Variables
        int digitCompu, digitUsu, fija = 0;

        for (int cont1 = 1; cont1 <= 4; cont1++) {//Inicio del For
            //Saca el ultimo digito del numero del Usuario y de la compu
            digitCompu = pnumCompu % 10;
            digitUsu = pnumUsu % 10;

            //Compara eso digitos si son iguales
            if (digitCompu == digitUsu) {//Incio Condicio
                fija += 1;//si se cumple es una fija
            }//Fin Condicion

            //Eliminamos el ultimo digito de esos numeros para compara los siguientes
            pnumCompu = pnumCompu / 10;
            pnumUsu = pnumUsu / 10;

        }//Fin del For

        //Regresa el numero de fijas
        return fija;
    }

    static boolean ganoJuego(int pfija) {
        //Si hay 4 fijas retornar que si gano sino decir que no
        if (pfija == 4) {
            return true;
        } else {
            return false;
        }
    }

    static void resultado(boolean pgana) {
        //si gano imprimir que si gano sino inidicar que perdio
        if (pgana) {
            System.out.println("Has Ganado");
        } else {
            System.out.println("Has Perdido");
        }

    }
}

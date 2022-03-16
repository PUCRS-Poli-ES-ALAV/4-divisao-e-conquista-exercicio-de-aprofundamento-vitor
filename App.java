import java.util.Random;

public class App {
    static int ite = 0;
    public static void main(String[] args) throws Exception {
        int tamanho = 1048576;

        int array[] = new int[tamanho];
        Random rand = new Random();
        for(int i=0; i<tamanho; i++){
            array[i] = rand.nextInt(30);
        }

        long inicio = System.currentTimeMillis();
        //System.out.println("Maior: " + maxVal1(array, array.length));
        System.out.println("Maior: " + maxVal2(array,0,array.length-1));
        long fim = System.currentTimeMillis();
        System.out.println("Iterações: " + ite);
        System.out.println("Tempo de execução: " + (fim-inicio) + "ms");
    }

    public static int maxVal1(int A[], int n) {  
        int max = A[0];
        int iteracoes = 0;
        for (int i = 1; i < n; i++) {  
            iteracoes++;
            if( A[i] > max ) 
               max = A[i];
        }
        System.out.println("Iterações: " + iteracoes);
        return max;
    }
    

    public static int maxVal2(int A[], int init, int end) { 
        ite++;
        if (end - init <= 1)
            return Math.max(A[init], A[end]); 

        else {
              int m = (init + end)/2;
              int v1 = maxVal2(A,init,m);   
              int v2 = maxVal2(A,m+1,end);  
              return Math.max(v1,v2);
            }
    }
}
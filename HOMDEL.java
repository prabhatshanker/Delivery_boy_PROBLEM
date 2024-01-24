import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
        static void floyadWarshall(int N, int [][] T){
            for(int k =0; k<N; k++){
                for(int i =0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if (T[i][k] != Integer.MAX_VALUE && T[k][j] != Integer.MAX_VALUE && T[i][k] + T[k][j] < T[i][j]){
                            T[i][j] = T[i][k] + T[k][j];
                        }
                    }
                }
            }
        }
    
    
    
	    public static void main (String[] args) throws java.lang.Exception
	    {
		    Scanner scn = new Scanner(System.in);
		    int N = scn.nextInt();
            int [][] T = new int[N][N];
            
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    T[i][j] = scn.nextInt();
                }
            }
            
            floyadWarshall(N, T);
            int M = scn.nextInt();
            
            for(int i = 0; i < M; i++){
                int Start = scn.nextInt();
                int Gas = scn.nextInt();
                int Destination = scn.nextInt();
                
                int jarakAntar = T[Start][Gas] + T[Gas][Destination];
                
                int jarakOpt = T[Start][Destination];
                
                System.out.println(jarakAntar + " " + (jarakAntar - jarakOpt ));
            }
            
            scn.close();
	    }
}

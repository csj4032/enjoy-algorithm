package p11568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ports[] = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for( int i = 1 ; i <= n ; i ++ ) {
            ports[i] = Integer.parseInt( st.nextToken() );
        }
        int L[] = new int[n+1];
        int length = 1;
        for( int i = 1; i <= n ; i ++ ) {
            if( L[1] == 0 || L[1] > ports[i] ) {
                L[1] = ports[i];
            }
            else if( L[length] < ports[i] ) {
                L[++length] = ports[i];
            }
            else {
                int index = Arrays.binarySearch(L, 1, length+1, ports[i]);
                if( index < 0 ) {
                    L[index*-1-1] = ports[i];
                }
            }
        }
        System.out.print(Arrays.toString(L));
        System.out.print(length);
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mateusgobo
 */
public class LogicNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite o nro. 1: ");
        String nro1 = br.readLine();

        System.out.println("Digite o nro. 2: ");
        String nro2 = br.readLine();
        String nro3 = "";

        char[] charNro1 = nro1.toCharArray();
        char[] charNro2 = nro2.toCharArray();

        int maxIndex = charNro1.length > charNro2.length ? charNro1.length : charNro2.length;
        int count = 0;
        while (count < maxIndex) {
            if (count > 0) {
                if (charNro1.length > count) {
                    nro3 += String.valueOf(charNro1[count]);
                }
                if (charNro2.length > count) {
                    nro3 += String.valueOf(charNro2[count]);
                }
            } else {
                nro3 += String.valueOf(charNro1[count]) + String.valueOf(charNro2[count]);
            }
            count++;
        }
        Integer nroFinal = Integer.parseInt(nro3);
        System.out.println(nroFinal > 1000000 ? "-1" : "Nro 3 ==> " + nro3);

        br.close();
    }
}

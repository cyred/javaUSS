import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        System.out.println("IT IS USS TIME!");
        System.out.println("Autor: Ingvar Kassuk");
        System.out.println("Aasta: 2016");

        int[][] laud = new int [10][10];
        int[] uss = {5 , 5};
        int[] oun = {7 , 7};

        Scanner sc = new Scanner(System.in);
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String suund = sc.nextLine();
            if(suund.equals("s")) {
                uss[1]++;
            }
            if(suund.equals("w")) {
                uss[1]--;
            }
            if(suund.equals("d")){
                uss[0]++;
            }
            if(suund.equals("a")){
                uss[0]--;
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    int[] preagu = {j, i};
                    if (Arrays.equals(uss, preagu)) {
                        System.out.print('U');
                    } else if (Arrays.equals(oun, preagu)){
                        System.out.print('O');
                    } else {
                        System.out.print('-');
                    }
                }
                System.out.println();
            }
            System.out.println();
        }


        // 0 = tühjus
        // 1 = uss



    }
}

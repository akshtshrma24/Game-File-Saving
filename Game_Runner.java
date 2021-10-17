import java.io.*;
import java.util.Scanner;
import java.util.Random;
public class Game_Runner {
    public static void main(String[] args) throws IOException {
        Random rand = new Random();
        int upperbound = 3;
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your username?");
        String username = sc.nextLine();
        System.out.print("Rock, Paper, or Scissors?  \n");
        int winCounter = 0;
        int loserCounter = 0;
        while(loserCounter < 1) {
            int int_random = rand.nextInt(upperbound);
            String a = sc.nextLine();
            String[] rps = {"Rock", "Paper", "Scissors"};
            System.out.println(rps[int_random]);
            if (a.equals("Rock")){
                if (int_random == 0){
                    System.out.print("TIE\n");
                    System.out.print("Rock, Paper, or Scissors?  \n");
                }
                if (int_random == 1){
                    System.out.print("LOSER\n");
                    loserCounter++;
                }
                if (int_random == 2){
                    System.out.print("WINNER\n");
                    System.out.print("Rock, Paper, or Scissors?  \n");
                    winCounter++;
                }

            }
            if (a.equals("Paper")){
                if (int_random == 0){
                    System.out.println("WINNER\n");
                    System.out.print("Rock, Paper, or Scissors?  \n");
                    winCounter++;
                }
                if (int_random == 1){
                    System.out.println("TIE\n");
                    System.out.print("Rock, Paper, or Scissors?  \n");
                }
                if (int_random == 2){
                    System.out.println("LOSER\n");
                    loserCounter++;
                }
            }
            if (a.equals("Scissors")){
                if (int_random == 0){
                    System.out.println("LOSER\n");
                    loserCounter++;
                }
                if (int_random == 1){
                    System.out.println("WINNER\n");
                    System.out.print("Rock, Paper, or Scissors?  \n");
                    winCounter++;
                }
                if (int_random == 2){
                    System.out.println("TIE\n");
                    System.out.print("Rock, Paper, or Scissors?  \n");
                }
            }
        }

        File topScores = new File("BLANK.txt");
        if(!topScores.exists())
        {
            topScores.createNewFile();
        }

        FileReader fr = new FileReader(topScores);
        BufferedReader br = new BufferedReader(fr);

        String all = "";
        String st;
        while((st = br.readLine()) != null)
        {
            all += st + "\n";
        }

        FileWriter fw = new FileWriter(topScores);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(all + username + ", " + winCounter);


        bw.close();
        fw.close();
        br.close();
        fr.close();

        topScores = new File("BLANK.txt");


        FileReader fr2 = new FileReader(topScores);
        BufferedReader br2 = new BufferedReader(fr2);

        String all2 = "";
        String st2;
        while((st2 = br2.readLine()) != null)
        {
            all2 += st2 + "\n";
        }

        top5Sorting sorting = new top5Sorting(all2);
        sorting.splitIntoArrayListString();
        sorting.splitIntoArrayListEntry();
        System.out.println(sorting.getEntrySplit());
    }
}
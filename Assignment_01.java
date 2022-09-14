package Assignment;

import java.util.*;

public class Assignment_01 {
    public static void main(String[] args) {

        // Initializing the Towers
        Scanner sc = new Scanner(System.in);
        Random rd =new Random();
        System.out.print("Enter the number of towers: ");
        int n = sc.nextInt();
        ArrayList< ArrayList< Integer > > towers = new ArrayList< ArrayList< Integer > >(n);

        System.out.println("Enter 1 for random numbers ");
        System.out.println("Enter 2 to input the numbers yourself ");
        int choice = sc.nextInt();

        final int max_height = 10;
        if(choice == 1) {   // Random Input
            for(int i =0; i < n;i++) {
                int tempLength= (int)(rd.nextDouble()*max_height);    //Random Heights of towers
                ArrayList<Integer> temp = new ArrayList<>(tempLength);
                for(int j = 0; j < tempLength; j++) {
                    temp.add(rd.nextInt(30));         //Random numbers in the towers
                }
                towers.add(temp);
            }
        }

        else if(choice == 2) {  // User Input
            System.out.print("Enter the matrix, enter 99 to go to the next tower: \n");
            for(int i = 0; i < n; i++) {
                ArrayList<Integer> a = new ArrayList<Integer>();
                towers.add(a);
            }
            for(int i = 0; i < n; ) {
                int x = sc.nextInt();
                if(x == 99) {       // If the input is -1, go to next tower
                    i++;
                    continue;
                }
                towers.get(i).add(x);
            }
        }

        else {
            System.out.println("Incorrect Input!");
        }

        // Printing the Towers
        for(int i = max_height; i > -1; i--) {  // Initialize i as the top floor
            for(int j = 0; j < towers.size(); j++) {    // Check all the towers for the floor
                try {
                    System.out.print(towers.get(j).get(i)); // If it exists, print it
                }
                catch(Exception e) {
                    System.out.print(" ");      // Else print a black
                }
                finally {
                    System.out.print("\t");
                }
            }
            System.out.println("");
        }

        for(ArrayList<Integer> i: towers) {         // Checking to see if the tower is rising or not
            for(int j = 0; j < i.size() - 1; j++) {
                if(i.get(j) > i.get(j + 1)) {   // If even 1 element isn't rising, the tower is not rising
                    System.out.println("The tower is not a rising tower!");
                    sc.close();
                    return;
                }
            }
        }
        System.out.println("The tower is a rising tower!");
        sc.close();
    }
}
package chapter8.FinancialTsunami;

import java.util.Arrays;
import java.util.Scanner;

public class FinancialTsunami {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of banks: ");
        int numOfBanks = input.nextInt();
        System.out.print("Enter minimum total assets: ");
        int limit = input.nextInt();
        double[] banksInitialBalances = new double[numOfBanks];
        double[] banksActualBalances = new double[numOfBanks];
        double[][] loans = new double[numOfBanks][numOfBanks];
        boolean[] safety = new boolean[numOfBanks];
        Arrays.fill(safety, true);
        getBanksInformation(banksInitialBalances, loans, input);
        do {
            updateBanksBalances(banksActualBalances, banksInitialBalances, loans, safety);
        } while (checkBanksSafety(banksActualBalances, safety, limit));
        printUnsafeBanks(safety);
    }    

    public static void getBanksInformation( double[] banksInitialBalances,
                                            double[][] loans,
                                            Scanner input) {
        for (int i = 0; i < banksInitialBalances.length; i++) {
            System.out.print("Enter information for bank " + i + ": ");
            banksInitialBalances[i] = input.nextDouble();
            int numOfLoans = input.nextInt();
            for (int j = 0; j < numOfLoans; j++) {
                int bank = input.nextInt();
                loans[i][bank] = input.nextDouble();
            }
        }
    }

    public static boolean checkBanksSafety( double[] banksActualBalances,
                                            boolean[] safety,
                                            int limit) {
        boolean changeSafety = false;
        for (int i = 0; i < safety.length; i++) {
            if (banksActualBalances[i] < limit && safety[i]) {
                safety[i] = false;
                changeSafety = true;
            }
        }
        return changeSafety;
    }

    public static void updateBanksBalances( double[] banksActualBalances,
                                            double[] banksInitialBalances,
                                            double[][] loans,
                                            boolean[] safety) {
        for (int i = 0; i < banksActualBalances.length; i++) {
            banksActualBalances[i] = banksInitialBalances[i];
            for (int j = 0; j < loans[i].length; j++) {
                if(safety[j]) {
                    banksActualBalances[i] += loans[i][j];
                }
            }
        }
    }

    public static void printUnsafeBanks(boolean[] safety) {
        int numOfUnsafe = checkNumOfUnsafeBank(safety);
        if (numOfUnsafe == 0) {
            System.out.print("There are no unsafe banks");
        }
        else if (numOfUnsafe == 1) {
            System.out.print("Unsafe bank is: ");
        }
        else {
            System.out.print("Unsafe bank " + (numOfUnsafe == 1 ? "is" : "are") + ": ");
        }
        for (int i = 0; i < safety.length; i++) {
            if (!safety[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static int checkNumOfUnsafeBank(boolean[] safety) {
        int unsafe = 0;
        for (boolean safe: safety) {
            if (!safe) {
                unsafe++;
            }
        }
        return unsafe;
    }
}
package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        int[] values = {400, 540, 120, 9, 550};

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();
            executeAction(scanner, action, values);
        }
    }

    private static void executeAction(Scanner scanner, String action, int[] values) {
        if (action.equals("remaining")) {
            remainingAction(values);
        } else if (action.equals("buy")) {
            buyAction(scanner, values);
        } else if (action.equals("fill")) {
            fillAction(values);
        } else if (action.equals("take")) {
            takeAction(values);
        } else {
            System.exit(0);
        }
    }

    private static void remainingAction(int[] values) {
        System.out.println("The coffee machine has:\n" +
                values[0] + " ml of water\n" +
                values[1] + " ml of milk\n" +
                values[2] + " g of coffee beans\n" +
                values[3] + " disposable cups\n" +
                "$" + values[4] + " of money");
    }

    private static void takeAction(int[] values) {
        System.out.println("I gave you " + values[4]);
        values[4] = 0;
    }

    private static void fillAction(int[] values) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        int waterQuantity = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int milkQuantity = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int coffeeBeansQuantity = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        int coffeeAmount = scanner.nextInt();

        values[0] = values[0] + waterQuantity;
        values[1] = values[1] + milkQuantity;
        values[2] = values[2] + coffeeBeansQuantity;
        values[3] = values[3] + coffeeAmount;
    }

    private static void buyAction(Scanner scanner, int[] values) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");

        String option = scanner.nextLine();
        try {
            if (Integer.valueOf(option) == 1) {
                if (values[0] >= 250 && values[2] >= 16 && values[3] > 0 && values[4] >= 4) {
                    System.out.println("I have enough resources, making you a coffee!");
                    values[0] = values[0] - 250;
                    values[2] = values[2] - 16;
                    values[3] = values[3] - 1;
                    values[4] = values[4] + 4;
                } else {
                    if (values[0] < 250) {
                        System.out.println("Sorry, not enough water!");
                    } else if (values[2] < 16) {
                        System.out.println("Sorry, not enough coffee beans");
                    } else if (values[3] <= 0) {
                        System.out.println("Sorry, not enough disposable cups");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                }
            } else if (Integer.valueOf(option) == 2) {
                if (values[0] >= 350 && values[1] >= 75 && values[2] >= 20 && values[3] > 0 && values[4] >= 7) {
                    System.out.println("I have enough resources, making you a coffee!");
                    values[0] = values[0] - 350;
                    values[1] = values[1] - 75;
                    values[2] = values[2] - 20;
                    values[3] = values[3] - 1;
                    values[4] = values[4] + 7;
                } else {
                    if (values[0] < 350) {
                        System.out.println("Sorry, not enough water!");
                    } else if (values[1] < 75) {
                        System.out.println("Sorry, not enough milk");
                    } else if (values[2] < 20) {
                        System.out.println("Sorry, not enough coffee beans");
                    } else if (values[3] <= 0) {
                        System.out.println("Sorry, not enough disposable cups");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                }
            } else {
                if (values[0] >= 200 && values[1] >= 100 && values[2] >= 12 && values[3] > 0 && values[4] >= 6) {
                    System.out.println("I have enough resources, making you a coffee!");
                    values[0] = values[0] - 200;
                    values[1] = values[1] - 100;
                    values[2] = values[2] - 12;
                    values[3] = values[3] - 1;
                    values[4] = values[4] + 6;
                } else {
                    if (values[0] < 200) {
                        System.out.println("Sorry, not enough water!");
                    } else if (values[1] < 100) {
                        System.out.println("Sorry, not enough milk");
                    } else if (values[2] < 12) {
                        System.out.println("Sorry, not enough coffee beans");
                    } else if (values[3] <= 0) {
                        System.out.println("Sorry, not enough disposable cups");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}

import java.util.*;

class Card {
    private String symbol;
    private int number;

    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Card{symbol='" + symbol + "', number=" + number + "}";
    }
}

public class CardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Card>> cardMap = new TreeMap<>(); 

        System.out.print("Enter number of cards: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("Enter card " + (i + 1) + " details:");
            System.out.print("Symbol: ");
            String symbol = scanner.nextLine();
            System.out.print("Number: ");
            int number = scanner.nextInt();
            scanner.nextLine(); 

            cardMap.putIfAbsent(symbol, new ArrayList<>());
            cardMap.get(symbol).add(new Card(symbol, number));
        }

        System.out.println("\nDistinct Symbols in Alphabetical Order:");
        for (String symbol : cardMap.keySet()) {
            List<Card> cards = cardMap.get(symbol);
            int sum = cards.stream().mapToInt(Card::getNumber).sum();
            System.out.println("Symbol: " + symbol);
            System.out.println("Cards: " + cards);
            System.out.println("Number of Cards: " + cards.size());
            System.out.println("Sum of Numbers: " + sum);
            System.out.println();
        }
        scanner.close();
    }
}

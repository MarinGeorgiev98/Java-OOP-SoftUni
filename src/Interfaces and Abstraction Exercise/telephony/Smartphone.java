package telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {
    List<String> numbers;
    List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String number : this.numbers) {
            for (char symbol : number.toCharArray()) {
                if (!Character.isDigit(symbol)) {
                    sb
                            .append("Invalid number!")
                            .append(System.lineSeparator());
                }
                else {
                    sb
                            .append("Calling... ")
                            .append(number)
                            .append(System.lineSeparator());
                }
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String URL : this.urls) {
            for (char symbol : URL.toCharArray()) {
                if (Character.isDigit(symbol)) {
                    sb
                            .append("Invalid URL!")
                            .append(System.lineSeparator());
                }
                else {
                    sb
                            .append("Browse: ")
                            .append(URL)
                            .append("!")
                            .append(System.lineSeparator());
                }
            }
        }
        return sb.toString().trim();
    }
}
package Тelephony05;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder browserSites = new StringBuilder();
        gerBrowserSites(browserSites);
        return browserSites.toString().trim();
    }

    private void gerBrowserSites(StringBuilder browserSites) {
        Pattern pattern = Pattern.compile("^([^0-9]+)$");

        for (String url : this.urls) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.find()) {
                browserSites.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            } else {
                browserSites.append("Invalid URL!").append(System.lineSeparator());
            }
        }
    }

    @Override
    public String call() {
        StringBuilder calledNumbers = new StringBuilder();
        getCalledNumbers(calledNumbers);
        return calledNumbers.toString().trim();
    }

    private void getCalledNumbers(StringBuilder calledNumbers) {
        Pattern pattern = Pattern.compile("^([0-9]+)$");

        for (String number : this.numbers) {
            Matcher matcher = pattern.matcher(number);
            if (matcher.find()) {
                calledNumbers.append("Calling... ").append(number).append(System.lineSeparator());
            } else {
                calledNumbers.append("Invalid number!").append(System.lineSeparator());
            }
        }
    }
}

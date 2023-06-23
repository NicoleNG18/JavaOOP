package com.company.Interfaces.Telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        setNumbers(numbers);
        setUrls(urls);
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {

            if (url.matches(("([^0-9]+)"))) {
                sb.append(String.format("Browsing: " + url + "!"))
                        .append(System.lineSeparator());

            } else {
                sb.append("Invalid URL!")
                        .append(System.lineSeparator());
            }

        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {

            if (number.matches("[0-9]+")) {
                sb.append(String.format("Calling... " + number))
                        .append(System.lineSeparator());

            } else {
                sb.append("Invalid number!")
                        .append(System.lineSeparator());
            }

        }
        return sb.toString();
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

}


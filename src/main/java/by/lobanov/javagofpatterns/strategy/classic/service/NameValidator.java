package by.lobanov.javagofpatterns.strategy.classic.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class NameValidator {
    private static final Pattern NAME_PATTERN =
            Pattern.compile("^[А-ЯЁ][а-яё]+(-[А-ЯЁ][а-яё]+)?\\s[А-ЯЁ][а-яё]+\\s[А-ЯЁ][а-яё]+$");

    public boolean isValid(String fullName) {
        return fullName != null && NAME_PATTERN.matcher(fullName).matches();
    }
}

package by.lobanov.javagofpatterns.strategy.enumfunction.strategy;

import by.lobanov.javagofpatterns.strategy.enumfunction.model.Document;

public enum DocumentType {
    PASSPORT {
        @Override
        public String process(Document document) {
            return "Верификация паспорта клиента " + document.getClientId() +
                    ". Данные сохранены в KYC систему.";
        }

        @Override
        public String generateArchivePath() {
            return "/archive/identity/";
        }
    },

    CONTRACT {
        @Override
        public String process(Document document) {
            return "Договор №" + document.getContent().hashCode() +
                    " подписан клиентом " + document.getClientId();
        }

        @Override
        public String generateArchivePath() {
            return "/archive/contracts/";
        }
    },

    STATEMENT {
        @Override
        public String process(Document document) {
            return "Выписка по счету клиента " + document.getClientId() +
                    " обработана. Сумма операций: " + document.getContent().length() + " руб.";
        }

        @Override
        public String generateArchivePath() {
            return "/archive/statements/";
        }
    };

    public abstract String process(Document document);
    public abstract String generateArchivePath();
}

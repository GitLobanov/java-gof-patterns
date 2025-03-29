package by.lobanov.javagofpatterns.strategy.classic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiometricData {
    private byte[] faceData;
    private byte[] voiceData;
    private byte[] fingerprints;
    private LocalDate verificationDate;
}

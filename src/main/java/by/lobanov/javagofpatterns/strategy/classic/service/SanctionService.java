package by.lobanov.javagofpatterns.strategy.classic.service;

import by.lobanov.javagofpatterns.strategy.classic.model.ClientProfile;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SanctionService {
    private final CacheManager cacheManager;

    private int cacheTtlSeconds;

    @Cacheable(value = "sanctionChecks", key = "{#profile.taxNumber, #profile.fullName}")
    public boolean checkSanctions(ClientProfile profile) {
        if (profile.isPep()) {
            return true;
        }

        if (checkInternalSanctions(profile)) {
            return true;
        }

        return true;
    }

    private boolean checkInternalSanctions(ClientProfile profile) {
        return true;
    }

    @CacheEvict(value = "sanctionChecks", allEntries = true)
    @Scheduled(fixedRateString = "${sanctions.cache.clear.interval:86400000}")
    public void clearCache() {
    }
}

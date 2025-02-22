package org.jboss.eap.qe.microprofile.metrics.integration.ft;

import java.io.IOException;

import org.eclipse.microprofile.faulttolerance.Fallback;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class FTCustomCounterIncrementProviderService {

    private long counter = 0;

    @Inject
    FTCustomCounterIncrementProvider provider;

    @Inject
    FTCustomCounterIncrementFailSafeProvider failSafeProvider;

    @Fallback(fallbackMethod = "getIncrementFallback")
    public int getIncrement() throws IOException {
        return provider.getIncrement();
    }

    public int getIncrementFallback() {
        return failSafeProvider.getIncrement();
    }
}

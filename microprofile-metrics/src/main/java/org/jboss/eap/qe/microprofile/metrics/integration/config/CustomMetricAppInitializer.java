package org.jboss.eap.qe.microprofile.metrics.integration.config;

import org.eclipse.microprofile.metrics.Metadata;
import org.eclipse.microprofile.metrics.MetadataBuilder;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.MetricType;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.RegistryType;

import jakarta.inject.Inject;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class CustomMetricAppInitializer implements ServletContextListener {

    @Inject
    CustomCounterMetric customMetric;

    @Inject
    @RegistryType(type = MetricRegistry.Type.APPLICATION)
    MetricRegistry metricRegistry;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Metadata metadata = new MetadataBuilder()
                .withName("custom-metric")
                .withType(MetricType.COUNTER)
                .withUnit(MetricUnits.NONE)
                .build();
        metricRegistry.register(metadata, customMetric);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

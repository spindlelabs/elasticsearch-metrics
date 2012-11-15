package com.spindle.elasticsearch.metrics;

import org.elasticsearch.common.inject.AbstractModule;

public class MetricsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MetricsService.class).asEagerSingleton();
    }
}

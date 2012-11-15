package com.spindle.elasticsearch.metrics;

import org.elasticsearch.common.collect.Lists;
import org.elasticsearch.common.component.LifecycleComponent;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.plugins.AbstractPlugin;

import java.util.Collection;

public class MetricsPlugin extends AbstractPlugin {

    private final Settings settings;

    public MetricsPlugin(Settings settings) {
        this.settings = settings;
    }

    @Override
    public String name() {
        return "metrics";
    }

    @Override
    public String description() {
        return "Metrics Plugin";
    }

    @Override
    public Collection<Class<? extends Module>> modules() {
        Collection<Class<? extends Module>> modules = Lists.newArrayList();
        if (settings.getAsBoolean("spindle.elasticsearch.metrics.enabled", false)) {
            modules.add(MetricsModule.class);
        }
        return modules;
    }

    @Override
    public Collection<Class<? extends LifecycleComponent>> services() {
        Collection<Class<? extends LifecycleComponent>> services = Lists.newArrayList();
        if (settings.getAsBoolean("spindle.elasticsearch.metrics.enabled", false)) {
            services.add(MetricsService.class);
        }
        return services;
    }
}

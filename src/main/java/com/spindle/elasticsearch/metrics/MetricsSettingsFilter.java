package com.spindle.elasticsearch.metrics;

import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.SettingsFilter;

public class MetricsSettingsFilter implements SettingsFilter.Filter {
    @Override
    public void filter(ImmutableSettings.Builder settings) {
        settings.remove("metrics.graphite.hostname");
        settings.remove("metrics.graphite.port");
        settings.remove("metrics.graphite.prefix");
        settings.remove("metrics.graphite.report_interval");
        settings.remove("metrics.stats.indices");
    }
}

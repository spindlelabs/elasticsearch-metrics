`elasticsearch-metrics`
=======================

`elasticsearch-metrics` integrates [Metrics](http://metrics.codahale.com/) with [elasticsearch](http://www.elasticsearch.org/) and [Graphite](http://graphite.wikidot.com).

At [Spindle](https://spindle.com/), we're using `elasticsearch-metrics` with [`check_graphite.py`](https://github.com/spindlelabs/nagios-plugins) to monitor our production elasticsearch clusters.

Currently, `elasticsearch-metrics` reports:

 * [JVM metrics](http://metrics.codahale.com/maven/metrics-core/apidocs/com/yammer/metrics/core/VirtualMachineMetrics.html) including thread counts, memory usage, uptime, and GC time.
 * [`log4j` metrics](http://metrics.codahale.com/manual/log4j/) including warning and error message rates.
 * The document count for selected indices.

It's easy to hack `elasticsearch-metrics` to gather additional metrics: edit `MetricsService.java`.

To generate a plugin archive:

    $ mvn package

Copy the contents of `target/releases/elasticsearch-metrics-1.0.0-SNAPSHOT.zip` to the `plugins/elasticsearch-metrics` directory.

Then, configure the plugin:

    spindle.elasticsearch.metrics.enabled: true
    spindle.elasticsearch.metrics.graphite.hostname: graphite.example.com
    spindle.elasticsearch.metrics.graphite.port: 2003
    spindle.elasticsearch.metrics.graphite.report_interval: 1m
    spindle.elasticsearch.metrics.graphite.prefix: elasticsearch
    spindle.elasticsearch.metrics.stats.indices: foo, bar, baz

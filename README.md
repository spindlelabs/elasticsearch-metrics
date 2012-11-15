elasticsearch-metrics
=====================

elasticsearch-metrics integrates [Metrics](http://metrics.codahale.com/) with [elasticsearch](http://www.elasticsearch.org/).

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

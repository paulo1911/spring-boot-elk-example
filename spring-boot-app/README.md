# spring-boot-elk-example
projeto de exemplo Spring Boot com Elastic Searc, LogStash e Kibana 


#### On the command line

Create an index pattern via the Kibana API:

```console
$ curl -XPOST -D- 'http://localhost:5601/api/saved_objects/index-pattern' \
    -H 'Content-Type: application/json' \
    -H 'kbn-version: 6.2.3' \
    -d '{"attributes":{"title":"logstash-*","timeFieldName":"@timestamp"}}'
```
(ns crux-bench.config
  (:import org.rocksdb.util.SizeUnit))


(def index-dir "data/db-dir")
(def log-dir "data/eventlog")

(def ^:private default-block-cache-size (* 10 SizeUnit/MB))
(def ^:private default-block-size (* 16 SizeUnit/KB))


(def crux-options
  {:kv-backend "crux.kv.rocksdb.RocksKv"
   :bootstrap-servers "kafka-cluster2-kafka-bootstrap.crux:9092"
   :event-log-dir log-dir
   :db-dir index-dir
   :tx-topic "crux-bench-transaction-log"
   :doc-topic "crux-bench-docs"
   :server-port 8080})

(def secret-password
  "bcrypt+sha512$ad3066f667bdcfa2a9e0fbc79710bfdb$12$aabc70396ad92c1147f556105c8acda0c17a6f231b85c658")

(def supported-backends [:crux])

(def query-timeout-ms 15000)

(def datomic-tx-size 100)

(def watdiv-tests
  {"watdiv/data/watdiv-stress-100/warmup.1.desc" "watdiv/data/watdiv-stress-100/warmup.sparql"
   "watdiv/data/watdiv-stress-100/test.1.desc" "watdiv/data/watdiv-stress-100/test.1.sparql"
   "watdiv/data/watdiv-stress-100/test.2.desc" "watdiv/data/watdiv-stress-100/test.2.sparql"
   "watdiv/data/watdiv-stress-100/test.3.desc" "watdiv/data/watdiv-stress-100/test.3.sparql"
   "watdiv/data/watdiv-stress-100/test.4.desc" "watdiv/data/watdiv-stress-100/test.4.sparql"})

(defproject jcrit "0.1.0-SNAPSHOT"
            :description "Animal reservation system"
            :dependencies [[org.clojure/clojure "1.2.1"]
                           [org.clojure/clojure-contrib "1.2.0"]
                           [postgresql/postgresql "8.4-702.jdbc4"]
                           [org.clojure/java.jdbc "0.0.3"]
                           [enlive "1.0.0"]
                           [noir "1.0.0"]]
            :main jcrit.server)


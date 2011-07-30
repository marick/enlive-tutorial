(ns jcrit.db
  (:require [clojure.java.jdbc :as sql]))

(def db {:classname "com.postgresql.Driver"
         :subprotocol "postgresql"
         :subname "//localhost:5432/jcrit"})
  

(defn create-animal-table []
  (sql/with-connection db
    (sql/create-table :animals
                      [:id "serial" "NOT NULL"]
                      [:official_name "text"]
                      [:nickname      "text"]
                      [:extra_display_info "text"]
                      [:added_to_service "date"]
                      [:removed_from_service "date"]
                      [:notes "text"]
                      ["CONSTRAINT" "animals_pkey" "PRIMARY KEY (id)"])))
     

(defproject clojure-web-server "0.1.0-SNAPSHOT"
  :description "A tiny clojure web server"
  :url ""
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/mit"}
  :dependencies [
                 [org.clojure/clojure "1.8.0"]
                 [ring "1.4.0"]
                 [compojure "1.3.4"]]
  :min-lein-version "2.0.0"
  :uberjar-name "lil.jar"
  :main clojure-web-server.core
  :profiles {
             :dev
             {:main clojure-web-server.core/-dev-main}}
  )

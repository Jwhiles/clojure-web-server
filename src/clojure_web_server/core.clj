(ns clojure-web-server.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.handler.dump :refer [handle-dump]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]])
  )


(defn welcome
  "a basic handler function"
  [request]
  {:status 200
   :body "<h1>my first page</h1>"
   :headers {}})

(defn hello
  "for saying hello"
  [request]
  (let [name (get-in request [:route-params :name])]
    {:status 200
     :body (str "<h1> hello " name "</h1>")
     :headers {}}))


(defroutes app
  (GET "/" [] welcome)
  (GET "/hello/:name" [] hello)
  (GET "/request-info" [] handle-dump)
  (not-found "<h1> nothing here </h1>"))

(defn -main
  " a little web server"
  [port-number]
  (jetty/run-jetty
    app
    {:port (Integer. port-number)}))

(defn -dev-main
  "dev version of the server - with hot reloading"
  [port-number]
  (jetty/run-jetty (wrap-reload #'app)
                   {:port (Integer. port-number)}))


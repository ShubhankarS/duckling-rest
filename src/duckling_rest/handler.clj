(ns duckling-rest.handler
  (:gen-class)
  (:use compojure.core ring.middleware.json)
  (:require [compojure.handler :as handler])
  (:require
    [duckling.core :as p]
    [duckling.time.obj :as time]
  )
  (:require
  	[compojure.route :as route]
    [ring.adapter.jetty :refer :all]
  )
  (refer-clojure :exclude [merge partial iterate format print contains? max min])
  (:use joda-time)
)

(def fmt (formatter "yyyy-MM-dd HH:mm:ss:SSSZ" :date-time (formatter :date)))

(defn parse-all [text-to-parse]
  (p/parse :en$core text-to-parse)
)

(defn parse-time [text-to-parse]
  (p/parse :en$core text-to-parse [:time])
)

(defn parse-time-with-reference [text-to-parse, reference-time]
  (p/parse :en$core text-to-parse [:time] {:reference-time {:start (parse-date-time fmt reference-time) :grain :second}})
)

(defn parse-number [text-to-parse]
  (p/parse :en$core text-to-parse [:number])
)

(defn parse-number-like [text-to-parse]
  (p/parse :en$core text-to-parse [:number :ordinal])
)

(defn parse-ordinal [text-to-parse]
  (p/parse :en$core text-to-parse [:ordinal])
)

(defn parse-duration [text-to-parse]
  (p/parse :en$core text-to-parse [:duration])
)

(defroutes app-routes
  (GET "/parse/all/:text" [text] (parse-all text))
  (GET "/parse/time/:text" [text] (parse-time text))
  (GET "/parse/number/:text" [text] (parse-number text))
  (GET "/parse/number-like/:text" [text] (parse-number-like text))
  (GET "/parse/ordinal/:text" [text] (parse-ordinal text))
  (GET "/parse/duration/:text" [text] (parse-duration text))

  (POST "/parse/all" {:keys [params]} (let [{:keys [text]} params] (parse-all text)))
  (POST "/parse/time" {:keys [params]} (let [{:keys [text]} params] (parse-time text)))
  (POST "/parse/time-with-reference" {:keys [params]} (let [{:keys [text, reference-time]} params] (parse-time-with-reference text reference-time)))
  (POST "/parse/number" {:keys [params]} (let [{:keys [text]} params] (parse-number text)))
  (POST "/parse/number-like" {:keys [params]} (let [{:keys [text]} params] (parse-number-like text)))
  (POST "/parse/ordinal" {:keys [params]} (let [{:keys [text]} params] (parse-ordinal text)))
  (POST "/parse/duration" {:keys [params]} (let [{:keys [text]} params] (parse-duration text)))
  (route/not-found "Not Found")
)

(def app
      (-> (handler/api app-routes)
        (wrap-json-body)
        (wrap-json-params)
        (wrap-json-response))
)

(defn -main [& args]
  (p/load!)
  (run-jetty app {:port 9000}))


; :dim  examples
; temperature   “70°F”
; “72° Fahrenheit”
; “thirty two celsius”
; “65 degrees”
; distance  “8miles”
; “3 feet”
; “2 inches”
; “3’’“
; “4km”
; “12cm”
; volume  “250ml”
; “2liters”
; “1 gallon”
; amount-of-money   “ten dollars”
; “4 bucks”
; “$20”
; email   “help@wit.ai”
; url   “http://wit.ai”
; “www.foo.com:8080/path”
; “https://myserver?foo=bar”
; “cnn.com/info”
; “foo.com/path/path?ext=%23&foo=bla”
; “localhost”
; phone-number  “415-123-3444”
; “+33 4 76095663”
; “(650)-283-4757 ext 897”
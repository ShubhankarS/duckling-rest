(defproject duckling-rest "0.1.3-SNAPSHOT"
  ; ...project settings...

  :plugins [[lein-ring "0.12.6"]]

  :dependencies [
	  [org.clojure/clojure "1.11.4"]
	  [wit/duckling "1.2.0-SNAPSHOT"]
	  [ring/ring-core "1.9.5"]
	  [ring/ring-jetty-adapter "1.9.5"]
	  [compojure "1.6.3"]
	  [cheshire/cheshire "5.11.0"]
	  [ring/ring-json "0.5.1"]
	  [clj-time "0.15.2"]
    [clojure.joda-time "0.7.0"]
  ]

  :main duckling-rest.handler
  
  :ring {:handler duckling-rest.handler/app
         :nrepl {:start? true
                 :port 9998}}
  :profiles {
    :uberjar {:aot :all}
    :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}}
  :jvm-opts ["-Xmx500m"]
)
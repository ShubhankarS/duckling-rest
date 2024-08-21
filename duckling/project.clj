(defproject wit/duckling "1.2.0-SNAPSHOT"
  :description "Date & Number parser"
  :license {:url "https://github.com/wit-ai/duckling"
            :comments "see LICENSE"}
  :url "https://github.com/wit-ai/duckling"
  :plugins [[s3-wagon-private "1.1.2"]
            [lein-midje "3.1.3"]]
  :repl-options {:init-ns duckling.core}
  :dependencies [[org.clojure/clojure "1.11.4"]
                 [org.clojure/tools.nrepl "0.2.13"]
                 [org.clojure/tools.logging "1.3.0"]
                 [clj-time "0.15.2"]
                 [prismatic/plumbing "0.6.0"]]
  :deploy-repositories [["clojars" {:creds :gpg}]]
  :profiles {:dev {:dependencies [[org.clojure/tools.trace "0.7.6"]
                                  [midje "1.6.3"]
                                  [cheshire "5.3.1"]]}
             :uberjar {:aot [duckling.core]}}
  :test-selectors {:default (complement :benchmark)
                   :benchmark :benchmark}
  :scm {:name "git"
        :url "https://github.com/wit-ai/duckling"}
  :pom-addition [:developers [:developer
                               [:name "Wit.ai"]
                               [:url "https://wit.ai"]
                               [:email "contact@wit.ai"]]])

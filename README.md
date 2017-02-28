#duckling-rest

A REST enabled version of the [Duckling project](https://github.com/wit-ai/duckling) by [Wit.ai](https://wit.ai) with some extensions

To compile and run:

  1) Install lein as in the link : [https://github.com/technomancy/leiningen](https://github.com/technomancy/leiningen)

  2) To use the local (extended) version of duckling, go into the duckling folder in the project and run `lein jar` to generate a snapshot of the duckling project and then run `lein install` to install this this jar as a local dependency.
  
  3) In case you want to use a non extended version of the duckling project, replace `[wit/duckling "1.0.85-SNAPSHOT"]` in `project.clj` (present in the main directory of the repository) with `[wit/duckling "0.4.23"]` or the latest version from the [Duckling project](https://github.com/wit-ai/duckling)
  
  4) Back in the main project directory, run `lein deps` to download dependencies;
  
  5) In the main project directory, run `lein run` to test it out or `lein uberjar` to generate a standalone jar
  
  6) Run the jar with the following command: `java -Xms256m -Xmx512m -Djava.awt.headless=true -jar target/standalone.jar` (customise the Xms and Xmx memory options based on system capabilities)
  
  7) The server should be accessible on port 9000

GET API's:
	
	1) GET "/parse/all/:text"
	2) GET "/parse/time/:text"
	3) GET "/parse/number/:text"
	4) GET "/parse/ordinal/:text"
	5) GET "/parse/duration/:text"

POST API's:
	
	1) POST "/parse/all"
	2) POST "/parse/time"
	3) POST "/parse/number"
	4) POST "/parse/ordinal"
	5) POST "/parse/duration"
	
	with JSON request body as: {text:"text"}
	

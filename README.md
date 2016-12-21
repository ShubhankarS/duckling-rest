#duckling-rest

A REST enabled version of the Duckling project by Wit.ai with some extensions

To compile and run:

	1) Install lein as in the link : https://github.com/technomancy/leiningen

	2) Go into the ducklign folder int the project and run "lein jar" to generate a snapshot of the ducklign project

	3) Back in the main project directory, run "lein deps" to download dependencies;

	3) In the main project directory, run "lein run" to test it out or "lein uberjar" to generate a standalone jar

	4) Run the jar with the following command: "java -Xms256m -Xmx512m -Djava.awt.headless=true -jar target/standalone.jar" (customise the Xms and Xmx memory options based on system capabilities)

	5) The server should be accessible on port 9000

API's:
	
	1) GET "/parse/all/:text"
	2) GET "/parse/time/:text"
	3) GET "/parse/number/:text"
	4) GET "/parse/ordinal/:text"
	5) GET "/parse/duration/:text"

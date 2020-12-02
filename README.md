# Zipkin Setup
docker pull openzipkin/zipkin  
docker run -d -p 9411:9411 openzipkin/zipkin

open http://localhost:9411/zipkin/

# Run Applications
Run TechJam1 & TechJam2 as applications.
hit http://localhost:8080/app1/ ( should see welcome to Techjam message)

# distra

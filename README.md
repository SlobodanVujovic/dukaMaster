# Build
mvn clean package && docker build -t com.vujo/DukaMaster .

# RUN

docker rm -f DukaMaster || true && docker run -d -p 8080:8080 -p 4848:4848 --name DukaMaster com.vujo/DukaMaster 
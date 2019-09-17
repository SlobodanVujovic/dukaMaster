FROM airhacks/glassfish
COPY ./target/DukaMaster.war ${DEPLOYMENT_DIR}

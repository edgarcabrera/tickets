FROM airhacks/glassfish
COPY ./target/tikets.war ${DEPLOYMENT_DIR}

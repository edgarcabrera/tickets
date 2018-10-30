# Build
mvn clean package && docker build -t gt.com.kinal/tikets .

# RUN

docker rm -f tikets || true && docker run -d -p 8080:8080 -p 4848:4848 --name tikets gt.com.kinal/tikets "# tickets" 

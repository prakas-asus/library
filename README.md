# 1. Tata cara menjalankan project
## Untuk configurasi swagger sudah menggunakan swaggerconfig
    berikut : alamat swagger (http://localhost:8080/swagger-ui/index.html#/)
## buatkoneksi docker terlebih dahulu
    docker network create backend
## Membuat Database menggunakan Docker
    docker run -itd --network=backend -d -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=admin -d postgres
    Untuk saat ini tidak perlu running database terlebih dahulu karena sudah di buat docker yaml
# Catatan untuk membuka dengan "docker compose" harap buka menggunakan url 
    http://localhost/swagger-ui/index.html#/
## hal ini dikarenakan port diubah menggunakan nginx
## Untuk deploy menggunakan docker compose
    docker-compose up -d --build
## Untuk menghapus container, database dan service melalui docker compose
    docker-compose down
## untuk build image menggunakan docker
    docker build -t app:1.0 .
## untuk running images ke container docker
    docker run -itd --network=backend -d -p 8080:8080 --name app_1 -d app:1.0
## Project ini dapat dijalankan dengan menggunakan perintah :
    ./mvnw spring-boot:run
# 2. Belajar forwarding port agar bisa di akses keluar internet
## port disamakan dengan port terakhir
    - ssh -R 80:localhost:80 serveo.net
# 3. buat dalam satu jaringan elastic dan kibana
    docker network create elastic-net
# 4. elasticsearch
## install elasticsearch
  docker run -d --name elasticsearch \
  --network elastic-net \
  -p 9200:9200 -p 9300:9300 \
  -e discovery.type=single-node \
  -e xpack.security.enabled=false \
  -e ES_JAVA_OPTS="-Xms1g -Xmx1g" \
  -v esdata:/usr/share/elasticsearch/data \
  docker.elastic.co/elasticsearch/elasticsearch:8.15.0
# 5. kibana
## install kibana
  docker run -d --name kibana \
  --network elastic-net \
  -p 5601:5601 \
  -e ELASTICSEARCH_HOSTS=http://elasticsearch:9200 \
  docker.elastic.co/kibana/kibana:8.15.0


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
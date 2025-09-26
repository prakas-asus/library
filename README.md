# 1. Tata cara menjalankan project
## Untuk configurasi swagger sudah menggunakan swaggerconfig
    berikut : alamat swagger (http://localhost:8080/swagger-ui/index.html#/)
## Membuat Database menggunakan Docker
    docker network create backend
    docker run -itd --network=backend -d -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=admin -d postgres
    Untuk saat ini tidak perlu running database terlebih dahulu karena sudah di buat docker yaml
## Untuk deploy menggunakan docker compose
    docker-compose up -d --buil
## Untuk menghapus container, database dan service
    docker-compose down
## Project ini dapat dijalankan dengan menggunakan perintah :
    ./mvnw spring-boot:run.

# 2. Belajar forwarding port agar bisa di akses keluar internet
## port disamakan dengan port terakhir
    - ssh -R 80:localhost:80 serveo.net
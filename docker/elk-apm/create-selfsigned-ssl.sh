#!/bin/bash -e
mkdir tmp/ | true
openssl genrsa -out tmp/selfsigned.key 2048
openssl req -new -key tmp/selfsigned.key -out tmp/selfsigned.csr
openssl x509 -req -days 365 -in tmp/selfsigned.csr -signkey tmp/selfsigned.key -out tmp/selfsigned.crt
cat tmp/selfsigned.key tmp/selfsigned.crt > ssl.pem
rm -rf tmp/

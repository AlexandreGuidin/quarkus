#!/bin/bash

cd src/main/resources/keys
rm -rf *
openssl genrsa -out rsa_private_key.pem 2048
openssl rsa -pubout -in rsa_private_key.pem -out public_key.pem
openssl pkcs8 -topk8 -nocrypt -inform pem -in rsa_private_key.pem -outform pem -out private_key.pem
rm -rf rsa_private_key.pem

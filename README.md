# Spring security com o novo `jwt-nimbus` sugerido pelo spring.

>Esse projeto segue o seguinte tutorial: https://www.danvega.dev/blog/2022/09/06/spring-security-jwt/


&nbsp;
### Comandos `openssl` para gerar as keys:

> no _macOs_ o `openssl` já vem instalado por padrão.

- criar rsa key pair
```shell
openssl genrsa -out keypair.pem 2048
```

- extrair public key
```shell
openssl rsa -in keypair.pem -pubout -out public.pem
```

- criar a key privada no formato PKCS#8
```shell
openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem
```
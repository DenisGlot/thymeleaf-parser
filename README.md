# Thymeleaf parser
Opens http endpoint where in request you can send 
a thymeleaf template and needed variables for thymeleaf context
and it returns parsed html

### curl 
`curl localhost:8080 -F "params={\"yourVar\":\"Awesome\"}" -F file=@/path/youtTemplate.html`

### dockerhub
denisgl/thymeleaf-parser:1.0
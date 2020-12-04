# Lagom scala CORS example


`sbt runAll`



```bash
curl -H "Access-Control-Request-Method: GET" \
        -H "Access-Control-Request-Headers: origin, x-requested-with" \
        -H "Origin: http://my-domain.com"  \
        -X OPTIONS http://localhost:53713/api/hello/123 -v        | head -30
```
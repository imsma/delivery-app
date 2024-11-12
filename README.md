chmod +x run-all.sh

```
docker-compose up -d
```

Test the PostgreSQL connection

```
docker exec -it postgres psql -U delivery_admin -d food_delivery
```

- Order Service
- Show Menu
  - Create an Order

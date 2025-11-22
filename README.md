# Shop / Storefront

## Overview
The Shop module is a minimal storefront API that interacts with the **ERP system**. It exposes product listing and order checkout endpoints for frontend consumption.

## Features
- List all products from ERP
- View single product details
- Checkout / create orders via ERP
- Minimal, stateless API

## Tech Stack
- Java 21
- Spring Boot 3.x
- Maven
- RestTemplate for ERP integration

## Setup & Run
1. Configure ERP base URL in `ShopService` (default: http://localhost:8080/api)
2. Build and run:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Endpoints
| Resource | Endpoint | Method |
|----------|----------|--------|
| Products | /shop/products | GET |
| Product | /shop/products/{id} | GET |
| Checkout | /shop/checkout | POST |

**Example Checkout Request**
```json
{
  "items": [
    {"productId": "uuid1", "quantity": 2},
    {"productId": "uuid2", "quantity": 1}
  ]
}
```

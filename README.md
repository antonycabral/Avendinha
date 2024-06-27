#diagrama de classes do projeto 

```mermaid
classDiagram
    class Market {
        +Long id
        +String name
        +String email
        +String password
        +List~Item~ items
        +List~Order~ orders
    }

    class Customer {
        +Long id
        +String name
        +String email
        +String password
        +Cart cart
        +List~Order~ orders
    }

    class Item {
        +Long id
        +String name
        +Double price
        +Market market
    }

    class Cart {
        +Long id
        +Customer customer
        +List~Item~ items
        +Double totalPrice
    }

    class Order {
        +Long id
        +Customer customer
        +List~Item~ items
        +Double totalPrice
        +String paymentMethod
        +String deliveryMethod
        +Market market
    }

    Market "1" -- "0..*" Item : manages
    Market "1" -- "0..*" Order : receives
    Customer "1" -- "1" Cart : Possui
    Cart "1" -- "0..*" Item : contains
    Customer "1" -- "0..*" Order : places
    Order "0..*" -- "0..*" Item : contains

```

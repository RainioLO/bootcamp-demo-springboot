## Summary
- Interface (Controller & Service Layer)
  - Controller (XXXOperation.java) -> @GetMapping
- static variable -> similar to database (application 7 x 24)
  - You will lost the data after the restart the app

RDB
- ABC: id:1 -> stock: 100

- Thread 1: select stock:100 -> update ABC set stock = stock - 1 where id = 1 and stock = 100;
return 1

if return value = 1
  send email to customer confirm order

- Thread 2: 100 -> update ABC set stock = stock - 1 where id = 1 and stock = 100;
return 0

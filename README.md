# Assignment
 Ecart-Assignment of CRUD
 
## Step 1: Install Database 
 ```
 CREATE DATABASE `omnicuris` /*!40100 DEFAULT CHARACTER SET latin1 */;
```
## Step 2: Run JAR (tomcat port :8080)

## Step 3: CRUD for Product in PostMan

### Post for Data in Product 

```
 POST: http://localhost:8080/product/addproduct
 
 JSON Input
 {
    "product_Id":"4",
    "product_name":"Product 4",
    "product_quantity":"5"
    
}
```

### Read Data from Product 

```
Get :  http://localhost:8080/product/getAll
```

### Update Data from Product
```
PUT:  http://localhost:8080/product/update/3

json input 
 {
   "product_Id": 3,
   "product_name": "New Product",
   "product_quantity": 4
 }
```


### Delete Data from Product

```
delete with ID : 4
Delete:  http://localhost:8080/product/delete/4
```

## Step 4 User Purchase

### Single Order

```
POST:  http://localhost:8080/user/buy

json input
{
    
    "email":"abc@gmail",
    "name":"alpha",
    "products":[
   {
    "product_Id":"2",
    "product_name":"Product 2",
    "product_quantity":"1"  
  
    
}
    ]

}

```

### Bulk Order

```
POST: http://localhost:8080/user/buy
json input

{
    
    "email":"abc@gmail",
    "name":"alpha",
    "products":[
   {
    "product_Id":"2",
    "product_name":"Product 2",
    "product_quantity":"1"  
  
    
},
{
    "product_Id":"1",
    "product_name":"Product 1",
    "product_quantity":"2"  
  
    
}
    ]

}
```

### Quantity more than available quantity 

Will return a message
 Prodocut not available  Product 1
 
 
### Get All the Orders

```
Get:  http://localhost:8080/user/allOrders
```

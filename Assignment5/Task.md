# Floor Stores Inc.
## _Software Design Document of the application_

1. Primarily, there are two types of users in the system
    -   Users
    -   Employees

    Users perform operations like searching products or searching the stores, whereas employees perform operations related to prdouct management.
    So, I created an Enum called UserType, which will have values ```User``` and ```Employee```

2. Related to store management, I defined the following entities
    - StoreManager
    - Store
    - StoreItem

    StoreManager entity manages all the stores present. It has operations like ```addStore```, ```getAllProducts``` in a store. It contains all the stores present. ```List<Store>```

    Store entity will have ```storeId``` and ```List<StoreItems>```. It has store related operations.

    Each ```StoreItem``` will represent a product and the area in sqft that is present in the store, hence it has
attributes ```product``` and ```areaInSquareFeet```

    All the stores and what products each store contains will be saved into a database, hence I created these entities

3. I defined ```SearchManager```, this will interact with the floor database and has operations like, ```saearchByName```, ```filterByCategory``` etc. User can interact with ```SearchManager``` to perform these operations.
4. Employee interacts with the ```ProductManager``` and saves, edits or deletes the products, and these operations will be reflected in the product database.

5. Product database will contain the information about which store has which products, and each product contains the ```productId```,```categoryId```,```storeId```
6. Floor Database will contain multiple tables
    - Floor
    - Category
    - Type
    - Species
    
    As there is a relation between category-type and category-species, I defined seperate entities, for this, so that
    ```one-to-one``` and ```one-to-many``` relationships can be represented effectively.
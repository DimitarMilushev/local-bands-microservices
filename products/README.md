Managing products is not simply about maintaining a list of products. You also have to manage the inventory, discounts, categories, and other attributes of the products. So, always focus on simplifying the data structure while reducing duplicates. In the above table structure, the main product table contains information about the products.

There are two other separate tables called discount, product_inventory, and product_category that are connected to it through database relationships. This approach provides the greatest level of flexibility to the database. For instance, we can simply query the product_inventory table to check for inventory without going through all the data associated with other related tables. This is also a good place to utilize indexes to increase the performance of the database.

An example schema from Dev.to:
![Example schema](
https://res.cloudinary.com/practicaldev/image/fetch/s--_dI5c3Xv--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_880/https://resources.fabric.inc/hs-fs/hubfs/product-management-ecommerce-table-4.png%3Fwidth%3D618%26name%3Dproduct-management-ecommerce-table-4.png
)


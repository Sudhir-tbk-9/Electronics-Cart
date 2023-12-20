# Electronics-Cart
# Electric Cart Management System

This Java project implements an Electric Cart Management System that allows users to add electronic devices to their cart, perform various operations, and view the cart's contents. The system handles exceptions such as duplicate products, input mismatches, and provides discounts for certain conditions.

## ElectricCart Class

### Overview
The `ElectricCart` class represents an electronic device in the cart. It includes attributes such as ID, category, brand, price, and charging type. The class also provides methods to retrieve the price, ID, and a formatted string representation of the device.

## DuplicateException Class

### Overview
The `DuplicateException` class extends the `Exception` class and is thrown when duplicate products are found in the cart. It includes a constructor to display a warning message.

## ElectronicCartController Class

### Overview
The `ElectronicCartController` class serves as the main controller for the Electric Cart Management System. It allows users to add electronic devices to their cart, view the cart, and perform various operations. The class includes methods for selecting device categories, charging types, displaying the cart, finding the product with the lowest price, finding products with the same price, and checking for duplicate items.

### Usage
1. Users input the number of devices they want to add to the cart.
2. For each device, users input details such as ID, category, brand, price, and charging type.
3. Discounts are applied based on the price.
4. Users can view their cart and perform operations such as finding the lowest-priced product, finding products with the same price, and checking for duplicate items.
5. The system handles exceptions and provides warnings for duplicate products.

## License
This project is open-source and available under the [MIT License](LICENSE). Feel free to use, modify, and distribute the code.

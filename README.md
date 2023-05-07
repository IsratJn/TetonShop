# Automation of TetonShop Website

It contains and complete workflow of a new user from landing on website -> login -> Add a certain product to cart -> go to cart -> go to checkout -> Selecting shipping
information(home delivery) -> creating new address -> go to payment method page(COD) -> place order -> go to All Orders page ->getting the first orderIdNo -> go to edit orders page 
-> canceling the first order.

I have implemented **Page Object Model(POM)** design pattern.
It includes testng assertions.
All the variables were read from **JSON** file using **Data Provider Annotation**.
It also includes **Report** with screenshots.
![Test Report](https://user-images.githubusercontent.com/42838747/236707811-32ad40e4-a27f-42c3-943c-a7d72ba6996a.png)
![Failed TestCase(SS)](https://user-images.githubusercontent.com/42838747/236707815-ace03d1f-8b47-4d40-afa4-84043643283a.png)

# **Currency Conversion Application** 🪙🪙

## **Main Aim** 
  🔸Provide users with real-time and accurate currency
conversion rates using Excange-Rates open source APIs.supports range of currencies and offer a
user-friendly interface .

## **Platforms we support**
  🔸Web
  🔸Android
  🔸IOS

## **Project Hierarchy**

![image](https://github.com/mahmoudmatar01/BM_Graduation_Project/assets/116927809/d0bc96a8-5082-45d1-ad2e-f6980e4e3a7a)


# **Main Services & Functionalities**
   🔹Conversion Sector : Enable user to convert between amount of money from one base currency to another target currency he needs.
   
   🔹Compare Sector : Enable User to compare between amount of money of one base Currency to another pair Currencies at the same time.
   
   🔹Add to Favourites Sector : Enable user to add Currencies to his favorite screen according to his interest.
   
   🔹Live-Exchange rate for Currencies according to one base currency 


# **📌Technical Sector**
   🔹Excetion Handling is provided to handle any errors.
   
   🔹Unit tests are provided to Test Functionalities.

   🔹Using Actuators to check application health

   🔹Loggers to facilitate tracking and error handling 

   🔹In-Cache Memory is applied 

   🔹Scheduler to update the cache memory every ONE HOUR to make sure of that live exchange rates are applied.

   🔹Easy to add/remove currencies , as we Scalibility is from our app priorities

   🔹**Design Patterns**: a)Builder Design Pattern    --> in Models
                          b)Singleton Design Pattern  --> in Helper & Logger

   🔹Enums and Constants to ease the work & clean the code.

   🔹Using Mappers and Helpers 

   🔹Utilizing Docker, as Our App ensures cross-platform compatibility.





# **Our APIs**

![image](https://github.com/mahmoudmatar01/BM_Graduation_Project/assets/116927809/7bf6ec45-94cb-432a-931e-58f31c790222)

### Request and Response of Each one :

 ### 🔸A backend "currencies-info/currencies" EndPoint:  

   **-Type:** GET
   
   **-Request Body:** No Parameters

   **-Response Body:**
        ![image](https://github.com/mahmoudmatar01/BM_Graduation_Project/assets/116927809/400ddfda-9922-4467-9d15-e88b983e7475)



  ### 🔸A backend "currencies-conversion/currency-conversion" EndPoint:
  
   **-Type:** GET
   
   **-Request:** Base Currency: USD,
                Target Currency: AED,
                Amount: 200
                
  **-Response Body:**
      ![image](https://github.com/mahmoudmatar01/BM_Graduation_Project/assets/116927809/a63b713c-b841-4b9b-bb80-6de9d2210bd3)




  ### 🔸A backend exchange-rate/currency-exchangeRate EndPoint:

  **-Type:** GET
  
  **-Request:** AED
  
  **-Response Body:**
        ![image](https://github.com/mahmoudmatar01/BM_Graduation_Project/assets/116927809/282c4aac-3c32-4b1c-8aeb-8dccfb0b6974)

 
  ### 🔸A backend currencies-compare-rate/currencies-compare EndPoint:
  
   **-Type:** POST
  
   **-Request:** {
                 "baseCode": "EGP",
                 "firstTargetCode": "AED",
                 "secondTargetCode": "USD",
                 "amount": 2000
               } 

   > [NOTE THAT]
   > Request type here is json         
       



   **-Response Body:** 
        ![image](https://github.com/mahmoudmatar01/BM_Graduation_Project/assets/116927809/503a9684-812b-421b-a7c1-c4c0d4dabb71)




# **Tools & Technologies💡**
  
  🔸Programming Language: Java 17
  
  🔸Backend Framework: Spring Boot v3.1.3
  
  🔸Deployment: Railway
  
  🔸API Documentation: Swagger 
  
  🔸Logger: SLF4J & Singleton design pattern classs
  
  🔸Docker
  
# **Docker**

   🔹Image:
       ![image](https://github.com/mahmoudmatar01/BM_Graduation_Project/assets/116927809/c771926e-63af-403e-8295-eaf8b3d18c0d)


   🔹Container:
       ![image](https://github.com/mahmoudmatar01/BM_Graduation_Project/assets/116927809/e25126fb-f117-49e5-bfd7-db4a1102f426)



 # **APIs Documantation 📄✒️ Via [Swagger](http://localhost:5902/swagger-ui/index.html)**

 # **Future Ideas & Features 💭**
 
   ➕ Login & Registration page.
   
   ➕ Authentication & Authorization sector.

   ➕ Integrate with different Wallets.

   ➕ Adding Circuit Breaker design pattern to ensure App stability when increasung requests on APIs and avoid crashing.






# **Currency Conversion Application** 🪙🪙

## **Main Aim** 
  🔸Provide users with real-time and accurate currency
conversion rates using Excange-Rates open source APIs.supports range of currencies and offer a
user-friendly interface .

## **Platforms we support**
  🔸Web
  🔸Android
  🔸IOS

# **Main Services & Functionalities**
   🔹Conversion Sector : Enable user to convert between amount of money from one base currency to another target currency he needs.
   
   🔹Compare Sector : Enable User to compare between amount of money of one base Currency to another pair Currencies at the same time.
   
   🔹Add to Favourites Sector : Enable user to add Currencies to his favorite screen according to his interest.
   
   🔹Live-Exchange rate for Currencies according to one base currency 


# **📌Technical Sector**
   🔹Excetion Handling is provided to handle any errors.
   
   🔹Unit tests are provided to Test Functionalities.

   🔹Using Actuators to check application health

   🔹In-Cache Memory is applied 

   🔹Scheduler to update the cache memory every ONE HOUR to make sure of that live exchange rates are applied.

   🔹Easy to add/remove currencies , as we Scalibility is from our app priorities

   🔹**Design Patterns**: a)Builder Design Pattern  

   🔹Enums and Constants to ease the work & clean the code.

   🔹Using Mappers and Helpers 





# **Our APIs**

![image](https://github.com/mahmoudmatar01/BM_Graduation_Project/assets/116927809/dcfe8f79-9c9e-4033-bf0e-8b88e026e841)

### Request and Response of Each one :

 ### 🔸A backend "currencies-info/currencies" EndPoint:  

   **-Type:** GET
   
   **-Request Body:** No Parameters

   **-Response Body:**
        ![image](https://github.com/mahmoudmatar01/BM_Graduation_Project/assets/116927809/14cef460-a985-4662-8fd3-8cbb00d7bc3c)



  ### 🔸A backend "currencies-conversion/currency-conversion" EndPoint:
  
   **-Type:** GET
   
   **-Request:** Base Currency: USD,
                Target Currency: AED,
                Amount: 200
                
  **-Response Body:**
        ![image](https://github.com/mahmoudmatar01/BM_Graduation_Project/assets/116927809/f35bb384-b8f9-4354-8d05-e98dee9336ae)




  ### 🔸A backend exchange-rate/currency-exchangeRate EndPoint:

  **-Type:** GET
  
  **-Request:** AED
  
  **-Response Body:**
       ![image](https://github.com/mahmoudmatar01/BM_Graduation_Project/assets/116927809/4f56d251-5511-40eb-a086-0d21510214eb)

 
  ### 🔸A backend exchange-rate/currency-exchangeRate EndPoint:
  
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
      ![image](https://github.com/mahmoudmatar01/BM_Graduation_Project/assets/116927809/12511921-ec8b-457c-a2bb-08f9c2b4716c)



# **Tools & Technologies💡**
  
  🔸Programming Language: Java 17
  
  🔸Backend Framework: Spring Boot v3.1.3
  
  🔸Deployment: Railway
  
  🔸API Documentation: Swagger 
  
  🔸Logger: SLF4J
  
  


 # **APIs Documantation 📄✒️ Via [Swagger](http://localhost:5902/swagger-ui/index.html)**

 # **Future Ideas & Features 💭**
 
   ➕ Login & Registration page.
   
   ➕ Authentication & Authorization sector.

   ➕ Integrate with different Wallets.






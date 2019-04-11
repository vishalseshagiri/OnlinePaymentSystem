### Online Processing Payment Application
- **Author** : Vishal Seshagiri

#### UML Sequence Diagram
![](Documentation/Glassdoor_intern_UML_Sequence_Diagram.png)

#### UML Class Diagram
![](Documentation/Glassdoor_intern_UML_Class_Diagram.png)

#### Goal
- My code is broken down into 4 main directories
    - Data Access Object files which basically consist of **UserDatabase.java** and **MerchantDatabase.java**
    - Payment Procedure Data Transfer Operations which are **IncomingRequest.java** and **UserObject.java**.
    - Payment Processor files which are **AcquiringBank.java**, **CardScheme.java** and **IssuingBank.java**.
    - Payment Runner file which is **PaymentApplication.java**.
- I have used the **Protoype Design Pattern** for this project which is evident from the ample usage of interfaces and objects.
- There aare two basic interfaces in the project which are **DaoOperations** and **PayProcessor**
- Whenever possible class variables have been limited to private access modifiers to ensure **security** in the application and getters and setters are used to facilitate **accessibilty**.
- Custom **Exceptions** are thrown to **validate** the data and caught in the application runner. A static final class **ErrorHandler.java** has been created to store the exception enumerations.
- **Console based logging** has been achieved using the log42j library.

#### Improvements
- As a part of further improvements geospatial features of the transaction can be tracked to ensure prevention of fraudalent transactions. This can done by using the goolemaps java api and querying the distance between transaction location and user's billing address. A simple heuristic can then be employed to either validate or invalidate the transaction.
- UserIDs could be generated randomly and passwords can be hashed using a hash function like md5 before storing to the database.
- Concurrency can be ensured by making the class methods **synchronized** and spawning threads to pass multiple incomingRequests to the api. This will ensure that the methods are thread safe and concurrent in their execution.

#### Testing
- 9 test cases have been implemented to ensure correctness of code.
- They simulate the following conditions:
    - Successful isCardPresent Transaction
    - Successful isCardNotPresent Transaction
    - Condition where CardNotPresent Exception is thrown
    - Condition where IncorrectPin Exception is thrown
    - Condition where StolenCard Exception is thrown
    - Condition where InsufficientFunds Exception is thrown
    - Condition where AddressMismatch Exception is thrown
    - Condition where CustomerDoesNotExist Exception is thrown
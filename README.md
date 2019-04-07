# Carousell #


Clean Architecture
  **Presentation Layer(app) <- Modules [Data,Domain]** <br/>
       * MVP for View, Model Interaction <br/>
         + HomePreseterImpl <- ViewContract <br/>

  **Data  <-  Module [Domain]** <br/>
       * Network <br/>
         +  ArticleCloudRepository <br/>

  **Domain** <br/>
       * UseCases has been defined <br/>
         +  ArticleUseCase <br/>


- Domain, Data, app  basic test cases has been integrated.       
         
   
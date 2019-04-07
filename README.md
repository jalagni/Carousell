# Carousell #


Clean Architecture
  **Presentation Layer <- Modules [Data,Domain]** <br/>
       * MVP for View, Model Interaction <br/>
         - HomePreseterImpl <- ViewContract <br/>

  **Data  <-  Module [Domain]** <br/>
       * Network <br/>
         - ArticleCloudRepository <br/>

  **Domain** <br/>
       * UseCases has been defined <br/>
         - ArticleUseCase <br/>
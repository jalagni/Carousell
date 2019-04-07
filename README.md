# Carousell #


Clean Architecture
  **Presentation Layer <- Modules [Data,Domain]**
       * MVP for View, Model Interaction
         - HomePreseterImpl <- ViewContract

  **Data  <-  Module [Domain]**
       * Network
         - ArticleCloudRepository

  **Domain**
       * UseCases has been defined
         - ArticleUseCase
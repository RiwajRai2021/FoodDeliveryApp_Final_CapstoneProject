import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FoodCatalogueRoutingModule } from './food-catalogue-routing.module';
import { FoodCatalogueComponent } from './components/food-catalogue.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
     ],
  imports: [
    CommonModule,
    FoodCatalogueRoutingModule, 
    FoodCatalogueComponent,
    RouterModule
  ]
})
export class FoodCatalogueModule { }
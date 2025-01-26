import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RestaurantDetailsRoutingModule } from './restaurant-details-routing.module';
import { FormsModule } from '@angular/forms';
import { ResturantDetailsComponent } from '../component/resturant-details/resturant-details.component';


@NgModule({
  declarations: [
    ResturantDetailsComponent
  ],
  imports: [
    CommonModule,
    RestaurantDetailsRoutingModule,
    FormsModule
  ]
})
export class RestaurantDetailsModule { }

import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderModule } from './header/header.module';
import { RestaurantListingModule } from './restaurant-listing/restaurant-listing.module';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FoodCatalogueModule } from './food-catalogue/food-catalogue.module';
import { OrderSummaryRoutingModule } from './order-summary/order-summary-routing.module';
import { OrderSummaryComponent } from './order-summary/components/order-summary.component';

@NgModule({
  declarations: [
    AppComponent, 
   
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HeaderModule, 
    RestaurantListingModule, 
    HttpClientModule, 
    FoodCatalogueModule,
    AppRoutingModule, 
    OrderSummaryRoutingModule, 
    OrderSummaryComponent
  ],
  providers: [
    provideClientHydration(withEventReplay())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

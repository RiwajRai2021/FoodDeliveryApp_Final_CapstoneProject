import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderModule } from './header/header.module';
import { RestaurantListingModule } from './restaurant-listing/restaurant-listing.module';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'
import { FoodCatalogueModule } from './food-catalogue/food-catalogue.module';
import { OrderSummaryRoutingModule } from './order-summary/order-summary-routing.module';
import { OrderSummaryComponent } from './order-summary/components/order-summary.component';
import { UserModule } from './user/user.module';
import { ResturantDetailsComponent } from './view/component/resturant-details/resturant-details.component';
import { RestaurantDetailsModule } from './view/module/restaurant-details.module';
import { StorageService } from './utils/storage.service';

@NgModule({
  declarations: [
    AppComponent,  
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HeaderModule, 
    RestaurantListingModule, 
    HttpClientModule, 
    FoodCatalogueModule,
    AppRoutingModule, 
    OrderSummaryRoutingModule, 
    OrderSummaryComponent,
    UserModule,
    RestaurantDetailsModule
  ],
  providers: [
    provideClientHydration(withEventReplay()),
    StorageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

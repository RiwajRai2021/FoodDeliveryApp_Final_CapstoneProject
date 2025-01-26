import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderSummaryComponent } from './order-summary/components/order-summary.component';
import { UserComponent } from './user/user.component';
import { RestaurantListingComponent } from './restaurant-listing/components/restaurant-listing.component';
import { ResturantDetailsComponent } from './view/component/resturant-details/resturant-details.component';

const routes: Routes = [
  { path: '', redirectTo: 'user', pathMatch: 'full' },
  { path: 'user', component: UserComponent },
  { path: 'details', component: ResturantDetailsComponent },
  { path: 'restaurant-listing', component: RestaurantListingComponent },
  { path: 'orderSummary', component: OrderSummaryComponent }, // Add the orderSummary route
  // Add other routes as needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

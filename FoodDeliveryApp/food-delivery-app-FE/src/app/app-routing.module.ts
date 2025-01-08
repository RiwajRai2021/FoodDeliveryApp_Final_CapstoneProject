import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrderSummaryComponent } from './order-summary/components/order-summary.component';

const routes: Routes = [
  { path: '', redirectTo: 'restaurant-listing', pathMatch: 'full' },
  { path: 'orderSummary', component: OrderSummaryComponent }, // Add the orderSummary route
  // Add other routes as needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

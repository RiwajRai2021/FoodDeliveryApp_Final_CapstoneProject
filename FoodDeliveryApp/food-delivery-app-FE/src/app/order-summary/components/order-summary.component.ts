import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FoodItem } from '../../Shared/models/FoodItem';
import { FoodCataloguePage } from '../../Shared/models/FoodCataloguePage';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-order-summary',
  templateUrl: './order-summary.component.html',
  styleUrls: ['./order-summary.component.css'], 
  standalone:true,
  imports:[CommonModule]
})
export class OrderSummaryComponent implements OnInit {
decrement(_t14: any) {
throw new Error('Method not implemented.');
}
increment(_t14: any) {
throw new Error('Method not implemented.');
}

  obj: FoodCataloguePage; // Define the obj property
  total: number = 0; // Define the total property
  showDialog: boolean = false;
username: any;
foodItemResponse: any;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.obj = JSON.parse(params['data']);
      this.calculateTotal();
    });
  }

  calculateTotal() {
    this.total = this.obj.foodItemsList.reduce((acc, item) => acc + ((item.price || 0) * item.quantity), 0);
  }

  saveOrder() {
    // Your order saving logic here
    this.showDialog = true;
  }

  closeDialog() {
    this.showDialog = false;
  }
}

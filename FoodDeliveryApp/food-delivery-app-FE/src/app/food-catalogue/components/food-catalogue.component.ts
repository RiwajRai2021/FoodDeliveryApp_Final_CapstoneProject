import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodItemService } from '../service/fooditem.service';
import { FoodCataloguePage } from '../../Shared/models/FoodCataloguePage';
import { FoodItem } from '../../Shared/models/FoodItem';
import { Restaurant } from '../../Shared/models/Restaurant'; // Import Restaurant
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-food-catalogue',
  templateUrl: './food-catalogue.component.html',
  styleUrls: ['./food-catalogue.component.css'],
  imports: [CommonModule] // Include CommonModule here
})
export class FoodCatalogueComponent implements OnInit {

  restaurantId: number;
  foodItemResponse: FoodCataloguePage;
  foodItemCart: FoodItem[] = [];
  orderSummary: FoodCataloguePage;
  restaurant: Restaurant; // Define the restaurant property

  constructor(private route: ActivatedRoute, private foodItemService: FoodItemService, private router: Router) {
    this.restaurant = { /* Initialize with a default value if necessary */ };
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.restaurantId = +params.get('id')!;
    });

    this.getFoodItemsByRestaurant(this.restaurantId);
  }

  getFoodItemsByRestaurant(restaurantId: number) {
    this.foodItemService.getFoodItemsByRestaurant(restaurantId).subscribe(
      (data: FoodCataloguePage) => { // Explicitly define the type of data
        this.foodItemResponse = data;
        this.restaurant = data.restaurant; // Assign the restaurant property
      }
    )
  }

  increment(food: any) {
    food.quantity++;
    const index = this.foodItemCart.findIndex(item => item.id === food.id);
    if (index === -1) {
      this.foodItemCart.push(food);
    } else {
      this.foodItemCart[index] = food;
    }
  }

  decrement(food: any) {
    if (food.quantity > 0) {
      food.quantity--;

      const index = this.foodItemCart.findIndex(item => item.id === food.id);
      if (this.foodItemCart[index].quantity === 0) {
        this.foodItemCart.splice(index, 1);
      } else {
        this.foodItemCart[index] = food;
      }
    }
  }

  onCheckOut() {
    this.foodItemCart;
    this.orderSummary = {
      foodItemsList: [],
      restaurant: this.restaurant // Assign the restaurant property here
    };
    this.orderSummary.foodItemsList = this.foodItemCart;
    this.router.navigate(['/orderSummary'], { queryParams: { data: JSON.stringify(this.orderSummary) } });
  }
}


import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FoodItemService } from '../service/fooditem.service';
import { FoodCataloguePage } from '../../Shared/models/FoodCataloguePage';
import { FoodItem } from '../../Shared/models/FoodItem';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  selector: 'app-food-catalogue',
  templateUrl: './food-catalogue.component.html',
  styleUrls: ['./food-catalogue.component.css'],
  imports: [CommonModule, RouterModule]
})
export class FoodCatalogueComponent { 

   restaurantId: number;
   foodItemResponse: FoodCataloguePage = {
    restaurant: {
      id: 0,
      name: '',
      address: '',
      city: '',
      restaurantDescription: ''
    },
    foodItemsList: []
  };
  foodItemCart: FoodItem[] = [];
  orderSummary: FoodCataloguePage;

  constructor(private route: ActivatedRoute, private foodItemService: FoodItemService, private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const idParam = params.get('id');
      if (idParam) {
        this.restaurantId = +idParam;
        this.getFoodItemsByRestaurant(this.restaurantId);
      } else {
        console.error('Restaurant ID is null');
      }
    });
  }

  getFoodItemsByRestaurant(restaurant: number) {
    this.foodItemService.getFoodItemsByRestaurant(restaurant).subscribe(
      data => {
        console.log('Data received:', data);
        this.foodItemResponse = data;
      },
      error => {
        console.error('Error fetching food items:', error);
      }
    );
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
      if (this.foodItemCart[index].quantity == 0) {
        this.foodItemCart.splice(index, 1);
      } else {
        this.foodItemCart[index] = food;
      }
    }
  }

  onCheckOut() {
    this.orderSummary = {
      foodItemsList: [],
      restaurant: {
        id: 0,
        name: '',
        address: '',
        city: '',
        restaurantDescription: ''
      }
    };
    if (this.foodItemCart && this.foodItemResponse && this.foodItemResponse.restaurant) { 
      this.orderSummary.foodItemsList = this.foodItemCart; 
      this.orderSummary.restaurant = this.foodItemResponse.restaurant; 
    } else {
      console.error('Food item cart or restaurant data is undefined');
    }
    this.router.navigate(['/orderSummary'], { queryParams: { data: JSON.stringify(this.orderSummary) } });
  }
}
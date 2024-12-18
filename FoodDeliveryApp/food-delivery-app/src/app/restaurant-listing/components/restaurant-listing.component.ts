import { Component } from '@angular/core';
import { Restaurant } from '../../Shared/models/Restaurant';
import { RestaurantService } from '../../services/restaurant.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-restaurant-listing',
  standalone: false,
  
  templateUrl: './restaurant-listing.component.html',
  styleUrl: './restaurant-listing.component.css'
})
export class RestaurantListingComponent {

  public restaurantList:Restaurant[]; 

  ngOnInt(){
    this.getAllRestaurants(); 
  }
    
  constructor(private router:Router, private restaurantService:RestaurantService ){}

  getAllRestaurants() {
   this.restaurantService.getAllRestaurants().subscribe(
    data=>{
      this.restaurantList=data;
    }
   )
  }
 getRandomImage():string{
  const imageCount=8; //Adjust this number based on the number of images in your asset folder
  const randomIndex=this.getRandomNumber(1,imageCount); 
  return `${randomIndex}.jpg`; //Replace with your image filename pattern
  
}
  getRandomNumber(min: number, max:number):number {
    return Math.floor(Math.random()*(max-min+1))+min;
  }

onButtonClick(id:number){
  this.router.navigate(['/food-catagloue', id]); 
}

}

import { ChangeDetectorRef, Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { Restaurant } from '../../Shared/models/Restaurant';
import { RestaurantService } from '../service/restaurant-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-restaurant-listing',
  templateUrl: './restaurant-listing.component.html',
  styleUrls: ['./restaurant-listing.component.css'], 
  imports: [CommonModule, RouterModule]
})
export class RestaurantListingComponent {
  public restaurantList: Restaurant[] = [];
  private readonly imageCount = 8; // Number of images available

  constructor(
    private cdr: ChangeDetectorRef, 
    private router: Router, 
    private restaurantService: RestaurantService
  ) {}

  ngOnInit() {
    this.getAllRestaurants();
  }

  private getRandomNumber(min: number, max: number): number {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  private getRandomImage(): string {
    const randomIndex = this.getRandomNumber(1, this.imageCount);
    return `assets/restaurant-pics/${randomIndex}.jpg`;
  }

  private assignImagesToRestaurants() {
    this.restaurantList.forEach(restaurant => {
      restaurant['imageSrc'] = this.getRandomImage(); // Add `imageSrc` property dynamically
    });
  }

  getAllRestaurants() {
    this.restaurantService.getAllRestaurants().subscribe(data => {
      this.restaurantList = data;
      this.assignImagesToRestaurants(); // Assign random images after fetching restaurants
    });
  }

  onButtonClick(id: number) {
    this.router.navigate(['/food-catalogue', id]);
  }
}

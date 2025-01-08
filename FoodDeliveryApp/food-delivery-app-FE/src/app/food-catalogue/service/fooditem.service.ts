import { Injectable } from "@angular/core";
import { API_URL_FC } from "../../constants/url";
import { HttpClient } from "@angular/common/http";
import { catchError, Observable, throwError } from "rxjs";
import { FoodCataloguePage } from '../../Shared/models/FoodCataloguePage'; // Import the model

@Injectable({
    providedIn: 'root'
})

export class FoodItemService {

    private apiUrl = `${API_URL_FC}/foodCatalogue/fetchRestaurantAndFoodItemsById`; 

    constructor(private http: HttpClient) { }

    getFoodItemsByRestaurant(id: number): Observable<FoodCataloguePage> {
        return this.http.get<FoodCataloguePage>(`${this.apiUrl}/${id}`)
        .pipe(
            catchError(this.handleError)
        ); 
    }

    private handleError(error: any): Observable<never> {
        console.error('An error occurred:', error); 
        return throwError(error.message || error); 
    }
}

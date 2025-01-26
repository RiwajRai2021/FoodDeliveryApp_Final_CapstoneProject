import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { API_URL_UD } from '../constants/url';
import { catchError, Observable, throwError } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = API_URL_UD + '/api/auth';

  constructor(private http: HttpClient) { }

  loginURL(username:string, password:string): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}` + '/login', {"username": username, "password": password})
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: any) {
    console.error('An error occured:', error);
    return throwError(error.message || error)
  }

}

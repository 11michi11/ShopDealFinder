import {Injectable} from '@angular/core';
import {FoodWasteProduct} from './foodWasteProduct';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  baseUrl = 'http://localhost:8080';
  foodWasteUrl = `${this.baseUrl}/products/foodWaste`;

  constructor(private http: HttpClient) {
  }

  getFoodWastProducts(): Observable<FoodWasteProduct[]> {
    return this.http.get<FoodWasteProduct[]>(this.foodWasteUrl);
  }


}

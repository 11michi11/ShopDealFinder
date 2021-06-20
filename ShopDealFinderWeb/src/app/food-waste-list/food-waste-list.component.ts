import {Component, OnInit} from '@angular/core';
import {ProductServiceService} from '../product-service.service';
import {FoodWasteProduct} from '../foodWasteProduct';
import {ThemePalette} from '@angular/material/core';


@Component({
  selector: 'app-food-waste-list',
  templateUrl: './food-waste-list.component.html',
  styleUrls: ['./food-waste-list.component.css']
})
export class FoodWasteListComponent implements OnInit {

  products: FoodWasteProduct[];

  constructor(private productService: ProductServiceService) {
  }

  async ngOnInit(): Promise<void> {
    this.products = await this.productService.getFoodWastProducts().toPromise();
  }

}

import { Component } from '@angular/core';
import { StorageService } from '../../utils/storage.service';

@Component({
  selector: 'app-header',
  standalone: false,
  
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  username: string = ''

  constructor(private localStorage: StorageService) {
    debugger;
    if(localStorage == undefined) {
      /*if(localStorage.getItem('user') != undefined || localStorage.getItem('user') != null) {
        debugger;
      }
        */
    }
    
  }

}

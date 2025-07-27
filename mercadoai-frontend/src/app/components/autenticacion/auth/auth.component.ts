import { Component } from '@angular/core';
import { User } from '../../../models/User';
import { SharingDataService } from '../../../services/sharing-data.service';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MainLayoutComponent } from "../../layout/main-layout/main-layout.component";

@Component({
  selector: 'app-auth',
  standalone: true,
  imports: [FormsModule, RouterModule, MainLayoutComponent],
  templateUrl: './auth.component.html'
})
export class AuthComponent {

  user: User;

  constructor(private data: SharingDataService ){
    this.user = new User();
  }

  onSubmit(){
    console.log(this.user);
    if(!this.user.username || !this.user.password){
      Swal.fire(
        "errror en la validacion",
        "username y password requeridos",
        "error"
      )
    }else{
      console.log("emitir evento de login");
      this.data.handlerLoginEvent.emit({
        username: this.user.username,
        password: this.user.password
      });
      
    }
  }
}

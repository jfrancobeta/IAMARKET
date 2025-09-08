import { Component } from '@angular/core';
import Swal from 'sweetalert2';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Usuario } from '../../../../core/models/Usuario/Usuario';
import { SharingDataService } from '../../../../core/services/sharing-data.service';

@Component({
  selector: 'app-auth',
  standalone: true,
  imports: [FormsModule, RouterModule],
  templateUrl: './auth.component.html'
})
export class AuthComponent {

  user: Usuario;

  constructor(private data: SharingDataService ){
    this.user = new Usuario();
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

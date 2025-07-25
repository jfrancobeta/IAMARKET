import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterOutlet } from '@angular/router';
import { SharingDataService } from './services/sharing-data.service';
import { AuthService } from './services/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html'
})
export class AppComponent {
  constructor(private data: SharingDataService,
    private serviceAuth: AuthService,
    private router : Router 
  ) {
    
  }

  ngOnInit() {
    this.handlerLogin();
  }

  handlerLogin(){
    this.data.handlerLoginEvent.subscribe(({username, password}) => {
      this.serviceAuth.loginUser({username, password}).subscribe({
        next: (response) => {
          const token = response.token;
          const payload = this.serviceAuth.getPayload(token);
          const user = {username: payload.sub}
          const login = {
            user,
            isAuth: true ,
            isAdmin: payload.isAdmin
          }
          this.serviceAuth.token = token  
          this.serviceAuth.user = login;
          
          //navegar al inicio
          //this.router.navigate(['/']);
          console.log(token)
          Swal.fire("Login exitoso", `Bienvenido ${user.username}`, "success");
        },
        error: (error) => {
          console.log(error);
          if(error.status == 401){
            Swal.fire("errror en el login", "username o password incorrectos","error")
          }else{
            throw error;
          }
        }
      });
    })
  }
}

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterOutlet } from '@angular/router';
import Swal from 'sweetalert2';
import { AuthService } from './core/services/auth.service';
import { SharingDataService } from './core/services/sharing-data.service';
import { HeaderComponent } from './shared/layout/header/header.component';
import { MainLayoutComponent } from './shared/layout/main-layout/main-layout.component';

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
            isAdmin: payload.isAdmin,
            usuario: payload.usuario 
          }
          this.serviceAuth.token = token  
          this.serviceAuth.user = login;

          this.router.navigate(['/dashboard']);
          console.log("Login exitoso", login);
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

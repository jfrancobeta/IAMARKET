import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterOutlet } from '@angular/router';
import { SharingDataService } from './services/sharing-data.service';
import { AuthService } from './services/auth.service';
import Swal from 'sweetalert2';
import { HeaderComponent } from "./components/layout/header/header.component";
import { MainLayoutComponent } from "./components/layout/main-layout/main-layout.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, HeaderComponent, MainLayoutComponent],
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

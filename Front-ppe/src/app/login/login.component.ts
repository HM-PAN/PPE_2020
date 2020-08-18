import { Component, OnInit } from "@angular/core";
import { AuthServiceService } from "../services/auth-service.service";
import { Router } from "@angular/router";
import { decode } from "punycode";
import { ToastrService } from "ngx-toastr";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
})
export class LoginComponent implements OnInit {
  nomUser;
  roleUser;
  mode: number = 0;
  constructor(
    private authService: AuthServiceService,
    private router: Router,
    private toas: ToastrService
  ) {}

  ngOnInit() {}
  public onLogin(user) {
    console.log(user);
    this.authService.login(user).subscribe(
      (resp) => {
        console.log(resp);
        let jwt = resp.toString();
        // console.log(resp.headers.get("Authorization"));
        // console.log(user);
        this.authService.saveToken(jwt);
        // console.log(this.authService.decoded.roles[0].authority);
        // this.nomUser = this.authService.decoded.sub;
        // console.log(this.nomUser);
        // this.roleUser = this.authService.decoded.roles[0].authority;
        //console.log(jwt);
        this.authService.bool = false;
        this.router.navigateByUrl("/home");
        this.toas.success("Bienvenue chez TunJob", "Succes", {
          positionClass: "toast-bottom-right",
        });
      },
      (error) => {
        this.mode = 1;
      }
    );
  }
}

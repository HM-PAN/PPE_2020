import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";
import { HomeComponent } from "./home/home.component";
import { LoginRComponent } from "./login/login-r/login-r.component";
import { OffresComponent } from "./offres/offres.component";
import { CompteRecruteurComponent } from "./compte-recruteur/compte-recruteur.component";
import { CompteCandidatComponent } from "./compte-candidat/compte-candidat.component";
import { DetailsComponent } from "./details/details.component";
import { DashComponent } from "./dashbord/dash/dash.component";
import { OffreTanitComponent } from "./offre-tanit/offre-tanit.component";

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "home", component: HomeComponent },
  { path: "loginR", component: LoginRComponent },
  { path: "offres", component: OffresComponent },
  { path: "compteRecruteur", component: CompteRecruteurComponent },
  { path: "compteCandidat", component: CompteCandidatComponent },
  { path: "details/:id", component: DetailsComponent },
  { path: "dash", component: DashComponent },
  { path: "Tanit", component: OffreTanitComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

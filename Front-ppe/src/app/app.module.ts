import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { NgxPaginationModule } from "ngx-pagination";
import { CommonModule } from "@angular/common";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { AuthServiceService } from "./services/auth-service.service";
import { HomeComponent } from "./home/home.component";
import { WebScrapingService } from "./services/web-scraping.service";
import { MaterialModule } from "./material/material.module";
import { LoginRComponent } from "./login/login-r/login-r.component";
import { OffresComponent } from "./offres/offres.component";
import { CompteRecruteurComponent } from "./compte-recruteur/compte-recruteur.component";
import { CompteCandidatComponent } from "./compte-candidat/compte-candidat.component";
import { DetailsComponent } from "./details/details.component";
import { DashComponent } from "./dashbord/dash/dash.component";
import { Chart1Component } from "./dashbord/chart1/chart1.component";
import { Chart2Component } from "./dashbord/chart2/chart2.component";
import { OffreTanitComponent } from "./offre-tanit/offre-tanit.component";
import { ToastrModule } from "ngx-toastr";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    LoginRComponent,
    OffresComponent,
    CompteRecruteurComponent,
    CompteCandidatComponent,
    DetailsComponent,
    DashComponent,
    Chart1Component,
    Chart2Component,
    OffreTanitComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MaterialModule,
    NgxPaginationModule,
    CommonModule,
    ToastrModule.forRoot(),
  ],
  providers: [AuthServiceService, WebScrapingService],
  bootstrap: [AppComponent],
})
export class AppModule {}

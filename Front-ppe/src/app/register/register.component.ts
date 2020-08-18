import { Component, OnInit } from "@angular/core";
import { RegisterService } from "../services/register.service";
import { CandidatElastic } from "../models/candidat-elactic";
import { Candidat } from "../models/candidat";
import { CrudService } from "../services/crud.service";
import { Recruteur } from "../models/recruteur";
import { Router } from "@angular/router";
import { ToastrService } from "ngx-toastr";

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"],
})
export class RegisterComponent implements OnInit {
  getcandidat;
  x = true;
  getrecruteur;
  candidatE: CandidatElastic = {
    username: "",
    password: "",
    repassword: "",
  };
  candidat: Candidat = {
    id: null,
    nom: "",
    prenom: "",
    email: "",
  };
  recruteur: Recruteur = {
    id: null,
    nom: "",
    prenom: "",
    email: "",
    nom_entreprise: "",
  };

  constructor(
    private http: RegisterService,
    private crudsevice: CrudService,
    private route: Router,
    private toas: ToastrService
  ) {}
  add(value) {
    console.log(value);
    console.log(this.candidatE);

    this.http.addCandidat(this.candidatE).subscribe(
      (data) => console.log("data", data),
      (error) => console.log(error)
    );
    //add to the second database
    this.candidat.id = this.getcandidat.length + 1;
    this.http.addC(this.candidat).subscribe(
      (data) => console.log("data", data),
      (error) => console.log(error)
    );
    this.route.navigate(["/login"]);
    this.toas.warning("user ajouter", "Succes", {
      positionClass: "toast-bottom-right",
    });
  }
  addR(value) {
    console.log(value);
    console.log(this.candidatE);

    this.http.addCandidatR(this.candidatE).subscribe(
      (data) => console.log("data", data),
      (error) => console.log(error)
    );
    //add to the second database
    this.recruteur.id = this.getcandidat.length + 1;
    this.http.addRecruteurToElastic(this.recruteur).subscribe(
      (data) => console.log("data", data),
      (error) => console.log(error)
    );
    this.route.navigate(["/login"]);
    this.toas.warning("user ajouter", "Succes", {
      positionClass: "toast-bottom-right",
    });
  }
  get() {
    this.http.getAll().subscribe((data) => (this.getcandidat = data));
  }

  /* addCandidatToElastic(value) {
    this.candidatE = new CandidatElastic(
      value.nom,
      value.password,
      value.repassword
    );
    this.http.addCandidatToElastic(this.candidatE).subscribe();
  }*/
  ngOnInit() {
    this.get();
  }
  rec() {
    this.x = false;
  }
}

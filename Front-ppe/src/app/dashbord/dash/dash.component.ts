import { Component, OnInit } from "@angular/core";
import { OffresService } from "src/app/services/offres.service";
import { CrudService } from "src/app/services/crud.service";

@Component({
  selector: "app-dash",
  templateUrl: "./dash.component.html",
  styleUrls: ["./dash.component.css"],
})
export class DashComponent implements OnInit {
  constructor(private offreservice: OffresService, private crud: CrudService) {}
  leng = [];
  spacialite = [];
  offre;
  offreIn;
  offreMedi;
  offreAg;
  ofrreCall;
  candidat;
  recru;
  lengthRec: number;
  lengthoffre: number;
  lengthCan: number;
  ngOnInit() {
    this.getCandidat();
    this.getOffre();
    this.getRecruteur();
    //   console.log("daa", this.leng);
    //   console.log("length of ", this.offre.length);
    //   console.log("length of rec", this.recru.length);
    //   console.log("length of can", this.candidat.length);
    // this.leng = [this.offre.length];
    //console.log("daa", this.leng);
  }
  getOffre() {
    this.offreservice.getOffres().subscribe((data) => {
      this.offre = data["content"];
      console.log(this.offre);
      this.lengthoffre = this.offre.length;
      this.leng.push(this.offre.length);
      console.log("length of offres", this.lengthoffre);
      this.offreIn = this.offre.filter((x) => x.titre.includes("informatique"));
      this.offreAg = this.offre.filter((x) => x.titre.includes("agriculture"));
      this.offreMedi = this.offre.filter((x) => x.titre.includes("medical"));
      this.ofrreCall = this.offre.filter((x) => x.titre.includes("call"));
      this.spacialite.push(this.offreIn.length);
      this.spacialite.push(this.offreAg.length);
      this.spacialite.push(this.offreMedi.length);
      this.spacialite.push(this.ofrreCall.length);
    });
  }
  getCandidat() {
    this.crud.getAll("candidat/get").subscribe((data) => {
      this.candidat = data["content"];
      this.lengthCan = this.candidat.length;
      console.log("length of candidats", this.lengthCan);

      this.leng.push(this.candidat.length);
    });

    console.log("length of can ", this.leng);
  }
  getRecruteur() {
    this.crud.getAll("recruteur/get").subscribe((data) => {
      this.recru = data["content"];
      this.lengthRec = this.recru.length;
      // console.log("length of rec", lengthRec);
      console.log("eeee", this.recru);

      this.leng.push(this.recru.length);
    });
  }
}

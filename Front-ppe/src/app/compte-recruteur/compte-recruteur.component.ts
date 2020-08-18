import { Cvv } from "./../cvv";
import { Cv } from "./../models/cv";
import { Router } from "@angular/router";
import { RegisterService } from "./../services/register.service";
import { Offres } from "./../models/offres";
import { AuthServiceService } from "src/app/services/auth-service.service";
import { CrudService } from "./../services/crud.service";
import { Component, OnInit } from "@angular/core";
import { HttpEventType, HttpRequest } from "@angular/common/http";
import { OffresService } from "../services/offres.service";
import { ToastrService } from "ngx-toastr";

@Component({
  selector: "app-compte-recruteur",
  templateUrl: "./compte-recruteur.component.html",
  styleUrls: ["./compte-recruteur.component.css"],
})
export class CompteRecruteurComponent implements OnInit {
  nomRecruteur;
  bool = false;
  offre: Offres = {
    nom_entreprise: "",
    num_offre: null,
    domaine: "",
    date_Lancement: null,
    date_Limite: null,
    capacite: null,
    titre: "",
  };
  id;
  getCv;
  x = false;
  y = false;
  num;
  curent;
  selectfile;
  progress;
  currentfile: any;
  count;
  idoffre;
  recruteur;
  cand;
  candi;
  all_offers = [];
  cv: Cv = {
    num_cv: this.count + 1,
    contenue: "",
    candidat: this.cand,
  };
  constructor(
    private http: CrudService,
    private auth: AuthServiceService,
    private ht: RegisterService,
    private route: Router,
    private httpo: OffresService,
    private toas: ToastrService
  ) {}

  ngOnInit() {
    this.get();
    this.getOffre();
    this.getCandidat();
    //this.getcv();

    this.getNum_Cv();
  }
  add(value) {
    this.offre.num_offre = this.idoffre + 1;
    this.http.addc(this.offre).subscribe((data) => console.log(data));
    console.log("ppppp", this.offre);
    console.log("ppppp", this.recruteur);

    this.recruteur.offres.push(this.offre);
    this.ht.addRecruteurToElastic(this.recruteur).subscribe(
      (data) => console.log("recruteur", data),
      (error) => console.log(error)
    );
    //this.route.navigate(["/home"]);
    this.toas.success("Offre Added", "Succes", {
      positionClass: "toast-bottom-right",
    });
  }
  getOffre() {
    this.http.getAll("offre/get").subscribe((data) => {
      let x = data["content"];
      this.all_offers = x;
      console.log("all offres-> ", this.all_offers);
      // trim rec offers
      let all_visible_offers = [];

      this.idoffre = x.length;
      console.log("idooffre.", this.idoffre);
    });
  }
  get() {
    this.http.getAll("recruteur/get").subscribe(
      (data) => {
        console.log("nomuser", this.auth.nomU);
        this.nomRecruteur = data;
        this.recruteur = this.nomRecruteur.content.filter(
          (x) => x.nom == this.auth.nomU
        )[0];
        console.log(this.recruteur);
        const new_vis = this.recruteur.offres.filter((x) => x != null);
        this.recruteur.offres = new_vis;
        this.id = this.recruteur.id;
      },
      (error) => console.log(error)
    );
  }
  getCandidat() {
    this.http.getAll("candidat/get").subscribe((data) => {
      //console.log("datacandidat",);
      this.candi = data;
      this.cand = this.candi.content.find((x) => x.nom == this.auth.nomU);
      if (this.cand) {
        console.log("candidat", this.cand);
        this.id = this.cand.id;
      }
      //console.log("iddddddd",this.id)
    });
  }
  voir() {
    this.y = !this.y;
  }
  addCv(value) {
    this.cv.num_cv = this.count + 1;
    this.cv.candidat = this.cand;
    this.http.ajouterCv(this.cv).subscribe((data) => console.log(data));

    //   //this.cand.cv.num_cv = this.cv.num_cv
    //   this.cand.cv = new Cvv(this.cv.num_cv, this.cv.contenue);
    //  console.log("fff",this.cand.cv)
    //  console.log("fffaaa",this.cand)

    // //   this.ht.addC(this.cand).subscribe(data => {
    // //     console.log("nouveau cand.", data)
    // //  })
  }

  // getcv() {
  //   this.http.getAll("candidat/cv/get").subscribe((data) => {
  //     this.getCv = data;
  //     this.count = this.getCv.content.length;
  //     this.num = this.getCv.content.find(
  //       (x) => x.candidat.id == this.cand.id
  //     ).num_cv;
  //     console.log("iddddddd", this.num);
  //   });
  // }
  changebool() {
    this.bool = !this.bool;
  }
  onedit(c) {
    this.curent = c;
    this.x = true;
  }
  selectFile(event) {
    this.selectfile = event.target.files;
  }
  upload() {
    this.progress = 0;
    this.currentfile = this.selectfile.item(0);
    this.http
      .uploadcv(this.currentfile, this.curent.num_cv)
      .subscribe((event) => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress = Math.round((100 * event.loaded) / event.total);
        } else if (event instanceof HttpRequest) {
          alert("fini");
        }
      });
    this.x = false;
  }
  getNum_Cv() {
    // let x = this.getCv.content
    // this.num = x.find(x => x.candidat.nom ==this.auth.nomU).num_cv
    // console.log("nuuum",this.num)
  }
  deleteOffre(id) {
    console.log("id to remove", id);
    this.httpo.deleteOffre(id, this.id).subscribe(
      (data) => {
        //this.recruteur.offres.num_offre == id;
        //this. = this.ffres.filter((x) => x.num_offre != id);
        console.log(data);
        this.route.navigate(["/home"]);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}

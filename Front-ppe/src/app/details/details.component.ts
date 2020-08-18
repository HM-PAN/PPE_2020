import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { CrudService } from "../services/crud.service";
import { AuthServiceService } from "../services/auth-service.service";
import { RegisterService } from "../services/register.service";
import { Route } from "@angular/compiler/src/core";
import { ToastrService } from "ngx-toastr";
@Component({
  selector: "app-details",
  templateUrl: "./details.component.html",
  styleUrls: ["./details.component.css"],
})
export class DetailsComponent implements OnInit {
  constructor(
    private activ: ActivatedRoute,
    private http: CrudService,
    private auth: AuthServiceService,
    private ht: RegisterService,
    private route: Router,
    private toas: ToastrService
  ) {}
  id;
  offres;
  candi;
  cand;
  count;
  list: [];
  ngOnInit() {
    this.id = parseInt(this.activ.snapshot.paramMap.get("id"));
    this.getOffre();
    this.getCandidat();

    //console.log("xxx",this.x);
  }
  getOffre() {
    this.http.getAll("offre/get").subscribe((data) => {
      this.offres = data["content"].find((x) => x.num_offre == this.id);
      console.log("offresggg", (this.list = this.offres.domaine.split(" ")));
      //console.log("xxxx",this.x)
    });
    // = this.offres.domaine;
  }
  postuler() {
    // console.log("ggg", this.offres);
    // console.log("hetha candidat", this.cand);
    // let x = this.cand;
    // console.log(this.cand);
    //this.offres.candidat[0] = this.cand;
    console.log("offers : ", this.offres);
    let offers_to_push = JSON.parse(JSON.stringify(this.offres));
    delete offers_to_push.candidat;
    this.cand.offres.push(offers_to_push);
    console.log("cand ", this.cand);
    let cand_to_push = JSON.parse(JSON.stringify(this.cand));
    delete cand_to_push.offres;
    this.offres.candidat.push(cand_to_push);
    // go
    this.ht.addC(this.cand).subscribe(
      (data) => {
        console.log("nouveau cand.", data);
      },
      (error) => {
        console.log("first add error");
        console.log(error);
      }
    );
    this.http.addc(this.offres).subscribe(
      (data) => {
        console.log(JSON.stringify(data));
      },
      (error) => {
        console.log("second add error");
        console.log(error);
      }
    );
    this.route.navigate(["/compteRecruteur"]);
    this.toas.success("Candidature envoyé", "Succes", {
      positionClass: "toast-top-right",
    });
  }
  getCandidat() {
    this.http.getAll("candidat/get").subscribe((data) => {
      //console.log("datacandidat",);
      this.candi = data;
      this.cand = this.candi.content.find((x) => x.nom == this.auth.nomU);
      console.log("candidat", this.cand);

      this.count = this.cand.id;
      //console.log("iddddddd",this.id)
    });
  }
}

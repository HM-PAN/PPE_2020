import { Router } from "@angular/router";
import { CrudService } from "./../services/crud.service";
import { Component, OnInit } from "@angular/core";
import { WebScrapingService } from "../services/web-scraping.service";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
})
export class HomeComponent implements OnInit {
  public webData = [];
  page = 1;
  offres;
  web;
  sear;
  constructor(
    private _WebScrapingService: WebScrapingService,
    private http: CrudService,
    private route: Router
  ) {}

  ngOnInit() {
    this._WebScrapingService
      .getData()
      .subscribe((data) => (this.webData = data));
    this.getOffre();
  }
  getOffre() {
    this.http.getAll("offre/get").subscribe((data) => {
      this.offres = this.web = data["content"];
      console.log("offres", this.offres);
    });
  }
  redirec(data) {
    this.route.navigate(["/details", data.num_offre]);
  }
  informatique() {
    this.offres = this.web.filter((x) => x.titre.includes("informatique"));
  }
  Medical() {
    //this.getA();
    // this.webData = this.web.filter(x => x.Description.includes("medical"));
    this.offres = this.web.filter((x) => x.titre.includes("medical"));
  }
  agri() {
    this.offres = this.web.filter((x) => x.titre.includes("agriculture"));
  }
  call() {
    this.offres = this.web.filter((x) => x.titre.includes("call"));
  }
  search() {
    this.offres = this.web.filter((x) => x.titre.includes(this.sear));
  }
}

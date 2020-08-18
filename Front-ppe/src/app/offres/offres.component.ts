import { Component, OnInit } from "@angular/core";
import { Offres } from "../models/offres";
import { OffresService } from "../services/offres.service";

@Component({
  selector: "app-offres",
  templateUrl: "./offres.component.html",
  styleUrls: ["./offres.component.css"],
})
export class OffresComponent implements OnInit {
  public offres;
  constructor(private offresServices: OffresService) {}

  ngOnInit() {
    this.getOffres();
  }
  getOffres() {
    this.offresServices.getOffres().subscribe((data) => {
      console.log(data);
      this.offres = data;
    });
  }
}

import { Component, OnInit } from "@angular/core";
import { WebScrapingService } from "../services/web-scraping.service";

@Component({
  selector: "app-offre-tanit",
  templateUrl: "./offre-tanit.component.html",
  styleUrls: ["./offre-tanit.component.css"],
})
export class OffreTanitComponent implements OnInit {
  constructor(private _WebScrapingService: WebScrapingService) {}
  public webData = [];
  ngOnInit() {
    this._WebScrapingService
      .getData()
      .subscribe((data) => (this.webData = data));
  }
}

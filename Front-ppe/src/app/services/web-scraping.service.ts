import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { IwebScraping } from "../webScrapint";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class WebScrapingService {
  private _url: string = "/assets/data/data.json";
  constructor(private http: HttpClient) {}

  getData(): Observable<IwebScraping[]> {
    return this.http.get<IwebScraping[]>(this._url);
  }
}

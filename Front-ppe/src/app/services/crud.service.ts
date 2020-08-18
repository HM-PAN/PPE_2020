import { Injectable } from "@angular/core";
import { HttpClient, HttpRequest, HttpEvent } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class CrudService {
  host = "http://localhost:8005/";
  constructor(private http: HttpClient) {}
  getAll(url) {
    return this.http.get(this.host + url);
  }
  add(obj, url) {
    return this.http.post(this.host + url, obj);
  }
  addc(obj) {
    console.log("adding offer");
    return this.http.post("http://localhost:8005/offre/add", obj);
  }
  delete(obj, url) {
    return this.http.delete(this.host + url, obj);
  }
  update(url, obj) {
    return this.http.put(this.host + url, obj);
  }
  ajouterCv(obj) {
    return this.http.post("http://localhost:8005/candidat/cv/add", obj);
  }
  uploadcv(file: File, num_cv): Observable<HttpEvent<{}>> {
    let formadata: FormData = new FormData();
    formadata.append("file", file);
    const req = new HttpRequest(
      "POST",
      `http://localhost:8005/candidat/cv/uploadCv/${num_cv}`,
      formadata,
      {
        reportProgress: true,
        responseType: "text",
      }
    );
    return this.http.request(req);
  }
}

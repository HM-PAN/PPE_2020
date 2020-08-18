import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Injectable({
  providedIn: "root",
})
export class RegisterService {
  constructor(private ht: HttpClient) {}
  addCandidat(obj) {
    return this.ht.post("http://localhost:8007/register/addCandidat", obj);
  }
  addCandidatR(obj) {
    return this.ht.post("http://localhost:8007/register/add/recruteur", obj);
  }

  addRecruteur(obj) {
    return this.ht.post("http://localhost:8007/register/add/recruteur", obj);
  }
  addRecruteurToElastic(obj) {
    return this.ht.post("http://localhost:8005/recruteur/add", obj);
  }
  addC(obj) {
    console.log("adding candidate");
    return this.ht.post("http://localhost:8005/candidat/add", obj);
  }
  //add recruteur **************************
  getAll() {
    return this.ht.get("http://localhost:8007/user/get");
  }
}

import { NgModule } from "@angular/core";
import {
  MatButtonModule,
  MatToolbarModule,
  MatSidenavModule,
  MatExpansionModule,
  MatFormFieldModule,
  MatInputModule,
  MatCardModule,
  MatIconModule,
} from "@angular/material";

const material = [
  MatButtonModule,
  MatToolbarModule,
  MatSidenavModule,
  MatExpansionModule,
  MatFormFieldModule,
  MatInputModule,
  MatCardModule,
  MatInputModule,
  MatIconModule,
];
@NgModule({
  imports: [material],
  exports: [material],
})
export class MaterialModule {}

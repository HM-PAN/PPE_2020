import { Component, OnInit, Input, OnChanges } from "@angular/core";
import { Chart } from "chart.js";
@Component({
  selector: "app-chart1",
  templateUrl: "./chart1.component.html",
  styleUrls: ["./chart1.component.css"],
})
export class Chart1Component implements OnInit, OnChanges {
  @Input("aa") lengeur = [];
  constructor() {}
  ngOnChanges() {
    this.chart();
  }

  ngOnInit() {
    console.log("ddd", this.lengeur);
  }

  chart() {
    // let nom = _.map(this.leng,'nomS');
    // let capacite = _.map(this.dat,'capacite');
    //console.log("ccccuuuu",capacite);
    let y = this.lengeur;
    console.log("hetha el Y", y);

    //console.log("tableau", tabLength);
    var myChart = new Chart("Myid", {
      type: "bar",
      data: {
        labels: ["NbCandidat", "NbOffre", "NbRecruteur"],
        datasets: [
          {
            label: "# of Votes",

            data: [4, 6, 9],
            backgroundColor: [
              "rgba(255, 99, 132, 0.2)",
              "rgba(54, 162, 235, 0.2)",
              "rgba(255, 206, 86, 0.2)",
              "rgba(75, 192, 192, 0.2)",
              "rgba(153, 102, 255, 0.2)",
              "rgba(255, 159, 64, 0.2)",
            ],
            borderColor: [
              "rgba(255, 99, 132, 1)",
              "rgba(54, 162, 235, 1)",
              "rgba(255, 206, 86, 1)",
              "rgba(75, 192, 192, 1)",
              "rgba(153, 102, 255, 1)",
              "rgba(255, 159, 64, 1)",
            ],
            borderWidth: 1,
          },
        ],
      },
      options: {
        scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: true,
              },
            },
          ],
        },
      },
    });
  }
}

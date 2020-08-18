import { Component, OnInit, Input, OnChanges } from "@angular/core";
import { Chart } from "chart.js";

@Component({
  selector: "app-chart2",
  templateUrl: "./chart2.component.html",
  styleUrls: ["./chart2.component.css"],
})
export class Chart2Component implements OnInit, OnChanges {
  @Input("spec") tab = [];
  constructor() {}

  ngOnInit() {}
  ngOnChanges() {
    this.charte();
  }
  charte() {
    let y = this.tab;
    //console.log("xxxxxxxxxx",y);

    var myChart = new Chart("MyIdd", {
      type: "pie",
      data: {
        labels: ["NbInfo", "NbMedical", "NbCall", "NbAg"],
        datasets: [
          {
            label: "# of Votes",
            data: [4, 10, 6, 11],
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

import React, { Component } from 'react';
import Chart from 'react-apexcharts';

const Context = React.createContext();

export class Provider extends Component {
  state = {
    options: {
      chart: {
        background: '#f4f4f4',
        foreColor: '#333'
      },

      xaxis: {
        categories: [
          "January",
          "February",
          "March",
          "April",
          "May",
          "June",
          "July",
          "August",
          "September",
          "October",
          "November",
          "December"
        ]
      },
      
      /* fill: {
        colors: ['#f44336']
      }, */
  
      grid: {
        row: {
          colors: ['#f3f3f3', 'transparent'],
          opacity: 0.5
        },
      },

      dataLabels: {
        enabled: false
      },

      stroke: {
        curve: 'straight'
      },
  

      title: {
        text: 'BTC course',
        align: 'center',
        margin: 20,
        offsetY: 20,
        
      }
    },

    series: [{
      name: 'Population',
      data: [
        8550405,
        3971883,
        2720546,
        2296224,
        1567442,
        1563025,
        1469845,
        1394928,
        1300092,
        1026908,
        1026908,
        1026908
      ]
    }]
  }

  
  render() {
    return (
        <Chart 
          options={this.state.options}
          series={this.state.series}
          type="line"
          height="450px"
          width="100%"

        />
    )
  }
}

export default Basic;
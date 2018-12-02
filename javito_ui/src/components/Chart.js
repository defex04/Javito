import React, { Component } from 'react';
import Chart from 'react-apexcharts';
import ChartForm from './chart_modules/ChartForm';
/* import axios from 'axios';
 */

class ChartX extends Component {
  constructor (props) {
    super(props);
    this.state = {

      /* Params of drop-down list with currency */
      options_curency: ['USD', 'EUR', 'GBP'],

      currency: 'USD',
      fromDate: '',
      toDate: '',

      /* Params for graph rendering */
      options: {
        chart: {
          background: '#f4f4f4',
          foreColor: '#333'
        },

        xaxis: {
          categories: [
            
          ]
        },
         
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
        name: 'value',
        data: []
      }]
    }
  }
  

  /* Function, that sets the values in state */
  
  getRequest = (URL) => { 
    fetch(URL)
      .then(res => res.json())
      .then(
        (result) => {

          /* Get all data parametrs */
          let date_mass = result.map((number) => number.date);
          let data_val = '';
          let text_val = '';

          /* Gets params from drop-down list and set data for state*/
          switch (this.state.currency) {
            case 'USD':
              data_val = result.map((number) => +number.USD);
              text_val = 'BTC course of USD';
              break;
            
            case 'EUR':
              data_val = result.map((number) => +number.EUR);
              text_val = 'BTC course of EUR';

              break;

            case 'GBP':
              data_val = result.map((number) => +number.GBP);
              text_val = 'BTC course of GBP';

              break;
          
            default:
              data_val = result.map((number) => +number.USD);
              text_val = 'BTC course of USD';
              break;
          }

          /* get fromDate and toDate from drop-down lists*/
          const {fromDate, toDate} = this.state;

          const newData = {
            fromDate,
            toDate
          }
         
          this.setState({

            fromDate: newData.fromDate,
            toDate: newData.toDate,

            options: {
              xaxis: {
                categories: date_mass
              },

              title: {
                text: text_val,
              }
            },

           series: [{
              data: data_val
            }],           
          });

          console.log('fromDate:  ', this.state.fromDate);
          console.log('toDate: ', this.state.toDate);
        }
      )
    }
  
  /* Handler of date and value data */
  onChange = e => this.setState ({
    [e.target.name]: e.target.value}
  )

  /* Submits a command for graph rendering  */
  onSubmit = (e) => {
    e.preventDefault();

    const data = {
      fromDate: this.state.fromDate,
      toDate: this.state.toDate,
      currency: this.state.currency
    };

    const URL =`http://localhost:3000/chart_data?fromDate=${data.fromDate}&toDate=${data.toDate}&currency=${data.currency}`;

     /* if date in state not empty and fromDate less toDate,
      then sends data in state  */
    if (data.fromDate !== '' 
      && data.toDate !== ''
      && data.fromDate <= data.toDate
      && this.getRequest(URL)
    );
  }

  
  render() {
    const {currency, fromDate, toDate} = this.state;
    return (
      <div className="container d-flex flex-wrap content m-auto">
        <div className = "col-md-12 ">
        <Chart 
          options={this.state.options}
          series={this.state.series}
          type="line"
          height="450px"
          width="100%"
        />
      
        <ChartForm
          fromDate = {fromDate}
          toDate = {toDate}
          currency = {currency}
          options_curency = {this.state.options_curency}
          onChange = {this.onChange}
          onSubmit = {this.onSubmit}
        />
      </div>
    </div>
    )
  }
}

export default ChartX;
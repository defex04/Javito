import React, { Component } from 'react';
import Chart from 'react-apexcharts';
/* import axios from 'axios';
 */

class Basic extends Component {
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

          /* Get all date parametrs */
          let date_mass = result.map((number) => number.date);
          let data_val = '';
          let val_text = '';

          /* Gets params from drop-down list and set data for state*/
          switch (this.state.currency) {
            case 'USD':
              data_val = result.map((number) => +number.USD);
              val_text = 'BTC course of USD';
              break;
            
            case 'EUR':
              data_val = result.map((number) => +number.EUR);
              val_text = 'BTC course of EUR';

              break;

            case 'GBP':
              data_val = result.map((number) => +number.GBP);
              val_text = 'BTC course of GBP';

              break;
          
            default:
              data_val = result.map((number) => +number.USD);
              val_text = 'BTC course of USD';
              break;
          }

          /* get fromDate and toDate from drop-down lists*/
          const {fromDate, toDate} = this.state;

          const newData = {
            fromDate,
            toDate
          }


          /* if date in state not empty and fromDate less toDate,
             then sends data in state  */
          if (newData.fromDate !== '' && newData.toDate !== '' 
              && newData.fromDate < newData.toDate &&
          this.setState({

            fromDate: newData.fromDate,
            toDate: newData.toDate,

            options: {
              xaxis: {
                categories: date_mass
              },

              title: {
                text: val_text,
              }
            },

           series: [{
              data: data_val
            }],           
          }));

          console.log('fromDate:  ', this.state.fromDate);
          console.log('toDate: ', this.state.toDate);
        },
        
        (error) => {
          this.setState({
            isLoaded: true,
            error
          });
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

    const URL = "http://localhost:3000/chart_data/";
    
    this.getRequest(URL);

  }

    
    //Проверка пустых полей
    /* if (newData.fromDate < newData.toDate) {
      console.log(JSON.stringify(newData));
    } 
    
    else console.log('Wrong! Check your date'); */

    //POST запрос на сервер
    /* fetch('https://mywebsite.com/endpoint/', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      firstParam: 'yourValue',
      secondParam: 'yourOtherValue',
    })
  }) */
    /* Код ? */
  

    
  render() {
    const {currency, fromDate, toDate} = this.state;
    return (
      <div>
        <Chart 
          options={this.state.options}
          series={this.state.series}
          type="line"
          height="450px"
          width="100%"
        />

        <form
          onSubmit={this.onSubmit}
          className = " form-inline float-right" >
        
          From
          <input 
            className="m-2 form-control form-control-sm"
            type="date"
            name="fromDate"
            value = {fromDate}
            onChange = {this.onChange}
          /> 
            
          To
          <input 
            className ="m-2 form-control form-control-sm"
            type="date"
            name="toDate"
            value = {toDate}
            onChange = {this.onChange}
          /> 

          Value
          <select
            className = " form-control form-control-sm m-2 mr-2"
            style={{cursor:'pointer'}}
            name="currency"
            onChange = {this.onChange}
            value={currency}
          >

          {this.state.options_curency.map((option, idx) =>
            <option
              key={idx}
              value={option}>
            {option} 
            </option>)}
          </select>
            
          <input 
            type="submit"
            className="btn btn-success btn-sm "
            value = "Show"
          />
       
        </form>
      </div>
    )
  }
}

export default Basic;
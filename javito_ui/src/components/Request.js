import React, { Component } from 'react';
import Chart from 'react-apexcharts';
import ChartForm from './chart_modules/ChartForm';


class Request extends Component {
  constructor (props) {
    super(props);
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
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
          categories: []
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
          text: 'BTC course of USD',
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
  componentDidMount () {
    fetch ('http://localhost:8081/hello/')
      .then(res => res.json())
      .then(
        (result) => {

          let date_mass = result.map((number) => number.time);
          let data_val = result.map((number) => +number.usd);

          this.setState({

            options: {
              xaxis: {
                categories: date_mass
              }
            },

            series: [{
                data: data_val
              }],           
            }); 
        })
  }

  getRequest = (URL) => { 
    fetch(URL)
      .then(res => (res.json()))
      .then(

        (result) => {

          let date_mass = (result.map((number) => number.time));
          let data_val = '';
          let text_val = '';

          /* Gets params from drop-down list and set data for state*/
          switch (this.state.currency) {
            case 'USD':
              data_val = result.map((number) => +number.usd);
              text_val = 'BTC course of USD';
              break;
            
            case 'EUR':
              data_val = result.map((number) => +number.eur);
              text_val = 'BTC course of EUR';

              break;

            case 'GBP':
              data_val = result.map((number) => +number.gbp);
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

     /* if date in state not empty and fromDate less toDate,
      then sends data in state  */
     if (data.fromDate !== '' 
      && data.toDate !== ''
      && data.fromDate <= data.toDate
      && this.getRequest(`http://localhost:8081/hello/`)
     ); 

  }

  
  render() {
    const {currency, fromDate, toDate} = this.state;
    return (
      <div>
        <div className = "pb-5">

          <div>
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

        <div>
          <Chart 
            options={this.state.options}
            series={this.state.series}
            type="line"
            height="450px"
            width="100%"
          />
        </div>
      </div>
      
    )
  }
}

export default Request;
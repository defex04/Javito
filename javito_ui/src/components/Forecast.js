import React, { Component } from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import '../../node_modules/react-bootstrap-table/dist/react-bootstrap-table-all.min.css';


class History extends Component {
  constructor(props) {
    super(props);

    let today = new Date(),
        tomorrow_date = (today.getDate() + 1) + '/' + (today.getMonth() + 1) + '/' + (today.getFullYear());
    
    this.state = {
      data: [], 
      tomorrow: tomorrow_date,

      current_status: 
      {
        usd: '',
        eur: '',
        gbp: ''
      }
      ,
      
      forecast: [],
      
      columns : [{
        Header: 'Course',
        accessor: 'course'
      }, {
        Header: 'Value',
        accessor: 'value',
      }]
    };
  };
  
  /* function, that creats icons element instead up and down */
  priceFormatter(cell) {
    if (cell === 'up') {
      return (<i className="fas fa-arrow-alt-circle-up text-success"></i>);
    }
    
    if (cell === 'down') {
      return (<i className="fas fa-arrow-alt-circle-down text-danger"></i>);
    }
  }


  componentDidMount() {
    fetch('http://localhost:3000/table')
      .then(response => response.json())
      .then(result => {
        console.log(result);
        let data_mass = result.map((number) => number);
        this.setState (
        {
          data: data_mass
        })
      })

      fetch('http://localhost:3000/forecast')
      .then(response => response.json())
      .then(result => {
        console.log(result);
        let forecast_val = result.map((number) => number.value);        
        this.setState (
        {
          forecast: forecast_val[0]
        })
      })
      
      fetch('http://localhost:3000/chart_data')
      .then(response => response.json())
      .then(result => {
        console.log(result);
        let curStatus_mass = result.map((number) => number);        
        let curStatus = curStatus_mass.pop();

        console.log(curStatus.USD);
        
        this.setState({
          current_status:  
            {
              usd: +curStatus.USD,
              eur: +curStatus.EUR,
              gbp: +curStatus.GBP
            }
          
        });

        console.log('curstatus', this.state.current_status)
        //console.log('current status: ', current_status.pop());

       /*  this.setState (
        {
          forecast: forecast_val[0]
        }) */
      })
  }
  
  render() {
    const {data, forecast, tomorrow} = this.state;
    const {usd, eur, gbp} = this.state.current_status;
    return (
      <React.Fragment>

        <div>
          <h5> Forecast of BTC-cource on   {tomorrow}: {forecast} </h5>
        </div>

        <div className = "fs-10 mt-5">
          <h5> Results of forecasts: </h5>
            <BootstrapTable data={data}>
              <TableHeaderColumn dataField='date' isKey>Date</TableHeaderColumn>
              
              <TableHeaderColumn
                dataField='trends'
                dataFormat={this.priceFormatter}>
                Trends
              </TableHeaderColumn>
              
              <TableHeaderColumn
                dataField='forecast'
                dataFormat={this.priceFormatter}>
                Forecast
              </TableHeaderColumn>

              <TableHeaderColumn dataField='result'>Results</TableHeaderColumn>
            </BootstrapTable>
          </div>

          <div className="mt-5">
            <h5> Current course status: </h5>
            USD: {usd}, <br /> 
            GBP: {gbp}, <br /> 
            EUR: {eur} <br /> 
          </div>
        
      </React.Fragment>
    );
  }
}


export default History;
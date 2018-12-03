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

      forecast: [],
      
      columns : [{
        Header: 'Course',
        accessor: 'course' // String-based value accessors!
      }, {
        Header: 'Value',
        accessor: 'value',
        //Cell: props => <span className='number'>{props.value}</span> // Custom cell components!
      }]
    };
  };
  
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
        
        console.log('state: ', this.state);
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
        
        console.log('forecast: ', this.state.forecast);
      })
  }
  
  render() {
    const {data, forecast, tomorrow} = this.state;
    return (
      <div>
        <BootstrapTable data={data}>
          <TableHeaderColumn dataField='date' isKey>Date</TableHeaderColumn>
          <TableHeaderColumn dataField='trends'>Trends</TableHeaderColumn>
          <TableHeaderColumn dataField='forecast'>Forecast</TableHeaderColumn>
          <TableHeaderColumn dataField='result'>Results</TableHeaderColumn>
        </BootstrapTable>
        
        Forecast of BTC-cource on tommorow,  {tomorrow}, is {forecast} 

      </div>

    );
  }
}


export default History;
import React, { Component } from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import '../../../node_modules/react-bootstrap-table/dist/react-bootstrap-table-all.min.css';

class History extends Component {
  constructor(props) {
    super(props);
    this.state = {
        date: '',
        trends: '',
        forecast: '',
        results: '',
      
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
      .then(result => /* {

        let date_mass = result.map((number) => number.date);
        let date_trends = result.map((number) => number.trends);
        let date_forecast = result.map((number) => number.forecast);
        let date_results = result.map((number) => number.results); */

        this.setState({
         /*  date: 1,
          trends: 1,
          forecast: 1,
          results: 1
          }); */
          date: result.date,
          trends: result.trends,
          })
        );
    console.log(this.state)
  }
  
  render() {
    return (
      <BootstrapTable>
        <TableHeaderColumn dataField='id' isKey>Date</TableHeaderColumn>
        <TableHeaderColumn dataField='name'>Trends</TableHeaderColumn>
        <TableHeaderColumn dataField='price'>Forecast</TableHeaderColumn>
        <TableHeaderColumn dataField='price'>Results</TableHeaderColumn>
      </BootstrapTable>
    );
  }
}


export default History;
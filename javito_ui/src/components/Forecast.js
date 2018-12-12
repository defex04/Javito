import React, { Component } from 'react';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import '../../node_modules/react-bootstrap-table/dist/react-bootstrap-table-all.min.css';


class History extends Component {
  constructor(props) {
    super(props);

    /* get next day */
    let today = new Date(),
        tomorrow_date = (today.getDate() + 1) + '/' + (today.getMonth() + 1) + '/' + (today.getFullYear());
    
    this.state = {
      /* get data for chart */
      data: [], 

      /* get tommorow date */
      tomorrow: tomorrow_date,

      /* state for current course status block */
      current_status: 
      {
        usd: '',
        eur: '',
        gbp: ''
      }
      ,
      
      /* forecast value on next day: top/down */
      forecast: '',
      
      /* states for table */
      columns : [{
        Header: 'Course',
        accessor: 'course'
      }, {
        Header: 'Value',
        accessor: 'value',
      }]
    };
  };
  
  /* function that creates icons element instead up and down */
  actionFormatter(cell) {
    switch (cell) {
      case 'up':
        return <i className="fas fa-arrow-alt-circle-up text-success"></i>;
      
      case 'down':
        return <i className="fas fa-arrow-alt-circle-down text-danger"></i>;
    
      default:
        break;
    }
  }
  
  
  componentDidMount() {
    /* get data for table */
    fetch('http://localhost:3004/table')
      .then(response => response.json())
      .then(result => {
        console.log(result);
        let data_mass = result.map((number) => number);
        this.setState (
        {
          data: data_mass
        })
      })

      /* get data for forecast of nextday */
      fetch('http://localhost:3004/forecast')
      .then(response => response.json())
      .then(result => {
        
        this.setState (
        {
          forecast: this.actionFormatter(result.value)
        })
      })
      
      /* gets data for current course's state */
      fetch('http://localhost:8081/hello/')
      .then(response => response.json())
      .then(result => {
        console.log(result);
        let curStatus_mass = result.map((number) => number);        
        let curStatus = curStatus_mass.pop();
        
        this.setState({
          current_status:  
            {
              usd: +curStatus.usd,
              eur: +curStatus.eur,
              gbp: +curStatus.gbp
            }
          
        });
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
                dataFormat={this.actionFormatter}>
                Trends
              </TableHeaderColumn>
              
              <TableHeaderColumn
                dataField='forecast'
                dataFormat={this.actionFormatter}>
                Forecast
              </TableHeaderColumn>

              <TableHeaderColumn dataField='result'>Results</TableHeaderColumn>
            </BootstrapTable>
          </div>

          <div className="mt-5">
            <h5> Current course status: </h5>
            USD: {usd} <br /> 
            GBP: {gbp} <br /> 
            EUR: {eur} <br /> 
          </div>
        
      </React.Fragment>
    );
  }
}


export default History;
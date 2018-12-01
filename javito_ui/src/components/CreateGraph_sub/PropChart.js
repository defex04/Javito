import React, { Component } from 'react';
import 'react-day-picker/lib/style.css';

class PropChart  extends Component {
  constructor(props){
    super(props);
    this.state = {
      
      options: ['USD', 'EUR', 'GBP'],

      currency: 'USD',
      fromDate: '',
      toDate: '',
      
      
    }
  }

  onChange = e => this.setState ({
    [e.target.name]: e.target.value
  })

  onSubmit = (e) => {
    e.preventDefault();

    const {fromDate, toDate, currency} = this.state;

    const newData = {
      fromDate,
      toDate,
      currency
    }
    
    //Проверка пустых полей
    if (newData.fromDate < newData.toDate) {
      console.log(JSON.stringify(newData));
    } 
    
    else console.log('Wrong! Check your date');

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
    
  }

    
  render() {
    const {currency, fromDate, toDate} = this.state;

    return (
        <form onSubmit={this.onSubmit}
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

            {this.state.options.map((option, idx) =>
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
    )
  }
}

export default PropChart;
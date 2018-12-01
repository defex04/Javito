import React from 'react';
import axios from 'axios';

 class GETRequest extends React.Component {
  state = {
    
    options_curency: ['USD', 'EUR', 'GBP'],


    fromDate: '',
    toDate: '', 
    currency: 'USD'
   }

  onChange = e => this.setState ({
    [e.target.name]: e.target.value}
  )

  
  handleSubmit = event => {
    event.preventDefault();

    const data = {
      fromDate: this.state.fromDate,
      toDate: this.state.toDate,
      currency: this.state.currency
    };



    axios.get(`http://localhost:3000/chart_data?fromDate=${data.fromDate}&toDate=${data.toDate}&currency=${data.currency}`)
      .then(res => {
        console.log(res);
       // console.log(res.data);
        console.log(data.fromDate);
      })

    
  }

  render() {
    
    const {fromDate, toDate, currency} = this.state
    return (
      <div className = "container ">

        <form
          onSubmit={this.handleSubmit}
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
        {/* <form onSubmit={this.handleSubmit}>
          <label>
            Person Name:
            <input type="text" name="name" onChange={this.handleChange} />
          </label>
          <button type="submit">Add</button>
        </form> */}
      </div>
    )
  }
}

export default GETRequest; 
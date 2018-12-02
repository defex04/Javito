import React from 'react';

const ChartForm = (props) => {

const { fromDate,
        toDate,
        currency,
        options_curency,
        onChange,
        onSubmit } = props;
      
  return (
    <div>
      <form
          onSubmit={onSubmit}
          className = " form-inline float-right" >
        
          From
          <input 
            className="m-2 form-control form-control-sm"
            type="date"
            name="fromDate"
            value = {fromDate}
            onChange = {onChange}
          /> 
            
          To
          <input 
            className ="m-2 form-control form-control-sm"
            type="date"
            name="toDate"
            value = {toDate}
            onChange = {onChange}
          /> 

          Value
          <select
            className = " form-control form-control-sm m-2 mr-2"
            style={{cursor:'pointer'}}
            name="currency"
            onChange = {onChange}
            value={currency}
          >

          {options_curency.map((option, idx) =>
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
  );
};

export default ChartForm;
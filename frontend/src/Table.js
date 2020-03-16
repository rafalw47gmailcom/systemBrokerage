import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Details from "./Details";

import Popup from "reactjs-popup";
 
/*
function showDetails(){
  alert('Kliknieto');
}
*/

function highlightRow(){
  
}

class Table extends Component {
 
      render() {
        return (

  // <tr onClick={showDetails}>
           
       <tr >


      <td> <img src= "favicon.ico" className="ui mini rounded image"  /></td>
      <td>{this.props.info.title}</td>
      <td>{this.props.info.country}</td>
      <td>{this.props.info.destinationCity}</td>
      <td>{this.props.info.dateFrom}</td>
      <td>{this.props.info.dateTo}</td>
      <td>{this.props.info.price}</td>
      <td>{this.props.info.touroperator}</td>

      <td> <Details /> </td>

      </tr>

        );
      }
    }
    
    export default Table;
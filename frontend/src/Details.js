import React, { Component } from 'react';
import Table from "./Table"
import axios from 'axios'

function showDetails(){
    window.location.href="offerDetails.html";
}

class Details extends React.Component {
render(){
    return (
         <button onClick={showDetails}>Szczegóły</button>
    );
}
}
export default Details;
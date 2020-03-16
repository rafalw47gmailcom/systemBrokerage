import React, { Component } from 'react';
import Table from "./Table"
import axios from 'axios'


class App extends React.Component {


state = 
{
  data: [],
  name: "byku",
  isLoading: false,

}
componentDidMount() {
  this.setState({ isLoading: true });
  fetch('http://localhost:8082/brokerapi/tours/all')
  .then(response => response.json())
  .then(data => {
    console.log(data);
    this.setState({data, isLoading: false})
  });
}



render() {
  if (this.state.isLoading) {
    return <p>Ładowanie…</p>;
  }

  return (
      <table class="table table-striped" >
  <thead>
    <tr>
    <th scope="col"></th>
      <th  scope="col">Tytuł</th>
      <th scope="col">Kraj</th>
      <th scope="col">Miejsce przylotu</th>
      <th scope="col">Data wyjazdu</th>
      <th scope="col">Powrót przed</th>
      <th scope="col">Cena</th>
      <th scope="col">Touroperator</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody >
    {this.state.data.map(table => <Table info={table}/>)}
  </tbody>
</table>
 
  );
}
}

export default App;

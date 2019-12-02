import React, {Component} from 'react';
import '../App.css'
import {AgGridReact} from 'ag-grid-react';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-balham.css';
import axios from 'axios';
import {MDBCard, MDBCardHeader} from "mdbreact";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            columnDefs: [{
                headerName: "No Of Units", field: "noOfUnits"
            }, {
                headerName: "Price", field: "price"
            }],
            rowData: [],
            rowData1: []
        }
    }

    componentWillMount() {
        axios.get(`http://localhost:8081/api/getHorseshoePriceList`)
            .then(pricelist => {
                console.log(pricelist.data);
                this.setState({"rowData": pricelist.data})
            }).catch(err => {
            console.log(err)
        });

        axios.get(`http://localhost:8081/api/getPenguiEarsPriceList`)
            .then(pricelist => {
                console.log(pricelist.data);
                this.setState({"rowData1": pricelist.data})
            }).catch(err => {
            console.log(err)
        })

    }

    render() {
        return (
            <div className="container">
                <div className="row">
                    <div className="col"> <MDBCardHeader className="text-center" color="blue" tag="h3">Horseshoe Price Table</MDBCardHeader></div>
                    <div className="col"> <MDBCardHeader className="text-center" color="blue" tag="h3">Penguin Ears Price Table</MDBCardHeader></div>
                    <div className="w-100"></div>
                    <div className="col">
                        <div
                            className="ag-theme-balham"
                            style={{
                                height: '500px',
                                width: '540px'
                            }}
                        >
                            <AgGridReact
                                columnDefs={this.state.columnDefs}
                                rowData={this.state.rowData}>
                            </AgGridReact>
                        </div>
                    </div>
                    <div className="col">
                        <div
                            className="ag-theme-balham"
                            style={{
                                height: '500px',
                                width: '540px'
                            }}
                        >
                            <AgGridReact
                                columnDefs={this.state.columnDefs}
                                rowData={this.state.rowData1}>
                            </AgGridReact>
                        </div>
                    </div>
                </div>
            </div>


        );
    }
}

export default App;
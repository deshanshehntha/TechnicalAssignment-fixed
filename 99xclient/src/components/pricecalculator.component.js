import React, {Component} from 'react';
import '../App.css'
import {AgGridReact} from 'ag-grid-react';
import 'ag-grid-community/dist/styles/ag-grid.css';
import 'ag-grid-community/dist/styles/ag-theme-balham.css';
import axios from 'axios';
import "ag-grid-enterprise";
import {
    MDBContainer,
    MDBRow,
    MDBCol,
    MDBBtn,
    MDBCard,
    MDBCardBody,
    MDBCardTitle,
    MDBCardText,
    MDBCardHeader,
    MDBDropdown, MDBDropdownItem,
} from "mdbreact";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            options: [],
            product: '',
            Qty: '',
            calcValue: '0.00',
            checked: false,
            surCharge: '0.00',
        };

        this.onFormSubmit = this.onFormSubmit.bind(this);
        this.onProductChange = this.onProductChange.bind(this);
        this.onChangeQty = this.onChangeQty.bind(this);
    }

    componentWillMount() {
        axios.get(`http://localhost:8081/api/getProductsList`)
            .then(productlist => {
                console.log(productlist.data);
                this.setState({"options": productlist.data})
            }).catch(err => {
            console.log(err)
        });
    }

    onProductChange(e) {
        this.setState({
            product: e.target.value
        })
    }

    onChangeQty(e) {
        this.setState({
            Qty: e.target.value
        })
    }

    onChangeAction(e) {
        this.setState({
            checked: e.target.checked
        })
    }


    onFormSubmit(e) {
        e.preventDefault();
        let obj = {
            product: this.state.product,
            qty: this.state.Qty,
            qtyType: this.state.checked

        };
        const url = 'http://localhost:8081/api/getCalculatedPrice';
        axios.post(url, obj).then(res => {
            console.log(res);
            var value = res.data.price;
            let surCharge = res.data.surCharge
            value = value.toFixed(2);
            this.setState({
                calcValue: value,
                surCharge: surCharge
            })
        }).catch(err => {
            console.log(err);
        });

        this.state = {
            product: '',
            Qty: ''
        };
    }


    render() {
        return (
            <div className="container">
                <div className="row">
                    <div className="col">
                        <MDBContainer>
                            <MDBCard className="d-flex justify-content-center align-self-center">
                                <MDBCardBody>
                                    <form onSubmit={this.onFormSubmit}>
                                        <label htmlFor="defaultFormLoginEmailEx" className="grey-text">
                                            Select Product
                                        </label>
                                        <div>
                                            <select name="product" value={this.state.product}
                                                    onChange={(e) => this.onProductChange(e)}>
                                                {this.state.options.map((e, key) => {
                                                    return <option key={key}
                                                                   value={e.productName}>{e.productName}</option>;
                                                })}
                                            </select>
                                        </div>

                                        <br/>
                                        <label className="grey-text">
                                            Enter Quantity
                                        </label>
                                        <input
                                            type="Number"
                                            id="defaultFormLoginPasswordEx"
                                            className="form-control"
                                            onChange={this.onChangeQty}
                                            value={this.state.Qty}
                                        />
                                        <input
                                            type="checkbox"
                                            checked={this.state.checked}
                                            onChange={this.onChangeAction.bind(this)}
                                        />
                                        <label className="grey-text">
                                            Use as Cartoon Quantiy
                                        </label>

                                        <div className="text-center mt-4">
                                            <button className=" btn btn-primary  btn-block " type="submit">
                                                <i class="fas fa-sign-in-alt"/> Calculate
                                            </button>
                                        </div>
                                    </form>
                                </MDBCardBody>
                            </MDBCard>
                        </MDBContainer>
                    </div>
                    <div className="col">
                        <MDBCardHeader style={{height: 200, width: 400, padding: 80, textSize: 200}}
                                       className="text-center" color="blue" tag="h6">
                            Rs. {this.state.calcValue}</MDBCardHeader>
                        <MDBCardHeader style={{height: 200, width: 400, padding: 80, textSize: 200}}
                                       className="text-center" color="blue" tag="h6">
                            Surge - Rs. {this.state.surCharge}</MDBCardHeader>
                    </div>
                </div>
            </div>
        );
    }
}


export default App;

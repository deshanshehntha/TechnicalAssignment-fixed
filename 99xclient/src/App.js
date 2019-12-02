import React from 'react';
import './App.css';
import FullPageIntroWithFixedNavbar from './components/navbar.component'
import './index.css'
import "@fortawesome/fontawesome-free/css/all.min.css";
import "bootstrap-css-only/css/bootstrap.min.css";
import "mdbreact/dist/css/mdb.css";
import { BrowserRouter as Router, Route, Switch, withRouter } from "react-router-dom";
import PriceTable from "./components/pricetable.component";
import PriceCalculator from "./components/pricecalculator.component"
import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
    return (
        <Router>
            <div className="container-fluid">
                <FullPageIntroWithFixedNavbar/>
                <br/><br/>
                <div className="container-fluid">
                    <Switch>
                    <Route exact path='/' component={PriceTable}/>
                    <Route path='/calculator' component={PriceCalculator}/>
                </Switch>
            </div>
            </div>
        </Router>



    );
}

export default App;

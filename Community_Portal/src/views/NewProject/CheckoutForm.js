import React, {Component} from 'react';
import axios from 'axios';
import {CardElement, injectStripe} from 'react-stripe-elements';

class CheckoutForm extends Component {
  constructor(props) {
    super(props);
    this.state = {complete: false};
    this.submit = this.submit.bind(this);
  }

  async submit(ev) {
    // User clicked submit
    try{
    let {token} = await this.props.stripe.createToken({name: "Name"});
    console.log(token);

    /*let response = await fetch('http://localhost:3001/projectpayment', {
    method: "POST",
    headers: {"Content-Type": "text/plain"},
    body: token.id
  });*/
  if(token.id){
 localStorage.setItem('payment', true)
 this.setState({complete: true});
}
  } catch(e){
    throw e;
  }
  }

  render() {
    if (this.state.complete) return <h1>Payment details saved!</h1>;
    return (
      <div className="checkout">
        <p>Initial charges: $20</p>
        <br/>
        <CardElement />
        <br/><br/>
        Name :    <input
          type="text"
          onChange={(e) => this.setState({ release_date: e.target.value })}
          placeholder="As in your card"
          style={{ width: '200px' }}
        /> <br/>
        Address:    <input
          type="text"
          onChange={(e) => this.setState({ release_date: e.target.value })}
          placeholder="Billing address"
          style={{ width: '200px' }}
        /> <br/>
        State :    <input
          type="text"
          onChange={(e) => this.setState({ release_date: e.target.value })}
          placeholder="Eg: California"
          style={{ width: '200px' }}
        /> <br/>
        <br/>
        <button onClick={this.submit}>Purchase</button>
      </div>
    );
  }
}

export default injectStripe(CheckoutForm);

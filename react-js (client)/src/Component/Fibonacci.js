import React, { Component } from "react";
import APIDataService from "../Services/APIDataService";

export default class Fibonacci extends Component {
  constructor(props) {
    super(props);
    this.retrieveFibonacci = this.retrieveFibonacci.bind(this);
    this.onChangeElements = this.onChangeElements.bind(this);
    

    this.state = {
      elements: 10,
      currentFibonacciSequence: null
    };
  }

  componentDidMount() {
    this.retrieveFibonacci();
  }


  retrieveFibonacci() {
    var data = {
        elements: this.state.elements
    };
    APIDataService.getFibonacci(data)
      .then(response => {
        this.setState({
            currentFibonacciSequence: response.data
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  onChangeElements(e) {
    this.setState({
        elements: e.target.value
    });
  }


  render() {
    const { elements, currentFibonacciSequence  } = this.state;

    return (
      <div class="card text-center">
        <div class="card-header">
          <h4>Get Fibonacci Numbers</h4>
        </div>
        <div class="input-group mb-4 w-25 m-auto">
            <input type="text" class="form-control" placeholder="How many numbers to retreve" id="elements" 
                required value={elements} onChange={this.onChangeElements} name="elements" />
            <div class="input-group-append">
                <button class="btn btn-primary" type="button" onClick={this.retrieveFibonacci} >Retreve</button>
            </div>
        </div>

        {currentFibonacciSequence ? (
        <div className="row mt-4">
            <div className="col-md-6">
                <label>
                <strong>Sequence:</strong>
                </label>{" "}
                {currentFibonacciSequence.fibonacci.join(", ")}
            </div>
            <div className="col-md-6">
                <label>
                <strong>Sorted:</strong>
                </label>{" "}
                {currentFibonacciSequence.sorted.join(", ")}
            </div>
        </div>

        ) : (
        <div>
            <br />
            <p>Please enter a number...</p>
        </div>
        )}
      <div class="mt-5 card-footer text-muted">By SA54 Khan Sher Mostafa Somik</div>
    </div>
    );
  }
}

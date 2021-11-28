import React, { useState, useEffect } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';
import PizzaService from '../services/PizzaService';
import { Button, Form } from 'react-bootstrap';

const CreatePizzaComponent = () => {

    const [crust, setCrust] = useState('')
    const [toppings, setToppings] = useState('')
    const history = useNavigate();
    const {id} = useParams();

    const saveOrUpdatePizza = (e) => {
        e.preventDefault();

        const pizza = {crust, toppings}

        if(id) {

            PizzaService.editPizza(id, pizza).then(() => {
                history('/ordertime')
            }).catch(error => {
                console.log(error)
            })

        } else {

            PizzaService.makePizza(pizza).then((response) =>{

                console.log(response.data)
    
                history('/ordertime')
    
            }).catch(error => {
                console.log(error)
            })
        }
        
    }

    const title = () => {

        if(id) {
            return <h2 className = "text-center">Update Order</h2>
        } else {
            return <h2 className = "text-center">Add Order</h2>
        }
        
    }

    useEffect(() => {

        PizzaService.retrieveAPizza(id).then((response) =>{
            setCrust(response.data.crust)
            setToppings(response.data.toppings)
        }).catch(error => {
            console.log(error)
        })

    }, [id])

    return (
        <div>
           <br />
           <div className="container">
                <div className="row">
                    <div style={{ backgroundColor: "#343a40", color: "#FFFFFF" }} className="card col-md-6 offset-md-3 offset-md-3">
                       {
                           title()
                       }
                        <div className="card-body">
                            <Form>
                                <div className="form-group mb-2">
                                    <label className="form-label"> Pizza Crust:</label>
                                    <input
                                        type="text"
                                        placeholder="Enter crust type"
                                        name="crust"
                                        className="form-control"
                                        value={crust}
                                        onChange={(e) => setCrust(e.target.value)}
                                    >
                                    </input>
                                </div>

                                <div className="form-group mb-2">
                                    <label className="form-label"> Toppings:</label>
                                    <input
                                        type="text"
                                        placeholder="Enter toppings"
                                        name="toppings"
                                        className="form-control"
                                        value= {toppings}
                                        onChange= {(e) => setToppings(e.target.value)}
                                    >
                                    </input>
                                </div>

                                <Button className="btn btn-success" onClick={(e) => saveOrUpdatePizza(e)} >Submit </Button>
                                <Link to="/ordertime" className="btn btn-info"> Return </Link>
                            </Form>

                        </div>
                    </div>
                </div>

           </div>

        </div>
    )
}


export default CreatePizzaComponent
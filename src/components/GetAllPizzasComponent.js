import React, {useState, useEffect} from 'react'
import { Link } from 'react-router-dom'
import PizzaService from '../services/PizzaService';
import { Table, Button, InputGroup, FormControl } from 'react-bootstrap';

const GetAllPizzasComponent = () => {

    const [pizzas, setPizzas] = useState([])
    const [search, setSearch] = useState("")

    useEffect(() => {

        retrieveAllPizzas();

    }, [])

    const retrieveAllPizzas = () => {
        PizzaService.retrieveAllPizzas().then((response) => {
            setPizzas(response.data)
            console.log(response.data);
        }).catch(error =>{
            console.log(error);
        })
    }

    const removePizza = (id) => {
       PizzaService.removePizza(id).then((response) =>{
        retrieveAllPizzas();
       }).catch(error =>{
           console.log(error);
       })
        
    }
                            
        return (
            <div className = "container">
                 <h2 className="text-center">Pizza Orders</h2>
                 <InputGroup className="mb-3">
                  <FormControl
                   placeholder="Search orders"
                   aria-label="Default"
                   aria-describedby="inputGroup-sizing-default"
                   onChange={(event) => {
                    setSearch(event.target.value);
                  }}
                 />
                 </InputGroup>
                 <Table className="table table-bordered table-striped" striped bordered hover variant="dark">
                            <thead>
                                <tr>
                                    <th>Order ID</th>
                                    <th>Pizza Crust</th>
                                    <th>Toppings</th>
                                    <th>Order Functions</th>
                                </tr>
                            </thead>
                            <tbody>
                            {/*eslint-disable-next-line*/}
                            {pizzas.filter((pizza) => {
                                if (search === "") {
                                    return pizza;
                                } else if (pizza.toppings.toLowerCase().includes(search.toLowerCase())) {
                                    return pizza;
                                }
                            }).map(pizza => {
                                return (
                                    <tr key = {pizza.id}>
                                         <td> {pizza.id} </td>
                                         <td> {pizza.crust} </td> 
                                         <td> {pizza.toppings} </td>
                                         <td>
                                                <Link className="btn btn-info" to={`/edit-pizza/${pizza.id}`} >Update</Link>
                                                <Button className="btn btn-danger" onClick={() => removePizza(pizza.id)} style={{marginLeft:"10px"}}> Delete</Button>
                                         </td>
                                    </tr>
                                    )
                                })
                            }
                        </tbody>
                        </Table>
                        <Link to="/add-pizza" className = "btn btn-primary mb-2" > Add Order </Link>
            </div>
    )
}

export default GetAllPizzasComponent
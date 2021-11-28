import axios from 'axios'

const PIZZA_BASE_API = "http://localhost:8080/orders";

class PizzaService { 

    makePizza(pizza) {
        return axios.post(PIZZA_BASE_API, pizza)
    }

    retrieveAllPizzas() {
        return axios.get(PIZZA_BASE_API)
    }

    retrieveAPizza(id) {
        return axios.get(PIZZA_BASE_API + '/' + id)
    }

    editPizza(id, pizza) {
        return axios.put(PIZZA_BASE_API + '/' + id, pizza)
    }

    removePizza(id) {
        return axios.delete(PIZZA_BASE_API + '/' + id)
    }

}

export default new PizzaService();

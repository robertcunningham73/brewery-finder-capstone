import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default{
    getBreweries(){
        return http.get('/breweries');
    },
    getBrewery(breweryId){
        return http.get(`/breweries/${breweryId}`);
    },
    getBeer(beerId){
        return http.get(`/beer-list/${beerId}`);
    },
    getBeerList(){
        return http.get('/beer-list');
    },
    getBeerByBrewery(breweryId){
        return http.get(`/breweries/${breweryId}/beer`);
    },
    updateBeer(beer, breweryId) {
        return http.put(`/beer-list/${beer.beerId}`, beer, breweryId);
    },
    updateBrewery(brewery){
        return http.put(`/breweries/${brewery.breweryId}`, brewery);
    },
    addBeer(beer, breweryId){
        return http.post(`/beer-list/${breweryId}/beer`, beer);
    },
    addBrewery(brewery){
        return http.post('/breweries', brewery)
    }
    
}
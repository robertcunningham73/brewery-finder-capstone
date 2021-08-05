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
    updateBeer(beer) {
        return http.put(`/beer-list/${beer.beerId}`, beer);
    },
    
}
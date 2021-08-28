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
    getBreweryByBeerId(beerId) {
        return http.get(`breweries/beer/${beerId}`);
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
        return http.put(`/beer-list/${breweryId}/${beer.beerId}`, beer);
    },
    updateBrewery(brewery){
        return http.put(`/breweries/${brewery.breweryId}`, brewery);
    },
    addBeer(beer, breweryId){
        return http.post(`/beer-list/${breweryId}/beer`, beer);
    },
    addBrewery(brewery){
        return http.post('/breweries', brewery)
    },
    deleteBreweryImage(breweryId, imagePath){
        return http.delete(`/breweries/${breweryId}/${imagePath}`)
    }
    
}
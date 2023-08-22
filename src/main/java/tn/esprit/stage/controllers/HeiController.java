package tn.esprit.stage.controllers;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tn.esprit.stage.entities.Hei;
import tn.esprit.stage.entities.Rate;

import java.util.List;
@CrossOrigin(origins = "https://eche-list.erasmuswithoutpaper.eu/api")
@RestController
public class HeiController {

    @RequestMapping(value = "showHei", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rate> showAllHeis() {
       /* RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Hei>> rateResponse =
                restTemplate.exchange("http://eche-list.erasmuswithoutpaper.eu/api",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Hei>>() {
                        });
        List<Hei> heis = rateResponse.getBody();
        System.out.println(heis.size());


        return heis;*/
        /*RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("https://eche-list.erasmuswithoutpaper.eu/api", Object[].class);
        Object[] objects = responseEntity.getBody();
        MediaType contentType = responseEntity.getHeaders().getContentType();
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println(objects.length);
        return objects;*/

        /*final RestTemplate restTemplate = new RestTemplate();
        final String response = restTemplate.getForObject("https://eche-list.erasmuswithoutpaper.eu/api", String.class);

        System.out.println(response);
        return response;*/
        final RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Rate>> rateResponse =
                restTemplate.exchange("https://eche-list.erasmuswithoutpaper.eu/api",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Rate>>() {
                        });
        List<Rate> rates = rateResponse.getBody();
        System.out.println(rates.size());
        return rates;
    }

}

package org.dgac.cl.integracion.adlogin;

import org.dgac.cl.model.service.ParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;



@Service
public class AdLoginServiceImpl implements AdLoginService {

    @Autowired
    private Environment env;

    @Autowired
    private ParametroService parametroService;

    @SuppressWarnings("deprecation")
    
    @Override
    public Boolean login(String user, String pass) throws Exception{
        ResponseEntity<String> adr = null;
        String uri = parametroService.findById("WS_LOGIN_WSDL") + "/login";
        MultiValueMap<String,String> parameters = new LinkedMultiValueMap<>();
        parameters.add("usuario", user);
        parameters.add("password", pass);
        RestTemplate restTemplate = new RestTemplate();
        try {
            adr=restTemplate.postForEntity(uri, parameters, String.class);
            if(adr.getStatusCodeValue() == 200){
                return true;
            }
        } catch (RestClientException e) {
            JsonObject jsonRespuesta = new Gson().fromJson(e.getMessage(), JsonObject.class);
            String codigo = jsonRespuesta.get("codigo_error").getAsString();
            switch(codigo){
            case "001" -> {
                return false;
                }
            }

        }
        return false;
    }


    //     public Boolean login(String user, String pass) throws Exception {
    //     String uri = parametroService.findById("WS_LOGIN_WSDL") + "/login";
        
    //     MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
    //     parameters.add("usuario", user);
    //     parameters.add("password", pass);

    //     RestTemplate restTemplate = new RestTemplate();

    //     try {
    //         ResponseEntity<String> response = restTemplate.postForEntity(uri, parameters, String.class);
    //         return response.getStatusCode() == HttpStatus.OK;
    //     } catch (RestClientException e) {
    //         JsonObject jsonRespuesta = new Gson().fromJson(e.getMessage(), JsonObject.class);
    //         String codigo = jsonRespuesta.get("codigo_error").getAsString();
    //         return "001".equals(codigo);
    //     }
    // }

    
}

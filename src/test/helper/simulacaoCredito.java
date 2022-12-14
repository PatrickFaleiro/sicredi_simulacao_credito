import io.restassured.RestAssured;
import io.restassured.config.XmlConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.*;

public class simulacaoCredito {
    static Response response;
    private static final String BASE_URL = "http://localhost:8080/swagger-ui.html";

    public static void acessoConsultaSimulacao(){
        given().
                config(RestAssured.config().xmlConfig(XmlConfig.xmlConfig().declareNamespace("test", BASE_URL)));
    }
    public static void consultaCpfs(){
        response = when().
                get("/api/v1/simulacoes");
    }
    public static void validaStatusCode() {
        response.then().
                body("nome", hasItems("Fulano", "Deltrano"))
                .statusCode(200);
    }
    public static void consultaCpfEspecifico(String cpf){
        response = when().
                get("/api/v1/simulacoes/"+cpf);
    }
    public static void validaCpfConsultado(String cpf){
        response.then().
                body("cpf", equalTo(cpf))
                .statusCode(200);
    }
    public static void insereCpf(){
        geraCpf gerador = new geraCpf();
        String cpf = gerador.cpf();
        String cpfFormatado = gerador.removeCaracteresEspeciais(cpf);
        Map<String, Object> request = new HashMap<>();
        request.put("nome","Beltrano de tal");
        request.put("cpf",cpfFormatado);
        request.put("email", "teste@email.com.br");
        request.put("valor", 1000);
        request.put("parcelas", 2);
        request.put("seguro", true);
        response = given()
                        .contentType(ContentType.JSON)
                        .body(request).
                    when().
                        post("/api/v1/simulacoes/");
    }
    public static void validaInsercaoCredito(){
        response.then()
                .body("nome", equalTo("Beltrano de tal")).statusCode(201);
    }
    public static void insereCpfDuplicado(){
        //O m??todo usa um CPF que ja existe na base quando sobe o servi??o para validar a regra de duplica????o
        Map<String, Object> request = new HashMap<>();
        request.put("nome","Beltrano de tal");
        request.put("cpf", "66414919004");
        request.put("email", "teste@email.com.br");
        request.put("valor", 1000);
        request.put("parcelas", 2);
        request.put("seguro", true);
        response = given()
                        .contentType(ContentType.JSON)
                        .body(request).
                   when().
                        post("/api/v1/simulacoes/");
    }
    //No Swagger mostra de maneira errada os retornos do servi??o, tanto em c??digo quanto em mensagem.
    //Sugest??o: Mudar no projeto os c??digos/mensagens erradas.
    public static void validaMensagemCpfDuplicado(){
        response.then().body("mensagem", equalTo("CPF duplicado")).statusCode(400);
    }
    public static void insereSimulacaoEmailInvalido(){
        geraCpf gerador = new geraCpf();
        String cpf = gerador.cpf();
        String cpfFormatado = gerador.removeCaracteresEspeciais(cpf);
        Map<String, Object> request = new HashMap<>();
        request.put("nome","Beltrano de tal");
        request.put("cpf",cpfFormatado);
        request.put("email", "emailInvalido");
        request.put("valor", 1000);
        request.put("parcelas", 2);
        request.put("seguro", true);
        response = given()
                .contentType(ContentType.JSON)
                .body(request).
                when().
                post("/api/v1/simulacoes/");
    }
    public static void validaEmailInvalidoSimulacaoCredito(){
        response.then().body("erros.email", equalTo("E-mail deve ser um e-mail v??lido")).statusCode(400);
    }
}

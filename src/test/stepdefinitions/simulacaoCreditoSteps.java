import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;


public class simulacaoCreditoSteps {
    @Dado("que estou no servico de simulacao de credito")
    public void que_estou_no_servico_de_simulacao_de_credito() {
        // Write code here that turns the phrase above into concrete actions
        simulacaoCredito.acessoConsultaSimulacao();
    }
    @Quando("consulto todos os cpfs")
    public void consulto_todos_os_cpfs() {
        // Write code here that turns the phrase above into concrete actions
        simulacaoCredito.consultaCpfs();
    }
    @Então("todos os cpfs cadastrados sao retornados")
    public void todosOsCpfsCadastradosSaoRetornados() {
        simulacaoCredito.validaStatusCode();
    }
    @Quando("consulto o cpf {} cadastrado")
    public void consultoUmCpfCadastrado(String cpf) {
        simulacaoCredito.consultaCpfEspecifico(cpf);
    }
    @Então("e retornado os dados do cpf {} cadastrado")
    public void eRetornadoOsDadosDoCadastrado(String cpf) {
        simulacaoCredito.validaCpfConsultado(cpf);
    }
    @Quando("insiro as informações de crédito do novo cpf")
    public void insiroAsInformaçõesDeCréditoDoNovoCpf() {
        simulacaoCredito.insereCpf();
    }
    @Então("um novo cadastro de simulação de credito e gerado")
    public void umNovoCadastroDeSimulaçãoDeCreditoEGeradoDoCpf() {
        simulacaoCredito.validaInsercaoCredito();
    }
    @Quando("insiro dados de um cpf ja cadastrado")
    public void insiroDadosDeUmCpfJaCadastrado() {
        simulacaoCredito.insereCpfDuplicado();
    }
    @Então("retorna mensagem de erro informando cpf duplicado")
    public void retornaMensagemDeErroInformandoCpfDuplicado() {
        simulacaoCredito.validaMensagemCpfDuplicado();
    }
    @Quando("tento cadastrar uma simulação de crédito com email invalido")
    public void tentoCadastrarUmaSimulaçãoDeCréditoComEmailInvalido() {
        simulacaoCredito.insereSimulacaoEmailInvalido();
    }
    @Então("e retornado mensagem informando que deve ser informado um email valido")
    public void eRetornadoMensagemInformandoQueDeveSerInformadoUmEmailValido() {
        simulacaoCredito.validaEmailInvalidoSimulacaoCredito();
    }
}

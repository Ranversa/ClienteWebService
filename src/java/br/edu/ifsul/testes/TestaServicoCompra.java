package br.edu.ifsul.testes;


import br.rdu.ifsul.cliente.Compra;
import br.rdu.ifsul.cliente.ServicoCompraService;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestaServicoCompra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DatatypeConfigurationException {
        ServicoCompraService cliente = new ServicoCompraService();
        Compra c = new Compra();
        c.setId(2);
        c.setCepDestino("99010010");
        c.setCepOrigem("99020020");
        c.setCliente("João");
        c.setFrete(19.90);
        c.setPrazoEntrega(7);
        c.setValor(98.67);
        cliente.getServicoCompraPort().inserir(c);
    }

}

package br.edu.ifsul.testes;


import br.edu.ifsul.correio.CResultado;
import br.edu.ifsul.correio.CResultadoObjeto;
import br.edu.ifsul.correio.CResultadoServicos;
import br.edu.ifsul.correio.CServico;
import br.edu.ifsul.correio.CalcPrecoPrazoWS;
import br.edu.ifsul.correio.CalcPrecoPrazoWSSoap;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestaServicoCorreio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DatatypeConfigurationException {
        // 04510 - Via PAC
        // 04014 - Via SEDEX
        
            CResultado resultado = calcPrazo("04510","28970970", "99036390");
            String prazo = resultado.getServicos().getCServico().get(0).getPrazoEntrega();
            System.out.println("prazo: "+prazo+" dias");
               
        
    }

    private static CResultado calcPrazo(java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino) {
        br.edu.ifsul.correio.CalcPrecoPrazoWS service = new br.edu.ifsul.correio.CalcPrecoPrazoWS();
        br.edu.ifsul.correio.CalcPrecoPrazoWSSoap port = service.getCalcPrecoPrazoWSSoap();
        return port.calcPrazo(nCdServico, sCepOrigem, sCepDestino);
    }

}

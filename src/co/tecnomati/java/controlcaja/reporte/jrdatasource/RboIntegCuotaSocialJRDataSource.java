/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.controlcaja.reporte.jrdatasource;

/**
 *
 * @author AnahiAramayo
 */
public class RboIntegCuotaSocialJRDataSource implements JRDataSource
{
    private List<Participante> listaParticipantes = new ArrayList<Participante>();
    private int indiceParticipanteActual = -1;
    
    public Object getFieldValue(JRField jrf) throws JRException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean next() throws JRException
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

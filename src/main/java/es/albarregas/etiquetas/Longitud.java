package es.albarregas.etiquetas;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.log4j.Logger;

public class Longitud extends TagSupport {

    private String palabra;

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        try {
            String valor = String.valueOf(palabra.length());
            out.write(valor);
            Logger.getRootLogger().info("Etiqueta s:longitud ejecutada sin problema");
        } catch (IOException ex) {
            Logger.getRootLogger().fatal("Problema al ejecutar la etiqueta s:longitud");
        }
        return Tag.EVAL_PAGE;
    }
}

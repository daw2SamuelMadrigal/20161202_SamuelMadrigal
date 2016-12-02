package es.albarregas.etiquetas;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.log4j.Logger;

public class LetraDNI extends TagSupport implements DynamicAttributes {

    private String numero;

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        this.numero = String.valueOf(value);
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            Writer out = pageContext.getOut();
            String letras[] = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E", "T"};
            try {
                int resto = Integer.parseInt(numero) % 23;
                String letra = letras[resto];
                out.write(numero + " - " + letra);
            } catch (NumberFormatException e) {
                out.write("Introduzca un número correcto");
            }
            Logger.getRootLogger().info("Etiqueta s:letraDNI ejecutada sin problemas");
        } catch (IOException ex) {
            Logger.getRootLogger().fatal("Problema al ejecutar la etiqueta s:letraDNI");
        }
        return Tag.EVAL_PAGE;
    }
}

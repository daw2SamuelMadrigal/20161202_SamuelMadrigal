package es.albarregas.etiquetas;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.log4j.Logger;

public class Cabecera extends TagSupport {
    
    private String logo;
    private String nombre;
    private String eslogan;

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEslogan(String eslogan) {
        this.eslogan = eslogan;
    }

    @Override
    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        this.nombre = (nombre == null || nombre.length() == 0) ? "Aquí tu nombre" : nombre;
        this.eslogan = (eslogan == null || eslogan.length() == 0) ? "Aquí tu eslogan" : eslogan;
        try {
            out.write(
                    "<header>"
                        + "<div style='float:left;width:100%'>"
                            + "<img style='float:left;height:100%;width:30%' src='images/" + logo + "' alt='Aquí tu logo'/>"
                            + "<h1 style='text-align:center'>" + nombre + "</h1>"
                            + "<h4 style='text-align:center'>" + eslogan + "</h4>"
                        + "</div>"
                    + "</header>"
            );
            Logger.getRootLogger().info("Etiqueta s:cabecera ejecutada sin problemas");
        } catch (IOException ex) {
            Logger.getRootLogger().fatal("Problema al ejecutar la etiqueta s:cabecera");
        }     
        return Tag.EVAL_PAGE;
    }
}

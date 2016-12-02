package es.albarregas.etiquetas;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.log4j.Logger;

public class Operacion extends TagSupport {

    private String operacion;
    private String val1;
    private String val2;
    private Double resultado;

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    @Override
    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        try {
            switch (operacion) {
                case "sumar":
                    this.resultado = Double.valueOf(val1) + Double.valueOf(val2);
                    break;
                case "restar":
                    this.resultado = Double.valueOf(val1) - Double.valueOf(val2);
                    break;
                case "multiplicar":
                    this.resultado = Double.valueOf(val1) * Double.valueOf(val2);
                    break;
                case "dividir":
                    this.resultado = Double.valueOf(val1) / Double.valueOf(val2);
                    break;
            }
            out.write(String.valueOf(resultado));
            Logger.getRootLogger().info("Etiqueta s:operacion ejecutada sin problema");
        } catch (IOException ex) {
            Logger.getRootLogger().fatal("Problema al ejecutar la etiqueta s:operacion");
        }
        return Tag.EVAL_PAGE;
    }
}

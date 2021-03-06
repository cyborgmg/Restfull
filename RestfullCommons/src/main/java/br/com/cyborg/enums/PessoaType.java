package br.com.cyborg.enums;

public enum PessoaType {
	
    F("Fisica", "F"),

    J("Juririca", "J");


    private String label;

    private String valor;

    private PessoaType(final String label, final String valor) {
        this.label = label;
        this.valor = valor;
    }

    public String getLabel() {
        return this.label;
    }

    public String getValor() {
        return this.valor;
    }
    
    public static PessoaType getPessoaType(String tipo) {
    	
    	switch (tipo) {
         	case "F":  return PessoaType.F;	
         	case "J":  return PessoaType.J;
    	}
    	
	return null;
	}

}

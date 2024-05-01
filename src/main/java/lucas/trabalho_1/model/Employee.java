package lucas.trabalho_1.model;

/**
 *
 * @author lucas campestrini <lucas.campestrini@gmail.com>
 */
public class Employee {
    
    private String cpf;
    private String name;
    private String position;
    private String workSchedule;

    public Employee(String cpf, String name, String position, String workSchedule) {
        this.cpf = cpf;
        this.name = name;
        this.position = position;
        this.workSchedule = workSchedule;
    }
    
    /**
     * Verifica se é o mesmo empregado vendo se é o mesmo cpf
     * 
     * @param e
     * @return 
     */
    public boolean equals(Employee e) {
        return this.getCpf().equals(e.getCpf());
    }

    public Employee(String cpf) {
        this.cpf = cpf;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{\n" + "cpf=" + cpf + ",\n name=" + name + ",\n position=" + position + ",\n WorkSchedule=" + workSchedule +"\n}";
    }
    
    
    
}

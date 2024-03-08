/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Fpt
 */
public class Comple {
    private String id;
    private String fullName;
    private String status;

    public Comple() {
    }

    public Comple(String id, String fullName, String status) {
        this.id = id;
        this.fullName = fullName;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString(){
        return String.format("%s | %15s | %15s", id, fullName, status);
    }
    
}
